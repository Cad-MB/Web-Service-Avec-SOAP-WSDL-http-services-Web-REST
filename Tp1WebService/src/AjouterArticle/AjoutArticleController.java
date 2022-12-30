/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AjouterArticle;

import helpers.DbConnect;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modals.Article;

/**
 *
 * @author ASUS
 */
public class AjoutArticleController implements Initializable {

    Article article = null;

    //la vue d'ajout
    @FXML
    private TextField libelleField;
    @FXML
    private TextField prixUnitField;
    @FXML
    private TextField tvaField;
    @FXML
    private Button btnAjouter;

    @FXML
    private void onClickAjouter(ActionEvent event) {

        try {

            String libelle = libelleField.getText();
            double tva = Double.valueOf(tvaField.getText());
            double prixUnit = Double.valueOf(prixUnitField.getText());

            article = new Article(libelle, prixUnit, tva);
            article.ajoutArticle(event);

        } catch (NumberFormatException e) {
            System.out.println("\nonClickAjouter Erreur");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("les données d'entrée sont invalides");
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de format");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DbConnect.TestConnectionMySql();
    }

}
