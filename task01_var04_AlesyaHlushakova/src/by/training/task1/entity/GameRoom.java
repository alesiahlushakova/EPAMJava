package by.training.task1.entity;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.exception.NonValidValueException;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

/**
 * @author  AlesyaHlushakova
 * storage for toy objects.
 */
public class GameRoom {
    public static final Logger LOG=
            LogManager.getLogger(GameRoom.class.getName());
    /**
     * linked list that stores all created toys.
     */
    private LinkedList<Toy> toys;
    public int totalToyPrice;

    /**
     * constructs game room with already existing devices.
     * @param toys
     */
    public GameRoom(LinkedList<Toy> toys) {
        this.toys = toys;
        for(Toy toy : toys) {
            this.totalToyPrice += toy.getPrice();
        }
        LOG.info("GameRoom created"+this.toys + "\n");
    }

    /**
     * constructs game room without already existing devices.
     */
    public GameRoom() {
        this.toys = new LinkedList<Toy>();
        this.totalToyPrice = 0;
        LOG.info("GameRoom created"+this.toys);
    }

    /**
     *adds toy to storage.
     * @param toy toy to add
     */
    public void addToy(Toy toy) {
        toys.addLast(toy);
        this.totalToyPrice += toy.getPrice();
    }

    /**
     * method gets toy by id.
     * @param id toy id
     * @return toy object
     * @throws InvalidDataException non-validation toy data
     */
    public Toy  getById(int id)  throws InvalidDataException {
        for ( Toy toy: toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        throw new  InvalidDataException("Can not get by ID");
    }
    public Toy getByIndex(int i) {
        return toys.get(i);
    }
    /**
     * removes toy from storage.
     * @param i index to remove
     */
    public void removeByIndex(int i) {

        toys.remove(i);
        LOG.info("Toy removed");
    }

    /**
     * removes toy by name.
     * @param name name of toy to delete
     */
    public void removeByName(String name) {
        for (Toy toy : toys) {
            if (toy.getName() == name) {
                toys.remove(toy);
                LOG.debug("Toy removed"+toy+"\n Current toys in game room"+toys);
            }
        }
    }

    public int calcSize() {
        return toys.size();
    }


}
