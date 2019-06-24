package test.by.training.task4service.factory;


import by.training.task4.exception.MedicineException;
import by.training.task4.exception.MedicineNotFoundException;
import by.training.task4.service.factory.MedicineFactory;
import by.training.task4.service.parser.Elements;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedicineFactoryTest {

    private MedicineFactory factory;


    @Test(dataProvider = "medicins")
    public void getMedicineTest(Elements element)
            throws MedicineNotFoundException {
        String actual = factory.getMedicine(element).getClass().getSimpleName();
        String expected = element.getValue();
        Assert.assertEquals(actual, expected);
    }


    @DataProvider(name = "medicins")
    public Object[][] createMedicins() {
        return new Object[][] {
            new Object[] { Elements.ANTIBIOTIC },
            new Object[] { Elements.ANALGETIC },
            new Object[] { Elements.VITAMIN }
        };
    }

    @BeforeClass
    public void beforeClass() {
        factory = new MedicineFactory();
    }

    @AfterClass
    public void afterClass() {
        factory = null;
    }
}
