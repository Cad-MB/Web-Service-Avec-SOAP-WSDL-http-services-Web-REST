
package tp2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour mult complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="mult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="number2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mult", propOrder = {
    "number1",
    "number2"
})
public class Mult {

    protected int number1;
    protected int number2;

    /**
     * Obtient la valeur de la propriété number1.
     * 
     */
    public int getNumber1() {
        return number1;
    }

    /**
     * Définit la valeur de la propriété number1.
     * 
     */
    public void setNumber1(int value) {
        this.number1 = value;
    }

    /**
     * Obtient la valeur de la propriété number2.
     * 
     */
    public int getNumber2() {
        return number2;
    }

    /**
     * Définit la valeur de la propriété number2.
     * 
     */
    public void setNumber2(int value) {
        this.number2 = value;
    }

}
