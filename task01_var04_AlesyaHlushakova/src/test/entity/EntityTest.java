package test.entity;

import by.training.task1.entity.Cube;
import by.training.task1.entity.Toy;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.CubeType;
import by.training.task1.uconst.Size;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author AlesyaHlushakova
 * test class.
 */
public class EntityTest {
    /**
     * toys.
     */
    private Toy toy1, toy2;

    /**
     * tests before class.
     */
    @BeforeClass
            public void setBefore() {
        toy1 = new Cube("rubick", 19, Size.SMALL, Age.BABY, CubeType.CLASSIC);
        toy2 = new Cube("rubick", 19, Size.SMALL, Age.BABY, CubeType.CLASSIC);
    }

    /**
     * equals test.
     */
    @Test
    public void equals() {
        Assert.assertEquals(toy1, toy2);
    }
}
