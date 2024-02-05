package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    
    public static void main(String[] args) {

        /* 설명. 트랜잭션 처리를 위한 DBMS 연동용 Connection 객체 생성 */
        Connection con = getConnection();
        System.out.println("con = " + con);

        /* 설명. 해당 Connection을 통해 트랜잭션 처리(비즈니스 로직 수행, CRUD) */
        Statement stm = null;        // 쿼리를 운반하고 결과를 반환하는 객체
        ResultSet rSet = null;       // **조회** 결과가 반환되는 객체

        try {
            stm = con.createStatement();

            /* 설명. 쿼리의 결과인 다중행/단일행을 받은 ResultSet */
            rSet = stm.executeQuery("SELECT * FROM EMPLOYEE");

            /* 한 행씩 확인 */
            while (rSet.next()){     // 이 반복문의 조회 결과 행 만큼 반복

                /* 반복문 안에서의 rSet은 단일행으로 해석 */
                System.out.println(rSet.getString("EMP_NAME") + ", " + rSet.getInt("SALARY"));
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
