
package by.training.task4.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Medicine complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType name="Medicine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pharm"
 *         type=
 *         "{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Version" type
 *         ="{http://www.example.com/Medicines}Version"
 *         maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CAS" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="([0-9]{2,5})-([0-9]{2})-([0-9]{1})"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="drug_bank" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="DB([0-9]{5})"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Medicine",
        namespace = "http://www.example.com/Medicines", propOrder = {
    "pharm",
    "version"
})
@XmlSeeAlso({
    Antibiotic.class,
    Vitamin.class,
    Analgetic.class
})
/**
 * medicine type.
 */
public class Medicine {
    private HashSet<Version> versions;
    /**
     * pharmacy.
     */
    @XmlElement(name = "Pharm",
            namespace = "http://www.example.com/Medicines", required = true)
    private String pharm;
    /**
     * nam.
     */
    @XmlElement(name = "Version",
            namespace = "http://www.example.com/Medicines", required = true)
    private List<Version> version;
    /**
     * name.
     */
    @XmlAttribute(name = "name", required = true)
    /**
     * name.
     */
    private String name;
    /**
     * cas.
     */
    @XmlAttribute(name = "CAS", required = true)
    private String cas;
    /**
     * drug bank.
     */
    @XmlAttribute(name = "drug_bank", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String drugBank;

    /**
     * Gets the value of the pharm property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getPharm() {
        return pharm;
    }

    /**
     * Sets the value of the pharm property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setPharm(final String value) {
        this.pharm = value;
    }

    /**
     * Gets the value of the version property.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE>
     * method for the version property.
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersion().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Version }
     * @return list
     */
    public HashSet<Version> getVersions() {
        return versions;
    }
    public void setVersion(HashSet<Version> versions) {
        this.versions = versions;
    }

    /**
     * Gets the value of the name property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Gets the value of the cas property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getCAS() {
        return cas;
    }

    /**
     * Sets the value of the cas property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setCAS(final String value) {
        this.cas = value;
    }

    /**
     * Gets the value of the drugBank property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getDrugBank() {
        return drugBank;
    }

    /**
     * Sets the value of the drugBank property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setDrugBank(final String value) {
        this.drugBank = value;
    }

}
