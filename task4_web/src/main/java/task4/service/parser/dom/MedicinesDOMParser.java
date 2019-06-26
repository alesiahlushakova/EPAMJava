/*
 * class: MedicinesDOMParser
 */

package main.java.task4.service.parser.dom;

import main.java.task4.exception.MedicineException;
import main.java.task4.exception.MedicineNotFoundException;
import main.java.task4.exception.DosageException;
import main.java.task4.exception.MedicineAttributeException;
import main.java.task4.exception.PackageException;
import main.java.task4.exception.VersionException;
import main.java.task4.exception.CertificateException;
import main.java.task4.model.Package;
import main.java.task4.model.Medicine;
import main.java.task4.model.Version;
import main.java.task4.model.Dosage;
import main.java.task4.model.Certificate;
import main.java.task4.model.Analgetic;
import main.java.task4.model.Antibiotic;
import main.java.task4.model.Vitamin;
import main.java.task4.service.factory.MedicineFactory;
import main.java.task4.service.factory.MedicinesAbstractParser;
import main.java.task4.service.parser.Attributes;
import main.java.task4.service.parser.Elements;
import main.java.task4.service.validator.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Class MedicinesDOMParser extends abstract class.
 * {@link MedicinesAbstractParser}, serves for building set of Medicine objects.
 * based on XML-document by parser it using DOM-parser for XML.
 * @author AlesyaHlushakova
 */
public class MedicinesDOMParser extends MedicinesAbstractParser {
    /**
     * logger intro.
     */
    private static final Logger LOG = LogManager.
            getLogger(MedicinesDOMParser.class);
    /**
     * document builder.
     */
    private DocumentBuilder docBuilder;
    /**
     * medicine factory.
     */
    private MedicineFactory mFactory;
    /**
     * date format.
     */
    private DateFormat dateFormat;

