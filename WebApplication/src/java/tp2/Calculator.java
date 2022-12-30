/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "CalculatorService")
public class Calculator {

    /**
     * Web service operation ( add operation )
     */
    @WebMethod(operationName = "sum")
    public int sum(@WebParam(name = "number1") int number1, @WebParam(name = "number2") int number2) {
        //TODO write your implementation code here:
        int sum = 0;
        sum = number1 + number2;
        return sum;
    }

    /**
     * Web service operation ( multiplication )
     */
    @WebMethod(operationName = "mult")
    public int mult(@WebParam(name = "number1") int number1, @WebParam(name = "number2") int number2) {
        //TODO write your implementation code here:
        int mult = 1;
        mult = number1 * number2;
        return mult;
    }

    /**
     * Web service operation ( minus )
     */
    @WebMethod(operationName = "min")
    public int minus(@WebParam(name = "number1") int number1, @WebParam(name = "number2") int number2) {
        //TODO write your implementation code here:
        int min = 0;
        min = number1 - number2;
        return min;
    }

    /**
     * Web service operation (division)
     */
    @WebMethod(operationName = "div")
    public double devision(@WebParam(name = "number1") int number1, @WebParam(name = "number2") int number2) {
        //TODO write your implementation code here:
        int div = 1;
        div = number1 / number2;
        return div;
    }
}
