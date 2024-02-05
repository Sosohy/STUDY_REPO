package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rSet = null;

        try {

            /* 설명. Statement와 달리 prepareStatement에서는 생성 당시에 쿼리가 있어야 한다. */
            // 사용자입력에 따라 달라지는 쿼리를 사용할 때는 prepare쓰는게 좋음, 쿼리 입력하면 해킹 될수도
            pstm = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");
            rSet = pstm.executeQuery();

            while(rSet.next()){
                System.out.println(rSet.getString("EMP_ID") + ", " + rSet.getString("EMP_NAME"));
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
