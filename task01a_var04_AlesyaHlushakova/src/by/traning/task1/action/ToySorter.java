package by.traning.task1.action;
import by.traning.task1.comparator.ToyNameComparator;
import by.traning.task1.comparator.ToyPriceComparator;
import by.traning.task1.entity.GameRoom;
import by.traning.task1.entity.Toy;
import by.traning.task1.exception.NonValidValueException;
import org.apache.logging.log4j.Level;
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
     * sort by name.
     * @param gameRoom game room
     */
    public void sortByName(final GameRoom gameRoom) {
        LinkedList<Toy> toys = gameRoom.getToys();
        Collections.sort(toys, new ToyNameComparator());
        try {
            gameRoom.setToys(toys);
        } catch (NonValidValueException e) {
            LOGGER.log(Level.ERROR, "Unable to set toys to game room", e);
        }
    }

    /**
     * sort by price.
     * @param gameRoom game room
     */
    public void sortByPrice(final GameRoom gameRoom) {
        LinkedList<Toy> toys = gameRoom.getToys();
        Collections.sort(toys, new ToyPriceComparator());
        try {
            gameRoom.setToys(toys);
        } catch (NonValidValueException e) {
            LOGGER.log(Level.ERROR, "Unable to set toys to game room", e);
        }
    }

    /**
     * sort by na,e then by price.
     * @param gameRoom game room
     */
    public void sortByNameThenPrice(final GameRoom gameRoom) {
        LinkedList<Toy> toys = gameRoom.getToys();
        Collections.sort(toys, new ToyNameComparator().
                thenComparing(new ToyPriceComparator()));
        try {
            gameRoom.setToys(toys);
        } catch (NonValidValueException e) {
            LOGGER.log(Level.ERROR, "Unable to set toys to game room", e);
        }
    }
}
