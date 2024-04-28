package com.example.csit228f2_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.w3c.dom.Element;
import javafx.scene.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BorrowedBooks extends Component implements Initializable {


    public VBox bookContainer;
    public Button refresh;


    @FXML
    public int retieveBooks(){
        bookContainer.getChildren().removeAll();
        bookContainer.getChildren().clear();

        String description;
        String title;
        Button borrowBook;


        try (Connection c = MySQLConnection.getConnection();

             Statement statement=c.createStatement();
        ) {

            System.out.println(HelloApplication.id);
            String selectQuery="select * from books where userid = "+HelloApplication.id;
            ResultSet resultSet=statement.executeQuery(selectQuery);
            while(resultSet.next()){

                    HBox hb = new HBox();
                    VBox vb = new VBox();
                    int bookid = resultSet.getInt("bookid");
                    System.out.println("book id: " + bookid);
                    borrowBook = new Button();
                    borrowBook.setText("Cancel Reservation");
                    System.out.println(resultSet.getString("userid"));
                    Text txnew = new Text(resultSet.getString("title"));
                    TextFlow txnew2 = new TextFlow(new Text("Reservation valid for 7 days"));
                    txnew2.maxHeight(100);

                    txnew.setFont(Font.font("Verdana", 20));

                    vb.getChildren().add(txnew);
                    vb.getChildren().add(txnew2);
                    vb.getChildren().add(borrowBook);
                    System.out.println(resultSet.getString("photo"));
                    Image img = new Image(getClass().getResourceAsStream(resultSet.getString("photo")));
                    ImageView imgV = new ImageView(img);

                    imgV.setFitHeight(100);
                    imgV.setFitWidth(100);
                    hb.getChildren().add(imgV);
                    hb.getChildren().add(vb);
                    hb.setPadding(new Insets(6,6,6,6));
                    bookContainer.getChildren().add(hb);

                    borrowBook.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try (Connection c = MySQLConnection.getConnection();

                                 Statement statement2=c.createStatement();
                            ) {

                                statement2.addBatch("Delete from orders where bookid="+bookid);
                                statement2.addBatch("update books  set availability=1, userid=0 where bookid="+bookid);
                                int jp=joption();
                                if(jp==JOptionPane.NO_OPTION||jp==JOptionPane.CANCEL_OPTION){

                                    return;
                                }
                                statement2.executeBatch();
                                retieveBooks();


                            }catch (SQLException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    });
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        retieveBooks();
    }
    int joption(){
        int jp=JOptionPane.showConfirmDialog(this,"Are you sure you want to reserve this book?");
        return jp;
    }
    public void returnToFrontPage(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        try {
            Stage stage= (Stage) refresh.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void toborrowpage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("book-borrow.fxml"));
        try {
            Stage stage= (Stage) refresh.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
