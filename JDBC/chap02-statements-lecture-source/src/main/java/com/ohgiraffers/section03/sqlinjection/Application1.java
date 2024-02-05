package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";     // sql 주입

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stm = null;
        ResultSet rSet = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND EMP_NAME = '" + empName + "'";
        System.out.println("query = " + query);

        try {
            stm = con.createStatement();
            rSet = stm.executeQuery(query);

            if(rSet.next()){
                System.out.println(rSet.getString("EMP_NAME") + "님 환영합니다.");
            }else {
                System.out.println("회원 정보 없음");
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
