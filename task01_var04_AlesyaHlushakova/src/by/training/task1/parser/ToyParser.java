package by.training.task1.parser;

import by.training.task1.exception.InvalidDataException;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.Size;
import by.training.task1.uconst.CubeType;
import by.training.task1.uconst.BallType;
import by.training.task1.uconst.DollType;
import by.training.task1.uconst.ToyTags;
import by.training.task1.uconst.VehicleType;
import by.training.task1.uconst.TypeToy;
import by.training.task1.validation.ToyValidator;

import java.util.Scanner;

/**
 * @author AlesyaHLushakova
 * class parses data from .txt files.
 */
public class ToyParser {
    /**
     * source string.
     */
    private String source;

    /**
     * constructor for parser.
     * @param source source string
     */
    public ToyParser(final String source) {
        this.source = source.toUpperCase();
    }

    /**
     * method takes toy type.
     * @return type of toy
     * @throws InvalidDataException incorrect input data
     */
    public TypeToy takeToyType() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.TYPE)
                    + ToyTags.TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String toyTypeStr = scanner.next();
            if (ToyValidator.isValidToyType((toyTypeStr))) {
                return TypeToy.valueOf(toyTypeStr);
            } else {
                throw new InvalidDataException(
                        "Not valid toy type while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    /**
     * method takes toy name.
     * @return name of toy
     * @throws InvalidDataException incorrect input data
     */
    public String takeToyName() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.NAME) + ToyTags.NAME.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            return scanner.next();
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    /**
     * method takes toy price.
     * @return price of toy
     * @throws InvalidDataException incorrect input data
     */
    public int takeToyPrice() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.PRICE) + ToyTags.PRICE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String priceStr = scanner.next();
            if (ToyValidator.isValidPrice(priceStr)) {
                return Integer.parseInt(priceStr);
            } else {
                throw new InvalidDataException(
                        "Not valid price while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    /**
     * method takes toy Age.
     * @return age of toy
     * @throws InvalidDataException incorrect input data
     */
    public Age takeToyAge() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.AGE) + ToyTags.AGE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String ageStr = scanner.next();
            if (ToyValidator.isValidAge(ageStr)) {
                return Age.valueOf(ageStr);
            } else {
                throw new InvalidDataException(
                        "Age restriction not validation while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }
    /**
     * method takes toy size.
     * @return size of toy
     * @throws InvalidDataException incorrect input data
     */
    public Size takeToySize() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.SIZE) + ToyTags.SIZE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String sizeStr = scanner.next();
            if (ToyValidator.isValidSize(sizeStr)) {
                return Size.valueOf(sizeStr);
            } else {
                throw new InvalidDataException(
                        "Size not valid while parsing file");
            }
        } else {
            throw new InvalidDataException(
                    "Not valid toy while parsing file");
        }
    }
    /**
     * method takes ball type.
     * @return type of ball
     * @throws InvalidDataException incorrect input data
     */
    public BallType takeBallType() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.BALL_TYPE)
                    + ToyTags.BALL_TYPE.length();
            Scanner scanner =
                    new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String ballType = scanner.next();
            if (ToyValidator.isValidBallType(ballType)) {
                return BallType.valueOf(ballType);
            } else {
                throw new InvalidDataException(
                        "Ball type not valid while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }
    /**
     * method takes cube type.
     * @return type of cube
     * @throws InvalidDataException incorrect input data
     */
    public CubeType takeCubeType() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.CUBE_TYPE)
                    + ToyTags.CUBE_TYPE.length();
            Scanner scanner =
                    new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String cubeType = scanner.next();
            if (ToyValidator.isValidCubeType(cubeType)) {
                return CubeType.valueOf(cubeType);
            } else {
                throw new InvalidDataException(
                        "Cube type not valid while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }
    /**
     * method takes doll type.
     * @return type of doll
     * @throws InvalidDataException incorrect input data
     */
    public DollType takeDollType()
            throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.DOLL_TYPE)
                    + ToyTags.DOLL_TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String dollType = scanner.next();
            if (ToyValidator.isValidDollType(dollType)) {
                return DollType.valueOf(dollType);
            } else {
                throw new InvalidDataException(
                        "Doll type not valid while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }
    /**
     * method takes vehicle type.
     * @return type of vehicle
     * @throws InvalidDataException incorrect input data
     */
    public VehicleType takeVehicleType() throws InvalidDataException {
        if (ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.VEHICLE_TYPE)
                    + ToyTags.VEHICLE_TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String vehicleType = scanner.next();
            if (ToyValidator.isValidVehicleType(vehicleType)) {
                return VehicleType.valueOf(vehicleType);
            } else {
                throw new InvalidDataException(
                        "Vehicle type not valid while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }
}
