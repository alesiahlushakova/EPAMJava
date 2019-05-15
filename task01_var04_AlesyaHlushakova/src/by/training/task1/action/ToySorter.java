package by.training.task1.action;
import by.training.task1.comparator.ComparatorOptions;
import by.training.task1.comparator.ToyNameComparator;
import by.training.task1.comparator.ToyPriceComparator;
import by.training.task1.storage.GameRoom;
import by.training.task1.entity.Toy;
import by.training.task1.exception.InvalidDataException;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author AlesyaHlushakova
 * class sorts toys.
 */
public class ToySorter {

    private static final Logger LOGGER = LogManager.getLogger(ToySorter.class);

    /**
     * sort by param.
     * @param type sort type
     * @param gameRoom game room
     */
    public static void sort(final GameRoom gameRoom, ComparatorOptions type) throws InvalidDataException {
        LinkedList<Toy> toys= new LinkedList<>();
        for(int i = 0; i<gameRoom.calcSize(); i++) {
            toys.add(gameRoom.getByIndex(i));
        }
        switch (type) {
            case NAME:
                Collections.sort(toys, new ToyNameComparator());
                break;
            case PRICE:
                Collections.sort(toys, new ToyPriceComparator());
                break;
            case NAMETHENPRICE:
                Collections.sort(toys, new ToyNameComparator().
                        thenComparing(new ToyPriceComparator()));
                break;
                default:
                    throw new InvalidDataException("not valid param");
        }

        for(int i = 0; i<gameRoom.calcSize(); ) {
            gameRoom.removeByIndex(i);
        }
            for(int i= 0; i<toys.size(); i++) {
                gameRoom.addToy(toys.get(i));
            }
    }


}
