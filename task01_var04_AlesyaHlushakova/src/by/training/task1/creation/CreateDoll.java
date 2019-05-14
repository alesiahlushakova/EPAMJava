package by.training.task1.creation;

import by.training.task1.entity.Doll;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;

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
     * constructor for dolls.
     * @param toyParser parser
     */
    public CreateDoll(ToyParser toyParser) {
        this.toyParser = toyParser;
    }
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
