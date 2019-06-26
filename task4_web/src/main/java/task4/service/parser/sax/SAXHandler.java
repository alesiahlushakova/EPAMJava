/*
 * class: SAXHandler
 */

package main.java.task4.service.parser.sax;

import main.java.task4.exception.MedicineNotFoundException;
import main.java.task4.model.Package;
import main.java.task4.model.*;
import main.java.task4.service.factory.MedicineFactory;
import main.java.task4.service.parser.Attributes;
import main.java.task4.service.parser.Elements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Handles SAX parser of XML document.
 * @author AlesyaHlushakova
 */
public class SAXHandler extends DefaultHandler {
    /**
     * logger intro.
     */
    private static final Logger LOG = LogManager.
            getLogger(SAXHandler.class);
    /**
     * medicines.
     */
    private Set<Medicine> medicines;
    /**
     * current element.
     */
    private Elements currentElement;
    /**
     * current attribute.
     */
    private Attributes currentAttr;
    /**
     * medicine factory.
     */
    private MedicineFactory mFactory;
    /**
     * date format.
     */
    private DateFormat dateFormat;
    /**
     * current medicine.
     */
    private Medicine currentMedicine;
    /**
     * current version.
     */
    private Version currentVersion;
    /**
     * certificate.
     */
    private Certificate currentCertificate;
    /**
     * package.
     */
    private main.java.task4.model.Package currentPackage;
    /**
     * dosage.
     */
    private Dosage currentDosage;

    /**
     * constructor.
     */
    public SAXHandler() {
        medicines = new HashSet<Medicine>();
        mFactory = new MedicineFactory();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * overrides start element.
     * @param uri uri
     * @param localName local name
     * @param qName name
     * @param attrs attributes
     */
    @Override
    public void startElement(
            final String uri, final String localName,
            final String qName,
            final org.xml.sax.Attributes attrs) {
        currentElement = Elements.valueOf(localName.toUpperCase());
        switch (currentElement) {
            case ANTIBIOTIC:
            case VITAMIN:
            case ANALGETIC:
            try {
                currentMedicine = mFactory.getMedicine(currentElement);
            } catch (MedicineNotFoundException e) {
                LOG.error("Medicine not presented exception", e);
            }
                for (int i = 0; i < attrs.getLength(); i++) {
                    String name = attrs.getLocalName(i);
                    String value = attrs.getValue(i);
                    currentAttr = Attributes.valueOf(name.toUpperCase());
                    switch (currentAttr) {
                        case NAME:
                            currentMedicine.setName(value);
                            break;
                        case CAS:
                            currentMedicine.setCas(value);
                            break;
                        case DRUG_BANK:
                            currentMedicine.setDrugBank(value);
                            break;
                        case RECIPE:
                            boolean recipe = Boolean.parseBoolean(value);
                            ((Antibiotic) currentMedicine).setRecipe(recipe);
                            break;
                        case SOLUTION:
                            ((Vitamin) currentMedicine).setSolution(value);
                            break;
                        case NARCOTIC:
                            boolean narcotic = Boolean.parseBoolean(value);
                            ((Analgetic) currentMedicine).setNarcotic(narcotic);
                        default:
                            break;
                    }
                }
                break;
            case VERSION:
                currentVersion = new Version();
                currentVersion.setAnalog(attrs.getValue(0));
                break;
            case CERTIFICATE:
                currentCertificate = new Certificate();
                break;
            case PACKAGE:
                currentPackage = new Package();
                if (attrs.getLength() > 0) {
                    currentPackage.setSize(attrs.getValue(0));
                }
                break;
            case DOSAGE:
                currentDosage = new Dosage();
                break;
            default:
                break;
        }
    }

    /**
     * overrides end element.
     * @param uri uri
     * @param localName local name
     * @param qName name
     */
    @Override
    public void endElement(final String uri,
                           final String localName, final String qName) {
        currentElement = Elements.valueOf(localName.toUpperCase());
        switch (currentElement) {
            case ANTIBIOTIC:
            case VITAMIN:
            case ANALGETIC:
                medicines.add(currentMedicine);
                break;
            case VERSION:
                currentMedicine.addVersion(currentVersion);
                break;
            case CERTIFICATE:
                currentVersion.setCertificate(currentCertificate);
                break;
            case PACKAGE:
                currentVersion.addPack(currentPackage);
                break;
            case DOSAGE:
                currentVersion.setDosage(currentDosage);
            default:
                break;
        }
    }

    /**
     * overrides method.
     * @param ch char.
     * @param start start
     * @param length length
     */
    @Override
    public void characters(final char[] ch, final int start,
                           final int length) {
        String content = new String(ch, start, length).trim();
        if (currentElement != null && !content.isEmpty()) {
            switch (currentElement) {
                case PHARM:
                    currentMedicine.setPharm(content);
                    break;
                case PRODUCER:
                    currentVersion.setProducer(content);
                    break;
                case FORM:
                    currentVersion.setForm(content);
                    break;
                case REGISTERED_BY:
                    currentCertificate.setRegisteredBy(content);
                    break;
                case REGISTRATION_DATE:
                    try {
                        Date date = dateFormat.parse(content);
                        currentCertificate.setRegistrationDate(date);
                    } catch (ParseException e) {

                    }
                    break;
                case EXPIRATION_DATE:
                    try {
                        Date date = dateFormat.parse(content);
                        currentCertificate.setExpireDate(date);
                    } catch (ParseException e) {

                    }
                    break;
                case QUANTITY:
                    currentPackage.setQuantity(Integer.parseInt(content));
                    break;
                case PRICE:
                    currentPackage.setPrice(Double.parseDouble(content));
                    break;
                case AMOUNT:
                    currentDosage.setAmount(content);
                    break;
                case FREQUENCY:
                    currentDosage.setFrequency(content);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * warning.
     * @param e exception
     */
    @Override
    public void warning(final SAXParseException e) {
        LOG.warn(getLineAddress(e), e);
    }

    /**
     * error.
     * @param e exception
     */
    @Override
    public void error(final SAXParseException e) {
        LOG.error(getLineAddress(e), e);
    }

    /**
     * fatal error.
     * @param e exception
     */
    @Override
    public void fatalError(final SAXParseException e) {
        LOG.fatal(getLineAddress(e), e);
    }

    /**
     * gets line address.
     * @param e exception
     * @return ex
     */
    public String getLineAddress(final SAXParseException e) {
        return e.getLineNumber() + ":" + e.getColumnNumber();
    }

    /**
     * getter for medicines.
     * @return medicines
     */
    public Set<Medicine> getMedicines() {
        return medicines;
    }
}


