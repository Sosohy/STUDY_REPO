package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {
    public int registMenu(Connection con, Menu registMenu) {

        PreparedStatement pstm = null;
        int result = 0;

        Properties prop = new Properties();

        /* 설명. 쿼리는 XML 파일로부터 읽어와서 활용 */
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            String query = prop.getProperty("insertMenu");
            System.out.println(query);

            pstm = con.prepareStatement(query);
            pstm.setString(1, registMenu.getMenuName());
            pstm.setInt(2, registMenu.getMenuPrice());
            pstm.setInt(3, registMenu.getCategoryCode());
            pstm.setString(4, registMenu.getOrderableStatus());
            result = pstm.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