    /**
     * constructor.
     */
    public MedicinesDOMParser() {
        medicins = new HashSet<Medicine>();
        mFactory = new MedicineFactory();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOG.error("Parser exception: " + e.getMessage());
        }
    }

    /**
     * Parses XML-document using DOM-parser, gets root-element of current doc.
     * @param xml - path to XML-document to parse
     * @return true - if parser was successful; false - if there occurred any
     * kind of exception during XML-document parser.
     */
    @Override
    public boolean buildSetMedicines(final String xml, final String xsd) {
        if (XMLValidator.validate(xml, xsd)) {
            Document document = null;
            try {
                document = docBuilder.parse(new File(xml));
                Element root = document.getDocumentElement();
                NodeList medicinsList = root.getChildNodes();
                for (int i = 0; i < medicinsList.getLength(); i++) {
                    Node node = medicinsList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element medicineElement = (Element) node;
                        Medicine medicine = buildMedicine(medicineElement);
                        medicins.add(medicine);
                    }
                }
                return true;
            } catch (IOException e) {
                LOG.error("Input/Output exception: " + e.getMessage());
            } catch (SAXException e) {
                LOG.error("SAX parser exception", e.getMessage());
            } catch (MedicineException e) {
                LOG.error("Error while creating Medicine");
            }
        }
        return false;
    }
    /**
     * Runs through all child-nodes.
     * @param medicineElement concrete medicine
     * @return {@link Medicine} object
     * @throws MedicineException exception
     */
    private Medicine buildMedicine(final Element medicineElement)
            throws MedicineException {
        Medicine currentMedicine;
        try {
            currentMedicine = mFactory.getMedicine(
                    Elements.valueOf(
                            medicineElement.getTagName().toUpperCase()));
            setMedicineAttributes(currentMedicine, medicineElement);
            Element pharm = (Element) medicineElement.getElementsByTagName(
                    Elements.PHARM.getValue()).item(0);
            currentMedicine.setPharm(pharm.getTextContent());
            currentMedicine.setVersions(buildVersions(medicineElement));
            return currentMedicine;
        } catch (MedicineNotFoundException
                | MedicineAttributeException
                | VersionException e) {
            String errorMessage = "Build medicine exception";
            LOG.error(errorMessage);
            throw new MedicineException(errorMessage, e);
        }
    }
    /**
     * Initializes Medicine object's fields depending on attribute-nodes of.
     * passed DOM-element.
     * @param medicine - Medicine object with fields supposed to initialize
     * @param medElement - DOM-element which contains relevant attributes
     * @throws MedicineAttributeException exception
     */
    private void setMedicineAttributes(final Medicine medicine,
                                       final Element medElement)
            throws MedicineAttributeException {
        NamedNodeMap attributes = medElement.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attribute = (Attr) attributes.item(i);
            String name = attribute.getName();
            String value = attribute.getValue();
            Attributes currentAttribute = Attributes.valueOf(
                    name.toUpperCase());
            switch (currentAttribute) {
                case NAME:
                    medicine.setName(value);
                    break;
                case CAS:
                    medicine.setCas(value);
                    break;
                case DRUG_BANK:
                    medicine.setDrugBank(value);
                    break;
                case RECIPE:
                    boolean recipe = Boolean.parseBoolean(value);
                    ((Antibiotic) medicine).setRecipe(recipe);
                    break;
                case SOLUTION:
                    ((Vitamin) medicine).setSolution(value);
                    break;
                case NARCOTIC:
                    boolean narcotic = Boolean.parseBoolean(value);
                    ((Analgetic) medicine).setNarcotic(narcotic);
                    break;
                default:
                    String errorMessage = "attribute <"
                            + currentAttribute
                            + "> is not valid";
                        LOG.error(errorMessage);
                    throw new MedicineAttributeException(errorMessage);
            }
        }
    }
    /**
     * Runs through all version-nodes of passed DOM-element and builds.
     * set of version.
     * @param medicineElement - DOM-element that represents concrete medicine
     * @return set of {@link Version} objects
     * @throws VersionException exception
     */
    private HashSet<Version> buildVersions(final Element medicineElement)
            throws VersionException {
        HashSet<Version> versions = new HashSet<>();
        NodeList versionElements = medicineElement.getElementsByTagName(
                Elements.VERSION.getValue());
        for (int i = 0; i < versionElements.getLength(); i++) {
            Element versionElement = (Element) versionElements.item(i);
            versions.add(buildVersion(versionElement));
        }
        return versions;
    }
    /**
     * Runs through all child-nodes of passed DOM-element and builds Version.
     * object depending on it.
     * @param versionElement - DOM-element that represents version of
     * concrete medicine.
     * @return {@link Version} object
     * @throws VersionException exception
     */
    private Version buildVersion(final Element versionElement)
            throws VersionException {
        Version currentVersion = new Version();
        currentVersion.setAnalog(versionElement.getAttribute(
                Attributes.ANALOG.getValue()));
        currentVersion.setProducer(versionElement.getElementsByTagName(
                Elements.PRODUCER.getValue()).item(0).getTextContent());
        currentVersion.setForm(versionElement.getElementsByTagName(
                Elements.FORM.getValue()).item(0).getTextContent());
        Element certificateElement =
                (Element) versionElement.getElementsByTagName(
                        Elements.CERTIFICATE.getValue()).item(0);
        Element dosageElement =
                (Element) versionElement.getElementsByTagName(
                        Elements.DOSAGE.getValue()).item(0);
        try {
            currentVersion.setCertificate(buildCertificate(certificateElement));
            currentVersion.setaPackages(buildPacks(versionElement));
            currentVersion.setDosage(buildDosage(dosageElement));
        } catch (CertificateException
                | PackageException
                | DosageException e) {
            String errorMessage = "Building version exception";
                LOG.error(errorMessage);
            throw new VersionException(errorMessage, e);
        }
        return currentVersion;
    }
    /**
     * Runs through all child-nodes of passed DOM-element and builds.
     * Certificate object depending on i.
     * @param certificateElement - DOM-element that represents certificate of
     * concrete medicine version.
     * @return {@link Certificate} object
     * @throws CertificateException exception
     */
    private Certificate buildCertificate(final Element certificateElement)
            throws CertificateException {
        Certificate currentCertificate = new Certificate();
        NodeList certificateFields = certificateElement.getChildNodes();
        for (int j = 0; j < certificateFields.getLength(); j++) {
            Node certField = certificateFields.item(j);
            if (certField.getNodeType() == Node.ELEMENT_NODE) {
                String tagName =
                        ((Element) certField).getTagName().toUpperCase();
                Elements currentField = Elements.valueOf(tagName);
                switch (currentField) {
                    case REGISTERED_BY:
                        currentCertificate.setRegisteredBy(
                                certField.getTextContent());
                        break;
                    case REGISTRATION_DATE:
                        try {
                            Date date = dateFormat.parse(
                                    certField.getTextContent());
                            currentCertificate.setRegistrationDate(date);
                        } catch (ParseException e) {

                        }
                        break;
                    case EXPIRATION_DATE:
                        try {
                            Date date = dateFormat.parse(
                                    certField.getTextContent());
                            currentCertificate.setExpireDate(date);
                        } catch (ParseException e) {

                        }
                        break;
                    default:
                        String errorMessage = "element <"
                                + currentField
                                + "> is not supposed to be here";
                        LOG.error(errorMessage);
                        throw new CertificateException(errorMessage);
                }
            }
        }
        return currentCertificate;
    }
    /**
     * Runs through all pack-nodes of passed DOM-element and builds set of
     * Package objects.
     *
     * @param versionElement - DOM-element that represents version of
     * concrete medicine
     * @return set of {@link main.java.task4.model.Package} objects
     * @throws PackageException exception
     */
    private HashSet<main.java.task4.model.Package> buildPacks(
            final Element versionElement)
            throws PackageException {
        HashSet<main.java.task4.model.Package> packs
                = new HashSet<main.java.task4.model.Package>();
        NodeList packElements = versionElement.getElementsByTagName(
                Elements.PACKAGE.getValue());
        for (int k = 0; k < packElements.getLength(); k++) {
            Element packElement = (Element) packElements.item(k);
            packs.add(buildPack(packElement));
        }
        return packs;
    }
    /**
     * Runs through all child-nodes of passed DOM-element and builds
     * Package object depending on it.
     * @param packElement - DOM-element that represents package form for
     * version of concrete medicine
     * @return {@link main.java.task4.model.Package} object
     * @throws PackageException exception
     */
    private main.java.task4.model.Package buildPack(final Element packElement)
            throws PackageException {
        main.java.task4.model.Package currentPackage
                = new Package();
        if (packElement.hasAttributes()) {
            Attr size = packElement.getAttributeNode(
                    Attributes.SIZE.getValue());
            currentPackage.setSize(size.getValue());
        }
        NodeList packFields = packElement.getChildNodes();
        for (int n = 0; n < packFields.getLength(); n++) {
            Node packField = packFields.item(n);
            if (packField.getNodeType() == Node.ELEMENT_NODE) {
                Elements currentField = Elements.valueOf(
                        ((Element) packField).getTagName().toUpperCase());
                switch (currentField) {
                    case QUANTITY:
                        currentPackage.setQuantity(Integer.parseInt(
                                packField.getTextContent()));
                        break;
                    case PRICE:
                        currentPackage.setPrice(Double.parseDouble(
                                packField.getTextContent()));
                        break;
                    default:
                        String errorMessage = "element <"
                                + currentField
                                + "> is not supposed to be here";

                        throw new PackageException(errorMessage);
                }
            }
        }
        return currentPackage;
    }
    /**
     * Runs through all child-nodes of passed DOM-element and builds
     * Dosage object depending on it.
     * @param dosageElement - DOM-element that represents dosage for version
     * of concrete medicine
     * @return {@link Dosage} object
     * @throws DosageException exception
     */
    private Dosage buildDosage(final Element dosageElement)
            throws DosageException {
        Dosage currentDosage = new Dosage();
        NodeList dosageFields = dosageElement.getChildNodes();
        for (int k = 0; k < dosageFields.getLength(); k++) {
            Node dosageField = dosageFields.item(k);
            if (dosageField.getNodeType() == Node.ELEMENT_NODE) {
                Elements currentField = Elements.valueOf(
                        ((Element) dosageField).getTagName().toUpperCase());
                switch (currentField) {
                    case AMOUNT:
                        currentDosage.setAmount(
                                dosageField.getTextContent());
                        break;
                    case FREQUENCY:
                        currentDosage.setFrequency(
                                dosageField.getTextContent());
                        break;
                    default:
                        String errorMessage = "element <"
                                + currentField
                                + "> is not supposed to be here";

                        throw new DosageException(errorMessage);
                }
            }
        }
        return currentDosage;
    }
}

