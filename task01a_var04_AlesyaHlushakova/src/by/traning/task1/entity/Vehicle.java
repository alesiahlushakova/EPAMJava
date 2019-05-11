package by.traning.task1.entity;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import by.traning.task1.util.Age;
import by.traning.task1.util.Size;
import by.traning.task1.util.VehicleType;

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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Vehicle vehicle = (Vehicle) object;
        return java.util.Objects.equals(vehicleType, vehicle.vehicleType);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), vehicleType);
    }
}
