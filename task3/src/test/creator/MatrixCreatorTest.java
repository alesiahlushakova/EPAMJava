package test.creator;

import by.training.task03.creator.MatrixCreator;
import by.training.task03.entity.Matrix;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MatrixCreatorTest {
    @Test
    void fillFromFileTest() {
        MatrixCreator creator = new MatrixCreator();
        creator.fillFromFile("data\\data.txt");
        Matrix a = Matrix.getInstance();
        Assert.assertTrue(false);
    }

}
