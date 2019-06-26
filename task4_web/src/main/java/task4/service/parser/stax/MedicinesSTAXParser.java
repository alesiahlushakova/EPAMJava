/*
 * class: MedicinesSTAXParser
 */

package main.java.task4.service.parser.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


import main.java.task4.exception.MedicineException;
import main.java.task4.exception.MedicineNotFoundException;
import main.java.task4.model.Analgetic;
import main.java.task4.model.Antibiotic;
import main.java.task4.model.Certificate;
import main.java.task4.model.Dosage;
import main.java.task4.model.Medicine;
import main.java.task4.model.Package;
import main.java.task4.model.Version;
import main.java.task4.model.Vitamin;
import main.java.task4.service.factory.MedicineFactory;
import main.java.task4.service.factory.MedicinesAbstractParser;
import main.java.task4.service.parser.Attributes;
import main.java.task4.service.parser.Elements;
import main.java.task4.service.validator.XMLValidator;

/**
 * Class MedicinesSTAXParser extends abstract class
 * {@link MedicinesAbstractParser}, serves for building set of Medicine objects
 * based on XML-document by parser it using StAX-parser for XML.
 *
 *
 * @author AlesyaHlushakova
 */
public class MedicinesSTAXParser extends MedicinesAbstractParser {
    /**
     * xml input factory.
     */
    private XMLInputFactory inputFactory;
    /**
     * medidcine factory.
     */
    private MedicineFactory mFactory;
    /**
     * fate format.
     */
    private DateFormat dateFormat;
    /**
     * current elements.
     */
    private Elements currentElement;
    /**
     * current medicine.
     */
    private Elements currentMedicine;
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
    private Package currentPackage;
    /**
     * dosage.
     */
    private Dosage currentDosage;

    /**
     * constructor.
     */
    public MedicinesSTAXParser() {
        super();
        mFactory = new MedicineFactory();
        medicins = new HashSet<Medicine>();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFactory = XMLInputFactory.newInstance();
    }

