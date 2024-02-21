package com.ohgiraffers.section01.xml;

import org.apache.ibatis.session.SqlSession;


import java.util.*;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

public class MenuService {
    public void findMenuByPrice(int maxPrice) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.selectMenuByPrice(maxPrice);
        if(menus != null && !menus.isEmpty())
            menus.forEach(System.out::println);
        else
            System.out.println("DB와 연동 실패 또는 검색 결과 없음");

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.searchMenu(searchCriteria);

        if(menus != null && !menus.isEmpty())
            menus.forEach(System.out::println);
        else
            System.out.println("DB와 연동 실패 또는 검색 결과 없음");

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.searchMenuBySupCategory(searchCriteria);
        
        if(menus != null && !menus.isEmpty())
            menus.forEach(System.out::println);
        else
            System.out.println("DB와 연동 실패 또는 검색 결과 없음");
        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomList) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.searchMenuByRandomMenuCode(randomList);

        if(menus != null && !menus.isEmpty())
            menus.forEach(System.out::println);
        else
            System.out.println("DB와 연동 실패 또는 검색 결과 없음");
        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menus != null && !menus.isEmpty())
            menus.forEach(System.out::println);
        else
            System.out.println("DB와 연동 실패 또는 검색 결과 없음");
        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.searchMenuByNameOrCategory(criteria);

        if(menus != null && !menus.isEmpty())
            menus.forEach(System.out::println);
        else
            System.out.println("DB와 연동 실패 또는 검색 결과 없음");
        sqlSession.close();

    }

    public void modifyMenu(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(criteria);
        if(result > 0) {
            System.out.println("정보 수정 성공");
            sqlSession.commit();
        }else {
            System.out.println("정보 수정 실패");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
