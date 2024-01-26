package com.ohgiraffers.section04.assignment.service;

import com.ohgiraffers.section04.assignment.aggregate.Member;
import com.ohgiraffers.section04.assignment.repository.MemberRepository;

import java.util.ArrayList;

/* 설명. 트랜잭션 성공실패 여부 확인 및 회원관련 비즈니스 로직 처리하는 클래스 */
public class MemberService {
    private final MemberRepository mr = new MemberRepository();

    public MemberService() {
    }

    public void selectAllMembers() {
        ArrayList<Member> selectedMembers = mr.selectAllMembers();

        /* 설명. 회원이 한명도 없어서 조회 결과가 없더라도 ArrayList객체는 넘어온다.(Empty 상태로) */
        if(!selectedMembers.isEmpty()){       // 회원이 한 명이라도 조회 된다면
            for (Member m : selectedMembers){
                System.out.println(m);
            }
            return;                           // 이후 코드와 상관 없이 메소드 종료
        }

        /* 설명. 조건이 맞지 않아(회원이 조회되지 않아) 출력을 하는 구문(else 안쓰기) */
        System.out.println("아직 회원이 없음");
    }

    /* 설명. 전달된 회원번호를 활용해 repository에 있는 memList로부터 해당 회원 찾아 반환 받기 */
    public void selectMember(int memNo) {
        Member selectedMember = mr.selectMember(memNo);
        if(selectedMember != null){
            System.out.println("조회된 회원 : " + selectedMember);
        }else{
            System.out.println("회원 정보 없음");
        }
    }

    /* 설명. 입력 받아 넘어온 회원이 가질 번호를 만들고 추가 후, repository로 전달 후, 결과 확인 */
    public void registMember(Member member) {
//        System.out.println(member);
        int lastMemberNo = mr.selectLastMemberNo();
        member.setMemNo(lastMemberNo + 1);

        int result = mr.registMember(member);
        if(result == 1){
            System.out.println(member.getId()+"의 회원 가입 성공!.!");
        }
    }

    public void deleteMember(int memNo) {
        int result = mr.deleteMember(memNo);
        if(result > 0){
            System.out.println(memNo + "번 회원 탈퇴 완료");
            return;
        }
        System.out.println("회원 탈퇴 실패");
    }
}
