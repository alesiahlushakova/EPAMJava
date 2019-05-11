package by.training.task1.create;

import by.training.task1.entity.Vehicle;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parse.ToyParser;

/**
 * @author Alesya hlushakova
 * class creates doll toys.
 */
public class CreateVehicle extends ToyFactoryAbstract {
    /**
     * declare toy parser.
     */
    private ToyParser toyParser;
    /**
     * method creates vehicle toys.
     * @return vehicle
     * @throws InvalidDataException invalid input
     */
    public Vehicle createToy() throws InvalidDataException {
        return new Vehicle(toyParser.takeToyName(), toyParser.takeToyPrice(),
                toyParser.takeToySize(),
                toyParser.takeToyAge(), toyParser.takeVehicleType());
    }
}
