package by.training.task1.creation;

import by.training.task1.entity.Ball;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;
/**
 * TODO generics
 */

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
     * constructor for ball creator.
     * @param toyParser parser
     */
    public CreateBall(ToyParser toyParser) {
        this.toyParser = toyParser;
    }


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
