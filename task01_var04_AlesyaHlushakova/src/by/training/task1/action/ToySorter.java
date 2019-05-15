package by.training.task1.action;
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
     * sort by name.
     * @param gameRoom game room
     */
    public static void sortByName(final GameRoom gameRoom) throws InvalidDataException {
        LinkedList<Toy> toys= new LinkedList<>();
        for(int i = 0; i<gameRoom.calcSize(); i++) {
            toys.add(gameRoom.getByIndex(i));
        }
        Collections.sort(toys, new ToyNameComparator());
        for(int i = 0; i<gameRoom.calcSize(); ) {
            gameRoom.removeByIndex(i);
        }
            for(int i= 0; i<toys.size(); i++) {
                gameRoom.addToy(toys.get(i));
            }
    }

    /**
     * sort by price.
     * @param gameRoom game room
     */
    public static void sortByPrice(final GameRoom gameRoom) throws InvalidDataException {
        LinkedList<Toy> toys = new LinkedList<>();
        for(int i = 0; i<gameRoom.calcSize(); i++) {
            toys.add(gameRoom.getByIndex(i));
        }
        Collections.sort(toys, new ToyPriceComparator());
        for(int i = 0; i<gameRoom.calcSize(); ) {
            gameRoom.removeByIndex(i);
        }
        for(int i= 0; i<toys.size(); i++) {
            gameRoom.addToy(toys.get(i));
        }
    }

    /**
     * sort by name then by price.
     * @param gameRoom game room
     */
    public static void sortByNameThenPrice(final GameRoom gameRoom) {
        LinkedList<Toy> toys = new LinkedList<>();
        for(int i = 0; i<gameRoom.calcSize(); i++) {
            toys.add(gameRoom.getByIndex(i));
        }
        Collections.sort(toys, new ToyNameComparator().
                thenComparing(new ToyPriceComparator()));
     //   try {
        for(int i = 0; i<gameRoom.calcSize(); ) {
            gameRoom.removeByIndex(i);
        }
        for(int i= 0; i<toys.size(); i++) {
            gameRoom.addToy(toys.get(i));
        }
    }
}
