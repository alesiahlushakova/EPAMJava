package entities;

import entities.enums.Age;
import entities.enums.Size;
import entities.enums.VehicleType;

/**
 * @author AlesyaHlushakova
 */
public class Vehicle extends Toy {
    private VehicleType vehicleType;

    /**
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
    }
    /**
     *
     * @return
     */
    public VehicleType getDollType() {
        return vehicleType;
    }

    /**
     * @param type
     */
    public void setDollType(VehicleType type) {
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
}
