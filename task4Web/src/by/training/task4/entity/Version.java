
package by.training.task4.entity;

import javax.xml.bind.annotation.*;
import java.util.HashSet;


/**
 * <p>Java class for Version complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Version">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Producer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Form">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tablet"/>
 *               &lt;enumeration value="pills"/>
 *               &lt;enumeration value="powder"/>
 *               &lt;enumeration value="liquid"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Certificate" type="{http://www.example.com/Medicines}Certificate"/>
 *         &lt;element name="Package" type="{http://www.example.com/Medicines}Package" maxOccurs="unbounded"/>
 *         &lt;element name="Dosage" type="{http://www.example.com/Medicines}Dosage"/>
 *       &lt;/sequence>
 *       &lt;attribute name="analog" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version", namespace = "http://www.example.com/Medicines", propOrder = {
    "producer",
    "form",
    "certificate",
    "_package",
    "dosage"
})
public class Version {

    @XmlElement(name = "Producer", namespace = "http://www.example.com/Medicines", required = true)
    protected String producer;
    @XmlElement(name = "Form", namespace = "http://www.example.com/Medicines", required = true)
    protected String form;
    @XmlElement(name = "Certificate", namespace = "http://www.example.com/Medicines", required = true)
    protected Certificate certificate;
    @XmlElement(name = "Package", namespace = "http://www.example.com/Medicines", required = true)
    protected HashSet<Package> _package;
    @XmlElement(name = "Dosage", namespace = "http://www.example.com/Medicines", required = true)
    protected Dosage dosage;
    @XmlAttribute(name = "analog", required = true)
    protected String analog;

    /**
     * Gets the value of the producer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Sets the value of the producer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProducer(String value) {
        this.producer = value;
    }

    /**
     * Gets the value of the form property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getForm() {
        return form;
    }

    /**
     * Sets the value of the form property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setForm(String value) {
        this.form = value;
    }

    /**
     * Gets the value of the certificate property.
     *
     * @return
     *     possible object is
     *     {@link Certificate }
     *
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     *
     * @param value
     *     allowed object is
     *     {@link Certificate }
     *
     */
    public void setCertificate(Certificate value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the package property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the package property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackage().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Package }
     *
     *
     */
    public HashSet<Package> getPackage() {
        if (_package == null) {
            _package = new HashSet<Package>();
        }
        return this._package;
    }
    public  void setPackage(HashSet<Package> packages) {
        this._package = packages;
    }
    public void addPackage(Package pack) {
        _package.add(pack);
    }

    /**
     * Gets the value of the dosage property.
     * 
     * @return
     *     possible object is
     *     {@link Dosage }
     *     
     */
    public Dosage getDosage() {
        return dosage;
    }

    /**
     * Sets the value of the dosage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dosage }
     *     
     */
    public void setDosage(Dosage value) {
        this.dosage = value;
    }

    /**
     * Gets the value of the analog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnalog() {
        return analog;
    }

    /**
     * Sets the value of the analog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalog(String value) {
        this.analog = value;
    }

}
