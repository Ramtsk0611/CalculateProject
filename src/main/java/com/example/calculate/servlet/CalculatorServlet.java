package com.example.calculate.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        int sum = a+b;
        req.setAttribute("sum", sum);
        RequestDispatcher reqd = req.getRequestDispatcher("avg");
        reqd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        int sum = a+b;
//        resp.getWriter().println("sum of "+a+" & "+b+" is "+sum);
        req.setAttribute("a",a);
        req.setAttribute("b",b);
        req.setAttribute("sum",sum);
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
