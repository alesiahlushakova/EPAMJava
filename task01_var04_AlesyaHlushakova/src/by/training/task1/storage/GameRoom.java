package by.training.task1.storage;
import by.training.task1.entity.Toy;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * @author  AlesyaHlushakova
 * storage for toy objects.
 */
public class GameRoom {
    /**
     * logger intro.
     */
    public static final Logger LOG =
            LogManager.getLogger(GameRoom.class.getName());
    /**
     * linked list that stores all created toys.
     */
    private LinkedList<Toy> toys;

    /**
     * total price.
     */
    private int totalToyPrice;
    /**
     * method calculates toy prices.
     * @return total price
     */
    public int getTotalToyPrice() {
        return totalToyPrice;
    }

    /**
     * constructs game room with already existing devices.
     * @param toys toys
     */
    public GameRoom(final LinkedList<Toy> toys) {
        this.toys = toys;
        for (Toy toy : toys) {
            this.totalToyPrice += toy.getPrice();
        }
        LOG.info("GameRoom created" + this.toys + "\n");
    }

    /**
     * constructs game room without already existing devices.
     */
    public GameRoom() {
        this.toys = new LinkedList<Toy>();
        this.totalToyPrice = 0;
        LOG.info("GameRoom created" + this.toys);
    }

    /**
     *adds toy to storage.
     * @param toy toy to add
     */
    public void addToy(final Toy toy) {
        toys.addLast(toy);
        this.totalToyPrice += toy.getPrice();
    }

    /**
     * method gets toy by index.
     * @param i toy id
     * @return toy object
     */
    public Toy takeByIndex(final int i) {
        return toys.get(i);
    }
    /**
     * removes toy from storage.
     * @param i index to remove
     */
    public void removeByIndex(final int i) {

        toys.remove(i);
        LOG.info("Toy removed");
    }
    /**
     * removes toy by name.
     * @param name name of toy to delete
     */
    public void removeByName(final String name) {
        for (Toy toy : toys) {
            if (toy.getName() == name) {
                toys.remove(toy);
                LOG.debug("Toy removed"
                        + toy + "\n Current toys in game room" + toys);
            }
        }
    }

    /**
     * method calculates size of storage.
     * @return size
     */
    public int calcSize() {
        return toys.size();
    }


}
