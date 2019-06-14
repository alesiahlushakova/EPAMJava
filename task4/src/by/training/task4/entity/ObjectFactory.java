
package by.training.task4.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.training.task4.entity package. 
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

    private final static QName _Medicine_QNAME = new QName("http://www.example.com/Medicines", "Medicine");
    private final static QName _Antibiotic_QNAME = new QName("http://www.example.com/Medicines", "Antibiotic");
    private final static QName _Vitamin_QNAME = new QName("http://www.example.com/Medicines", "Vitamin");
    private final static QName _Analgetic_QNAME = new QName("http://www.example.com/Medicines", "Analgetic");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.training.task4.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Medicine }
     * 
     */
    public Medicine createMedicineType() {
        return new Medicine();
    }

    /**
     * Create an instance of {@link Antibiotic }
     * 
     */
    public Antibiotic createAntibioticType() {
        return new Antibiotic();
    }

    /**
     * Create an instance of {@link Medicines }
     * 
     */
    public Medicines createMedicines() {
        return new Medicines();
    }

    /**
     * Create an instance of {@link Vitamin }
     * 
     */
    public Vitamin createVitaminType() {
        return new Vitamin();
    }

    /**
     * Create an instance of {@link Analgetic }
     * 
     */
    public Analgetic createAnalgeticType() {
        return new Analgetic();
    }

    /**
     * Create an instance of {@link Certificate }
     * 
     */
    public Certificate createCertificateType() {
        return new Certificate();
    }

    /**
     * Create an instance of {@link Package }
     * 
     */
    public Package createPackageType() {
        return new Package();
    }

    /**
     * Create an instance of {@link Dosage }
     * 
     */
    public Dosage createDosageType() {
        return new Dosage();
    }

    /**
     * Create an instance of {@link Version }
     * 
     */
    public Version createVersionType() {
        return new Version();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Medicine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/Medicines", name = "Medicine")
    public JAXBElement<Medicine> createMedicine(Medicine value) {
        return new JAXBElement<Medicine>(_Medicine_QNAME, Medicine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Antibiotic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/Medicines", name = "Antibiotic", substitutionHeadNamespace = "http://www.example.com/Medicines", substitutionHeadName = "Medicine")
    public JAXBElement<Antibiotic> createAntibiotic(Antibiotic value) {
        return new JAXBElement<Antibiotic>(_Antibiotic_QNAME, Antibiotic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Vitamin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/Medicines", name = "Vitamin", substitutionHeadNamespace = "http://www.example.com/Medicines", substitutionHeadName = "Medicine")
    public JAXBElement<Vitamin> createVitamin(Vitamin value) {
        return new JAXBElement<Vitamin>(_Vitamin_QNAME, Vitamin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Analgetic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/Medicines", name = "Analgetic", substitutionHeadNamespace = "http://www.example.com/Medicines", substitutionHeadName = "Medicine")
    public JAXBElement<Analgetic> createAnalgetic(Analgetic value) {
        return new JAXBElement<Analgetic>(_Analgetic_QNAME, Analgetic.class, null, value);
    }

}
