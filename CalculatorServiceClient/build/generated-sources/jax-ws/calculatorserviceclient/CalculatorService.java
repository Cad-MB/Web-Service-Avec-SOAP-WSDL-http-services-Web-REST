
package calculatorserviceclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CalculatorService", targetNamespace = "http://webservice.hubberspot.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CalculatorService {


    /**
     * 
     * @param number1
     * @param number2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sum", targetNamespace = "http://webservice.hubberspot.com/", className = "calculatorserviceclient.Sum")
    @ResponseWrapper(localName = "sumResponse", targetNamespace = "http://webservice.hubberspot.com/", className = "calculatorserviceclient.SumResponse")
    @Action(input = "http://webservice.hubberspot.com/CalculatorService/sumRequest", output = "http://webservice.hubberspot.com/CalculatorService/sumResponse")
    public int sum(
        @WebParam(name = "number1", targetNamespace = "")
        int number1,
        @WebParam(name = "number2", targetNamespace = "")
        int number2);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://webservice.hubberspot.com/", className = "calculatorserviceclient.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://webservice.hubberspot.com/", className = "calculatorserviceclient.HelloResponse")
    @Action(input = "http://webservice.hubberspot.com/CalculatorService/helloRequest", output = "http://webservice.hubberspot.com/CalculatorService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}