<%-- 
    Document   : index
    Created on : Mar 9, 2018, 10:35:24 PM
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
        <title>P2T.com - Table Tennis Tutorial</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">P2T.com</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Courses<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="login.jsp">Strokes</a></li>
                            <li><a href="login.jsp">Serving</a></li>
                            <li><a href="login.jsp">Tactics</a></li>
                        </ul>
                    </li>
                    <li><a href="login.jsp">Shop</a></li>
                    <li><a href="login.jsp">Feedback</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="register.jsp" target="blank"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                    <li><a href="login.jsp" target='blank'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </nav>
        
        <div class="container-fluid" style="background-color: #9999ff">
            <div class="col-lg-6">
                <h3>Welcome to P2T.com - Table Tennis Tutorial Page</h3>
                <p>By attending courses of this page, you can learn table tennis 
                    from zero to a pro with many lessons with videos and instructions from us.</p>

                <div class="alert alert-info">
                    <strong>Info!</strong> Join now and improve your table tennis skill!
                </div>
            </div>
            <div class="col-lg-6">
                <iframe width="550" height="400px" src="https://www.youtube.com/embed/WqInod_ue1c">
                </iframe>
            </div>
        </div>
        
        <div class="container-fluid">
            <div class="footer">
                <h4 style="text-align: center">Contact us</h4><br>
                <a href="https://www.facebook.com/son.hoanglethanh" target="blank">
                    <img style="padding-left: 590px; padding-right: 80px; border: 0" src="images/facebook.png" alt="Facebook Page">
                </a>
                <a href="https://www.youtube.com/channel/UCk83OG8rkJOeyT2pZSIHkxg?view_as=subscriber" target="blank">
                    <img style="border: 0" src="images/youtube_alt.png" alt="Youtube Channel">
                </a>
            </div>
        </div>
    </body>
</html>
