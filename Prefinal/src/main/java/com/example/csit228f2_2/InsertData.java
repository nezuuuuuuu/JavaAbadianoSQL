package com.example.csit228f2_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void insertData(String name, String password) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement ps= c.prepareStatement( "insert into useraccounts (username, password) values(?,?)" )

        ) {




            ps.setString(1,name);
            ps.setString(2, password);
            int row=ps.executeUpdate();
            if(row>0){
                System.out.println("Succesfully");

            }





        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
