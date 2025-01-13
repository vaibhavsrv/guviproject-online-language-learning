package com.java.servlet;

import dao.ProgressDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProgressServlet")
public class ProgressServlet extends HttpServlet {
    private ProgressDAO progressDAO = new ProgressDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String language = request.getParameter("language");
        int progressLevel = Integer.parseInt(request.getParameter("progressLevel"));

        if (progressDAO.updateProgress(userId, language, progressLevel)) {
            request.setAttribute("message", "Progress updated successfully!");
        } else {
            request.setAttribute("message", "Failed to update progress.");
        }
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            List<String> progressData = progressDAO.getProgress(user.getId());
            request.setAttribute("progressData", progressData);
        }
        request.getRequestDispatcher("progress.jsp").forward(request, response);
    }
}
