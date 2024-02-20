package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    public MenuDAO() {
    }

    public List<MenuDTO> selectAllMenus(SqlSession sqlSession) {

        List<MenuDTO> menuList = sqlSession.selectList("MenuMapper.selectAllMenus");
        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {

        MenuDTO menu = sqlSession.selectOne("MenuMapper.selectMenu", menuCode);
        return menu;
    }
}
