
package tp1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour article complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libelleProperty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroArticle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroArticleProperty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prixUnit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="prixUnitProperty" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tvaProperty" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "article", propOrder = {
    "libelle",
    "libelleProperty",
    "numeroArticle",
    "numeroArticleProperty",
    "prixUnit",
    "prixUnitProperty",
    "tva",
    "tvaProperty"
})
public class Article {

    protected String libelle;
    protected String libelleProperty;
    protected int numeroArticle;
    protected int numeroArticleProperty;
    protected double prixUnit;
    protected double prixUnitProperty;
    protected double tva;
    protected double tvaProperty;

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
     * Obtient la valeur de la propriété libelleProperty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleProperty() {
        return libelleProperty;
    }

    /**
     * Définit la valeur de la propriété libelleProperty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleProperty(String value) {
        this.libelleProperty = value;
    }

    /**
     * Obtient la valeur de la propriété numeroArticle.
     * 
     */
    public int getNumeroArticle() {
        return numeroArticle;
    }

    /**
     * Définit la valeur de la propriété numeroArticle.
     * 
     */
    public void setNumeroArticle(int value) {
        this.numeroArticle = value;
    }

    /**
     * Obtient la valeur de la propriété numeroArticleProperty.
     * 
     */
    public int getNumeroArticleProperty() {
        return numeroArticleProperty;
    }

    /**
     * Définit la valeur de la propriété numeroArticleProperty.
     * 
     */
    public void setNumeroArticleProperty(int value) {
        this.numeroArticleProperty = value;
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

    /**
     * Obtient la valeur de la propriété prixUnitProperty.
     * 
     */
    public double getPrixUnitProperty() {
        return prixUnitProperty;
    }

    /**
     * Définit la valeur de la propriété prixUnitProperty.
     * 
     */
    public void setPrixUnitProperty(double value) {
        this.prixUnitProperty = value;
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
     * Obtient la valeur de la propriété tvaProperty.
     * 
     */
    public double getTvaProperty() {
        return tvaProperty;
    }

    /**
     * Définit la valeur de la propriété tvaProperty.
     * 
     */
    public void setTvaProperty(double value) {
        this.tvaProperty = value;
    }

}
