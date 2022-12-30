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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author ASUS
 */
public class AjouterArticleController implements Initializable {

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
            ajouterArticle(libelle, prixUnit, tva);
            ((Node) event.getSource()).getScene().getWindow().hide();
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
    public void initialize(URL location, ResourceBundle resources) {

    }

    private static String ajouterArticle(java.lang.String libelle, double tva, double prixUnit) {
        tp1.ArticleWebService_Service service = new tp1.ArticleWebService_Service();
        tp1.ArticleWebService port = service.getArticleWebServicePort();
        return port.ajouterArticle(libelle, tva, prixUnit);
    }

}
