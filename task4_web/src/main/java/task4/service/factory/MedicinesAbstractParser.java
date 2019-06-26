/*
 * class: MedicinesAbstractParser
 */

package main.java.task4.service.factory;

import java.io.IOException;
import java.util.Set;

import main.java.task4.exception.MedicineException;
import main.java.task4.model.Medicine;
import org.xml.sax.SAXException;

/**
 * Abstract class MedicinesAbstractParser serves as basis for concrete builders.
 * for {@link Medicine} object sets, depending on concrete XML parser.
 * technology.
 * @author AlesyaHlushakova
 */
public abstract class MedicinesAbstractParser {
    /**
     * medicines.
     */
    protected Set<Medicine> medicins;

    /**
     * getter for medicine.
     * @return medicine
     */
    public Set<Medicine> getMedicines() {
        return medicins;
    }

    /**
     * builds set of medicines.
     * @param xml file
     * @param xsd schema
     * @return is correct
     * @throws MedicineException exception
     * @throws IOException exception
     * @throws SAXException exception
     */
    public abstract boolean buildSetMedicines(String xml,
                                              String xsd)
            throws MedicineException, IOException, SAXException;
}

