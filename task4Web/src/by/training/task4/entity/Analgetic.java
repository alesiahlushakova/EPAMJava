
package by.training.task4.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Analgetic complex type.
 * <p>The following schema fragment specifies the expected.
 * content contained within this class.
 * <pre>
 * &lt;complexType name="Analgetic">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.com/Medicines}Medicine">
 *       &lt;attribute name="narcotic" use="required"
 *       type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Analgetic", namespace = "http://www.example.com/Medicines")
public class Analgetic
    extends Medicine {
    /**
     * attribute.
     */
    @XmlAttribute(name = "narcotic", required = true)
    /**
     * is narcotic.
     */
    private boolean narcotic;

    /**
     * Gets the value of the narcotic property.
     * @return  narcotic
     */
    public boolean isNarcotic() {
        return narcotic;
    }

    /**
     * Sets the value of the narcotic property.
     * @param value value
     */
    public void setNarcotic(final boolean value) {
        this.narcotic = value;
    }

}
