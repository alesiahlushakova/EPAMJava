package by.traning.task1;

import by.traning.task1.action.GameRoomMaker;
import by.traning.task1.action.ToyFinder;
import by.traning.task1.entity.Ball;
import by.traning.task1.entity.GameRoom;
import by.traning.task1.entity.Toy;
import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.exception.NonValidValueException;
import by.traning.task1.exception.StorageException;
import by.traning.task1.parse.ToyParser;
import by.traning.task1.read.ToyReader;
import by.traning.task1.runner.ToyStorageInitializer;
import by.traning.task1.store.ToyStorage;
import by.traning.task1.util.Age;
import by.traning.task1.util.BallType;
import by.traning.task1.util.Size;
import by.traning.task1.valid.ToyValidator;

import java.util.LinkedList;

public class Main {
    public static void main(final String[] args)  throws InvalidDataException, NonValidValueException, StorageException {
       Ball ball= new Ball( "sanya", 300, Size.LARGE, Age.BABY, BallType.PINGPONG);
        Ball ball1= new Ball( "lesya", 100, Size.LARGE, Age.BABY, BallType.PINGPONG);
        LinkedList<Toy> toys = new LinkedList<>();
        toys.add(ball);
        toys.add(ball1);

        LinkedList<Toy> toys1 = new LinkedList<>();
        toys.add(ball1);
        toys.add(ball);
        GameRoom gameRoom = new GameRoom(toys);
/*
        LinkedList<String> strings = new LinkedList<>();
        strings.add("type=BALL name=alenka price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS");
        ToyStorageInitializer tsi= new ToyStorageInitializer();
        ToyStorage storage = tsi.runner(strings);*/

       String testSrt = "type=BALL name=alenka price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS";
        System.out.println(ToyValidator.isValidToy(testSrt));
        System.out.println(ToyValidator.isValidDollType("BARBIE"));

        ToyReader readFromFile = new ToyReader();
        System.out.println(readFromFile.read("data\\toys.txt"));

        ToyParser toyParser = new ToyParser(testSrt);
       System.out.println(toyParser.takeToyName());

        ToyReader toyReader = new ToyReader();
        ToyStorageInitializer toyStorageInitializer = new ToyStorageInitializer();

       ToyStorage toyStorage=toyStorageInitializer.init(toyReader.read("data\\toys1.txt"));
        int expected = 170;
        int actual = new ToyFinder().findByPrice(new GameRoomMaker().makeGameRoom(400),100,200).getFirst().getPrice();
    }
}
