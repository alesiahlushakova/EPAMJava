package test.by.training.task02.reader;

import by.training.task02.exception.FileException;
import by.training.task02.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Alesyahlushakova
 * file reader tests.
 */
public class FileReaderTest {
    /**
     * file path.
     */
    private static final String CORRECT_FILE_PATH = "data//data.txt";
    /**
     * incorrect path.
     */
    private static final String INCORRECT_PATH = "incorrect";
    /**
     * file contents.
     */
    private static final String CORRECT_FILE_CONTENT = "Lorem ipsum dolor sit"
            + " amet, consectetur adipiscing elit.\n"
            + "Donec a sem faucibus risus fringilla consequat et at ante.\n"
            + "Sed ipsum lacus, faucibus at diam nec, finibus"
            + " tempor justo. Sed vulputate.";
    /**
     * file reader.
     */
    private final FileReader fileReader = new FileReader();

    /**
     * file reader test.
     * @throws FileException file exception
     */
    @Test(description = "should return separated"
            + " lines when correct file supplied")
    public void readShouldReturnSeparatedLinesWhenCorrectFileSupplied()
            throws FileException {
        String readResult = fileReader.read(CORRECT_FILE_PATH);
        Assert.assertEquals(readResult, CORRECT_FILE_CONTENT);
    }

    /**
     * file reader test.
     * @throws FileException fil exception
     */
    @Test(expectedExceptions = FileException.class,
    description = "should throw invalid file exception"
            + " when incorrect file supplied")
    public void readShouldThrowInvalidFileExceptionWhenIncorrectFileSupplied()
            throws FileException {
        fileReader.read(INCORRECT_PATH);
    }
}
