package com.ohgiraffers.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {
    public int modifyMenu(Connection con, Menu modifyMenu) {
        PreparedStatement pstm = null;
        int result = 0;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            System.out.println(prop.getProperty("updateMenu"));

            String query = prop.getProperty("updateMenu");

            pstm = con.prepareStatement(query);
            pstm.setString(1, modifyMenu.getMenuName());
            pstm.setInt(2, modifyMenu.getMenuPrice());
            pstm.setInt(3, modifyMenu.getMenuCode());

            result = pstm.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
