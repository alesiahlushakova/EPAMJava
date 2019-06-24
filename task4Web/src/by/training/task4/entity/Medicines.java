
package by.training.task4.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p>The following schema fragment specifies the
 * expected content contained within this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref=
 *         "{http://www.example.com/Medicines}Medicine" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "medicine"
})
@XmlRootElement(name = "Medicines",
        namespace = "http://www.example.com/Medicines")
public class Medicines {
    /**
     * medicine.
     */
    @XmlElementRef(name = "Medicine",
            namespace = "http://www.example.com/Medicines",
            type = JAXBElement.class)
    private List<JAXBElement<? extends Medicine>> medicine;

    /**
     * Gets the value of the medicine property.
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE>
     * method for the medicine property.
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedicine().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Vitamin }{@code >}
     * {@link JAXBElement }{@code <}{@link Medicine }{@code >}
     * {@link JAXBElement }{@code <}{@link Analgetic }{@code >}
     * {@link JAXBElement }{@code <}{@link Antibiotic }{@code >}
     * @return list
     */
    public List<JAXBElement<? extends Medicine>> getMedicine() {
        if (medicine == null) {
            medicine = new ArrayList<JAXBElement<? extends Medicine>>();
        }
        return this.medicine;
    }

}
