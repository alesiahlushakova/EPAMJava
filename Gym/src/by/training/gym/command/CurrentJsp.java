package by.training.gym.command;

import static by.training.gym.view.MessageManager.NONE_MESSAGE_KEY;

/**
 * class describes page url.

 */
public class CurrentJsp {

    /**
     * Common pages.
     */
    public static final String LOGIN_PAGE_PATH = "/jsp/common/login.jsp";
    public static final String MAIN_PAGE_PATH = "/jsp/common/main.jsp";
    public static final String ERROR_PAGE_PATH = "/jsp/common/error.jsp";
    public static final String REGISTER_PAGE_PATH = "/jsp/common/register.jsp";
    public static final String EDIT_PAGE_PATH = "/jsp/common/edit_user.jsp";
    /**
    * admin pages.
    */
    public static final String DESCRIBE_CLIENT_PAGE_PATH = "/jsp/admin/describe_client.jsp";
    public static final String SHOW_ALL_CLIENTS_PAGE_PATH = "/jsp/admin/show_all_clients.jsp";
    /**
     * Client's pages.
     */

    public static final String PREPARE_ORDER_PAGE_PATH = "/jsp/client/prepare_subscription.jsp";
    public static final String SHOW_CLIENT_ORDERS_PAGE_PATH = "/jsp/client/show_client_subscriptions.jsp";
    public static final String DESCRIBE_TRAINING_PROGRAM_PAGE_PATH = "/jsp/client/describe_program.jsp";
    public static final String ADD_FEEDBACK_PAGE_PATH = "/jsp/client/add_feedback.jsp";
    public static final String PAY_SUBSCRIPTION_PAGE_PATH = "/jsp/client/pay_subscription.jsp";
    /**
     * Coach's pages.
     */
    public static final String CREATE_EXERCISE_PAGE_PATH = "/jsp/coach/create_exercise.jsp";
    public static final String SHOW_EXERCISE = "/jsp/coach/show_exercise.jsp";
    public static final String PERSONAL_CLIENTS_PAGE_PATH = "/jsp/coach/personal_clients.jsp";
    public static final String CREATE_TRAINING_PROGRAM_PAGE_PATH = "/jsp/coach/create_program.jsp";
    public static final String EDIT_PROGRAM_PAGE_PATH = "/jsp/coach/edit_program.jsp";

    private String pageUrl;
    private boolean isRedirect;
    private String messageKey;

    /**
     * constructor.
     * @param pageUrl    the page's url.
     * @param isRedirect boolean value of variable isRedirect;
     */
    public CurrentJsp(String pageUrl, boolean isRedirect) {
        this.pageUrl = pageUrl;
        this.isRedirect = isRedirect;
        this.messageKey = NONE_MESSAGE_KEY;
    }

    /**
     * empty constructor.
     */
    public CurrentJsp() {
    }

    /**
     * constructor.
     *
     * @param pageUrl    the page's url.
     * @param isRedirect boolean value of variable isRedirect;
     * @param messageKey the message key.
     */
    public CurrentJsp(String pageUrl, boolean isRedirect, String messageKey) {
        this.pageUrl = pageUrl;
        this.isRedirect = isRedirect;
        this.messageKey = messageKey;
    }

    /**
     * getter for page url.
     * @return the page's url.
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * Setter for page url.
     * @param pageUrl the page's url.
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     * getter for isRedirect value.
     * @return boolean value of isRedirect variable.
     */
    public boolean isRedirect() {
        return isRedirect;
    }

    /**
     * setter for isRedirect value.
     * @param redirect the boolean value.
     */
    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    /**
     * getter for message key.
     * @return the message key.
     */
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * setter for the message key.
     * @param messageKey the message key.
     */
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
}