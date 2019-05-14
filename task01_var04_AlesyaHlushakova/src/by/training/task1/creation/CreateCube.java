package by.training.task1.create;

import by.training.task1.entity.Cube;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parse.ToyParser;

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
