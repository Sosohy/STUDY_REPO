package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("req = " + req);
        System.out.println("res = " + res);

        HttpServletRequest hRequest = (HttpServletRequest) req;
        HttpServletResponse hResponse = (HttpServletResponse) res;

        String httpMethod = hRequest.getMethod();
        System.out.println("httpMethod = " + httpMethod);

        if("GET".equals(httpMethod)){
            doGet(hRequest, hResponse);
        }else if("POST".equals(httpMethod)){
            doPost(hRequest, hResponse);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청 처리할 메소드 호출");
    }
}
