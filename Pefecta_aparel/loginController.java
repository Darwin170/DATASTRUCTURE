
package Pefecta_aparel;

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



public class loginController implements Initializable {
     @FXML
    private Button BTNLog;

    @FXML
    private Button Btnsign;

    @FXML
    private AnchorPane LOGINFORM;

    @FXML
    private AnchorPane MAIN;

    @FXML
    private PasswordField Password;

    @FXML
    private AnchorPane SIGNUPFORM;

    @FXML
    private TextField USERnameREG;

    @FXML
    private TextField UserN;

    @FXML
    private Button createacc;

    @FXML
    private Button createacc_Btn;

    @FXML
    private PasswordField passwordReg;
    @FXML
    private ImageView imgLogin, imgSignup;

    

    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private Alert alert;
    
    public void loginAccount(){
        
        String selectData = "SELECT username, password FROM user WHERE username = '"
                + UserN.getText() + "' and password = '" + Password.getText() + "'";
        
        connect = database.connectDB();
        
        try{
            
            if(UserN.getText().isEmpty()|| Password.getText().isEmpty() ){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                prepare = connect.prepareStatement(selectData);
                result = prepare.executeQuery();
                
                if(result.next()){
                    
                    data.username = UserN.getText();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully login");
                    alert.showAndWait();
                    
                    BTNLog.getScene().getWindow().hide();
                    
                    Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                    
                    Stage stage = new Stage();
                    stage.setTitle("Task Manager System");
                    
                    Scene scene = new Scene(root); 
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Username/Password");
                    alert.showAndWait();
                }
            }
            
            
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void registerAccount(){
        String insertData = "INSERT INTO user(username, password, date) VALUES(?,?,?)";
        
        connect = database.connectDB();
        
        try{
            
            if(USERnameREG.getText().isEmpty() ||passwordReg.getText().isEmpty() ){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            }else{
                String checkUsername = "SELECT username FROM user WHERE username = '" 
                        + USERnameREG.getText() + "'";
                
                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();
                
                if(result.next()){
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(USERnameREG.getText() + "was already taken");
                    alert.showAndWait();
                }else{
                    
                    if(passwordReg.getText().length() < 8){
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid Password, atleast 8 characters needed");
                        alert.showAndWait();
                    }else{
                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, USERnameREG.getText());
                        prepare.setString(2,passwordReg.getText());

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare.setString(3, String.valueOf(sqlDate));
                        
                        prepare.executeUpdate();
                        
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully create a new account");
                        alert.showAndWait();
                        
                        USERnameREG.setText("");
                        passwordReg.setText("");
                        
                        SIGNUPFORM.setVisible(false);
                        LOGINFORM.setVisible(true);
                        
                    }
                    
                }
            }
           
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    
   public void switchForm(ActionEvent event) {
    if (event.getSource() == createacc) {
        SIGNUPFORM.setVisible(true);
        LOGINFORM.setVisible(false);
    } else if (event.getSource() == Btnsign) {
        SIGNUPFORM.setVisible(false);
        LOGINFORM.setVisible(true);
    }
}

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}
