package by.traning.task1.test.entity;

import by.traning.task1.entity.Cube;
import by.traning.task1.entity.GameRoom;
import by.traning.task1.entity.Toy;
import by.traning.task1.util.Age;
import by.traning.task1.util.CubeType;
import by.traning.task1.util.Size;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class GameRoomTest {
    @Test
    public void setToys() throws Exception {
        Toy toy1 = new Cube("rubick", 19, Size.SMALL, Age.BABY, CubeType.CLASSIC);
        Toy toy2 = new Cube("myCube", 120, Size.MEDIUM, Age.CHILD, CubeType.CUBOID);
        LinkedList<Toy> toys1 = new LinkedList<>();
        toys1.add(toy1);
        toys1.add(toy2);
        LinkedList<Toy> toys2 = new LinkedList<>();
        toys2.add(toy2);
        toys2.add(toy1);

        LinkedList<Toy> expected = toys2;
        GameRoom gameRoom = new GameRoom(toys1);
        gameRoom.setToys(toys2);
        LinkedList<Toy> actual = gameRoom.getToys();
        Assert.assertEquals(expected, actual);
    }

}