package by.training.gym.controller.listener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
/**
 * @author Alesyahlushakova
 * attribute listener.
 */
public class SessionListener implements HttpSessionAttributeListener {
    private static final Logger LOGGER = LogManager.getLogger(SessionListener.class);
    public void attributeRemoved(HttpSessionBindingEvent ev) {
    }
    public void attributeAdded(HttpSessionBindingEvent ev) {
        LOGGER.info("add: " + ev.getClass().getSimpleName() + " : "+ ev.getName()
                + " : " + ev.getValue());
    }
    public void attributeReplaced(HttpSessionBindingEvent ev) {

        LOGGER.info("replace: " + ev.getClass().getSimpleName() + " : " + ev.getName()
                + " : " + ev.getValue());
    }
}
