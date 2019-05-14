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
    public static final Logger LOG=
            LogManager.getLogger(Vehicle.class.getName());
    /**
     * defines type of vehicle.
     */
    private VehicleType vehicleType;

    /**
     * constructor fot vehicle toy.
     * constructor for vehicles
     * @param name
     * @param price
     * @param size
     * @param age
     * @param type
     */
    public Vehicle(String name, int price, Size size, Age age, VehicleType type){
        super(name, price, size, age);
        this.vehicleType = type;
        LOG.info("Vehicle created: "+this.toString());
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
    public void setVehicleType(VehicleType type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        if (!super.equals(o)) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleType == vehicle.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vehicleType);
    }
}
