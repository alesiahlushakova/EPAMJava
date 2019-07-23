package by.training.gym.command;

import by.training.gym.command.client.*;
import by.training.gym.command.coach.*;

/**
 * class for command types.
 * @author AlesyaHlushakova
 */
public enum CommandType {

    /**
     * commands.
     */
    COMMON_LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    COMMON_LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    COMMON_REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    COMMON_CHANGE_LANGUAGE {
        {
            this.command = new ChangeLanguageCommand();
        }
    },
    /**
     * client commands.
     */
    CLIENT_SHOW_CLIENT_SUBSCRIPTIONS {
        {
            this.command = new ShowClientSubscriptionCommand();
        }
    },
    SHOW_CLIENT_PROGRAM {
        {
            this.command = new ShowClientProgramCommand();
        }
    },
    CHECK_ACTUAL_SUBSCRIPTION {
        {
            this.command = new CheckActualSubscriptionCommand();
        }
    },
    CLIENT_ADD_FEEDBACK {
        {
            this.command = new AddFeedbackCommand();
        }
    },
    CLIENT_PREPARE_SUBSCRIPTION {
        {
            this.command = new PrepareSubscriptionCommand();
        }
    },
    CLIENT_PAY_SUBSCRIPTION {
        {
            this.command = new PaySubscriptionCommand();
        }
    },
    /**
     * coach commands.
     */
    COACH_CREATE_EXERCISE {
        {
            this.command = new CreateExerciseCommand();
        }
    },
    COACH_SHOW_PERSONAL_CLIENTS {
        {
            this.command = new ShowPersonalClientsCommand();
        }
    },
    COACH_PREPARE_PROGRAM_CREATION {
        {
            this.command = new PrepareProgramCreationCommand();
        }
    },
    COACH_EDIT_PROGRAM {
        {
            this.command = new EditProgramCommand();
        }
    },
    COACH_CREATE_PROGRAM {
        {
            this.command = new CreateProgramCommand();
        }
    },
    COACH_FINISH_PROGRAM_CREATION {
        {
            this.command = new FinishProgramCreationCommand();
        }
    },
    COACH_EDIT_EXERCISE_IN_PROGRAM {
        {
            this.command = new EditExerciseInProgramCommand();
        }
    },
    COACH_DELETE_EXERCISE_FROM_PROGRAM {
        {
            this.command = new DeleteExerciseFromProgramCommand();
        }
    },
    COACH_ADD_EXERCISE_TO_PROGRAM {
        {
            this.command = new AddExerciseToProgramCommand();
        }
    },
    COACH_DELETE_DAY_FROM_PROGRAM {
        {
            this.command = new DeleteDayFromProgramCommand();
        }
    },
    COACH_EDIT_DIET_IN_PROGRAM {
        {
            this.command = new EditDietInProgramCommand();
        }
    },
    COACH_ADD_DAY_TO_PROGRAM {
        {
            this.command = new AddDayToProgramCommand();
        }
    },
    COACH_SAVE_PROGRAM_EDIT {
        {
            this.command = new SaveProgramCommand();
        }
    },
    ;
/**
 * todo add commands.
 */


    /**
     * Current command.
     */
    Command command;

    /**
     * Gets current commands.
     *
     * @return the current commands.
     */
    public Command getCurrentCommand() {
        return command;
    }
}
