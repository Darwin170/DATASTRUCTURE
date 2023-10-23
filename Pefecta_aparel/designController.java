/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pefecta_aparel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author umeng
 */
public class designController {
    

    @FXML
   private Button dsn1 , dsn2 ,dsn3 , dsn4
            , dsn5,dsn6,dsn7,dsn8,dsn9,dsn10,dsn11,dsn12,dsn13,dsn14,FINALOUTPPUT,Change;
     
@FXML
 private ImageView Mona,Death,Lexi,Hope
        ,InsideMe,OBG,OBF,PAB,PAG,PER,RG,RENA,Rica,Yakuza;
    
       @FXML
    private Stage stage;

    @FXML 
    private Scene scene;

    @FXML
    static Parent root = null;

    FXMLLoader loader;
    
    
 public void FINALOUTPUT(ActionEvent event) throws IOException {
   

       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("design.Fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
}
  public void BacktoSelectionOfshirt(ActionEvent event) throws IOException {
   

       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
}
 
 
}