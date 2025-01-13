<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Progress Tracker</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Language Progress Tracker</h1>
        </div>
        <div class="content">
            <%
                User user = (User) session.getAttribute("user");
                if (user != null) {
            %>
            <form action="ProgressServlet" method="post" class="progress-form">
                <input type="hidden" name="userId" value="<%= user.getId() %>">
                <label for="language">Select Language:</label>
                <select name="language" required>
                    <option value="" disabled selected>Select Language</option>
                    <option value="French">French</option>
                    <option value="Spanish">Spanish</option>
                    <option value="German">German</option>
                    <option value="Japanese">Japanese</option>
                </select>
                <label for="progressLevel">Progress Level (%):</label>
                <input type="number" name="progressLevel" placeholder="Enter Progress Level" required>
                <button type="submit" class="btn pastel-btn">Update Progress</button>
            </form>
            <hr>
            <h2>Your Current Progress:</h2>
            <%
                java.util.List<String> progressList = (java.util.List<String>) request.getAttribute("progressData");
                if (progressList != null && !progressList.isEmpty()) {
                    for (String progress : progressList) {
                        out.println("<p>" + progress + "</p>");
                    }
                } else {
                    out.println("<p>No progress data available.</p>");
                }
            %>
            <div class="buttons">
                <a href="profile.jsp"><button class="btn pastel-btn">Back to Profile</button></a>
            </div>
            <% } else { %>
            <p>You are not logged in. <a href="login.jsp">Login here</a>.</p>
            <% } %>
        </div>
    </div>
</body>
</html>
