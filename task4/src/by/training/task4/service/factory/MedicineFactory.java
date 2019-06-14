package by.training.task4.service.factory;

import by.training.task4.entity.Analgetic;
import by.training.task4.entity.Antibiotic;
import by.training.task4.entity.Medicine;
import by.training.task4.entity.Vitamin;
import by.training.task4.exception.MedicineNotPresentedException;
import by.training.task4.service.parser.constants.ElementsEnum;

/**
 * Factory class which creates concrete medicine objects depending on passed
 * value
 *
 * @author AlesyaHulshakova
 * @version 1.0
 */
public class MedicineFactory {

    /**
     * Factory method for creation concrete medicine objects
     *
     * @param element - {@link ElementsEnum} object which represents concrete
     * type of medicine to create
     * @return {@link Medicine} object ({@link Antibiotic} , {@link Analgetic}
     * or {@link Vitamin})
     * @throws MedicineNotPresentedException
     */
    public Medicine getMedicine(ElementsEnum element)
            throws MedicineNotPresentedException {
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
                throw new MedicineNotPresentedException(
                        "There is not such medicine type: " + element);
        }
        return medicine;
    }
}