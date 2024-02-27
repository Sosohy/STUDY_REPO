package com.ohgiraffers.section05.compositkey.subsection02.idclass;

import java.io.Serializable;

/* 설명. IdClass 타입으로 쓰인 클래스도 1차 캐시에서 식별자로 쓰이는 객체이므로 e+h 오버라이딩 */
public class MemberPK implements Serializable {

    private int memberNo;
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberPK memberPK = (MemberPK) o;

        if (memberNo != memberPK.memberNo) return false;
        return memberId.equals(memberPK.memberId);
    }

    @Override
    public int hashCode() {
        int result = memberNo;
        result = 31 * result + memberId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MemberPK{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
