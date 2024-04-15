package com.example.csit228f2_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
//             Statement statement = c.createStatement();
//             PreparedStatement ps= c.prepareStatement( "insert into users (name, email) values(?,?)" )
             Statement statement=c.createStatement();
           ) {
//            String createTableQuery = " CREATE TABLE IF NOT EXISTS users (" +
//                    "id INT AUTO_INCREMENT primary KEY," +
//                    "name varchar(50) not null," + "email varchar(50) not null)";
//

//            statement.execute(createTableQuery);
//            String name="Nico";
//            String email="sdadsad@gmail.com";
//            sta.setString(1,name);
//            ps.setString(2, email);
//            int row=ps.executeUpdate();


            System.out.println("Succesfully");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
