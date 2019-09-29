package by.training.gym.command;

import by.training.gym.command.admin.*;
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
    COMMON_EDIT_PROFILE {
        {
            this.command = new EditProfileCommand();
        }
    },
    /**
     * Admin commands.
     */
    ADMIN_FIND_CLIENT_BY_NAME {
        {
            this.command = new FindClientByNameCommand();
        }
    },
    ADMIN_SHOW_ALL_CLIENTS {
        {
            this.command = new ShowAllClientsCommand();
        }
    },
    ADMIN_REGISTER_COACH {
        {
            this.command = new RegisterCoachCommand();
        }
    },
    ADMIN_DELETE_CLIENT {
        {
             this.command = new DeleteClientCommand();
        }
    },
    ADMIN_SHOW_COACHES {
        {
            this.command = new ShowCoachesCommand();
        }
    },
    ADMIN_DELETE_COACH {
        {
            this.command = new DeleteCoachCommand();
        }
    },
    /**
     * client commands.
     */
    SPECIAL_SHOW_CLIENT_SUBSCRIPTIONS {
        {
            this.command = new ShowClientSubscriptionCommand();
        }
    },
    SPECIAL_SHOW_CLIENT_PROGRAM {
        {
            this.command = new ShowClientProgramCommand();
        }
    },
    CLIENT_CHECK_ACTUAL_SUBSCRIPTION {
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
    CLIENT_DISCARD_PROGRAM {
        {
            this.command = new DiscardProgramCommand();
        }
    },
    SPECIAL_DISCARD_CLIENT_SUBSCRIPTIONS {
        {
            this.command = new DiscardSubscriptionCommand();
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
    SPECIAL_EDIT_PROGRAM {
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
    SPECIAL_EDIT_EXERCISE_IN_PROGRAM {
        {
            this.command = new EditExerciseInProgramCommand();
        }
    },
    SPECIAL_DELETE_EXERCISE_FROM_PROGRAM {
        {
            this.command = new DeleteExerciseFromProgramCommand();
        }
    },
    SPECIAL_ADD_EXERCISE_TO_PROGRAM {
        {
            this.command = new AddExerciseToProgramCommand();
        }
    },
    SPECIAL_DELETE_DAY_FROM_PROGRAM {
        {
            this.command = new DeleteDayFromProgramCommand();
        }
    },
    SPECIAL_EDIT_DIET_IN_PROGRAM {
        {
            this.command = new EditDietInProgramCommand();
        }
    },
    SPECIAL_ADD_DAY_TO_PROGRAM {
        {
            this.command = new AddDayToProgramCommand();
        }
    },
    SPECIAL_SAVE_PROGRAM_EDIT {
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
