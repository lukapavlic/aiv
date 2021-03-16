
package si.um.feri.aiv.soapclient.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for oseba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="oseba">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bivalisce" type="{http://soap.aiv.feri.um.si/}posta" minOccurs="0"/>
 *         &lt;element name="datumVpisa" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priimek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oseba", propOrder = {
    "bivalisce",
    "datumVpisa",
    "email",
    "id",
    "ime",
    "priimek"
})
public class Oseba {

    protected Posta bivalisce;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumVpisa;
    protected String email;
    protected int id;
    protected String ime;
    protected String priimek;

    /**
     * Gets the value of the bivalisce property.
     * 
     * @return
     *     possible object is
     *     {@link Posta }
     *     
     */
    public Posta getBivalisce() {
        return bivalisce;
    }

    /**
     * Sets the value of the bivalisce property.
     * 
     * @param value
     *     allowed object is
     *     {@link Posta }
     *     
     */
    public void setBivalisce(Posta value) {
        this.bivalisce = value;
    }

    /**
     * Gets the value of the datumVpisa property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumVpisa() {
        return datumVpisa;
    }

    /**
     * Sets the value of the datumVpisa property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumVpisa(XMLGregorianCalendar value) {
        this.datumVpisa = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the priimek property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriimek() {
        return priimek;
    }

    /**
     * Sets the value of the priimek property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriimek(String value) {
        this.priimek = value;
    }

}
