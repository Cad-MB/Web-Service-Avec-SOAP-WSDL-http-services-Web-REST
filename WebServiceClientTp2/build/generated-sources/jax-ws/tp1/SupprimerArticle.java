
package tp1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour supprimerArticle complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="supprimerArticle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nArticle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supprimerArticle", propOrder = {
    "nArticle"
})
public class SupprimerArticle {

    protected int nArticle;

    /**
     * Obtient la valeur de la propriété nArticle.
     * 
     */
    public int getNArticle() {
        return nArticle;
    }

    /**
     * Définit la valeur de la propriété nArticle.
     * 
     */
    public void setNArticle(int value) {
        this.nArticle = value;
    }

}
