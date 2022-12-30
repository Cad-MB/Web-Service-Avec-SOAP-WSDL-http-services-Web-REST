
package tp1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ArticleWebService", targetNamespace = "http://tp1/", wsdlLocation = "http://localhost:8080/WebServiceTp2/ArticleWebService?WSDL")
public class ArticleWebService_Service
    extends Service
{

    private final static URL ARTICLEWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException ARTICLEWEBSERVICE_EXCEPTION;
    private final static QName ARTICLEWEBSERVICE_QNAME = new QName("http://tp1/", "ArticleWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebServiceTp2/ArticleWebService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ARTICLEWEBSERVICE_WSDL_LOCATION = url;
        ARTICLEWEBSERVICE_EXCEPTION = e;
    }

    public ArticleWebService_Service() {
        super(__getWsdlLocation(), ARTICLEWEBSERVICE_QNAME);
    }

    public ArticleWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ARTICLEWEBSERVICE_QNAME, features);
    }

    public ArticleWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, ARTICLEWEBSERVICE_QNAME);
    }

    public ArticleWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ARTICLEWEBSERVICE_QNAME, features);
    }

    public ArticleWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ArticleWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ArticleWebService
     */
    @WebEndpoint(name = "ArticleWebServicePort")
    public ArticleWebService getArticleWebServicePort() {
        return super.getPort(new QName("http://tp1/", "ArticleWebServicePort"), ArticleWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ArticleWebService
     */
    @WebEndpoint(name = "ArticleWebServicePort")
    public ArticleWebService getArticleWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://tp1/", "ArticleWebServicePort"), ArticleWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ARTICLEWEBSERVICE_EXCEPTION!= null) {
            throw ARTICLEWEBSERVICE_EXCEPTION;
        }
        return ARTICLEWEBSERVICE_WSDL_LOCATION;
    }

}
