package com.ohgiraffers.section03.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstm = null;
        int result = 0;

        /* soft delete */
//        String query1 = "UPDATE TBL_MENU SET ORDERABLE_STATUS = 'N' WHERE MENU_CODE = ? ";

        /* hard delete */
        String query2 = "DELETE FROM TBL_MENU WHERE MENU_CODE = ?";

        try {
            pstm = con.prepareStatement(query2);
            pstm.setInt(1, 23);

            result = pstm.executeUpdate();
            if(result > 0){
                commit(con);
            }else{
                rollback(con);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstm);
            close(con);
        }

        System.out.println("result = " + result);
    }
}
