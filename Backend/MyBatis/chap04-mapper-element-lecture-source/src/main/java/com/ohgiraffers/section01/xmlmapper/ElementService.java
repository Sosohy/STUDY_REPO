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

    }
}
