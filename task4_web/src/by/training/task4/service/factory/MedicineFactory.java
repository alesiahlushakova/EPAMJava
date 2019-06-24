/*
 * class: MedicineFactory
 */

package by.training.task4.service.factory;

import by.training.task4.exception.MedicineNotFoundException;
import by.training.task4.model.Analgetic;
import by.training.task4.model.Antibiotic;
import by.training.task4.model.Medicine;
import by.training.task4.model.Vitamin;
import by.training.task4.service.parser.Elements;

/**
 * Factory class which creates concrete medicine objects depending on passed
 * value
 *
 *
 * @author AlesyaHlushakova
 */
public class MedicineFactory {

    /**
     * Factory method for creation concrete medicine objects
     * 
     * @param element - {@link Elements} object which represents concrete
     * type of medicine to create
     * @return {@link Medicine} object ({@link Antibiotic} , {@link Analgetic} 
     * or {@link Vitamin})
     * @throws MedicineNotFoundException
     */
    public Medicine getMedicine(Elements element)
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
