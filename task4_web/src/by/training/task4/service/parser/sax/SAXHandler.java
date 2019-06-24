/*
 * class: SAXHandler
 */

package by.training.task4.service.parser.sax;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import by.training.task4.exception.MedicineNotFoundException;
import by.training.task4.model.*;
import by.training.task4.model.Package;
import by.training.task4.service.parser.Attributes;
import by.training.task4.service.parser.Elements;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


import by.training.task4.service.factory.MedicineFactory;

/**
 * Handles SAX parser of XML document
 *
 *
 * @author AlesyaHlushakova
 */
public class SAXHandler extends DefaultHandler {

    
    private Set<Medicine> medicins;
    
    private Elements currentElement;
    private Attributes currentAttr;
    private MedicineFactory mFactory;
    private DateFormat dateFormat;
    
    private Medicine currentMedicine;
    private Version currentVersion;
    private Certificate currentCertificate;
    private Package currentPackage;
    private Dosage currentDosage;
    
    public SAXHandler() {
        medicins = new HashSet<Medicine>();
        mFactory = new MedicineFactory();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    @Override
    public void startElement(
            String uri, String localName, String qName, org.xml.sax.Attributes attrs) {
        currentElement = Elements.valueOf(localName.toUpperCase());
        switch (currentElement) {
            case ANTIBIOTIC:
            case VITAMIN:
            case ANALGETIC:
            try {
                currentMedicine = mFactory.getMedicine(currentElement);
            } catch (MedicineNotFoundException e) {
              //  LOG.error("Medicine not presented exception", e);
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
                            ((Antibiotic)currentMedicine).setRecipe(recipe);
                            break;
                        case SOLUTION:
                            ((Vitamin)currentMedicine).setSolution(value);
                            break;
                        case NARCOTIC:
                            boolean narcotic = Boolean.parseBoolean(value);
                            ((Analgetic)currentMedicine).setNarcotic(narcotic);
                        default:
                            break;
                    }
                }
                break;
            case VERSION:
                currentVersion = new Version();
                currentVersion.setTradeName(attrs.getValue(0));
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
    
    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = Elements.valueOf(localName.toUpperCase());
        switch (currentElement) {
            case ANTIBIOTIC:
            case VITAMIN:
            case ANALGETIC:
                medicins.add(currentMedicine);
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
    
    @Override
    public void characters(char[] ch, int start, int length) {
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
                    currentCertificate.setRegistredBy(content);
                    break;
                case REGISTRATION_DATE:
                    try {
                        Date date = dateFormat.parse(content);
                        currentCertificate.setRegistrationDate(date);
                    } catch (ParseException e) {
                      //  LOG.error("Date parser exception: ", e);
                    }
                    break;
                case EXPIRATION_DATE:
                    try {
                        Date date = dateFormat.parse(content);
                        currentCertificate.setExpireDate(date);
                    } catch (ParseException e) {
                      //  LOG.error("Date parser exception: ", e);
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
    
    @Override
    public void warning(SAXParseException e) {

    }
    
    @Override
    public void error(SAXParseException e) {

    }
    
    @Override
    public void fatalError(SAXParseException e) {

    }
    
    public String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + ":" + e.getColumnNumber();
    }

    public Set<Medicine> getMedicins() {
        return medicins;
    }
}
