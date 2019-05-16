package by.training.task1.entity;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.Size;
import by.training.task1.uconst.VehicleType;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * class for vehicle toy.
 * @author AlesyaHlushakova
 */
public class Vehicle extends Toy {
    /**
     * logger introduction to class.
     */
    public static final Logger LOG =
            LogManager.getLogger(Vehicle.class.getName());
    /**
     * defines type of vehicle.
     */
    private VehicleType vehicleType;

    /**
     * constructor fot vehicle toy.
     * constructor for vehicles
     * @param name toy name
     * @param price toy price
     * @param size toy size
     * @param age toy age
     * @param type toy type
     */
    public Vehicle(final String name, final int price,
                   final Size size, final Age age, final VehicleType type) {
        super(name, price, size, age);
        this.vehicleType = type;
        LOG.info("Vehicle created: " + this.toString());
    }
    /**
     * method to get  vehicle toy type.
     * @return type of vehicle toy
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * method to set vehicle toy type.
     * @param type vehicle type
     */
    public void setVehicleType(final VehicleType type) {
        this.vehicleType = type;
    }

    /**
     * adds vehicle type to toString() of superclass.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "; Vehicle type: " + vehicleType;
    }

    /**
     * method overrides equals.
     * @param o comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return vehicleType == vehicle.vehicleType;
    }

    /**
     * method overrides hash code.
     * @return hash cide
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vehicleType);
    }
}
