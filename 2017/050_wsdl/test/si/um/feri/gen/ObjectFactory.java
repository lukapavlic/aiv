
package si.um.feri.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the si.um.feri.gen package. 
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

    private final static QName _Sestej_QNAME = new QName("http://feri.um.si/", "sestej");
    private final static QName _Deli_QNAME = new QName("http://feri.um.si/", "deli");
    private final static QName _ObdelajResponse_QNAME = new QName("http://feri.um.si/", "obdelajResponse");
    private final static QName _Mnozi_QNAME = new QName("http://feri.um.si/", "mnozi");
    private final static QName _OdstejResponse_QNAME = new QName("http://feri.um.si/", "odstejResponse");
    private final static QName _SestejResponse_QNAME = new QName("http://feri.um.si/", "sestejResponse");
    private final static QName _Obdelaj_QNAME = new QName("http://feri.um.si/", "obdelaj");
    private final static QName _Odstej_QNAME = new QName("http://feri.um.si/", "odstej");
    private final static QName _DeliResponse_QNAME = new QName("http://feri.um.si/", "deliResponse");
    private final static QName _MnoziResponse_QNAME = new QName("http://feri.um.si/", "mnoziResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: si.um.feri.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Odstej }
     * 
     */
    public Odstej createOdstej() {
        return new Odstej();
    }

    /**
     * Create an instance of {@link DeliResponse }
     * 
     */
    public DeliResponse createDeliResponse() {
        return new DeliResponse();
    }

    /**
     * Create an instance of {@link MnoziResponse }
     * 
     */
    public MnoziResponse createMnoziResponse() {
        return new MnoziResponse();
    }

    /**
     * Create an instance of {@link ObdelajResponse }
     * 
     */
    public ObdelajResponse createObdelajResponse() {
        return new ObdelajResponse();
    }

    /**
     * Create an instance of {@link Deli }
     * 
     */
    public Deli createDeli() {
        return new Deli();
    }

    /**
     * Create an instance of {@link Sestej }
     * 
     */
    public Sestej createSestej() {
        return new Sestej();
    }

    /**
     * Create an instance of {@link SestejResponse }
     * 
     */
    public SestejResponse createSestejResponse() {
        return new SestejResponse();
    }

    /**
     * Create an instance of {@link OdstejResponse }
     * 
     */
    public OdstejResponse createOdstejResponse() {
        return new OdstejResponse();
    }

    /**
     * Create an instance of {@link Mnozi }
     * 
     */
    public Mnozi createMnozi() {
        return new Mnozi();
    }

    /**
     * Create an instance of {@link Obdelaj }
     * 
     */
    public Obdelaj createObdelaj() {
        return new Obdelaj();
    }

    /**
     * Create an instance of {@link Racun }
     * 
     */
    public Racun createRacun() {
        return new Racun();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sestej }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "sestej")
    public JAXBElement<Sestej> createSestej(Sestej value) {
        return new JAXBElement<Sestej>(_Sestej_QNAME, Sestej.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deli }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "deli")
    public JAXBElement<Deli> createDeli(Deli value) {
        return new JAXBElement<Deli>(_Deli_QNAME, Deli.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObdelajResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "obdelajResponse")
    public JAXBElement<ObdelajResponse> createObdelajResponse(ObdelajResponse value) {
        return new JAXBElement<ObdelajResponse>(_ObdelajResponse_QNAME, ObdelajResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mnozi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "mnozi")
    public JAXBElement<Mnozi> createMnozi(Mnozi value) {
        return new JAXBElement<Mnozi>(_Mnozi_QNAME, Mnozi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdstejResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "odstejResponse")
    public JAXBElement<OdstejResponse> createOdstejResponse(OdstejResponse value) {
        return new JAXBElement<OdstejResponse>(_OdstejResponse_QNAME, OdstejResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SestejResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "sestejResponse")
    public JAXBElement<SestejResponse> createSestejResponse(SestejResponse value) {
        return new JAXBElement<SestejResponse>(_SestejResponse_QNAME, SestejResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obdelaj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "obdelaj")
    public JAXBElement<Obdelaj> createObdelaj(Obdelaj value) {
        return new JAXBElement<Obdelaj>(_Obdelaj_QNAME, Obdelaj.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Odstej }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "odstej")
    public JAXBElement<Odstej> createOdstej(Odstej value) {
        return new JAXBElement<Odstej>(_Odstej_QNAME, Odstej.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "deliResponse")
    public JAXBElement<DeliResponse> createDeliResponse(DeliResponse value) {
        return new JAXBElement<DeliResponse>(_DeliResponse_QNAME, DeliResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MnoziResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://feri.um.si/", name = "mnoziResponse")
    public JAXBElement<MnoziResponse> createMnoziResponse(MnoziResponse value) {
        return new JAXBElement<MnoziResponse>(_MnoziResponse_QNAME, MnoziResponse.class, null, value);
    }

}
