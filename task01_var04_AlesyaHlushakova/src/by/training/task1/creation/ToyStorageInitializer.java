package by.training.task1.creation;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;
import by.training.task1.storage.ToyStorage;
import by.training.task1.uconst.TypeToy;
import org.apache.logging.log4j.Level;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.util.LinkedList;

/**
 * @author AlesyaHlushakova
 * class that initializes toy storage by data from .txt file.
 */
public class ToyStorageInitializer {
    /**
     * logger intro.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ToyStorageInitializer.class);

    /**
     * method initializes toy storage by given values.
     * @param strings source string
     * @return tpy storage
     * @throws InvalidDataException invalid input data
     */
    public ToyStorage init(final LinkedList<String> strings) {
        ToyStorage storage = ToyStorage.getInstance();
        TypeToy typeToy;
        ToyParser toyParser;
        ToyCreator toyCreator;
        while (!strings.isEmpty()) {
            toyParser = new ToyParser((strings.removeFirst()));
            toyCreator = new ToyCreator((toyParser));
            try {
                typeToy = toyParser.takeToyType();
                switch (typeToy) {
                    case BALL:
                        storage.addToy(toyCreator.createBall());
                        break;
                    case CUBE:
                        storage.addToy(toyCreator.createCube());
                        break;
                    case DOLL:
                        storage.addToy(toyCreator.createDoll());
                        break;
                    case VEHICLE:
                        storage.addToy(toyCreator.createVehicle());
                        break;
                    default:
                        throw new InvalidDataException();
                }

            } catch (InvalidDataException e) {
                LOGGER.log(Level.ERROR, "String contains not valid toy", e);
            }
        }
        return storage;
    }
}
