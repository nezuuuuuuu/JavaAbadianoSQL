package com.example.csit228f2_2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveData {
    static void getData(){
        try (Connection c = MySQLConnection.getConnection();

             Statement statement=c.createStatement();
        ) {


            String selectQuery="select * from users";
            ResultSet resultSet=statement.executeQuery(selectQuery);
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                System.out.println(id+" "+ name+" "+email);
            }

            System.out.println("Succesfully");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static int checkIfValid(String name,String pass){
        try (Connection c = MySQLConnection.getConnection();

             Statement statement=c.createStatement();
        ) {


            String selectQuery="select * from useraccounts";
            ResultSet resultSet=statement.executeQuery(selectQuery);
            while(resultSet.next()){
                System.out.println(resultSet.getString("username"));
               if(name.equals(resultSet.getString("username"))){
                   System.out.println("same username");
                   System.out.println(resultSet.getString("password"));
                   if(pass.equals(resultSet.getString("password"))){
                       System.out.println("same pass");
                       return 1;
                   }
               }



            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
