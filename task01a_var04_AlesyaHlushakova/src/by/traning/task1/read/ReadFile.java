package by.traning.task1.read;



import by.traning.task1.entity.Toy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFile {

   // private final static Logger logger = Logger.getLogger(ReadFile.class);

    public List<Toy> read(String path) {
        List<Toy> toyList = null;
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            toyList = (List<Toy>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
           // logger.error(e);
        }
        return toyList;
    }
}
