package com.example.csit228f2_2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    public static List<User> users;
    public static int id;
    static AnchorPane as;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Creating a GridPane layout
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(25);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label titleLabel = new Label("Login");
        titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(titleLabel, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);

        TextField usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        // Adding Password Field

        HBox hb2=new HBox();

        PasswordField passwordField = new PasswordField();
//        Button show = new Button("show");

//        TextField passwrodf2= new TextField();
//        grid.add(passwrodf2, 1, 2);
        grid.add(passwordField, 1, 2);
//        grid.add(show, 2, 2);
//
        // Adding Login Button
        Button loginButton = new Button("Login");

        Button registerBtn = new Button("register");

        HBox hb=new HBox();
        hb.getChildren().add(loginButton);
        hb.getChildren().add(registerBtn);

        grid.add(hb, 1, 4);


        // Adding Message Label
//        final Label messageLabel = new Label();
//        grid.add(messageLabel, 1, 6);

        // Setting an action for the login button


        // Creating a scene and adding the grid to it
        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);

        // Show the stage
        stage.show();



//        show.setOnMouseReleased(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                passwrodf2.setText(passwordField.getText());
//
//                passwordField.setVisible(false);
//                passwrodf2.setVisible(true);
//            }
//        });


        registerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
                try {
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameTextField.getText();
                String password = passwordField.getText();
                if(RetrieveData.checkIfValid(username,password)>0){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                    try {
                        Scene scene = new Scene(loader.load());
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }



            }
        });


    }

    public static class HelloController {
        public ToggleButton tbNight;
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
                tbNight.getScene().getStylesheets().add(
                        getClass().getResource("styles.css").toExternalForm());
            } else {
                tbNight.getScene().getStylesheets().clear();
            }
        }


    }
}