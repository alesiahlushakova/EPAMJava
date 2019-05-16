package by.training.task1.creation;

import by.training.task1.entity.Toy;
import by.training.task1.exception.InvalidDataException;

/**
 * @author AlesyaHlushakova
 * abstract class for toy factory.
 */
public abstract class ToyFactoryAbstract {
    /**
     * method creates toy.
     * @return new toy
     * @throws InvalidDataException invalid args
     */
    public abstract Toy createToy() throws InvalidDataException;
}
