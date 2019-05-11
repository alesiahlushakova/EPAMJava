package by.traning.task1.create;

import by.traning.task1.entity.Ball;
import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.parse.ToyParser;

/**
 * @author Alesya hlushakova
 * class creates ball toys.
 */
public class CreateBall extends ToyFactoryAbstract{
    /**
     * declare toy parser.
     */
    private ToyParser toyParser;


    /**
     * method creates ball object.
     * @return ball
     * @throws InvalidDataException invalid input
     */
    public Ball createToy() throws InvalidDataException {
        return new Ball(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeBallType());
    }
}
