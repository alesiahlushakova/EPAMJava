package by.training.task1.reader;
import org.apache.logging.log4j.Level;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author AlesyaHlushakova
 * class gets strings from .txt file.
 */
public class ToyReader {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.getLogger(ToyReader.class);

    /**
     * method reads strings from file.
     * @param path source string
     * @return list of valid strings
     */
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
            throw new RuntimeException("File was not found");
        } finally {
            scanner.close();
        }
    }
}
