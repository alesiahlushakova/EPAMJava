package by.training.task4.service.factory;

import by.training.task4.entity.Medicine;
import by.training.task4.exception.MedicineException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Set;

public abstract class MedicinesAbstractBuilder {
    protected Set<Medicine> medicins;

    public Set<Medicine> getMedicins() {
        return medicins;
    }

    public abstract boolean buildSetMedicines(String xml) throws MedicineException, IOException, SAXException;
}
