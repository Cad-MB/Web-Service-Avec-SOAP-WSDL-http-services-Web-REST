/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

import helpers.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author ASUS
 */
public class Article {

    private int numeroArticle;
    private String libelle;
    private double prixUnit;
    private double tva;

    private SimpleIntegerProperty numeroArticleProperty;
    private SimpleStringProperty libelleProperty;
    private SimpleDoubleProperty prixUnitProperty;
    private SimpleDoubleProperty tvaProperty;

    Connection connection = DbConnect.getConnect();

    //constructeur par defaut
    public Article() {
    }

    //contructeur
    public Article(int numeroArticle, String libelle, double prixUnit, double tva) {
        this.numeroArticle = numeroArticle;
        this.libelle = libelle;
        this.prixUnit = prixUnit;
        this.tva = tva;
        this.numeroArticleProperty = new SimpleIntegerProperty(numeroArticle);
        this.libelleProperty = new SimpleStringProperty(libelle);
        this.prixUnitProperty = new SimpleDoubleProperty(prixUnit);
        this.tvaProperty = new SimpleDoubleProperty(tva);
    }

    public Article(String libelle, double prixUnit, double tva) {
        this.libelle = libelle;
        this.prixUnit = prixUnit;
        this.tva = tva;
        this.libelleProperty = new SimpleStringProperty(libelle);
        this.prixUnitProperty = new SimpleDoubleProperty(prixUnit);
        this.tvaProperty = new SimpleDoubleProperty(tva);
    }

    public int getNumeroArticle() {
        return numeroArticle;
    }

    public void setNumeroArticle(int numeroArticle) {
        this.numeroArticle = numeroArticle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(double prixUnit) {
        this.prixUnit = prixUnit;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public int getNumeroArticleProperty() {
        return numeroArticleProperty.getValue();
    }

    public void setNumeroArticleProperty(int nArticleProperty) {
        this.numeroArticleProperty = new SimpleIntegerProperty(nArticleProperty);
        this.numeroArticle = nArticleProperty;
    }

    public String getLibelleProperty() {
        return libelleProperty.getValue();
    }

    public void setLibelleProperty(String libelleProperty) {
        this.libelleProperty = new SimpleStringProperty(libelleProperty);
        this.libelle = libelleProperty;
    }

    public double getPrixUnitProperty() {
        return prixUnitProperty.getValue();
    }

    public void setPrixUnitProperty(double prixUnitProperty) {
        this.prixUnitProperty = new SimpleDoubleProperty(prixUnitProperty);
        this.prixUnit = prixUnitProperty;
    }

    public double getTvaProperty() {
        return tvaProperty.getValue();
    }

    public void setTvaProperty(double tvaProperty) {
        this.tvaProperty = new SimpleDoubleProperty(tvaProperty);
        this.tva = tvaProperty;
    }

    //methods
    public void ajoutArticle(ActionEvent event) {
        System.out.println("adding.... : " + libelle);
        String query;
        PreparedStatement preparedStatement;
        if (libelle.length() > 0 && libelle.length() < 40 && tva > 0 && prixUnit > 0) {
            try {
                query = "INSERT INTO Article (libelle, prixUnit, tva) VALUES (?, ?, ?);";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, libelle);
                preparedStatement.setDouble(2, prixUnit);
                preparedStatement.setDouble(3, tva);
                preparedStatement.executeUpdate();
                System.out.println("Inserted successufully!!");
                ((Node) event.getSource()).getScene().getWindow().hide();
            } catch (SQLException ex) {
                Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("L'article ne peut pas être ajouté");
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur d'ajout de l'article");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("L'article ne peut pas être ajouté");
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur d'ajout de l'article");
            alert.showAndWait();
        }
    }

    public void modifArticle(ActionEvent event, String libelle, double prixUnit, double tva) {
        this.libelle = libelle;
        this.prixUnit = prixUnit;
        this.tva = tva;

        System.out.println("modification.... : " + libelle);
        String query;
        PreparedStatement preparedStatement;
        if (libelle.length() > 0 && libelle.length() < 40 && tva > 0 && prixUnit > 0) {
            try {
//                query = "UPDATE Article SET libelle = " + libelle + ", prixUnit = " + prixUnit + ", tva =  " + tva + " WHERE nArticle = " + numeroArticle;
                query = "UPDATE Article SET libelle = ?, prixUnit = ?, tva =  ? WHERE nArticle = " + numeroArticle + ";";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, libelle);
                preparedStatement.setDouble(2, prixUnit);
                preparedStatement.setDouble(3, tva);
                preparedStatement.executeUpdate();
                System.out.println("updated successufully!!");
                ((Node) event.getSource()).getScene().getWindow().hide();
            } catch (SQLException ex) {
                Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("L'article ne peut pas être modifié");
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de modification de l'article");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("L'article ne peut pas être modifié");
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de modification de l'article");
            alert.showAndWait();
        }
    }

    public ObservableList<Article> consult1Article(String libRech) {
        System.out.println("searching.... : " + libRech);
        ObservableList<Article> searchedList = FXCollections.observableArrayList();
        String query;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            query = "SELECT * FROM `article` WHERE libelle LIKE '%" + libRech + "%'";
            preparedStatement = connection.prepareStatement(query);
            System.out.println("statement prepared !!");
            resultSet = preparedStatement.executeQuery();
            System.out.println("query executed successfully !!");

            while (resultSet.next()) {
                Article a = new Article();
                a.setNumeroArticleProperty(resultSet.getInt("nArticle"));
                a.setLibelleProperty(resultSet.getString("libelle"));
                a.setPrixUnitProperty(resultSet.getDouble("prixUnit"));
                a.setTvaProperty(resultSet.getDouble("tva"));
                searchedList.add(a);

            }
            System.out.println("searched list loaded successfully !!");

            for (int i = 0; i < searchedList.size(); i++) {
                Article a = searchedList.get(i);
                System.out.println("N: " + a.getNumeroArticle() + " Libellee: " + a.getLibelle() + " PrixUnitaire: " + a.getPrixUnit() + " TVA: " + a.getTva());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchedList;
    }

    public ObservableList<Article> consultListArticles() {
        System.out.println("consulting.... : ");
        ObservableList<Article> ArticlesList = FXCollections.observableArrayList();
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
                ArticlesList.add(a);

            }
            System.out.println("ArticlesList loaded successfully !!");

            for (int i = 0; i < ArticlesList.size(); i++) {
                Article a = ArticlesList.get(i);
                System.out.println("N: " + a.getNumeroArticle() + " Libellee: " + a.getLibelle() + " PrixUnitaire: " + a.getPrixUnit() + " TVA: " + a.getTva());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArticlesList;
    }

    public void supprimArticle() {
        System.out.println("deleting.... : " + libelle);
        String query;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            query = "DELETE FROM `article` WHERE nArticle  = " + numeroArticle;
            preparedStatement = connection.prepareStatement(query);
            System.out.println("executing statement...");
            preparedStatement.execute();
            System.out.println("article deleted successfully!!");

        } catch (SQLException ex) {
            Logger.getLogger(TableView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
