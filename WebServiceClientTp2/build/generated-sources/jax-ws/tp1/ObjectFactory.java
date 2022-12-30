
package tp1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tp1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsulterListArticle_QNAME = new QName("http://tp1/", "ConsulterListArticle");
    private final static QName _ModifierArticleResponse_QNAME = new QName("http://tp1/", "modifierArticleResponse");
    private final static QName _Consulter1ArticleResponse_QNAME = new QName("http://tp1/", "Consulter1ArticleResponse");
    private final static QName _AjouterArticleResponse_QNAME = new QName("http://tp1/", "ajouter_articleResponse");
    private final static QName _ConsulterListArticleResponse_QNAME = new QName("http://tp1/", "ConsulterListArticleResponse");
    private final static QName _SupprimerArticle_QNAME = new QName("http://tp1/", "supprimerArticle");
    private final static QName _ModifierArticle_QNAME = new QName("http://tp1/", "modifierArticle");
    private final static QName _SupprimerArticleResponse_QNAME = new QName("http://tp1/", "supprimerArticleResponse");
    private final static QName _Consulter1Article_QNAME = new QName("http://tp1/", "Consulter1Article");
    private final static QName _AjouterArticle_QNAME = new QName("http://tp1/", "ajouter_article");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tp1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModifierArticleResponse }
     * 
     */
    public ModifierArticleResponse createModifierArticleResponse() {
        return new ModifierArticleResponse();
    }

    /**
     * Create an instance of {@link ConsulterListArticle }
     * 
     */
    public ConsulterListArticle createConsulterListArticle() {
        return new ConsulterListArticle();
    }

    /**
     * Create an instance of {@link Consulter1ArticleResponse }
     * 
     */
    public Consulter1ArticleResponse createConsulter1ArticleResponse() {
        return new Consulter1ArticleResponse();
    }

    /**
     * Create an instance of {@link AjouterArticleResponse }
     * 
     */
    public AjouterArticleResponse createAjouterArticleResponse() {
        return new AjouterArticleResponse();
    }

    /**
     * Create an instance of {@link ModifierArticle }
     * 
     */
    public ModifierArticle createModifierArticle() {
        return new ModifierArticle();
    }

    /**
     * Create an instance of {@link ConsulterListArticleResponse }
     * 
     */
    public ConsulterListArticleResponse createConsulterListArticleResponse() {
        return new ConsulterListArticleResponse();
    }

    /**
     * Create an instance of {@link SupprimerArticle }
     * 
     */
    public SupprimerArticle createSupprimerArticle() {
        return new SupprimerArticle();
    }

    /**
     * Create an instance of {@link AjouterArticle }
     * 
     */
    public AjouterArticle createAjouterArticle() {
        return new AjouterArticle();
    }

    /**
     * Create an instance of {@link Consulter1Article }
     * 
     */
    public Consulter1Article createConsulter1Article() {
        return new Consulter1Article();
    }

    /**
     * Create an instance of {@link SupprimerArticleResponse }
     * 
     */
    public SupprimerArticleResponse createSupprimerArticleResponse() {
        return new SupprimerArticleResponse();
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsulterListArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "ConsulterListArticle")
    public JAXBElement<ConsulterListArticle> createConsulterListArticle(ConsulterListArticle value) {
        return new JAXBElement<ConsulterListArticle>(_ConsulterListArticle_QNAME, ConsulterListArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifierArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "modifierArticleResponse")
    public JAXBElement<ModifierArticleResponse> createModifierArticleResponse(ModifierArticleResponse value) {
        return new JAXBElement<ModifierArticleResponse>(_ModifierArticleResponse_QNAME, ModifierArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consulter1ArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "Consulter1ArticleResponse")
    public JAXBElement<Consulter1ArticleResponse> createConsulter1ArticleResponse(Consulter1ArticleResponse value) {
        return new JAXBElement<Consulter1ArticleResponse>(_Consulter1ArticleResponse_QNAME, Consulter1ArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "ajouter_articleResponse")
    public JAXBElement<AjouterArticleResponse> createAjouterArticleResponse(AjouterArticleResponse value) {
        return new JAXBElement<AjouterArticleResponse>(_AjouterArticleResponse_QNAME, AjouterArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsulterListArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "ConsulterListArticleResponse")
    public JAXBElement<ConsulterListArticleResponse> createConsulterListArticleResponse(ConsulterListArticleResponse value) {
        return new JAXBElement<ConsulterListArticleResponse>(_ConsulterListArticleResponse_QNAME, ConsulterListArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "supprimerArticle")
    public JAXBElement<SupprimerArticle> createSupprimerArticle(SupprimerArticle value) {
        return new JAXBElement<SupprimerArticle>(_SupprimerArticle_QNAME, SupprimerArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifierArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "modifierArticle")
    public JAXBElement<ModifierArticle> createModifierArticle(ModifierArticle value) {
        return new JAXBElement<ModifierArticle>(_ModifierArticle_QNAME, ModifierArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "supprimerArticleResponse")
    public JAXBElement<SupprimerArticleResponse> createSupprimerArticleResponse(SupprimerArticleResponse value) {
        return new JAXBElement<SupprimerArticleResponse>(_SupprimerArticleResponse_QNAME, SupprimerArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consulter1Article }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "Consulter1Article")
    public JAXBElement<Consulter1Article> createConsulter1Article(Consulter1Article value) {
        return new JAXBElement<Consulter1Article>(_Consulter1Article_QNAME, Consulter1Article.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tp1/", name = "ajouter_article")
    public JAXBElement<AjouterArticle> createAjouterArticle(AjouterArticle value) {
        return new JAXBElement<AjouterArticle>(_AjouterArticle_QNAME, AjouterArticle.class, null, value);
    }

}
