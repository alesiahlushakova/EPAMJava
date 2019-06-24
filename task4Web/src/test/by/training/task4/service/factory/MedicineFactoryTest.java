package test.by.training.task4.service.factory;

import by.training.task4.exception.MedicineNotPresentedException;
import by.training.task4.service.factory.MedicineFactory;
import by.training.task4.service.parser.constants.ElementsEnum;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedicineFactoryTest {
    private MedicineFactory factory;

    @Test(expectedExceptions = MedicineNotPresentedException.class,
            dataProvider = "elements")
    public void getMedicineExceptionTest(ElementsEnum element)
            throws MedicineNotPresentedException {
        factory.getMedicine(element);
    }

    @Test(dataProvider = "medicines")
    public void getMedicineTest(ElementsEnum element)
            throws MedicineNotPresentedException {
        String actual = factory.getMedicine(element).getClass().getSimpleName();
        String expected = element.getValue();
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "elements")
    public Object[][] createElements() {
        return new Object[][] {
                new Object[] { ElementsEnum.MEDICINES },
                new Object[] { ElementsEnum.PHARM },
                new Object[] { ElementsEnum.VERSION },
                new Object[] { ElementsEnum.PRODUCER },
                new Object[] { ElementsEnum.FORM },
                new Object[] { ElementsEnum.CERTIFICATE },
                new Object[] { ElementsEnum.REGISTRED_BY },
                new Object[] { ElementsEnum.REGISTRATION_DATE },
                new Object[] { ElementsEnum.EXPIRATION_DATE },
                new Object[] { ElementsEnum.PACKAGE },
                new Object[] { ElementsEnum.QUANTITY },
                new Object[] { ElementsEnum.PRICE },
                new Object[] { ElementsEnum.DOSAGE },
                new Object[] { ElementsEnum.AMOUNT },
                new Object[] { ElementsEnum.FREQUENCY }
        };
    }

    @DataProvider(name = "medicines")
    public Object[][] createMedicines() {
        return new Object[][] {
                new Object[] { ElementsEnum.ANTIBIOTIC },
                new Object[] { ElementsEnum.ANALGETIC },
                new Object[] { ElementsEnum.VITAMIN }
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
