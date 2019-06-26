/*
 * class: MedicineFactory
 */

package main.java.task4.service.factory;

import main.java.task4.exception.MedicineNotFoundException;
import main.java.task4.model.Analgetic;
import main.java.task4.model.Antibiotic;
import main.java.task4.model.Medicine;
import main.java.task4.model.Vitamin;
import main.java.task4.service.parser.Elements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Factory class which creates concrete medicine objects depending on passed.
 * value.
 * @author AlesyaHlushakova
 */
public class MedicineFactory {
    /**
     * logger intro.
     */
    private static final Logger LOG = LogManager.
            getLogger(MedicinesParserFactory.class);
    /**
     * Factory method for creation concrete medicine objects.
     * @param element - {@link Elements} object which represents concrete
     * type of medicine to create.
     * @return {@link Medicine} object ({@link Antibiotic} , {@link Analgetic}
     * or {@link Vitamin})
     * @throws MedicineNotFoundException exception
     */
    public Medicine getMedicine(final Elements element)
            throws MedicineNotFoundException {
        Medicine medicine = null;
        switch (element) {
            case ANTIBIOTIC:
                medicine = new Antibiotic();
                break;
            case VITAMIN:
                medicine = new Vitamin();
                break;
            case ANALGETIC:
                medicine = new Analgetic();
                break;
            default:
                throw new MedicineNotFoundException(
                        "There is not such medicine type: " + element);
        }
        return medicine;
    }
}


