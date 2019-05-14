package by.training.task1.creation;

import by.training.task1.entity.Cube;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;

/**
 * @author Alesya hlushakova
 * class creates cube toys.
 */
public class CreateCube extends ToyFactoryAbstract {
    /**
     * declare toy parser.
     */
    private ToyParser toyParser;

    /**
     * constructor for cubes.
     * @param toyParser parser
     */
    public CreateCube(ToyParser toyParser) {
        this.toyParser = toyParser;
    }

    /**
     * method creates cube toys.
     * @return cube
     * @throws InvalidDataException invalid input
     */
    public Cube createToy() throws InvalidDataException {
        return new Cube(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeCubeType());
    }

}
