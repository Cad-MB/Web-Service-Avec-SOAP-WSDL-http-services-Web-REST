/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tp1.Article;

/**
 *
 * @author ASUS
 */
public class ModifArticleController implements Initializable {

    @FXML
    private Text title;
    @FXML
    private TextField libelleField;
    @FXML
    private TextField prixUnitField;
    @FXML
    private TextField tvaField;

    Article article = null;

    @FXML
    private void onClickConfirmer(ActionEvent event) {

        try {
            String libelle = libelleField.getText();
            double tva = Double.valueOf(tvaField.getText());
            double prixUnit = Double.valueOf(prixUnitField.getText());
            modifierArticle(article.getNumeroArticle(), libelle, prixUnit, tva);
            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("les données d'entrée sont invalides");
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de format");
            alert.showAndWait();

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setEditedArticle(Article article) {
        this.article = article;
        title.setText("Mofidier l'article numéro " + article.getNumeroArticle());
        libelleField.setText(article.getLibelle());
        prixUnitField.setText(String.valueOf(article.getPrixUnit()));
        tvaField.setText(String.valueOf(article.getTva()));
    }

    private static String modifierArticle(int nArticle, java.lang.String libelle, double tva, double prixUnit) {
        tp1.ArticleWebService_Service service = new tp1.ArticleWebService_Service();
        tp1.ArticleWebService port = service.getArticleWebServicePort();
        return port.modifierArticle(nArticle, libelle, tva, prixUnit);
    }
}
