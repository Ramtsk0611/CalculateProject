package com.example.calculate.servlet;

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
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
            Statement st=con.createStatement();
            System.out.println("connection established successfully...!!");
            if(type.toLowerCase().equals("insert") ||type.toLowerCase().equals("update")){
                int count = st.executeUpdate(query);
                out = count+" rows got updated/Inserted";
            } else if (type.toLowerCase().equals("create")) {
                st.execute(query);
                out = "Table got Created Successfully";
            } else {
                out = "Wrong type of Operation Selected";
            }
            req.setAttribute("Response",out);
            req.getRequestDispatcher("sqlResponse.jsp").forward(req,resp);
//            ResultSet rs=st.executeQuery("Select * from "+tb);
//            while(rs.next())
//            {
//
//            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

