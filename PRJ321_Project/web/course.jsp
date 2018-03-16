<%-- 
    Document   : course
    Created on : Mar 13, 2018, 10:17:24 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Lesson"%>
<%@page import="model.Lesson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Lessons List</title>
    </head>
    <%
        ArrayList<Lesson> list = (ArrayList<Lesson>) request.getAttribute("list");
    %>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="homepage.jsp">P2T.com</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Courses<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="course?userID=${sessionScope.id}&courseID=1">Strokes</a></li>
                            <li><a href="course?userID=${sessionScope.id}&courseID=2">Serving</a></li>
                            <li><a href="course?userID=${sessionScope.id}&courseID=3">Tactics</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Shop</a></li>
                    <li><a href="feedback.jsp?userID=${sessionScope.id}">Feedback</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li style="color: white; padding-top: 13px">Hello ${sessionScope.username}</li>
                    <li><a href="userInfo?userID=${sessionScope.id}" target="blank"><span class="glyphicon glyphicon-user"></span> Info</a></li>
                    <li><a href="logout" target='blank'><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <h3>List of lessons in this courses : </h3>
            <table class="table table-hover">
                <tr>
                    <th>Lesson Name</th>
                    <th>Lesson Description</th>
                </tr>
                <%
                    for (Lesson l : list) {
                        pageContext.setAttribute("l", l);
                %>
                <tr>
                    <td><a href="lesson.jsp?lessonID=${l.link}" target="blank"><%= l.getName()%></a></td>
                    <td><%= l.getDescription()%></td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
