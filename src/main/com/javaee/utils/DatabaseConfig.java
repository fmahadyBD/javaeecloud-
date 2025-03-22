package com.javaee.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.javaee.constant.AppConstant.*;

public class DatabaseConfig {
public static Connection getConnection(){
    Connection connection = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
        System.out.println("Connected to database");
    }catch(Exception e){
        e.printStackTrace();
    }
    return connection;
}
// this is for only testing purpose:
//public static void main(String[] args) {
//    DatabaseConfig.getConnection();
//}
}
