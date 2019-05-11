package by.traning.task1.valid;

import by.traning.task1.util.Age;
import by.traning.task1.util.BallType;
import by.traning.task1.util.CubeType;
import by.traning.task1.util.DollType;
import by.traning.task1.util.VehicleType;
import by.traning.task1.util.Size;
import by.traning.task1.util.ToyTags;
import by.traning.task1.util.TypeToy;

/**
 * @author Alesya Hlushakova
 * class to validate inputs.
 */
public class ToyValidator {
    public  static boolean isValidPrice(String toy) {
        toy = toy.toUpperCase();
        int price = Integer.parseInt(toy);
        if (price>0) {
            return true;
        }
        return false;
    }
    /**
     * method to detect if toy is valid.
     * @param toy validating toy
     * @return is toy valid
     */
    public static boolean isValidToy(String toy) {
        toy = toy.toUpperCase();
        return toy.contains(ToyTags.AGE) && toy.contains(ToyTags.NAME)
                && toy.contains(ToyTags.PRICE)
                && toy.contains(ToyTags.SIZE);
    }

    /**
     * method to detect if ball is valid.
     * @param toy validating toy
     * @return is toy valid
     */
    public static  boolean isValidBall(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.BALL_TYPE);
    }
    /**
     * method to detect if cube is valid.
     * @param toy validating toy
     * @return is toy valid
     */
    public static  boolean isValidCube(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.CUBE_TYPE);
    }
    /**
     * method to detect if doll is valid.
     * @param toy validating toy
     * @return is toy valid
     */
    public static  boolean isValidDoll(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.DOLL_TYPE);
    }
    /**
     * method to detect if vehicle is valid.
     * @param toy validating toy
     * @return is toy valid
     */
    public static  boolean isValidVehicle(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.VEHICLE_TYPE);
    }
    /**
     * method to detect if age is valid.
     * @return is toy valid
     * @param ageStr string with age restriction
     */
    public static boolean isValidAge(final String ageStr) {
        Age[] ages = Age.values();
        for (Age age : ages) {
            if (age.toString().equalsIgnoreCase(ageStr)) {
                return true;
            }
        }
        return false;
    }
    /**
     * method to detect if ball type is valid.
     * @param ballTypeStr ball type
     * @return is toy valid
     */
    public static boolean isValidBallType(final String ballTypeStr) {
        BallType[] ballTypes = BallType.values();
        for (BallType ballType : ballTypes) {
            if (ballType.toString().equalsIgnoreCase(ballTypeStr)) {
                return true;
            }
        }
        return false;
    }
    /**
     * method to detect if cube type is valid.
     * @return is toy valid
     * @param cubeTypeStr cube toy type
     */
    public static boolean isValidCubeType(final String cubeTypeStr) {
        CubeType[] cubeTypes = CubeType.values();
        for (CubeType cubeType : cubeTypes) {
            if (cubeType.toString().equalsIgnoreCase(cubeTypeStr)) {
                return true;
            }
        }
        return false;
    }
    /**
     * method to detect if doll type is valid.
     * @param  dollTypeStr doll type
     * @return is toy valid
     */
    public static boolean isValidDollType(final String dollTypeStr) {
        DollType[] dollTypes = DollType.values();
        for (DollType dollType : dollTypes) {
            if (dollType.toString().equalsIgnoreCase(dollTypeStr)) {
                return true;
            }
        }
        return false;
    }
    /**
     * method to detect if vehicle type is valid.
     * @param vehicleTypeStr validating vehicle type
     * @return is toy valid
     */
    public static boolean isValidVehicleType(final String vehicleTypeStr) {
        VehicleType[] vehicleTypes = VehicleType.values();
        for (VehicleType vehicleType : vehicleTypes) {
            if (vehicleType.toString().equalsIgnoreCase(vehicleTypeStr)) {
                return true;
            }
        }
        return false;
    }
    /**
     * method to detect if toy size is valid.
     * @param sizeStr validating size
     * @return is toy valid
     */
    public static boolean isValidSize(final String sizeStr) {
        Size[] sizes = Size.values();
        for (Size size : sizes) {
            if (size.toString().equalsIgnoreCase(sizeStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * method to detect if toy parameter is valid.
     * @param typToyStr toy type
     * @return is toy size valid
     */
    public static boolean isValidToyType(final String typToyStr) {
        TypeToy[] typeToys = TypeToy.values();
        for (TypeToy typeSweet : typeToys) {
            if (typeSweet.toString().equalsIgnoreCase(typToyStr)) {
                return true;
            }
        }
        return false;
    }

}
