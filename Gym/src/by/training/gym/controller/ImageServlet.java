package by.training.gym.controller;


import by.training.gym.domain.User;

import by.training.gym.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import static by.training.gym.command.Command.USER_ATTRIBUTE;

/**
 * servlet that shows the image on jsp page.
 * @author AlesyaHlushakova
 */
public class ImageServlet extends HttpServlet {
    /**
     * Post method.
     *
     * @param request  the HTTP request.
     * @param response the HTTP response.
     * @throws ServletException object if execution of method is failed.
     * @throws IOException      object if execution of method is failed.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /**
     * Get method.
     *
     * @param request  the HTTP request.
     * @param response the HTTP response.
     * @throws ServletException object if execution of method is failed.
     * @throws IOException      object if execution of method is failed.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       processRequest(request, response);
    }

    /**
     * method processes request.
     * @param request the HTTP request.
     * @param response the HTTP response.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        OutputStream oImage;
        ResultSet rs = null;

        PreparedStatement pstmt = null;
        HttpSession currentSession = request.getSession();

        User user = (User)currentSession.getAttribute(USER_ATTRIBUTE);
        int userId = user.getId();
        UserService userService = new UserService();

        try {

           byte barray[] = userService.retrieveImage(userId);
                response.setContentType("image/gif");
                oImage=response.getOutputStream();
                oImage.write(barray);
                oImage.flush();
                oImage.close();

        }
        catch(Exception ex){

        }finally {
            try{


            }catch(Exception ex){

            }
        }
    }
}
