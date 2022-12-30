/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calculatorserviceclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnSum;

    @FXML
    private Label result;

    @FXML
    private TextField tfNum1;

    @FXML
    private TextField tfNum2;

    public void setBtnSum(Button btnSum) {
        this.btnSum = btnSum;
    }

    public void setResult(Label result) {
        this.result = result;
    }

    public void setTfNum1(TextField tfNum1) {
        this.tfNum1 = tfNum1;
    }

    public void setTfNum2(TextField tfNum2) {
        this.tfNum2 = tfNum2;
    }

    public Button getBtnSum() {
        return btnSum;
    }

    public Label getResult() {
        return result;
    }

    public TextField getTfNum1() {
        return tfNum1;
    }

    public TextField getTfNum2() {
        return tfNum2;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
       private static int sum_1(int number1, int number2) {
        calculatorserviceclient.CalculatorService_Service service = new calculatorserviceclient.CalculatorService_Service();
        calculatorserviceclient.CalculatorService port = service.getCalculatorServicePort();
        return port.sum(number1, number2);
        
    }
    @FXML
    private void onClickSum(ActionEvent event) {
        int num1 = Integer.parseInt(tfNum1.getText());
        int num2 = Integer.parseInt(tfNum2.getText());
        int res = sum_1(num1, num2);
        String ress = Integer.toString(res);
        result.setText(ress);

    }

 

}