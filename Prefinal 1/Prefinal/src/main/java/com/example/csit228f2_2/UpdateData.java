package com.example.csit228f2_2;
import java.sql.*;

public class UpdateData {

    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();

             PreparedStatement statement=c.prepareStatement("update users  set name = ? where id=?");
        ) {



            statement.setString(1,"mwehehee");
            statement.setString(2,"1");
            int rowUpdated= statement.executeUpdate();
            if(rowUpdated>0){
                System.out.println("succes");
            }


            RetrieveData.getData();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
