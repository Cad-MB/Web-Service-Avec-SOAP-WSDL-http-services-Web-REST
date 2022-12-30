/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

}
