package com.example.csit228f2_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static String URL="jdbc:mysql://localhost:3306/abadianodb";
    private static String USERNAME="abadianodb";
    private static String PASSWORD="jerwin123";


    public static Connection getConnection( ) {
         Connection c=null;
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            c= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
        return c;

    }



}
