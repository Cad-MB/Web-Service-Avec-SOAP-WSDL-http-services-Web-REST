/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField numberField2;

    @FXML
    private TextField numberField1;

    @FXML
    private TextField numberField7;

    @FXML
    private Label resultLabel;

    @FXML
    void onClickSomme(ActionEvent event) {

        int resultat = 0;
        int x = Integer.valueOf(numberField1.getText());
        int y = Integer.valueOf(numberField2.getText());
        resultat = sum(x, y);
        resultLabel.setText("Résultat = " + resultat);

    }

    @FXML
    void onClickSoustraction(ActionEvent event) {

        int resultat = 0;
        int x = Integer.valueOf(numberField1.getText());
        int y = Integer.valueOf(numberField2.getText());
        resultat = min(x, y);
        resultLabel.setText("Résultat = " + resultat);

    }

    @FXML
    void onClickMultiplication(ActionEvent event) {
        int resultat = 1;
        int x = Integer.valueOf(numberField1.getText());
        int y = Integer.valueOf(numberField2.getText());
        resultat = mult(x, y);
        resultLabel.setText("Résultat = " + resultat);
    }

    @FXML
    void onClickDevision(ActionEvent event) {
        double resultat = 0;
        int x = Integer.valueOf(numberField1.getText());
        int y = Integer.valueOf(numberField2.getText());
        resultat = div(x, y);
        resultLabel.setText("Résultat = " + resultat);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private static double div(int number1, int number2) {
        tp2.CalculatorService service = new tp2.CalculatorService();
        tp2.Calculator port = service.getCalculatorPort();
        return port.div(number1, number2);
    }

    private static int min(int number1, int number2) {
        tp2.CalculatorService service = new tp2.CalculatorService();
        tp2.Calculator port = service.getCalculatorPort();
        return port.min(number1, number2);
    }

    private static int mult(int number1, int number2) {
        tp2.CalculatorService service = new tp2.CalculatorService();
        tp2.Calculator port = service.getCalculatorPort();
        return port.mult(number1, number2);
    }

    private static int sum(int number1, int number2) {
        tp2.CalculatorService service = new tp2.CalculatorService();
        tp2.Calculator port = service.getCalculatorPort();
        return port.sum(number1, number2);
    }

}
