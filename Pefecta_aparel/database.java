/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pefecta_aparel;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author WINDOWS 10
 */
public class database {
    
   
    
    public static Connection connectDB(){
        
        try{
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfect","root", ""); 
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
}
