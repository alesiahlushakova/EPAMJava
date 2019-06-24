/*
 * class: MedicinsAbstractParser
 */

package by.training.task4.service.factory;

import java.io.IOException;
import java.util.Set;

import by.training.task4.exception.MedicineException;
import by.training.task4.model.Medicine;
import org.xml.sax.SAXException;

/**
 * Abstract class MedicinsAbstractParser serves as basis for concrete builders
 * for {@link Medicine} object sets, depending on concrete XML parser
 * technology
 *
 *
 * @author AlesyaHlushakova
 */
public abstract class MedicinsAbstractParser {

    protected Set<Medicine> medicins;

    public Set<Medicine> getMedicins() {
        return medicins;
    }
    
    public abstract boolean buildSetMedicins(String xml, String xsd)
            throws MedicineException, IOException, SAXException;
}