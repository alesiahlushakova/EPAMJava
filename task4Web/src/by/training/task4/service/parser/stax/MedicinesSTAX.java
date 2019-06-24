package by.training.task4.service.parser.stax;

import by.training.task4.entity.*;
import by.training.task4.entity.Package;
import by.training.task4.exception.MedicineException;
import by.training.task4.exception.MedicineNotPresentedException;
import by.training.task4.service.factory.MedicineFactory;
import by.training.task4.service.factory.MedicinesAbstractBuilder;
import by.training.task4.service.parser.constants.AttributesEnum;
import by.training.task4.service.parser.constants.ElementsEnum;
import by.training.task4.service.parser.dom.DOMParser;
import by.training.task4.service.validation.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class MedicinesSTAX extends MedicinesAbstractBuilder {
  //  public static final Logger LOG = LogManager.getLogger(MedicinesSTAX.class.getName());
    private XMLInputFactory inputFactory;
    private MedicineFactory mFactory;
    private DateFormat dateFormat;

    private ElementsEnum currentElement;
    private ElementsEnum currentMedicine;
    private Version currentVersion;
    private Certificate currentCertificate;
    private Package currentPack;
    private Dosage currentDosage;

    public MedicinesSTAX() {
        super();
        mFactory = new MedicineFactory();
        medicins = new HashSet<Medicine>();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFactory = XMLInputFactory.newInstance();
    }

    /**
     * Parses XML-document using StAX-parser, gets XML stream reader of current
     * document runs through it and builds set of Medicine objects
     *
     * @param xml - path to XML-document to parse
     * @return true - if parsing was successful; false - if there occurred any
     * kind of exception during XML-document parsing
     */
    @Override
    public boolean buildSetMedicines(String xml, String xsd) {
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
                        currentMedicine = ElementsEnum.valueOf(
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
              //  LOG.fatal(xml + " file not found", e);
                throw new RuntimeException();
            } catch (XMLStreamException e) {
              //  LOG.error("StAX parsing exception", e);
            } catch (MedicineException e) {
              //  LOG.error("An error occured within building Medicine object", e);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (XMLStreamException e) {
                      //  LOG.error("XML stream exception", e);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Builds medicine object by parsing XML document using XML stream reader
     *
     * @param reader - XMLStreamReader for current XML document
     * @return {@link Medicine} object
     * @throws XMLStreamException
     * @throws MedicineException
     */
    private Medicine buildMedicine(XMLStreamReader reader)
            throws XMLStreamException, MedicineException {
        Medicine medicine;
        try {
            medicine = mFactory.getMedicine(currentMedicine);
        } catch (MedicineNotPresentedException e) {
         //   LOG.error("Medicine not presented exception", e);
            throw new MedicineException("Medicine not presented", e);
        }
        setMedAttributes(medicine, reader);
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                currentElement = ElementsEnum.valueOf(
                        reader.getLocalName().toUpperCase());
                openingTag(medicine, reader);
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                currentElement = ElementsEnum.valueOf(
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
     * Handles XML opening tag
     *
     * @param medicine - current medicine object
     * @param reader - XMLStreamReader for current XML document
     * @throws XMLStreamException
     */
    private void openingTag(Medicine medicine, XMLStreamReader reader)
            throws XMLStreamException {
        switch (currentElement) {
            case PHARM:
                medicine.setPharm(getTextContent(reader));
                break;
            case VERSION:
                currentVersion = new Version();
                currentVersion.setAnalog(
                        reader.getAttributeValue(
                                null, AttributesEnum.ANALOG.getValue()));
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
            case REGISTRED_BY:
                currentCertificate.setRegisteredBy(getTextContent(reader));
                break;
            case REGISTRATION_DATE:
                try {
                    Date regDate = dateFormat.parse(getTextContent(reader));
                    currentCertificate.setRegistrationDate(regDate);
                } catch (ParseException e) {
                  //  LOG.error("Date parsing exception", e);
                }
                break;
            case EXPIRATION_DATE:
                try {
                    Date expDate = dateFormat.parse(getTextContent(reader));
                    currentCertificate.setExpirationDate(expDate);
                } catch (ParseException e) {
                  //  LOG.error("Date parsing exception", e);
                }
                break;
            case PACKAGE:
                currentPack = new Package();
                currentPack.setSize(reader.getAttributeValue(
                        null, AttributesEnum.SIZE.getValue()));
                break;
            case QUANTITY:
                currentPack.setQuantity(Integer.parseInt(
                        getTextContent(reader)));
                break;
            case PRICE:
                currentPack.setPrice(Double.parseDouble(
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
     * Handles closing XML tag
     *
     * @param medicine - current medicine object
     * @param reader - XMLStreamReader for current XML document
     */
    private void closingTag(Medicine medicine, XMLStreamReader reader) {
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
                currentVersion.addPackage(currentPack);
                currentPack = null;
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
     * Sets attributes for current medicine object
     *
     * @param medicine - medicine which attributes have to be setted
     * @param reader - XMLStreamReader for current XML document
     */
    private void setMedAttributes(Medicine medicine, XMLStreamReader reader) {
        medicine.setName(
                reader.getAttributeValue(null, AttributesEnum.NAME.getValue()));
        medicine.setCAS(
                reader.getAttributeValue(null, AttributesEnum.CAS.getValue()));
        medicine.setDrugBank(
                reader.getAttributeValue(
                        null, AttributesEnum.DRUG_BANK.getValue()));
        switch (currentMedicine) {
            case ANTIBIOTIC:
                boolean recipe = Boolean.parseBoolean(
                        reader.getAttributeValue(
                                null, AttributesEnum.RECIPE.getValue()));
                ((Antibiotic) medicine).setRecipe(recipe);
                break;
            case ANALGETIC:
                boolean narcotic = Boolean.parseBoolean(
                        reader.getAttributeValue(
                                null, AttributesEnum.NARCOTIC.getValue()));
                ((Analgetic) medicine).setNarcotic(narcotic);
                break;
            case VITAMIN:
                String solution = reader.getAttributeValue(
                        null, AttributesEnum.SOLUTION.getValue());
                ((Vitamin) medicine).setSolution(solution);
            default:
                break;
        }
    }

    /**
     * Gets text content of the current XML element
     *
     * @param reader - XMLStreamReader refers to XML element that contains text
     * content
     * @return String that represents text content of current element
     * @throws XMLStreamException
     */
    private String getTextContent(XMLStreamReader reader)
            throws XMLStreamException {
        String content = null;
        if (reader.hasNext()) {
            reader.next();
            content = reader.getText();
        }
        return content;
    }
}
