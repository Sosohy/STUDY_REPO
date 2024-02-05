package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명. 사번을 입력받아 한명의 사원을 조회하는 기능 작성 */
public class Application2 {

    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stm = null;
        ResultSet rSet = null;

        try {
            stm = con.createStatement();

            /* 조회하고자 하는 사번 입력받기 */
            Scanner sc = new Scanner(System.in);
            System.out.print("사번 입력 : ");
            int empId = sc.nextInt();
            String entYN = "N";

            /* 입력받은 사번을 활용한 쿼리작성 */
            String query = "SELECT EMP_ID, EMP_NAME  FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND ENT_YN = '" + entYN + "';";
            System.out.println("query = " + query);

            rSet = stm.executeQuery(query);

            if(rSet.next()){
                System.out.println(rSet.getString("EMP_ID") + ", " + rSet.getString("EMP_NAME"));
            }else {
                System.out.println("조회 결과 없음");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rSet);
            close(stm);
            close(con);
        }

    }
}
