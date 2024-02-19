package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // redirect 시키면 그걸 받는 서블릿은 무조건 GET으로 받음
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. 리다이렉트로 넘어온 서블릿이더라도 같은 JSESSIONID가 넘어왔을 것이므로 기존과 같은 session객체가 생성  */
        HttpSession session = req.getSession();

        // getAttribute 꺼내면 object형 <-> getParameter는 꺼내면 String형
        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>first name is ")
                .append(firstName)
                .append("\nlast name is ")
                .append(lastName)
                .append("</h3>");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();

    }

}
