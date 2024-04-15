package com.example.csit228f2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class HelloController extends Component {
    public ToggleButton tbNight;
    public Button logout;
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
      JOptionPane.showMessageDialog(this,"wala pani sir.");
    }
}