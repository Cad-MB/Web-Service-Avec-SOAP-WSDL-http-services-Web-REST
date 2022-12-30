/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.sql.Connection;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dell
 */
public class Article {
    String libelle;
    String NArticle;
    int prix;
    int tva;

    SimpleStringProperty libelleProperty;
    SimpleStringProperty NArticleProperty;
    SimpleIntegerProperty prixProperty;
    SimpleIntegerProperty tvaProperty;

    private static Connection connection;

    Article(String libelle, int prixUnit, int tva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getLibelleProperty() {
        return libelleProperty.getValue();
    }

    public void setLibelleProperty(String libelleProperty) {
        this.libelleProperty = new SimpleStringProperty(libelleProperty);
        this.libelle = libelleProperty;
    }

    public String getNArticleProperty() {
        return NArticleProperty.getValue();
    }

    public void setNArticleProperty(String nArticleProperty) {
        this.NArticleProperty = new SimpleStringProperty(nArticleProperty);
        this.NArticle = nArticleProperty;
    }

    public int getPrixProperty() {
        return prixProperty.getValue();
    }

    public void setPrixProperty(int prixProperty) {
        this.prixProperty = new SimpleIntegerProperty(prixProperty);
        this.prix = prixProperty;
    }

    public int getTvaProperty() {
        return tvaProperty.getValue();
    }

    public void setTvaProperty(int tvaProperty) {
        this.tvaProperty = new SimpleIntegerProperty(tvaProperty);
        this.tva = tvaProperty;
    }

    

    public Article() {

    }

    public Article(String NArticle, String Libelle, int prix, int tva) {
        this.NArticle = NArticle;
        this.NArticleProperty = new SimpleStringProperty(NArticle);
        this.libelle = Libelle;
        this.libelleProperty = new SimpleStringProperty(Libelle);
        this.prix = prix;
        this.prixProperty = new SimpleIntegerProperty(prix);
        this.tva = tva;
        this.tvaProperty = new SimpleIntegerProperty(tva);
    }

    public void setNArticle(String NArticle) {
        this.NArticle = NArticle;
    }

    public String getNArticle() {
        return NArticle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String Libelle) {
        this.libelle = Libelle;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

}