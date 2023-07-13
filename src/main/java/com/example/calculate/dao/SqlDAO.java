package com.example.calculate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlDAO {
    public String sqlProcessDAO(String query,String type) throws Exception{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "oracle123")) {
                Statement st = con.createStatement();
                System.out.println("connection established successfully...!!");
                if (type.toLowerCase().equals("insert") || type.toLowerCase().equals("update")) {
                    System.out.println("Inside insert/update-----");
                    int count = st.executeUpdate(query);
                    return count + " rows got updated/Inserted";
                } else if (type.toLowerCase().equals("create")) {
                    System.out.println("Inside Create-----");
                    boolean status = st.execute(query);
                    if(status == true) {
                        return "Table got Created Successfully";
                    } else {
                        return "Table not Created Successfully";
                    }
                } else {
                    return "Wrong type of Operation Selected";
                }
            }
        } catch(Exception e) {
            System.out.println("Exception due to: "+e.toString());
        }
        return null;
    }
}