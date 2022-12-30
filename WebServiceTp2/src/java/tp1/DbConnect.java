/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author ASUS
 */
@Stateless
public class DbConnect {

    private static String HOST = "localhost";
    private static int PORT = 3306;
    private static String DB_NAME = "tp1_articles";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static Connection connection;

    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s?serverTimezone=GMT&useSSL=false", HOST, PORT, DB_NAME), USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    public static void TestConnectionMySql() {
        //chargement du piloe
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Erreur de chargement de pilote");
            e.printStackTrace();
        }
    }
}
