package by.training.task03.service.reader;

import by.training.task03.exception.MatrixException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * @author AlesyaHlushakova
 * class reads numbers that fill each thread.
 */
public class ThreadReader {

    /**
     * line delimiter.
     */
    private static final String LINE_DELIMITER = "\n";

    /**
     * method reads from file.
     * @param source source string
     * @return string
     * @throws MatrixException exception while working with file
     */
    public String read(final String source) throws MatrixException {
        Path path = Paths.get(source);
        StringJoiner stringJoiner = new StringJoiner(LINE_DELIMITER);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(stringJoiner::add);
        } catch (IOException | InputMismatchException e) {

            throw new MatrixException("Error while reading from file" + e);

        }
        return stringJoiner.toString();
    }

}
