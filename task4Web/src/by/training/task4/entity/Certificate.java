
package by.training.task4.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;


/**
 * <p>Java class for Certificate complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType name="Certificate">
 *   &lt;complexContent>
 *     &lt;restriction base="
 *     {http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Registered_by"
 *         type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Registration_date">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="2000-01-01"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Expiration_date">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;maxInclusive value="2029-01-01"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Certificate",
        namespace = "http://www.example.com/Medicines", propOrder = {
    "registeredBy",
    "registrationDate",
    "expirationDate"
})
/**
 * class certificate type.
 */
public class Certificate {
    /**
     * registered by.
     */
    @XmlElement(name = "Registered_by",
            namespace = "http://www.example.com/Medicines", required = true)
    private String registeredBy;
    /**
     * registration date.
     */
    @XmlElement(name = "Registration_date",
            namespace = "http://www.example.com/Medicines", required = true)
    private Date registrationDate;
    /**
     * expiration date.
     */
    @XmlElement(name = "Expiration_date",
            namespace = "http://www.example.com/Medicines", required = true)
    private Date expirationDate;

    /**
     * Gets the value of the registeredBy property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getRegisteredBy() {
        return registeredBy;
    }

    /**
     * Sets the value of the registeredBy property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setRegisteredBy(final String value) {
        this.registeredBy = value;
    }

    /**
     * Gets the value of the registrationDate property.
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     */
    public void setRegistrationDate(final Date value) {
        this.registrationDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     */
    public void setExpirationDate(final Date value) {
        this.expirationDate = value;
    }

}
