package com.example.calculate.servlet;

import com.example.calculate.service.SqlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/sql")
public class SqlServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String query=req.getParameter("sqlQuery");
        String type=req.getParameter("type");
        String out;
        SqlService service = new SqlService();
        try
        {
            out = service.process(query,type);
            req.setAttribute("Response",out);
            req.getRequestDispatcher("sqlResponse.jsp").forward(req,resp);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

