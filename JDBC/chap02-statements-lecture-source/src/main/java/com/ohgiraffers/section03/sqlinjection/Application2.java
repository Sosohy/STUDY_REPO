package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명
 *  Statement와 달리 plaeholder(?)를 통한 sql injection 공격을 막을 수 있게 작성되어 있어
 *  보안적 측면에서도 PrepareStatement가 우수하다.
* */
public class Application2 {

    private  static String empId = "200";
    private  static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstm = null;
        ResultSet rSet = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?;";

        /* 설명
         *  아래 sql과 같이 PreparedStatement는 placeholder로 입력되는 값에 single quotation(')이 있다면
         *  single quotation을 하나 더 붙여주고 setString으로 값이 들어간다면 양 옆에도 single quotation을 붙여준다.
        * */
//        SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ''' OR 1=1 AND EMP_ID = ''200';

        try {
            pstm = con.prepareStatement(query);
            pstm.setString(1, empId);
            pstm.setString(2, empName);

            rSet = pstm.executeQuery();

            if(rSet.next()){
                System.out.println(rSet.getString("EMP_NAME") + "님 환영합니다.");
            }else {
                System.out.println("회원 정보 없음");
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
