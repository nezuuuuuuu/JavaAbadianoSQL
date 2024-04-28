package com.example.csit228f2_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void deleteData(int n) {
        try (Connection c = MySQLConnection.getConnection();

             PreparedStatement statement=c.prepareStatement("delete from users where id=?");
        ) {




            statement.setString(1,String.valueOf(n));
            int rowDeleted= statement.executeUpdate();
            if(rowDeleted>0){
                System.out.println("succes");
            }


            RetrieveData.getData();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
