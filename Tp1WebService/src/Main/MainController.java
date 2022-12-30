/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class MainController implements Initializable {

    //premiere vue
    @FXML
    private Button btnAjouterArticle;
    @FXML
    private Button btnConsulterPArticles;

    @FXML
    private void onClickAjouterArticle(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/AjouterArticle/AjoutArticleDocument.fxml"));

        Stage addStage = new Stage();
        addStage.setTitle("Ajouter un article");
        addStage.setScene(new Scene(root));
        addStage.setResizable(false);
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.showAndWait();
    }

    @FXML
    private void onClickConsulterPArticles(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/ConsulterArticle/ConsulterArticleDocument.fxml"));

        Stage addStage = new Stage();
        addStage.setTitle("Consulter la liste des articles");
        addStage.setScene(new Scene(root));
        addStage.setResizable(false);
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
