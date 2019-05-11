package by.traning.task1.parse;

import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.util.*;
import by.traning.task1.valid.ToyValidator;

import java.util.Scanner;

public class ToyParser {
    private String source;

    public ToyParser(String source) { this.source = source.toUpperCase();}

    public TypeToy takeToyType() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.TYPE) + ToyTags.TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String toyTypeStr = scanner.next();
            if (ToyValidator.isValidToyType((toyTypeStr))) {
                return TypeToy.valueOf(toyTypeStr);
            } else {
                throw new InvalidDataException("Not valid toy type while parsing file");
            }
        } else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public String takeToyName() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.NAME) + ToyTags.NAME.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            return scanner.next();
        }else{
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public int takeToyPrice() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.PRICE) + ToyTags.PRICE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String priceStr = scanner.next();
            if (ToyValidator.isValidPrice(priceStr)) {
                return Integer.parseInt(priceStr);
            } else{
                throw new InvalidDataException("Not valid price while parsing file");
            }
        } else{
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public Age takeToyAge() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.AGE) + ToyTags.AGE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String ageStr = scanner.next();
            if(ToyValidator.isValidAge(ageStr)){
                return Age.valueOf(ageStr);
            }
            else{
                throw new InvalidDataException("Age restriction not valid while parsing file");
            }
        }else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public Size takeToySize() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.SIZE) + ToyTags.SIZE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String sizeStr = scanner.next();
            if(ToyValidator.isValidSize(sizeStr)){
                return Size.valueOf(sizeStr);
            }
            else{
                throw new InvalidDataException("Size not valid while parsing file");
            }
        }else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public BallType takeBallType() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.BALL_TYPE) + ToyTags.BALL_TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String ballType = scanner.next();
            if(ToyValidator.isValidBallType(ballType)){
                return BallType.valueOf(ballType);
            }
            else{
                throw new InvalidDataException("Ball type not valid while parsing file");
            }
        }else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public CubeType takeCubeType() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.CUBE_TYPE) + ToyTags.CUBE_TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String cubeType = scanner.next();
            if(ToyValidator.isValidCubeType(cubeType)){
                return CubeType.valueOf(cubeType);
            }
            else{
                throw new InvalidDataException("Cube type not valid while parsing file");
            }
        }else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public DollType takeDollType() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.DOLL_TYPE) + ToyTags.DOLL_TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String dollType = scanner.next();
            if(ToyValidator.isValidDollType(dollType)){
                return DollType.valueOf(dollType);
            }
            else{
                throw new InvalidDataException("Doll type not valid while parsing file");
            }
        }else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }

    public VehicleType takeVehicleType() throws InvalidDataException {
        if(ToyValidator.isValidToy(this.source)) {
            int index = source.indexOf(ToyTags.VEHICLE_TYPE) + ToyTags.VEHICLE_TYPE.length();
            Scanner scanner = new Scanner(source.substring(index));
            scanner.useDelimiter("=| ");
            String vehicleType = scanner.next();
            if(ToyValidator.isValidVehicleType(vehicleType)){
                return VehicleType.valueOf(vehicleType);
            }
            else{
                throw new InvalidDataException("Vehicle type not valid while parsing file");
            }
        }else {
            throw new InvalidDataException("Not valid toy while parsing file");
        }
    }
}
