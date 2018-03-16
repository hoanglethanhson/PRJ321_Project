<%-- 
    Document   : feedback
    Created on : Mar 13, 2018, 6:05:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Feedback Page</title>
    </head>
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
            <h2>Give us tour feedback</h2>
            <form class="form-horizontal" action="feedback" method="POST">
                <div class="form-group">
                    <input type="hidden" value="${sessionScope.id}" name="userID">
                    <label class="control-label col-sm-2" for="feedback">Your feedback:</label>
                    <div class="col-sm-10">
                       <textarea class="form-control" rows="5" id="comment" name="txtFeedback"></textarea>
                    </div>
                </div>
   
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Send Feedback</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
