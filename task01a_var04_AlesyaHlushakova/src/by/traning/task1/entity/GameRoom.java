package by.traning.task1.entity;
import by.traning.task1.exception.NonValidValueException;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Objects;

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
     * getters and setters for game room.
     * @return toys in game room
     */
    public LinkedList<Toy> getToys() {
        return toys;
    }


    /**
     *adds toy to storage.
     * @param toy toy to add
     */
    public void addToy(Toy toy) {
        toys.addLast(toy);
        this.totalToyPrice += toy.getPrice();
    }

    public int getPrice() {
        return totalToyPrice;
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

    public void setToys(LinkedList<Toy> toys) throws NonValidValueException {
        if (this.toys.containsAll(toys) && toys.containsAll((this.toys))) {
            this.toys = toys;
        }
        else {
            throw new NonValidValueException("Contain of game room can not be changed with method setToys");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameRoom gameRoom = (GameRoom) o;
        return totalToyPrice == gameRoom.totalToyPrice &&
                Objects.equals(toys, gameRoom.toys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toys, totalToyPrice);
    }


}
