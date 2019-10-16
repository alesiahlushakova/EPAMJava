package test.by.training.gym.service;

import by.training.gym.domain.Exercise;
import by.training.gym.domain.ExerciseLevel;
import by.training.gym.service.ExerciseService;
import by.training.gym.service.ServiceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ExerciseServiceTest {
    ExerciseService exerciseService;
    List<Exercise> exerciselist;
    Exercise exerciseNotValid = new Exercise();
    Exercise exercise1 = new Exercise();
    Exercise exercise2 = new Exercise();
    Exercise exercise3 = new Exercise();
    Exercise exercise4 = new Exercise();
    @BeforeMethod
    public void setUp() {
        exerciseService = new ExerciseService();
        exerciselist = new ArrayList<Exercise>();
        exercise1 = new Exercise();
        exercise1.setName("running");
        exercise1.setLevel(ExerciseLevel.EXPERT);
        exercise1.setRestrictions("bones problems");
        exercise1.setCaloriesLost(400);
        exercise1.setDescription("Running will elongate your stamina");
        exercise1.setId(1);


        exercise2.setName("push ups");
        exercise2.setLevel(ExerciseLevel.CASUAL);
        exercise2.setRestrictions("heart dystony");
        exercise2.setCaloriesLost(200);
        exercise2.setDescription("Push ups improve muscles and male you fit");
        exercise2.setId(2);


        exercise3.setName("pressups");
        exercise3.setLevel(ExerciseLevel.STARTER);
        exercise3.setRestrictions("heart deseases");
        exercise3.setCaloriesLost(400);
        exercise3.setDescription("Press ups wil improve your stomach muscles");
        exercise3.setId(3);


        exercise4.setName("cycling");
        exercise4.setLevel(ExerciseLevel.CASUAL);
        exercise4.setRestrictions("Heart and lung deseases.");
        exercise4.setCaloriesLost(200);
        exercise4.setDescription("This exercise will improve your feet.");
        exercise4.setId(4);
        exerciselist.add(exercise1);
        exerciselist.add(exercise2);
        exerciselist.add(exercise3);
        exerciselist.add(exercise4);

        exerciseNotValid.setName("speed");
        exerciseNotValid.setDescription("aa");
        exerciseNotValid.setCaloriesLost(0);
        exerciseNotValid.setRestrictions("fff");
        exerciseNotValid.setId(5);

    }



    @Test
    public void testFindAllExercisesIdAndName() throws ServiceException {

        List<Exercise> exerciseList = exerciseService.findAllExercisesIdAndName();
        Assert.assertEquals(exerciseList, exerciselist);
    }




    @Test
    public void testCreateExercise() {
        List<Exercise> expected  = new ArrayList<>();
       Exercise exerciseOne = exerciseService.createExercise("running","bones problems",
               350, ExerciseLevel.EXPERT.name(),
               "Running will elongate your stamina" );
       exerciseOne.setId(1);
       Exercise exerciseTwo = exerciseService.createExercise("push ups", "heart dystony",
               200, ExerciseLevel.CASUAL.name(),
               "Push ups improve muscles and male you fit");
       exerciseTwo.setId(2);
       Exercise exerciseThree = exerciseService.createExercise("pressups","heart deseases",
               400, ExerciseLevel.STARTER.name(),
               "Press ups wil improve your stomach muscles" );
       exerciseThree.setId(3);
       Exercise exerciseFour = exerciseService.createExercise("cycling","Heart and lung deseases.",
               400, ExerciseLevel.CASUAL.name(),
               "This exercise will improve your feet." );
       exerciseFour.setId(4);
       expected.add(exerciseOne);
       expected.add(exerciseTwo);
       expected.add(exerciseThree);
       expected.add(exerciseFour);
       Assert.assertEquals(expected, exerciselist);
    }

    @Test
    public void testEditExercise() {
        TreeMap<Integer,List<Exercise>> map = new TreeMap<>();
        map.put(1, exerciselist);
        boolean expected = exerciseService.editExercise("3", "2",
                "2", "4", "5",  map );
        Assert.assertTrue(expected);
    }



}