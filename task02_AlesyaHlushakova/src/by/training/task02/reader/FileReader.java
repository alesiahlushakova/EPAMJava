package by.training.task02.reader;

import by.training.task02.exception.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class FileReader {
    private static final String LINE_DELIMITER = "\n";

    public String read(String source) throws FileException {
        Path path = Paths.get(source);
        StringJoiner stringJoiner = new StringJoiner(LINE_DELIMITER);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(stringJoiner::add);
        } catch (IOException e) {
            throw new FileException("Error while reading from file"+e);
        }
        return stringJoiner.toString();
    }
}
