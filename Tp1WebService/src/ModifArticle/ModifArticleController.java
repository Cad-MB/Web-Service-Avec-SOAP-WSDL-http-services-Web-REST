/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModifArticle;

import ConsulterArticle.ConsulterArticleController;
import helpers.DbConnect;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import modals.Article;

/**
 *
 * @author ASUS
 */
public class ModifArticleController implements Initializable {

    Article article = new Article();

    //la vue de modification
    @FXML
    private Text title;
    @FXML
    private TextField libelleField;
    @FXML
    private TextField prixUnitField;
    @FXML
    private TextField tvaField;
    @FXML
    private Button btnConfirmer;

    ConsulterArticleController consultController;

    @FXML
    private void onClickConfirmer(ActionEvent event) {

        try {
            String libelle = libelleField.getText();
            double tva = Double.valueOf(tvaField.getText());
            double prixUnit = Double.valueOf(prixUnitField.getText());
            article.modifArticle(event, libelle, prixUnit, tva);
        } catch (NumberFormatException e) {
            System.out.println("\nonClickConfirmer Erreur");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("les données d'entrée sont invalides");
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de format");
            alert.showAndWait();
        }

    }

    public void setEditedArticle(Article article) {
        this.article = article;
        title.setText("Mofidier l'article numéro " + article.getNumeroArticle());
        libelleField.setText(article.getLibelle());
        prixUnitField.setText(String.valueOf(article.getPrixUnit()));
        tvaField.setText(String.valueOf(article.getTva()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DbConnect.TestConnectionMySql();
    }

}
