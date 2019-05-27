package by.training.task02.reader;

import by.training.task02.exception.FileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * @author AlesyaHlushakova
 * file reader.
 */
public class FileReader {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    /**
     * line delimiter.
     */
    private static final String LINE_DELIMITER = "\n";

    /**
     * method reads from file.
     * @param source source string
     * @return string
     * @throws FileException exception while working with file
     */
    public String read(final String source) throws FileException {
        Path path = Paths.get(source);
        StringJoiner stringJoiner = new StringJoiner(LINE_DELIMITER);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(stringJoiner::add);
        } catch (IOException e) {
            LOGGER.warn("Error while reading from file");
            throw new FileException("Error while reading from file" + e);

        }
        return stringJoiner.toString();
    }
}
