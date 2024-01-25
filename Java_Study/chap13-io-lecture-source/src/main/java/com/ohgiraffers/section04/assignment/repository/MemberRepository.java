package com.ohgiraffers.section04.assignment.repository;

import com.ohgiraffers.section04.assignment.aggregate.BloodType;
import com.ohgiraffers.section04.assignment.aggregate.Member;

import java.io.*;
import java.util.ArrayList;

/* 설명. 데이터와 입출력을 위해 만들어지며 성공 실패 결과를 반환하는 클래스 */
public class MemberRepository {
    private ArrayList<Member> memList = new ArrayList<>();

    /* 설명. 프로그램이 켜지자마자(MemberRepository()가  실행되자마자) 파일에 dummy 데이터 추가 및 입력받기 */
    public MemberRepository() {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member(1, "user01", "pw01", 20, new String[]{"발레", "필라테스", "수영"}, BloodType.AB));
        members.add(new Member(2, "user02", "pw02", 25, new String[]{"축구", "음악 감상"}, BloodType.B));
        members.add(new Member(3, "user03", "pw03", 22, new String[]{"유튜브 시청", "공연보기", "게임"}, BloodType.O));
        
        saveMembers(members);
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
}
