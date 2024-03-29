package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;
import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementService {
    public void selectResultMapTest() {

        SqlSession sqlSession = getSqlSession();
        ElementMapper elementMapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menus = elementMapper.selectResultMapTest();
        menus.forEach(System.out::println);

        sqlSession.close();

    }

    public void selectResultMapAssociationTest() {

        SqlSession sqlSession = getSqlSession();
        ElementMapper elementMapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuAndCategoryDTO> menus = elementMapper.selectResultMapAssociationTest();
        menus.forEach(System.out::println);

        sqlSession.close();

    }

    public void selectResultMapCollectionTest() {

        SqlSession sqlSession = getSqlSession();
        ElementMapper elementMapper = sqlSession.getMapper(ElementMapper.class);

        List<CategoryAndMenuDTO> menus = elementMapper.selectResultMapCollectionTest();
        menus.forEach(System.out::println);

        sqlSession.close();
    }
}
