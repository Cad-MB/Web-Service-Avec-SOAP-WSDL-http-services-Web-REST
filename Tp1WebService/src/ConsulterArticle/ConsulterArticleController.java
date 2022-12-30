/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsulterArticle;

import ModifArticle.ModifArticleController;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import helpers.DbConnect;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import modals.Article;

/**
 *
 * @author ASUS
 */
public class ConsulterArticleController implements Initializable {

    @FXML
    private TableView<Article> articleTableView;
    @FXML
    private TableColumn<Article, String> nArticleCol;
    @FXML
    private TableColumn<Article, String> libelleCol;
    @FXML
    private TableColumn<Article, String> prixCol;
    @FXML
    private TableColumn<Article, String> tvaCol;
    @FXML
    private TableColumn<Article, String> editCol = new TableColumn();
    @FXML
    private Button refreshButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button addButton;
    @FXML
    private TextField searchField;
    @FXML
    private Label searchLabel;

    Article article = new Article();
    ObservableList<Article> ArticlesList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.REFRESH));
        searchButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.SEARCH));
        addButton.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PLUS));
        loadData();
    }

    private void loadData() {
        DbConnect.TestConnectionMySql();
        refreshData();
        loadTable();
    }

    @FXML
    private void refreshData() {
        searchLabel.setText("");
        ArticlesList.clear();
        ArticlesList = article.consultListArticles();
        nArticleCol.setCellValueFactory(new PropertyValueFactory<>("numeroArticleProperty"));
        libelleCol.setCellValueFactory(new PropertyValueFactory<>("libelleProperty"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prixUnitProperty"));
        tvaCol.setCellValueFactory(new PropertyValueFactory<>("tvaProperty"));
        articleTableView.setItems(ArticlesList);
    }

    @FXML
    private void onClickRefresh(ActionEvent event) {
        refreshData();
    }

    @FXML
    private void onClickAdd(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AjouterArticle/AjoutArticleDocument.fxml"));

        Stage addStage = new Stage();
        addStage.setTitle("Ajouter un article");
        addStage.setScene(new Scene(root));
        addStage.setResizable(false);
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.showAndWait();
        refreshData();
    }

    @FXML
    private void onClickSearch(ActionEvent event) {
        System.out.println("onClickSearch !!");
        if (searchField.getText().length() == 0) {
            refreshData();
        } else {
            ArticlesList.clear();
            ArticlesList = article.consult1Article(searchField.getText());
            nArticleCol.setCellValueFactory(new PropertyValueFactory<>("numeroArticleProperty"));
            libelleCol.setCellValueFactory(new PropertyValueFactory<>("libelleProperty"));
            prixCol.setCellValueFactory(new PropertyValueFactory<>("prixUnitProperty"));
            tvaCol.setCellValueFactory(new PropertyValueFactory<>("tvaProperty"));
            articleTableView.setItems(ArticlesList);
            searchLabel.setText("Recherche ('" + searchField.getText() + "') : " + ArticlesList.size() + " résultats");

        }
    }

    private void loadTable() {

        Callback<TableColumn<Article, String>, TableCell<Article, String>> cellFoctory = (TableColumn<Article, String> param) -> {
            // make cell containing buttons
            final TableCell<Article, String> cell = new TableCell<Article, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            article = articleTableView.getSelectionModel().getSelectedItem();
                            System.out.println("delete clicked : " + article.getLibelle());
                            article.supprimArticle();
                            refreshData();
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            try {
                                article = articleTableView.getSelectionModel().getSelectedItem();
                                System.out.println("edit clicked : " + article.getLibelle());
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifArticle/ModifArticleDocument.fxml"));
                                Parent root = (Parent) loader.load();
                                ModifArticleController modifController = loader.getController();
                                modifController.setEditedArticle(article);
                                Stage addStage = new Stage();
                                addStage.setTitle("Modifier un article");
                                addStage.setScene(new Scene(root));
                                addStage.setResizable(false);
                                addStage.initModality(Modality.APPLICATION_MODAL);
                                addStage.showAndWait();
                                refreshData();
                            } catch (IOException ex) {
                                Logger.getLogger(ConsulterArticleController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
                        managebtn.setSpacing(30);
                        setGraphic(managebtn);

                        setText(null);

                    }
                }
            };

            return cell;
        };
        editCol.setCellFactory(cellFoctory);
        articleTableView.getColumns().add(editCol);
    }

}
