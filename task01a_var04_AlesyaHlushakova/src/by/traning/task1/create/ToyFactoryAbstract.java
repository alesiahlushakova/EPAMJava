package by.traning.task1.create;

import by.traning.task1.entity.Toy;
import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.parse.ToyParser;

public abstract class ToyFactoryAbstract {
    public abstract Toy createToy() throws InvalidDataException;
}
