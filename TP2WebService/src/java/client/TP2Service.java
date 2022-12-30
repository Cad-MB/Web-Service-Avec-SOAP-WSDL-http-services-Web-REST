/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javafx.collections.ObservableList;



/**
 *
 * @author Dell
 */
@WebService(serviceName = "TP2Service")
public class TP2Service {

      Connection  connection=DB.getConnect();
      ObservableList<Article> ArticlesList = FXCollections.observableArrayList();
      String query;
      PreparedStatement preparedStatement;
      ResultSet resultSet;
      
    @WebMethod(operationName = "Consulter")
    public ObservableList<Article> Consulter() {
 
        try {
            System.out.println("consulting...");
          
            query = "SELECT * FROM `article`";
            preparedStatement = connection.prepareStatement(query);
            System.out.println("prepared statement...");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Article a = new Article();
                a.setNArticleProperty(resultSet.getString("NArticle"));
                a.setLibelleProperty(resultSet.getString("libelle"));
                a.setPrixProperty(resultSet.getInt("Prix_unit"));
                a.setTvaProperty(resultSet.getInt("tva"));
                ArticlesList.add(a);
                System.out.println(a.libelle);

            }
            System.out.println("size = " + ArticlesList.size());

        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArticlesList; 
    }

    /**
     * Web service operation
     * @param NArticle
     * @param libelle
     * @param tva
     * @param prix
     * @return 
     */
   @WebMethod(operationName = "Ajouter")
    public String Ajouter(@WebParam(name = "NArticle") String NArticle, @WebParam(name = "libelle") String libelle, @WebParam(name = "Prix_unit") int prix ,@WebParam(name = "tva") int tva) {
        System.out.println("adding.... : " + libelle);
       
        if (libelle.length() > 0 && libelle.length() < 40 && tva > 0 && prix > 0) {
            try {
                query = "INSERT INTO `article` VALUES (?, ?, ? ,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, NArticle);
                preparedStatement.setString(2, libelle);
                preparedStatement.setInt(3, prix);
                preparedStatement.setInt(4, tva);
                preparedStatement.executeUpdate();
                 
                return "Ajout de l'article avec succès";
            } catch (SQLException ex) {
                Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
                return "Erreur d'ajout de l'article";
            }
        } else {
            return "Erreur d'ajout, Veuillez vérifier vos contraintes d'artibuts";
        }
    }
    
     /**
     * Web service operation
     *
     * @param NArticle
     * @return
     */
    @WebMethod(operationName = "supprimerArticle")
    public String supprimerArticle(@WebParam(name = "NArticle") String NArticle) {
        

        try {
           query = "DELETE FROM `article` WHERE NArticle  = '" + NArticle + "'";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return "Article supprimé avec succès";
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur de la suppression";
        }
    }

    /**
     * Web service operation
     *
     * @param NArticle
     * @param libelle
     * @param tva
     * @param prix
     * @return
     */
    @WebMethod(operationName = "modifierArticle")
    public String modifierArticle(@WebParam(name = "NArticle") String NArticle, @WebParam(name = "libelle") String libelle, @WebParam(name = "tva") int tva, @WebParam(name = "Prix_unit") int prix) {
 
        if (libelle.length() > 0 && libelle.length() < 40 && tva > 0 && prix > 0) {
            try {
               query = "UPDATE `article` SET libelle = ?, Prix_unit = ?, tva =  ? WHERE NArticle = '" + NArticle + "';";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, libelle);
                preparedStatement.setInt(2, prix);
                preparedStatement.setInt(3, tva);
                preparedStatement.executeUpdate();
                return "Modification de l'article avec succès";
            } catch (SQLException ex) {
                Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
                return "Erreur de modification de l'article";
            }
        } else {
            return "Erreur de modification, Veuillez vérifier vos contraintes d'artibuts";
        }
    }

    /**
     * Web service operation
     * @param libelle
     * @return 
     */
    @WebMethod(operationName = "Rechercher")
    public ObservableList Rechercher(@WebParam(name = "libelle") String libelle) {
       
        ObservableList<Article> searchedList = FXCollections.observableArrayList();
      

        try {
            query = "SELECT * FROM `article` WHERE libelle LIKE '" + libelle + "%'";
            preparedStatement = connection.prepareStatement(query);
            System.out.println("statement prepared !!");
            resultSet = preparedStatement.executeQuery();
            System.out.println("query executed successfully !!");

            while (resultSet.next()) {
                Article a = new Article();
                a.setNArticleProperty(resultSet.getString("NArticle"));
                a.setLibelleProperty(resultSet.getString("libelle"));
                a.setPrixProperty(resultSet.getInt("Prix_unit"));
                a.setTvaProperty(resultSet.getInt("tva"));
                searchedList.add(a);

            }
            System.out.println("searched list loaded successfully !!");

            for (int i = 0; i < searchedList.size(); i++) {
                Article a = searchedList.get(i);
                System.out.println("NArticle: " + a.getNArticle() + " libelle: " + a.getLibelle() + " Prix_unit: " + a.getPrix() + " tva: " + a.getTva());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchedList;
    }
    
    
}
