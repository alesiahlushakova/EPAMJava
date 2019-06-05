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
    private static final String CORRECT_FILE_PATH = "data//input.txt";
    /**
     * incorrect path.
     */
    private static final String INCORRECT_PATH = "incorrect";
    /**
     * file contents.
     */
    private static final String CORRECT_FILE_CONTENT = "It has survived"
            + " not only five centuries,"
            + " but also the leap into electronic typesetting, remaining "
            + "essentially unchanged. It"
            + " was popularised in the with the release of Letraset sheets"
            + " containing Lorem Ipsum passages,"
            + " and more recently with desktop publishing software like Aldus"
            + " PageMaker including versions of Lorem Ipsum.\n"
            + "It is a long established fact that a reader will be distracted"
            + " by the readable content of a page"
            + " when looking at its layout. The point of using Ipsum is that"
            + " it has a more-or-less normal distribution"
            + " of letters, as opposed to using 'Content here, content here', "
            + "making it look like readable English.\n"
            + "It is a established fact that a reader will be of a page when"
            + " looking at its layout.\n"
            + "Bye.";
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
    public void readTest1()
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
    public void readTest2()
            throws FileException {
        fileReader.read(INCORRECT_PATH);
    }

}
