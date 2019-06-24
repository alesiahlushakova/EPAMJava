package by.training.task4.service.parser.sax;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import by.training.task4.entity.*;
import by.training.task4.entity.Package;
import by.training.task4.exception.MedicineNotPresentedException;
import by.training.task4.service.factory.MedicineFactory;
import by.training.task4.service.parser.constants.AttributesEnum;
import by.training.task4.service.parser.constants.ElementsEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
public class SAXParser extends DefaultHandler {
    private Set<Medicine> medicins;

    private ElementsEnum currentElement;
    private AttributesEnum currentAttr;
    private MedicineFactory mFactory;
    private DateFormat dateFormat;

    private Medicine currentMedicine;
    private Version currentVersion;
    private Certificate currentCertificate;
    private Package currentPack;
    private Dosage currentDosage;

    public SAXParser() {
        medicins = new HashSet<Medicine>();
        mFactory = new MedicineFactory();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attrs) {
        currentElement = ElementsEnum.valueOf(localName.toUpperCase());
        switch (currentElement) {
            case ANTIBIOTIC:
            case VITAMIN:
            case ANALGETIC:
                try {
                    currentMedicine = mFactory.getMedicine(currentElement);
                } catch (MedicineNotPresentedException e) {
                    //LOG.error("Medicine not presented exception", e);
                }
                for (int i = 0; i < attrs.getLength(); i++) {
                    String name = attrs.getLocalName(i);
                    String value = attrs.getValue(i);
                    currentAttr = AttributesEnum.valueOf(name.toUpperCase());
                    switch (currentAttr) {
                        case NAME:
                            currentMedicine.setName(value);
                            break;
                        case CAS:
                            currentMedicine.setCAS(value);
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
                currentVersion.setAnalog(attrs.getValue(0));
                break;
            case CERTIFICATE:
                currentCertificate = new Certificate();
                break;
            case PACKAGE:
                currentPack = new Package();
                if (attrs.getLength() > 0) {
                    currentPack.setSize(attrs.getValue(0));
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
        currentElement = ElementsEnum.valueOf(localName.toUpperCase());
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
                currentVersion.addPackage(currentPack);
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
                case REGISTRED_BY:
                    currentCertificate.setRegisteredBy(content);
                    break;
                case REGISTRATION_DATE:
                    try {
                        Date date = dateFormat.parse(content);
                        currentCertificate.setRegistrationDate(date);
                    } catch (ParseException e) {
                       // LOG.error("Date parsing exception: ", e);
                    }
                    break;
                case EXPIRATION_DATE:
                    try {
                        Date date = dateFormat.parse(content);
                        currentCertificate.setExpirationDate(date);
                    } catch (ParseException e) {
                       //LOG.error("Date parsing exception: ", e);
                    }
                    break;
                case QUANTITY:
                    currentPack.setQuantity(Integer.parseInt(content));
                    break;
                case PRICE:
                    currentPack.setPrice(Double.parseDouble(content));
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
     //   LOG.warn(getLineAddress(e), e);
    }

    @Override
    public void error(SAXParseException e) {
      //  LOG.error(getLineAddress(e), e);
    }

    @Override
    public void fatalError(SAXParseException e) {
     //   LOG.fatal(getLineAddress(e), e);
    }

    public String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + ":" + e.getColumnNumber();
    }

    public Set<Medicine> getMedicins() {
        return medicins;
    }
}
