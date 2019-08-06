package test.by.training.gym.service;

import by.training.gym.domain.Exercise;
import by.training.gym.domain.ExerciseLevel;
import by.training.gym.domain.Program;
import by.training.gym.service.ProgramService;
import by.training.gym.service.ServiceException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.*;

import static org.testng.Assert.*;

public class ProgramServiceTest {

    ProgramService programService = new ProgramService();
    Program program1 = new Program();
    Program program2 = new Program();
    Program program3 = new Program();
    Program program4 = new Program();
    Program program5 = new Program();
    @BeforeClass
    public void setUp() {
        program1.setDiet("diet");
        program1.setClientId(1);
        program1.setCoachId(4);
        program1.setStartDate(Date.valueOf("2019-08-01"));
        program1.setEndDate(Date.valueOf("2019-08-06"));

        program2.setDiet("greek diet");
        program2.setClientId(3);
        program2.setCoachId(4);
        program2.setStartDate(Date.valueOf("2019-08-01"));
        program2.setEndDate(Date.valueOf("2019-09-01"));

        program3.setDiet("avoid unhealthy food");
        program3.setClientId(5);
        program3.setCoachId(3);
        program3.setStartDate(Date.valueOf("2019-08-01"));
        program3.setEndDate(Date.valueOf("2019-08-06"));

        program4.setDiet("get rid of smoking");
        program4.setClientId(2);
        program4.setCoachId(4);
        program4.setStartDate(Date.valueOf("2019-08-01"));
        program4.setEndDate(Date.valueOf("2019-08-06"));

        program5.setDiet("Be sure to eat before exercise " +
                "(2 hours before it starts). Protein dishes" +
                " and foods containing slow carbohydrates are" +
                " well suited for this: cereals, flour, vegetables, " +
                "etc. Carbohydrates before exercise are needed in order " +
                "to load glycogen depots and provide muscles and brain with " +
                "energy during training. Amino acids allow you to run anabolism. " +
                " R  n  r  nFood after exercise. The greatest need for nutrients" +
                " is observed soon after training. It is best to use a carbohydrate" +
                "-protein shake (gainer) immediately after the end of the training, " +
                "then a heavy meal should follow no later than 1-1.5 hours after " +
                "training. [3] Include foods rich in proteins and slow carbohydrates," +
                " you can eat even a small amount of fast carbohydrates (sweet). " +
                "After the training, the so-called protein-carbohydrate window opens," +
                " during this time the body is positioned to assimilate a large amount " +
                "of food, while the nutrients are used to restore muscles and replenish " +
                "energy.");
        program5.setClientId(3);
        program5.setCoachId(6);
        program5.setStartDate(Date.valueOf("2019-06-02"));
        program5.setEndDate(Date.valueOf("2019-07-30"));
        program5.setId(2);
    }

    @DataProvider(name = "createProgramProvider")
    public Object[][] dataProviderCreateProgram() {
        return new Object[][]{
                {1, "4", "diet", "2019-08-01", "2019-08-06", program1},
                {3, "4", "greek diet", "2019-08-01", "2019-09-01", program2},
                {5, "3", "avoid unhealthy food", "2019-08-01", "2019-08-06", program3},
                {2, "4", "get rid of smoking", "2019-08-01", "2019-08-06", program4},
        };
    }

    @DataProvider(name = "findTrainingProgramByIdProvider")
    public Object[][] dataProviderFindTrainingProgramById() {
        return new Object[][]{
                {3, program5},
                {9, null},
        };
    }

    @DataProvider(name = "findTrainingProgramAuthorProvider")
    public Object[][] dataProviderFindTrainingProgramAuthor() {
        return new Object[][]{
                {1, "Duben Polina"},
                {2, "sazonov yauhen"},
                {3, "popovich sasha"},
                {10, ""}
        };
    }

    @Test(dataProvider = "createProgramProvider")
    public void testCreateProgram(final int authorIdValue, final String clientIdValue,
                                  final String diet, final String startDateValue,
                                  final String endDateValue, final Program expected)
            throws ServiceException {
        Program actual = programService.createProgram(authorIdValue, clientIdValue, diet,
                startDateValue, endDateValue);
        Assert.assertEquals(actual, expected);
    }



    @Test(dataProvider = "findTrainingProgramByIdProvider")
    public void testFindTrainingProgramById(final int clientId,
                                            final Program expected)
    throws ServiceException{
        Program actual = programService.findTrainingProgramById(clientId);

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "findTrainingProgramAuthorProvider")
    public void testFindTrainingProgramAuthor(final int programId,
                                              final String expected)
            throws ServiceException{
        String actual = programService.findTrainingProgramAuthor(programId);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testShowExercisesFromProgram()
            throws ServiceException{
        Map<Integer,List<Exercise>> expected = new HashMap<>();
        Exercise exercise = new Exercise();
        exercise.setName("pressups");
        exercise.setLevel(ExerciseLevel.STARTER);
        exercise.setDescription("Press ups wil improve your stomach muscles");
        exercise.setSets(5);
        exercise.setRepeats(50);
        exercise.setDays(7);
        exercise.setId(1);
        expected.put(1, new ArrayList<>());
        expected.put(7, Arrays.asList(exercise));
        Map<Integer, List<Exercise>> actual = programService.showExercisesFromProgram(1);
        boolean e = actual.equals(expected);
        Assert.assertEquals(actual, expected);
    }

}