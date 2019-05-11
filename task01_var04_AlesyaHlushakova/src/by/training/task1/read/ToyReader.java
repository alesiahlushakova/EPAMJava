package by.training.task1.read;
import org.apache.logging.log4j.Level;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ToyReader {
    private static final Logger LOGGER = LogManager.getLogger(ToyReader.class);

    public LinkedList<String> read(String path){
        File file = new File(path);
        LinkedList<String> strings = new LinkedList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                strings.add(scanner.nextLine());
            }
            return strings;
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException("File did not find");
        }finally {
            scanner.close();
        }
    }
}
