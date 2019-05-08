package by.traning.task1.action;

import by.traning.task1.entity.GameRoom;
import by.traning.task1.entity.Toy;
import by.traning.task1.exception.NonValidValueException;

import java.util.LinkedList;
import java.util.List;

/**
 * @author  AlesyaHlushakova
 * class finds toy by parameters
 */
public class ToyFinder {
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
}
