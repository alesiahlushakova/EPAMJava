package by.training.gym.command;

import by.training.gym.command.client.*;

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
    };
/**
 * todo add commands.
 */


    /**
     * Current command.
     */
    CommandAction command;

    /**
     * Gets current commands.
     *
     * @return the current commands.
     */
    public CommandAction getCurrentCommand() {
        return command;
    }
}
