package by.training.gym.controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gym?useSSL=false" +
                    "?verifyServerCertificate=false" +
                    "&useSSL=false" +
                    "&requireSSL=false" +
                    "&useLegacyDatetimeCode=false" +
                    "&amp" +
                    "&serverTimezone=UTC", "root", "motherlode");
            Statement statement = connection.createStatement();
            printWriter.println("<html><head> <title> test</title> </head>");
            ResultSet resultSet = statement.executeQuery("Select Firstname,Lastname from Users");
            printWriter.println("<table border=2>");
            printWriter.println("<tr>" + "<th>NAME</th>" + "<th>SURNAME</th>" + "</tr>");
            while (resultSet.next()){

                printWriter.println("<tr>" + "<th>"+resultSet.getString(1) + "</th>");
                printWriter.println("<th>" + resultSet.getString(2) + "</th>" + "</tr>");
            }
            printWriter.println("</table>");
            printWriter.println("</html>");
        } catch (Exception e) {
            System.out.println("Exception:"+e);
        }
    }
}
