package com.example.calculate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlDAO {
    public String sqlProcessDAO(String query,String type) throws Exception{
        ResultSet rs;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "sys123")) {
                Statement st = con.createStatement();
                System.out.println("connection established successfully...!!");
                if (type.toLowerCase().equals("insert") || type.toLowerCase().equals("update")) {
                    System.out.println("Inside insert/update-----");
                    int count = st.executeUpdate(query);
                    return count + " rows got updated/Inserted";
                } else if (type.toLowerCase().equals("create")) {
                    System.out.println("Inside Create-----");
                    try {
                        st.execute(query);
                    } catch(Exception e){
                        return "Table not Created Successfully";
                    }
                    return "Table got Created Successfully";
                } else if (type.toLowerCase().equals("select")){
                    int count=0;
                    rs = st.executeQuery(query);
                    while ( rs.next() ) {
                        count++;
//                        System.out.println(rs.getString(0));
                        System.out.println(rs.getString(1));
                        System.out.println(rs.getString(2));
                        System.out.println(rs.getString(3));
                        System.out.println(rs.getString(4));
                        System.out.println(rs.getString(5));
                    }
                    return count+" no of Rows are fetched...";
                } else {
                    return "Wrong type of Operation Selected";
                }
            }
        } catch(Exception e) {
            System.out.println("Exception due to: "+e.toString());
        } finally {
            System.out.println("Calling Finally...");
        }
        return null;
    }
}