    /**
     * Parses XML-document using StAX-parser, gets XML stream reader of current.
     * document runs through it and builds set of Medicine objects.
     * @param xml - path to XML-document to parse
     * @return true - if parser was successful; false - if there occurred any
     * kind of exception during XML-document parser
     */
    @Override
    public boolean buildSetMedicines(final String xml, final String xsd) {
        if (XMLValidator.validate(xml, xsd)) {
            XMLStreamReader reader = null;
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(new File(xml));
                reader = inputFactory.createXMLStreamReader(fis);
                while (reader.hasNext()) {
                    int type = reader.next();
                    if (type == XMLStreamConstants.START_ELEMENT) {
                        String name = reader.getLocalName();
                        currentMedicine = Elements.valueOf(
                                name.toUpperCase());
                        switch (currentMedicine) {
                            case ANTIBIOTIC:
                            case ANALGETIC:
                            case VITAMIN:
                                medicins.add(buildMedicine(reader));
                            default:
                                break;
                        }
                    }
                }
                return true;
            } catch (FileNotFoundException e) {

                throw new RuntimeException();
            } catch (XMLStreamException e) {

            } catch (MedicineException e) {

            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (XMLStreamException e) {

                    }
                }
            }
        }
        return false;
    }
    /**
     * Builds medicine object by parser XML document using XML stream reader.
     * @param reader - XMLStreamReader for current XML document
     * @return {@link Medicine} object
     * @throws XMLStreamException exception
     * @throws MedicineException exception
     */
    private Medicine buildMedicine(final XMLStreamReader reader)
            throws XMLStreamException, MedicineException {
        Medicine medicine;
        try {
            medicine = mFactory.getMedicine(currentMedicine);
        } catch (MedicineNotFoundException e) {

            throw new MedicineException("Medicine not presented", e);
        }
        setMedAttributes(medicine, reader);
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                currentElement = Elements.valueOf(
                        reader.getLocalName().toUpperCase());
                openingTag(medicine, reader);
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                currentElement = Elements.valueOf(
                        reader.getLocalName().toUpperCase());
                if (currentElement == currentMedicine) {
                    break;
                }
                closingTag(medicine, reader);
            }
        }
        return medicine;
    }
    /**
     * Handles XML opening tag.
     * @param medicine - current medicine object
     * @param reader - XMLStreamReader for current XML document
     * @throws XMLStreamException exception
     */
    private void openingTag(final Medicine medicine,
                            final XMLStreamReader reader)
            throws XMLStreamException {
        switch (currentElement) {
            case PHARM:
                medicine.setPharm(getTextContent(reader));
                break;
            case VERSION:
                currentVersion = new Version();
                currentVersion.setAnalog(
                        reader.getAttributeValue(
                                null, Attributes.ANALOG.getValue()));
                break;
            case PRODUCER:
                currentVersion.setProducer(getTextContent(reader));
                break;
            case FORM:
                currentVersion.setForm(getTextContent(reader));
                break;
            case CERTIFICATE:
                currentCertificate = new Certificate();
                break;
            case REGISTERED_BY:
                currentCertificate.setRegisteredBy(getTextContent(reader));
                break;
            case REGISTRATION_DATE:
                try {
                    Date regDate = dateFormat.parse(getTextContent(reader));
                    currentCertificate.setRegistrationDate(regDate);
                } catch (ParseException e) {

                }
                break;
            case EXPIRATION_DATE:
                try {
                    Date expDate = dateFormat.parse(getTextContent(reader));
                    currentCertificate.setExpireDate(expDate);
                } catch (ParseException e) {

                }
                break;
            case PACKAGE:
                currentPackage = new Package();
                currentPackage.setSize(reader.getAttributeValue(
                        null, Attributes.SIZE.getValue()));
                break;
            case QUANTITY:
                currentPackage.setQuantity(Integer.parseInt(
                        getTextContent(reader)));
                break;
            case PRICE:
                currentPackage.setPrice(Double.parseDouble(
                        getTextContent(reader)));
                break;
            case DOSAGE:
                currentDosage = new Dosage();
                break;
            case AMOUNT:
                currentDosage.setAmount(getTextContent(reader));
                break;
            case FREQUENCY:
                currentDosage.setFrequency(getTextContent(reader));
                break;
            default:
                break;
        }
    }
    /**
     * Handles closing XML tag.
     * @param medicine - current medicine object
     * @param reader - XMLStreamReader for current XML document
     */
    private void closingTag(final Medicine medicine,
                            final XMLStreamReader reader) {
        switch (currentElement) {
            case VERSION:
                medicine.addVersion(currentVersion);
                currentVersion = null;
                break;
            case CERTIFICATE:
                currentVersion.setCertificate(currentCertificate);
                currentCertificate = null;
                break;
            case PACKAGE:
                currentVersion.addPack(currentPackage);
                currentPackage = null;
                break;
            case DOSAGE:
                currentVersion.setDosage(currentDosage);
                currentDosage = null;
                break;
            default:
                break;
        }
    }
    /**
     * Sets attributes for current medicine object.
     * @param medicine - medicine which attributes have to be setted
     * @param reader - XMLStreamReader for current XML document
     */
    private void setMedAttributes(final Medicine medicine,
                                  final XMLStreamReader reader) {
        medicine.setName(
                reader.getAttributeValue(null, Attributes.NAME.getValue()));
        medicine.setCas(
                reader.getAttributeValue(null, Attributes.CAS.getValue()));
        medicine.setDrugBank(
                reader.getAttributeValue(
                        null, Attributes.DRUG_BANK.getValue()));
        switch (currentMedicine) {
            case ANTIBIOTIC:
                boolean recipe = Boolean.parseBoolean(
                        reader.getAttributeValue(
                                null, Attributes.RECIPE.getValue()));
                ((Antibiotic) medicine).setRecipe(recipe);
                break;
            case ANALGETIC:
                boolean narcotic = Boolean.parseBoolean(
                        reader.getAttributeValue(
                                null, Attributes.NARCOTIC.getValue()));
                ((Analgetic) medicine).setNarcotic(narcotic);
                break;
            case VITAMIN:
                String solution = reader.getAttributeValue(
                        null, Attributes.SOLUTION.getValue());
                ((Vitamin) medicine).setSolution(solution);
            default:
                break;
        }
    }
    /**
     * Gets text content of the current XML element.
     * @param reader - XMLStreamReader refers to XML element that contains text
     * content
     * @return String that represents text content of current element
     * @throws XMLStreamException exception
     */
    private String getTextContent(final XMLStreamReader reader)
            throws XMLStreamException {
        String content = null;
        if (reader.hasNext()) {
            reader.next();
            content = reader.getText();
        }
        return content;
    }
}

