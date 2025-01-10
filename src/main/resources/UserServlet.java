package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            if (userDAO.registerUser(user)) {
                response.sendRedirect("login.jsp");
            } else {
                response.getWriter().write("Registration failed.");
            }
        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = userDAO.loginUser(username, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("profile.jsp");
            } else {
                response.getWriter().write("Invalid credentials.");
            }
        }
    }
}

