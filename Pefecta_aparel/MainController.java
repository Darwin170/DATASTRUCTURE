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
public class MainController {
    @FXML
   private Button tshirt1 , tshirt2 ,tshirt3 , tshirt4
            , tshirt5,tshir6,tshirt7,tshirt8,tshirt9,nextDesign;
     
@FXML
 private ImageView clrshirt1,clrshirt2,clrshirt3,clrshirt4
        ,clrshirt5,clrshirt6,clrshirt7,clrshirt8,clrshirt9;
    
       @FXML
    private Stage stage;

    @FXML 
    private Scene scene;

    @FXML
    static Parent root = null;

    FXMLLoader loader;
    
    
 public void Designpage(ActionEvent event) throws IOException {
   

       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("design.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
//    }
// public void nextpageforAcidBlue(ActionEvent event) throws IOException {
//   
//
//       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("AcidBlue.fxml"));
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//    }
}
}
    

    
    

