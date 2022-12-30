
package tp1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajouter_article complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajouter_article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="prix_unit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajouter_article", propOrder = {
    "libelle",
    "tva",
    "prixUnit"
})
public class AjouterArticle {

    protected String libelle;
    protected double tva;
    @XmlElement(name = "prix_unit")
    protected double prixUnit;

    /**
     * Obtient la valeur de la propriété libelle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit la valeur de la propriété libelle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelle(String value) {
        this.libelle = value;
    }

    /**
     * Obtient la valeur de la propriété tva.
     * 
     */
    public double getTva() {
        return tva;
    }

    /**
     * Définit la valeur de la propriété tva.
     * 
     */
    public void setTva(double value) {
        this.tva = value;
    }

    /**
     * Obtient la valeur de la propriété prixUnit.
     * 
     */
    public double getPrixUnit() {
        return prixUnit;
    }

    /**
     * Définit la valeur de la propriété prixUnit.
     * 
     */
    public void setPrixUnit(double value) {
        this.prixUnit = value;
    }

}
