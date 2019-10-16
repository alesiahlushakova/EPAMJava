package by.training.gym.controller.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
@WebListener
public class RequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent ev) {

        HttpServletRequest req = (HttpServletRequest) ev.getServletRequest();
        String uri = "Request Initialized for " + req.getRequestURI();
        String id = "Request Initialized with ID="+ req.getRequestedSessionId();
        ServletContext context = ev.getServletContext();

        context.log(uri + "\n" +id);
    }
    public void requestDestroyed(ServletRequestEvent ev) {
        ServletContext context = ev.getServletContext();
        context.log("Request Destroyed: "
                + ev.getServletRequest().getAttribute("lifecycle"));
    }
}