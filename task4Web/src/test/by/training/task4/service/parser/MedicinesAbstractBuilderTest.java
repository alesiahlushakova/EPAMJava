package test.by.training.task4.service.parser;

import by.training.task4.entity.*;
import by.training.task4.entity.Package;
import by.training.task4.exception.MedicineException;
import by.training.task4.exception.ParserException;
import by.training.task4.service.factory.MedicineParserFactory;
import by.training.task4.service.factory.MedicinesAbstractBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class MedicinesAbstractBuilderTest {
    private static final String VALID_XML = "validTest.xml";
    private static final String INVALID_XML = "invalidTest.xml";
    private static final String VALIDTION_XML = "Medicines.xsd";

    private static MedicineParserFactory factory;
    private static MedicinesAbstractBuilder builder;

    private static Set<Medicine> validMedicinsSet;

    @Test(dataProvider = "medicinsBuilders", description = "positive test")
    public void buildSetMedicinsPositiveTest(String jaxp)
            throws ParserException, IOException, SAXException, MedicineException {
        builder = factory.getBuilder(jaxp);
        builder.buildSetMedicines(VALID_XML, VALIDTION_XML);
        Set<Medicine> actualMedicinsSet = builder.getMedicins();
        Assert.assertEquals(actualMedicinsSet, validMedicinsSet);
    }

    @Test(dataProvider = "medicinsBuilders", description = "negative test")
    public void buildSetMedicinsNegativeTest(String jaxp)
            throws ParserException, IOException, SAXException, MedicineException {
        builder = factory.getBuilder(jaxp);
        Assert.assertFalse(builder.buildSetMedicines(INVALID_XML, VALIDTION_XML));
    }

    @DataProvider(name = "medicinsBuilders")
    public static Object[][] createData() {
        return new Object[][] {
                {"sax"}, {"dom"}, {"stax"}
        };
    }

    @BeforeClass
    public void beforeClass() throws ParseException {
        factory = new MedicineParserFactory();

        validMedicinsSet = new HashSet<Medicine>();

        Medicine medicine = new Antibiotic();
        medicine.setName("Test antibiotic");
        medicine.setCAS("12345-67-8");
        medicine.setDrugBank("DB00000");
        medicine.setPharm("Test Pharmacy");
        ((Antibiotic) medicine).setRecipe(true);

        Version version = new Version();
        version.setAnalog("Test trade name");
        version.setProducer("Test producer");
        version.setForm("pills");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Certificate certificate = new Certificate();
        certificate.setRegisteredBy("Test registration");
        certificate.setRegistrationDate(dateFormat.parse("2010-01-01"));
        certificate.setExpirationDate(dateFormat.parse("2020-01-01"));
        Package pack = new Package();
        pack.setQuantity(100);
        pack.setPrice(200.00);
        HashSet<Package> packs = new HashSet<Package>();
        packs.add(pack);

        Dosage dosage = new Dosage();
        dosage.setAmount("Test amount");
        dosage.setFrequency("Test frequency");

        version.setCertificate(certificate);
        version.setPackage(packs);
        version.setDosage(dosage);
        medicine.addVersion(version);
        validMedicinsSet.add(medicine);
    }

    @AfterClass
    public void afterClass() {
        validMedicinsSet.clear();
        validMedicinsSet = null;
    }
}
