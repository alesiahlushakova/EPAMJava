
package by.training.task4.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Antibiotic complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType name="Antibiotic">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.com/Medicines}Medicine">
 *       &lt;attribute name="recipe" type=
 *       "{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Antibiotic",
        namespace = "http://www.example.com/Medicines")
public class Antibiotic
    extends Medicine {
    /**
     * attribute.
     */
    @XmlAttribute(name = "recipe")
    private Boolean recipe;

    /**
     * Gets the value of the recipe property.
     * @return
     *     possible object is
     *     {@link Boolean }
     */
    public boolean isRecipe() {
        if (recipe == null) {
            return true;
        } else {
            return recipe;
        }
    }

    /**
     * Sets the value of the recipe property.
     * @param value
     *     allowed object is
     *     {@link Boolean }
     */
    public void setRecipe(final Boolean value) {
        this.recipe = value;
    }

}
