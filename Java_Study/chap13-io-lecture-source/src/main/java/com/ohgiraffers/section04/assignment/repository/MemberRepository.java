package com.ohgiraffers.section04.assignment.repository;

import com.ohgiraffers.section04.assignment.aggregate.BloodType;
import com.ohgiraffers.section04.assignment.aggregate.Member;
import com.ohgiraffers.section04.assignment.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

/* 설명. 데이터와 입출력을 위해 만들어지며 성공 실패 결과를 반환하는 클래스 */
public class MemberRepository {
    private ArrayList<Member> memList = new ArrayList<>();

    /* 설명. 프로그램이 켜지자마자(MemberRepository()가  실행되자마자) 파일에 dummy 데이터 추가 및 입력받기 */
    public MemberRepository() {

        /* 설명. 회원가입 기능 추가 후 이제는 파일이 기존에 존재하면(처음이 아니므로) 회원 3명으로 초기화 X */
        File file = new File("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat");
        if(!file.exists()) {
            ArrayList<Member> members = new ArrayList<>();
            members.add(new Member(1, "user01", "pw01", 20, new String[]{"발레", "필라테스", "수영"}, BloodType.AB));
            members.add(new Member(2, "user02", "pw02", 25, new String[]{"축구", "음악 감상"}, BloodType.B));
            members.add(new Member(3, "user03", "pw03", 22, new String[]{"유튜브 시청", "공연보기", "게임"}, BloodType.O));

            saveMembers(members);
        }
        loadMembers();

//        System.out.println("repo에서 회원정보 제대로 읽어오는지");
//        for (Member m : memList){
//            System.out.println(m);
//        }
    }

    /* 설명. 회원이 담긴 ArrayList를 던지면 파일에 출력하는 기능 */
    private void saveMembers(ArrayList<Member> members) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat")));
            /* 넘어온 회원만큼 객체 출력 */
            for(Member m : members){
                oos.writeObject(m);
            }

            oos.flush();           // 출력 시에는 flush 해줄것
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(oos != null)
                    oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 설명. 파일로부터 회원객체들을 입력 받아 memList에 쌓기 */
    private void loadMembers() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat")));

            /* 설명. 파일로부터 모든 회원정보를 읽어 memList에 추가(add) */
            while (true) {
                memList.add((Member) (ois.readObject()));
            }
        } catch (EOFException e){
            System.out.println("회원정보 모두 로딩");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null)
                    ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memList;
    }

    public Member selectMember(int memNo) {
        for (Member m : memList) {
            if (m.getMemNo() == memNo) {
                return m;
            }
        }
        return null;
    }

    public int selectLastMemberNo() {
//        Member lastMember = memList.get(memList.size()-1);    // 가장 최근에 가입한 회원
//        return lastMember.getMemNo();                         // 그 회원의 번호(마지막 번호) 반환
        return memList.get(memList.size()-1).getMemNo();
    }

    /* 설명. 기존 회원 객체에 이어서 파일 출력을 하고 추가한 객체의 수를 반환 (-> DML 작업의 결과는 int) */
    /* 설명. 기존 ObjectOutputStream 대신 새로 정의한 스트림으로 회원 한명 객체 파일 출력하고 int 반환 -> 이어쓰기 */
    public int registMember(Member member) {
        MyObjectOutput moo = null;
        try {
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat", true)));

            /* 파일로 객체 하나 출력 */
            moo.writeObject(member);            // 외부에도 저장

            /* Repository의 memList에도 추가하기 */
            memList.add(member);                // 현재 실행되고 있는 내부에도 저장

            moo.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(moo != null)
                    moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 1;
    }

    public int deleteMember(int memNo) {
        for (int i = 0; i < memList.size(); i++) {
            if(memList.get(i).getMemNo() == memNo){      // 지우려는 회원과 같은 회원 번호인 index 찾기

                /* 설명. 프로그램 상에서 회원을 관리하는 memberList뿐 아니라 DB(회원 파일)도 같이 적용되게 함 */
                memList.remove(i);
                saveMembers(memList);
                return 1;
            }
        }
        return 0;
    }
}
