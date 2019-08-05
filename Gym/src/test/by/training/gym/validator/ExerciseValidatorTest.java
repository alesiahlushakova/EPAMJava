package test.by.training.gym.validator;

import by.training.gym.domain.Exercise;
import by.training.gym.service.validator.ExerciseValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;




public class ExerciseValidatorTest {

    private static final ExerciseValidator EXERCISE_DATA_VALIDATOR = new ExerciseValidator();

    private static final int VALID_EXERCISES_COUNT = 13;
    private static final int NOT_VALID_EXERCISES_COUNT = 15;
    private static final int VALID_SETS_COUNT = 4;
    private static final int VALID_REPEATS_COUNT = 10;
    private static final int VALID_WEIGHT_LOSS = 2;

    private static List<Exercise> exercisesForTest;

    @BeforeClass
    public static void setExercisesForTest() {
        exercisesForTest = new ArrayList<>();

        Exercise exercise = new Exercise();
        exercise.setId(1);
        exercisesForTest.add(exercise);

        Exercise exerciseSecond = new Exercise();
        exerciseSecond.setId(2);
        exercisesForTest.add(exerciseSecond);

        Exercise exerciseThird = new Exercise();
        exerciseThird.setId(3);
        exercisesForTest.add(exerciseThird);
    }

    @DataProvider
    public static Object[][] validExerciseValues() {
        return new Object[][]{
                {"Приседания.","Болезни суствавов", 200, "CASUAL", "Приседания. Сесть и встать."},
                {"Гак-приседания.","Болезни почек", 20, "CASUAL", "Приседания. Сесть и встать."},
                {"Dead lift.","Болезни кишечного тракта", 100, "EXPERT", "No description."},
                {"Explosive jumps.","Болезни Мочевого пузыря", 200, "STARTER", "No description."}
        };
    }

    @DataProvider
    public static Object[][] notValidExerciseValues() {
        return new Object[][]{
                {"Приседания.!","Болезни суствавов", 200, "PRO", "Приседания. Сесть и встать."},
                {"Dead lift.","Болезни суствавов", -10, "MASTER", "No description."},
                {"Гак-приседания.","", 200, null, "Приседания. Сесть и встать."},

                {"Explosive jumps.", "Болезни суствавов", 200, "STARTER", "<alert(bug)>"}
        };
    }

    @DataProvider
    public static Object[][] notValidDataForAddOperation() {
        return new Object[][]{
                {NOT_VALID_EXERCISES_COUNT,0, 5, 5},
                {13, 2, 0, 2},
                {10, 1, 2, 0}
        };
    }

    @DataProvider
    public static Object[][] validDataForCheckForUniqueOperation() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }

    @DataProvider
    public static Object[][] notValidDataForEditOperation() {
        return new Object[][]{
                {1,0, 1},
                {0, 1, 0},
                {1, -2, 30},
                {0, 10, -2}
        };
    }

    @Test
    (dataProvider = "validExerciseValues")
    public void shouldExerciseDataBeValid(String name, String restrictions,int caloriesLost, String levelValue, String description) {
        boolean actualResult = EXERCISE_DATA_VALIDATOR.checkData(name, restrictions, caloriesLost, levelValue, description);
        Assert.assertTrue(actualResult);
    }

    @Test
    (dataProvider = "notValidExerciseValues")
    public void shouldExerciseDataBeNotValid(String name, String restrictions,int caloriesLost, String levelValue, String description) {
        boolean actualResult = EXERCISE_DATA_VALIDATOR.checkData(name, restrictions, caloriesLost, levelValue, description);
        Assert.assertFalse(actualResult);
    }



    @Test
    (dataProvider = "validDataForCheckForUniqueOperation")
    public void shouldCheckExerciseForUniqueFail(int exerciseId) {
        boolean actualResult = EXERCISE_DATA_VALIDATOR.checkExerciseForUniqueInTrainingProgram(exerciseId, exercisesForTest);

        Assert.assertFalse(actualResult);
    }

    @Test
    public void shouldCheckExerciseForUniqueBeSuccessful() {
        int exerciseIdUnique = 4;
        boolean actualResult = EXERCISE_DATA_VALIDATOR.checkExerciseForUniqueInTrainingProgram(exerciseIdUnique, exercisesForTest);

        Assert.assertTrue(actualResult);
    }

    @Test
    public void shouldEditOperationBeSuccessful() {
        boolean actualResult = EXERCISE_DATA_VALIDATOR.checkExerciseDuringEditOperation(VALID_WEIGHT_LOSS, VALID_SETS_COUNT, VALID_REPEATS_COUNT);

        Assert.assertTrue(actualResult);
    }

    @Test
    (dataProvider = "notValidDataForEditOperation")
    public void shouldEditOperationFail(int weightLoss, int setsCount, int repeatsCount) {
        boolean actualResult = EXERCISE_DATA_VALIDATOR.checkExerciseDuringEditOperation(weightLoss, setsCount, repeatsCount);

        Assert.assertFalse(actualResult);
    }
}
