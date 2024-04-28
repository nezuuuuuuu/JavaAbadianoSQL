package com.example.csit228f2_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Register extends Component {
    @FXML
    public PasswordField confirmpasswordtxt;
    @FXML
    public PasswordField password;
    @FXML
    public TextField username;
    public Label doesnotmatch;
    public Label emptyname;
    public Label emptypass;

    @FXML
    public void Registeruser() {
        doesnotmatch.setVisible(false);
        String name =username.getText();
        if(name.equals("")){
            emptyname.setVisible(true);
            return;

        }
        emptyname.setVisible(false);

        String passwrd= password.getText();
        if (passwrd.equals("")){
            emptypass.setVisible(true);
            return;
        }
        emptypass.setVisible(false);
        if(passwrd.equals(confirmpasswordtxt.getText())){
            InsertData.insertData(name,passwrd);
            doesnotmatch.setVisible(false);
            emptypass.setVisible(false);
            emptyname.setVisible(false);
            int jp=JOptionPane.showConfirmDialog(this,"Do you want to sign in directly?");
            if(jp==0){
                if(RetrieveData.checkIfValid(name,passwrd)>0){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                    try {
                        Scene scene = new Scene(loader.load());
                        Stage stage=(Stage) password.getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }else {

                        Stage stage=(Stage) password.getScene().getWindow();

                    HelloApplication ha=new HelloApplication();
                try {
                    ha.start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            }else{
            doesnotmatch.setVisible(true);
        }
        }


}