package by.traning.task1.create;

import by.traning.task1.entity.*;
import by.traning.task1.util.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author AlesyaHlushakova
 * by.traning.task1.factory for autogeneration of random toys
 */
public class Toyfactory {
    private static Random numberGenerator = new Random();

    /**
     * @param toyCount
     * @return toys
     */
    public static ArrayList<Toy> create(int toyCount) {
        ArrayList<Toy> toys = new ArrayList<Toy>();
        for (int i = 0; i < toyCount; i++) {
            toys.add(releaseToy());
        }
        return toys;
    }

    /**
     * generates random toy.
     * @return toy
     */
    public static Toy releaseToy(){
        int randomPrice = numberGenerator.nextInt(40000) + 1;
        switch (numberGenerator.nextInt(3)){
            case 0:
                return new Ball("ball", randomPrice, randomElement(Size.values()), randomElement(Age.values()), randomElement(BallType.values()));
            case 1:
                return new Vehicle("vehicle", randomPrice, randomElement(Size.values()), randomElement(Age.values()), randomElement(VehicleType.values()));
            case 2:
                return new Doll("doll", randomPrice,  randomElement(Size.values()), randomElement(Age.values()), randomElement(DollType.values()) );
            case 3:
                return new Cube("cube", randomPrice,  randomElement(Size.values()), randomElement(Age.values()), randomElement(CubeType.values()) );
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * @param elements
     * @param <T>
     * @return random value of certain enum
     */
    public static <T> T randomElement(T[] elements) {
        return elements[numberGenerator.nextInt(elements.length)];
    }
}
