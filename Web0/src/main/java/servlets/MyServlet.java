package servlets;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Vojts on 16.10.2016.
 */
@WebServlet("/site")
public class MyServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/laba1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/form.html");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ArrayList<User> users = new ArrayList<User>();

        Boolean fail = false;

        String search = "select login, password from user where login=? AND password = ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement authorized = con.prepareStatement(search);

            authorized.setString(1, login);
            authorized.setString(2, password);

            ResultSet auth_result = authorized.executeQuery();

            if (auth_result.first()){
                if(login.equals("admin")){
                    Statement statement = con.createStatement();
                    ResultSet result_search = statement.executeQuery("select * from user");
                    while (result_search.next()) {
                        int id = result_search.getInt(1);
                        String login_user = result_search.getString(2);
                        String password_user = result_search.getString(3);
                        users.add(new User(id, login_user, password_user));
                    }
                }
            }
            else {
                fail = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("fail", fail);
        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request, response);
    }
}
