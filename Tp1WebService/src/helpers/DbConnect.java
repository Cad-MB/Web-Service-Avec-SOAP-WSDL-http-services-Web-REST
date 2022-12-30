/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DbConnect {
    private static String HOST = "localhost";
        private static int PORT = 3306;
        private static String DB_NAME = "tp1_articles";
        private static String USERNAME = "root";
        private static String PASSWORD = "root";
        private static Connection connection ;
        
        
        public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s?serverTimezone=GMT", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }
        
        public static void TestConnectionMySql(){
            //chargement du piloe
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(Exception e){
                System.out.println("Erreur de chargement de pilote");
                e.printStackTrace();
            }
        }
    
}
