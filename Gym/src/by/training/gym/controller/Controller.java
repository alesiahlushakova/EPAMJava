package by.training.gym.controller;

import by.training.gym.command.Command;
import by.training.gym.command.CommandFactory;
import by.training.gym.command.CurrentJsp;
import by.training.gym.view.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.training.gym.command.Command.MESSAGE_ATTRIBUTE;
import static by.training.gym.view.MessageManager.NONE_MESSAGE_KEY;


@MultipartConfig(maxFileSize = 16177215)
public class Controller extends HttpServlet {
    /**
     * Get method.
     *
     * @param request  the HTTP request.
     * @param response the HTTP response.
     * @throws ServletException object if execution of method is failed.
     * @throws IOException      object if execution of method is failed.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Post method.
     *
     * @param request  the HTTP request.
     * @param response the HTTP response.
     * @throws ServletException object if execution of method is failed.
     * @throws IOException      object if execution of method is failed.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurrentJsp page;
        CommandFactory factory = new CommandFactory();
        Command command = factory.defineCommand(request);
        page = command.execute(request);

        boolean isRedirect = page.isRedirect();
        if (isRedirect) {
            redirect(page, request, response);
        } else {
            forward(page, request, response);
        }
    }

    private void redirect(CurrentJsp page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = page.getPageUrl();
        response.sendRedirect(request.getContextPath() + url);
    }

    private void forward(CurrentJsp page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = page.getPageUrl();
        String messageKey = page.getMessageKey();
        if (!NONE_MESSAGE_KEY.equals(messageKey)) {
            String message = MessageManager.getProperty(messageKey);
            request.setAttribute(MESSAGE_ATTRIBUTE, message);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

}

