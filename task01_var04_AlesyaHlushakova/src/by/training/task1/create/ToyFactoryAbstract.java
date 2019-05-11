package by.training.task1.create;

import by.training.task1.entity.Toy;
import by.training.task1.exception.InvalidDataException;

public abstract class ToyFactoryAbstract {
    public abstract Toy createToy() throws InvalidDataException;
}
