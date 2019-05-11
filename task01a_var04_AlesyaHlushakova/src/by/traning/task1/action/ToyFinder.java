package by.traning.task1.action;

import by.traning.task1.entity.GameRoom;
import by.traning.task1.entity.Toy;
import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.exception.NonValidValueException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

/**
 * @author  AlesyaHlushakova
 * class finds toy by parameters
 */
public class ToyFinder {
    public static final Logger LOGGER = LogManager.getLogger(ToyFinder.class);
    public  Toy findById(final GameRoom gameRoom, int id) throws InvalidDataException {
        try {
            LinkedList<Toy> result = gameRoom.getToys();
            return gameRoom.getById(id);
        }
     catch (InvalidDataException e) {
            LOGGER.warn("Not found by id");
     }
        throw new InvalidDataException("Error in finding by id");
    }
    /**
     * method finds by price between certain
     * sum of money.
     * @param gameRoom current game room
     * @param minPrice minimum price
     * @param maxPrice max price
     * @return list of toys
     * @throws NonValidValueException incorrect input
     */
    public LinkedList<Toy> findByPrice(final GameRoom gameRoom,
                                       final int minPrice, final int maxPrice)
            throws NonValidValueException {
        if (minPrice >=0 && maxPrice >= 0 && minPrice <= maxPrice) {
           LinkedList<Toy> result = new LinkedList<>();
            List<Toy> toys = gameRoom.getToys();
           for (Toy toy: toys) {
               if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice) {
                   result.add(toy);
               }
           }
           return result;
        } else {
            throw new NonValidValueException("Incorrect args");
        }
    }

    /**
     * method finds toy by name.
     * @param gameRoom storage
     * @param name name of toy
     * @return list of toys with certain name
     * @throws NonValidValueException
     */
    public LinkedList<Toy> findByName(final GameRoom gameRoom, final String name)
            throws NonValidValueException {
        if (!name.isEmpty()) {
            LinkedList<Toy> result = new LinkedList<>();
            List<Toy> toys = gameRoom.getToys();
            for (Toy toy: toys) {
                if (name.equalsIgnoreCase(toy.getName() )) {
                    result.add(toy);
                }
            }
            return result;
        } else {
            throw new NonValidValueException("Incorrect args");
        }
    }
}
