package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명
 *  PreparedStatement는 Statement와 달리 placeholder(?)를 사용한 쿼리를 파싱하고 캐싱하여 다시 재해석하는 과정을 생략함으로 인해
 *  불완전하게 작성된 쿼리 실행의 경우 Statmement보다 빠르다.
* */
public class Application2 {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rSet = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("사번 입력 : ");
        String empId = sc.nextLine();
        String entYN = "N";

        /* PreparedStatement는 Statement때와 달리 placeholder(?)를 활용한 하나의 문자열 형태로 쿼리 작성 가능 */
        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?;";

        try {
            pstm = con.prepareStatement(query);
            pstm.setString(1, empId);
            pstm.setString(2, entYN);

            rSet = pstm.executeQuery();

            if(rSet.next()){
                System.out.println(rSet.getString("EMP_ID") + ", " + rSet.getString("EMP_NAME"));
            }else {
                System.out.println("조회 결과 없음");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rSet);
            close(pstm);
            close(con);
        }
    }
}
