<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>User Profile</h1>
        </div>
        <div class="content">
            <%
                User user = (User) session.getAttribute("user");
                if (user != null) {
            %>
            <p><strong>Username:</strong> <%= user.getUsername() %></p>
            <p><strong>Email:</strong> <%= user.getEmail() %></p>
            <div class="buttons">
                <a href="progress.jsp"><button class="btn pastel-btn">Track Progress</button></a>
                <a href="index.jsp"><button class="btn pastel-btn">Logout</button></a>
            </div>
            <% } else { %>
            <p>You are not logged in. <a href="login.jsp">Login here</a>.</p>
            <% } %>
        </div>
    </div>
</body>
</html>
