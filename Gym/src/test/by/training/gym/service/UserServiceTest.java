package test.by.training.gym.service;

import by.training.gym.domain.User;
import by.training.gym.domain.UserRole;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class UserServiceTest {
    UserService userService;
    ArrayList<User> emptyList = new ArrayList<>();
    Map<Integer, String> expectedMap;
    User user1;
    User user2;
    User user3;
    User user4;
    @BeforeMethod
    public void setUp() {
        userService = new UserService();
        user1 = new User();
        user1.setFirstName("Duben");
        user1.setLastName("Polina");
        user1.setLogin("pomazafa");
        user1.setPassword("2178a4d04eeeb4f32142812d2bb1fcb6cd556ac7");
        user1.setTelephone("375336340558");
        user1.setUserRole(UserRole.ADMIN);
        user1.setId(1);

        user2 = new User();
        user2.setFirstName("Glushakova");
        user2.setLastName("Alesya");
        user2.setLogin("lesya");
        user2.setPassword("1f9e03a7e14322e674bf511268660dd1469eb573");
        user2.setTelephone("375440498762");
        user2.setUserRole(UserRole.COACH);
        user2.setId(2);

        user3 = new User();
        user3.setFirstName("Alex");
        user3.setLastName("Goncharov");
        user3.setLogin("mmf2018");
        user3.setPassword("49049515566fa38e1b8e268723a3730dcf527f36");
        user3.setTelephone("375443765489");
        user3.setUserRole(UserRole.CLIENT);
        user3.setId(3);

        user4 = new User();
        user4.setFirstName("alesia");
        user4.setLastName("hlushakova");
        user4.setLogin("alesya");
        user4.setPassword("09ccbd0ba216106cc143c32fa7d9db6a8e6ef42d");
        user4.setTelephone("375336340558");
        user4.setUserRole(UserRole.CLIENT);
        user4.setId(4);

        expectedMap = new HashMap<>();
        expectedMap.put(3, "Alex Goncharov");
        expectedMap.put(4, "alesia hlushakova");
        expectedMap.put(5, "Andrew Dokurno");
    }

    @DataProvider(name = "loginTest")
    public Object[][] dataProviderTestLogin() {
        return new Object[][]{{user1.getLogin(), "Admin007", user1},
                {user2.getLogin(), "Coach1999", user2},
                {user3.getLogin(), "A123", user3},
                {user4.getLogin(), "A1234", user4}
              };
    }

    @DataProvider(name = "loginUniqueness")
    public Object[][] dataProviderCheckUserLoginForUniqueness() {
        return new Object[][]{{"pomazafa"},
                {"lesya"},
                {"mmf2018"},
                {"alesya"}};
    }

    @DataProvider(name = "findClientsByNameProvider")
    public Object[][] dataProviderFindClientsByName() {
        return new Object[][]{{"Alesya", Arrays.asList(user2)},
                {"Polina", Arrays.asList(user1)},
                {"alesia hlushakova", Arrays.asList(user4)},
                {"esya", emptyList}};
    }

    @DataProvider(name = "findPersonalClientsProvider")
    public Object[][] dataProviderFindPersonalClients() {
        return new Object[][]{{2, emptyList},

                {7, emptyList}};
    }

    @Test(dataProvider = "loginTest")
    public void testLogin(final String login, final String password,
                          final User expected) throws ServiceException {
       Assert.assertEquals(userService.login(login, password), expected);

    }


    @Test(dataProvider = "loginUniqueness")
    public void testCheckUserLoginForUniqueness(final String login)
            throws ServiceException {
       Assert.assertTrue(userService.checkUserLoginForUniqueness(login));
    }

    @Test(dataProvider = "findClientsByNameProvider")
    public void testFindClientByName(final String name, final List<User> expected)
    throws ServiceException{
        List<User> actual = userService.findClientByName(name);
        Assert.assertEquals(actual, expected);
    }



    @Test(dataProvider = "findPersonalClientsProvider")
    public void testFindPersonalClients(final int coachId,
                                        final List<User> expected)
            throws ServiceException {
       List<User> actual = userService.findPersonalClients(coachId);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindClientsForProgramCreation()
    throws ServiceException{
       Map<Integer, String> actual = userService.findClientsForProgramCreation();
       Assert.assertEquals(actual, expectedMap);
    }
}