package by.training.gym.controller;

import by.training.gym.dao.ConnectionController;
import by.training.gym.dao.UserDAO;
import by.training.gym.domain.User;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;

import javax.resource.spi.ConnectionManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static by.training.gym.command.Command.USER_ATTRIBUTE;


public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        BufferedInputStream bin=null;
        BufferedOutputStream bout=null;
        InputStream in =null;

        response.setContentType("image/jpeg");
        ServletOutputStream out;
        out = response.getOutputStream();
        HttpSession currentSession = request.getSession();
        User user = (User)currentSession.getAttribute(USER_ATTRIBUTE);
        int id = user.getId();
               UserService userService = new UserService();
        try {

            in = userService.retrieveImage(id, in);
            bin = new BufferedInputStream(in);
            bout = new BufferedOutputStream(out);
            int ch=0;
            while((ch=bin.read())!=-1)
            {
                bout.write(ch);
            }

        } catch (ServiceException ex) {
        //   LOGGER.error("Error occurred during processing photo");
        }finally{
            try{
                if(bin!=null)bin.close();
                if(in!=null)in.close();
                if(bout!=null)bout.close();
                if(out!=null)out.close();
            }catch(IOException ex){

            }
        }

    }
}
