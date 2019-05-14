package by.training.task1.creation;

import by.training.task1.entity.Ball;
import by.training.task1.entity.Cube;
import by.training.task1.entity.Doll;
import by.training.task1.entity.Vehicle;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;

/**
 * @author AlesyHlushkova
 * class that creates toys of different types.
 */
public class ToyCreator {
    /**
     * declare toy parser.
     */
    private ToyParser toyParser;

    /**
     * constructor.
     * @param parser toy parser
     */
    public ToyCreator(final ToyParser parser) {
        this.toyParser = parser;
    }

    /**
     * method creates ball object.
     * @return ball
     * @throws InvalidDataException invalid input
     */
    public Ball createBall() throws InvalidDataException {
        return new Ball(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeBallType());
    }

    /**
     * method creates cube toys.
     * @return cube
     * @throws InvalidDataException invalid input
     */
    public Cube createCube() throws InvalidDataException {
        return new Cube(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeCubeType());
    }

    /**
     * method creates doll toys.
     * @return doll
     * @throws InvalidDataException invalid input
     */
    public Doll createDoll() throws InvalidDataException {
        return new Doll(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeDollType());
    }

    /**
     * method creates vehicle toy.
     * @return vehicle
     * @throws InvalidDataException invalid input
     */
    public Vehicle createVehicle() throws InvalidDataException {
        return new Vehicle(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeVehicleType());
    }
}
