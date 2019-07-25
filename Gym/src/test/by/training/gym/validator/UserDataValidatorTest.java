package test.by.training.gym.validator;

import by.training.gym.service.validator.UserValidator;


import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class UserDataValidatorTest {

    private static final UserValidator USER_DATA_VALIDATOR = new UserValidator();
    private static final String FULL_NAME = "Alex Smith";

    @DataProvider
    public static Object[][] notValidDataForNameForFullCheckOperation() {
        return new Object[][]{
                {""},
                {null},
                {"Alex "},
                {" Alex"},
                {" "},
                {"AlexSmith"},
                {"Alex-Smith"},
                {"Alex_Smith"},
                {"Alex Smith 22"},
                {"2Alex Smith"}
        };
    }

    @DataProvider
    public static Object[][] validUserData() {
        return new Object[][]{
                {"client1", "client1", "Alex", "Smith","375290987657"},
                {"client1", "client1", "Александр", "Смит", "375445678987"},
                {"111111Client", "client1", "Alex", "Smith", "375338765780"},
                {"client1", "111111Client", "Alex", "Smith", "375338765780"},
                {"client1", "5051", "Alex", "Smith", "375338765780"},
                {"client1", "client1", "Ai", "Smith", "375334765780"},
                {"client1", "client1", "Alex", "Che", "375338765780"},
                {"client1_lone", "client1", "Alex", "Che", "375338765780"},
                {"client1", "client1_client1", "Alex", "Che", "375338765780"},
                {"CLIENT", "client1", "Alex", "Che", "375338765780"},
                {"client1", "CLIENT", "Alex", "Che", "375338765780"},
        };
    }

    @DataProvider
    public static Object[][] notValidUserData() {
        return new Object[][]{
                {"!!!client1", "client1", "Alex", "Smith", ""},
                {"client1", "client1!1", "Александр", "Смит", "37533876"},
                {"111111Client", "client1", "", "Smith", "375338765780"},
                {"client1", "111111Client", "Alex", "", "375338765780"},
                {"client1", "5051", null, "Smith", "175338765780"},
                {"client1", "client1", "Ai", null, "375338765780"},
                {"client1", "", "Alex", "Che", "375338765780"},
                {"client@mail.ru", "cli", "Alex", "Che", "375338765780"},
                {"client1", "Alex", "Che", null, "375298756437"},
                {"CL", "client1", "Alex", "Che","4354"},
                {"C", "client1", "Alex", "Che","45656"},
                {"CLs", "client1", "Alex", "Che", "375338765780"},
                {"CLsd", "client1", "Alex", "Che", "375338765780"},
                {"CLass", "client1", "Alex", "Che", "375338765780"},
                {null, "CLIENT", "Alex", "Che", "375338765780"},
                {"client1", "client1", "Alex!", "Smith", "375338765780"},
                {"client1", "client1", "Александр", "Смит2", "375338765780"},
                {"111111#Client", "client1", "Alex", "Smith", "375338765780"},
                {"client1", "11111+=+1Client", "Alex", "Smith", "375338765780"},
                {"client1", "5051", "<span>", "Smith", "375338765780"},
                {"client1", "client1", "Ai", "<>@", "375338765780"},
                {"client,.1", "client1", "Alex", "Che", "375338765780"},
                {"@@", "client1", "Alex", "Che", "375338765780"},
                {"client1", "ad", "Alex", "Che", "375338765780"},
                {"CLIENT", "a", "Alex", "Che", "375338765780"},
                {"client1", "CLIENT", "Alex", "Вал2", "375338765780"}
        };
    }

    @Test
    public void shouldCheckNameForFullBeSuccessful() {
        boolean actualResult = USER_DATA_VALIDATOR.isNameFull(FULL_NAME);

        Assert.assertTrue(actualResult);
    }

    @Test
    ( dataProvider = "notValidDataForNameForFullCheckOperation")
    public void shouldCheckNameForFullFail(String name) {
        boolean actualResult = USER_DATA_VALIDATOR.isNameFull(name);

        Assert.assertFalse(actualResult);
    }

    @Test( dataProvider = "validUserData")
    public void shouldUserDataBeValid(String login, String password,
                                      String firstName, String lastName, String telephone) {
        boolean actualResult = USER_DATA_VALIDATOR.checkData(login, password,
                firstName, lastName, telephone);

        Assert.assertTrue(actualResult);
    }

    @Test (dataProvider ="notValidUserData")
    public void shouldUserDataBeNotValid(String login, String password, String firstName,
                                         String lastName, String telephone) {
        boolean actualResult = USER_DATA_VALIDATOR.checkData(login, password,
                firstName, lastName, telephone);

        Assert.assertFalse(actualResult);
    }
}
