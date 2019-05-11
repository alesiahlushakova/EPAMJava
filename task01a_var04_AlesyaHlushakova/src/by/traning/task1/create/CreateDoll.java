package by.traning.task1.create;

import by.traning.task1.entity.Doll;
import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.parse.ToyParser;

/**
 * @author Alesya hlushakova
 * class creates doll toys.
 */
public class CreateDoll extends ToyFactoryAbstract{
    /**
     * declare toy parser.
     */
    private ToyParser toyParser;
    /**
     * method creates doll toys.
     * @return doll
     * @throws InvalidDataException invalid input
     */
    /**
     * method creates doll toys.
     * @return doll
     * @throws InvalidDataException invalid input
     */
    public Doll createToy() throws InvalidDataException {
        return new Doll(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeDollType());
    }
}
