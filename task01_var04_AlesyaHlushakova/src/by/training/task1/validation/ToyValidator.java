package by.training.task1.validation;

import by.training.task1.uconst.Age;
import by.training.task1.uconst.BallType;
import by.training.task1.uconst.CubeType;
import by.training.task1.uconst.DollType;
import by.training.task1.uconst.VehicleType;
import by.training.task1.uconst.Size;
import by.training.task1.uconst.ToyTags;
import by.training.task1.uconst.TypeToy;

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
     * method to detect if toy is validation.
     * @param toy validating toy
     * @return is toy validation
     */
    public static boolean isValidToy(String toy) {
        toy = toy.toUpperCase();
        return toy.contains(ToyTags.AGE) && toy.contains(ToyTags.NAME)
                && toy.contains(ToyTags.PRICE)
                && toy.contains(ToyTags.SIZE);
    }

    /**
     * method to detect if ball is validation.
     * @param toy validating toy
     * @return is toy validation
     */
    public static  boolean isValidBall(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.BALL_TYPE);
    }
    /**
     * method to detect if cube is validation.
     * @param toy validating toy
     * @return is toy validation
     */
    public static  boolean isValidCube(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.CUBE_TYPE);
    }
    /**
     * method to detect if doll is validation.
     * @param toy validating toy
     * @return is toy validation
     */
    public static  boolean isValidDoll(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.DOLL_TYPE);
    }
    /**
     * method to detect if vehicle is validation.
     * @param toy validating toy
     * @return is toy validation
     */
    public static  boolean isValidVehicle(String toy) {
        toy = toy.toUpperCase();
        return isValidToy(toy) && toy.contains(ToyTags.VEHICLE_TYPE);
    }
    /**
     * method to detect if age is validation.
     * @return is toy validation
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
     * method to detect if ball type is validation.
     * @param ballTypeStr ball type
     * @return is toy validation
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
     * method to detect if cube type is validation.
     * @return is toy validation
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
     * method to detect if doll type is validation.
     * @param  dollTypeStr doll type
     * @return is toy validation
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
     * method to detect if vehicle type is validation.
     * @param vehicleTypeStr validating vehicle type
     * @return is toy validation
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
     * method to detect if toy size is validation.
     * @param sizeStr validating size
     * @return is toy validation
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
     * method to detect if toy parameter is validation.
     * @param typToyStr toy type
     * @return is toy size validation
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
