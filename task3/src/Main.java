import by.training.task03.creator.MatrixCreator;
import by.training.task03.entity.Matrix;

public class Main {

    public static void main(String[] args) {
        MatrixCreator creator = new MatrixCreator();
        creator.fillFromFile("data\\data.txt");
        Matrix a = Matrix.getInstance();
    }
}
