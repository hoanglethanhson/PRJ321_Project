<%-- 
    Document   : purchaseInfo
    Created on : Mar 13, 2018, 9:22:15 AM
    Author     : Admin
--%>

<%@page import="model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Purchase Info</title>
    </head>
    <%
        String info = (String) request.getAttribute("info");
        Course c = (Course) request.getAttribute("course");
    %>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="homepage.jsp">P2T.com</a>
                </div>
                
                <ul class="nav navbar-nav navbar-right">
                    <li style="color: white; padding-top: 13px">Hello ${sessionScope.username}</li>
                    <li><a href="userInfo?userID=${sessionScope.id}" target="blank"><span class="glyphicon glyphicon-user"></span> Info</a></li>
                    <li><a href="logout" target='blank'><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="alert alert-info">
                <strong>Info!</strong> 

                <% if (info.equals("Success")) {%>
                    Purchase successfully!<br>
                    <h4>Course : <strong><%=c.getName()%></strong><br></h4>
                    Description : <%=c.getDescription()%>
                <%} else {%>
                    Invalid or duplicate activate code! <br>
                    Please check again!

                    Please re-enter the course code that you purchased here to activate the course : 

                <div class="container-fluid">
                    <form class="form-horizontal" action="purchase" method="POST">
                        <div class="form-group">
                            <input type="hidden" value="${sessionScope.id}" name='txtUserId'>
                            <label class="control-label col-sm-2" for="code">Code:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username" placeholder="Enter code" name="txtCode" required="required">
                            </div>
                        </div>

                        <div class="form-group">        
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Activate</button>
                            </div>
                        </div>
                    </form>             
                    
                </div>

                <%}%>

            </div>
        </div>
    </body>
</html>
