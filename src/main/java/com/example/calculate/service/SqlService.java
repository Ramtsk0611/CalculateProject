package com.example.calculate.service;

import com.example.calculate.dao.SqlDAO;

public class SqlService {
    SqlDAO dao = new SqlDAO();
    public String process(String query,String type){
        try {
            return dao.sqlProcessDAO(query, type);
        } catch(Exception e){
            System.out.println("Exception due to "+e.toString());
        }
        return null;
    }
}