package test.creation;

import by.training.task1.creation.CreateVehicle;
import by.training.task1.entity.Vehicle;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.Size;
import by.training.task1.uconst.VehicleType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author AlesyaHlushakova
 * test class.
 */
public class CreateVehicleTest {
    /**
     * vehicle creation test.
     * @throws InvalidDataException exception
     */
    @Test
    public void testCreateToy() throws InvalidDataException {
        String vehicle = "type=VEHICLE name=audi price=2500 "
                + "size=LARGE age=TEENAGER VEHICLE_TYPE=BUS";
        ToyParser toyParser = new ToyParser(vehicle);
        CreateVehicle creator = new CreateVehicle(toyParser);
        Vehicle expected = new Vehicle("AUDI", 2500,
                Size.LARGE, Age.TEENAGER, VehicleType.BUS);
        assertEquals(creator.createToy(), expected);
    }
}
