package com.example.calculate.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
            String n = request.getParameter("userName");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("Welcome " + n);

            Cookie ck = new Cookie("uname", n);//creating cookie object
            response.addCookie(ck);//adding cookie in the response
            //creating submit button
            out.print("<form action='User2Page' method = 'post'>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");

            out.close();
    }
}
