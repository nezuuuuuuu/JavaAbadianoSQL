package com.example.csit228f2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.awt.Color.WHITE;
import static java.awt.Color.white;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelloController extends Component {
    @FXML
    public ToggleButton tbNight;
    @FXML
    public Button logout;
    @FXML
    public Button borrowbook;
    public Text txtName;
    @FXML
    private Label welcomeText;

    @FXML
    private void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void onNightModeClick() {
        if (tbNight.isSelected()) {
            // night mode
            txtName.setFill(Color.WHITE); // Setting font color

            tbNight.getScene().getStylesheets().add(
                    getClass().getResource("styles.css").toExternalForm());
        } else {
            txtName.setFill(Color.BLACK); // Setting font color
            tbNight.getScene().getStylesheets().clear();
        }
    }
    @FXML
    private void toborrowpage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("book-borrow.fxml"));
        try {
            Stage stage= (Stage) tbNight.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void logout() {
        Stage stage=(Stage) tbNight.getScene().getWindow();

        HelloApplication ha=new HelloApplication();
        try {
            ha.start(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(ActionEvent actionEvent) {
        try (Connection c = MySQLConnection.getConnection();

             PreparedStatement statement=c.prepareStatement("delete from useraccounts where id="+HelloApplication.id);
        ) {



            int rowDeleted= statement.executeUpdate();
            if(rowDeleted>0){


                Stage stage= (Stage) tbNight.getScene().getWindow();

                (new HelloApplication()).start(stage);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}