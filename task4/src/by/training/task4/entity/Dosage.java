
package by.training.task4.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Dosage complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType name="Dosage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amount"
 *         type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Frequency"
 *         type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dosage",
        namespace = "http://www.example.com/Medicines", propOrder = {
    "amount",
    "frequency"
})
/**
 * dosage type.
 */
public class Dosage {
    /**
     * amount.
     */
    @XmlElement(name = "Amount",
            namespace = "http://www.example.com/Medicines", required = true)
    private String amount;
    /**
     * frequency.
     */
    @XmlElement(name = "Frequency",
            namespace = "http://www.example.com/Medicines", required = true)
    private String frequency;

    /**
     * Gets the value of the amount property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setAmount(final String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the frequency property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setFrequency(final String value) {
        this.frequency = value;
    }

}
