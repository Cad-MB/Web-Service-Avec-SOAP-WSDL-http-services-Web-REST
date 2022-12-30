/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import modals.Article;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "ArticleWebService")
public class ArticleWebService {

    Connection connection = DbConnect.getConnect();

    /**
     * Web service operation
     *
     * @param libelle
     * @param tva
     * @param prix_unit
     * @return
     */
    @WebMethod(operationName = "ajouter_article")
    public String ajouter_article(@WebParam(name = "libelle") String libelle, @WebParam(name = "tva") double tva, @WebParam(name = "prix_unit") double prix_unit) {
//
        String query;
        PreparedStatement preparedStatement;
        if (libelle.length() > 0 && libelle.length() < 40 && tva > 0 && prix_unit > 0) {
            try {
                query = "INSERT INTO Article (libelle, prixUnit, tva) VALUES (?, ?, ?);";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, libelle);
                preparedStatement.setDouble(2, prix_unit);
                preparedStatement.setDouble(3, tva);
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
     * @param nArticle
     * @param libelle
     * @param tva
     * @param prix_unit
     * @return
     */
    @WebMethod(operationName = "modifierArticle")
    public String modifierArticle(@WebParam(name = "nArticle") int nArticle, @WebParam(name = "libelle") String libelle, @WebParam(name = "tva") double tva, @WebParam(name = "prix_unit") double prix_unit) {
        String query;
        PreparedStatement preparedStatement;
        if (libelle.length() > 0 && libelle.length() < 40 && tva > 0 && prix_unit > 0) {
            try {
                query = "UPDATE Article SET libelle = ?, prixUnit = ?, tva =  ? WHERE nArticle = " + nArticle + ";";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, libelle);
                preparedStatement.setDouble(2, prix_unit);
                preparedStatement.setDouble(3, tva);
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
     *
     * @param nArticle
     * @return
     */
    @WebMethod(operationName = "supprimerArticle")
    public String supprimerArticle(@WebParam(name = "nArticle") int nArticle) {
        String query;
        PreparedStatement preparedStatement;

        try {
            query = "DELETE FROM `article` WHERE nArticle  = " + nArticle;
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
     * @return
     */
    @WebMethod(operationName = "ConsulterListArticle")
    public ObservableList<Article> ConsulterListArticle() {
        ObservableList<Article> articles = FXCollections.observableArrayList();
        String query;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            query = "SELECT * FROM `article`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            System.out.println("query executed successfully !!");

            while (resultSet.next()) {
                Article a = new Article();
                a.setNumeroArticleProperty(resultSet.getInt("nArticle"));
                a.setLibelleProperty(resultSet.getString("libelle"));
                a.setPrixUnitProperty(resultSet.getDouble("prixUnit"));
                a.setTvaProperty(resultSet.getDouble("tva"));
                articles.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articles;
    }

    /**
     * Web service operation
     *
     * @param libelle
     * @return
     */
    @WebMethod(operationName = "Consulter1Article")
    public ObservableList Consulter1Article(@WebParam(name = "libelle") String libelle) {
        ObservableList<Article> articles = FXCollections.observableArrayList();
        String query;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            query = "SELECT * FROM `article` WHERE libelle LIKE '" + libelle + "%'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Article a = new Article();
                a.setNumeroArticleProperty(resultSet.getInt("nArticle"));
                a.setLibelleProperty(resultSet.getString("libelle"));
                a.setPrixUnitProperty(resultSet.getDouble("prixUnit"));
                a.setTvaProperty(resultSet.getDouble("tva"));
                articles.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articles;
    }
}
