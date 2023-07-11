package com.example.calculate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/avg")
public class AvgNum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        int sum = (int) req.getAttribute("sum");
        float avg = (float) (sum / 2.0);
        req.setAttribute("sum", sum);
        req.setAttribute("avg", avg);
//        PrintWriter out = resp.getWriter();
//        out.println("Sum is: " + sum);
//        out.println("Average is: " + avg);
        req.getRequestDispatcher("Avgresult.jsp").forward(req,resp);
    }

}
