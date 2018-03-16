<%-- 
    Document   : productlist
    Created on : Mar 14, 2018, 5:11:18 PM
    Author     : Admin
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>P2T.com - Shop</title>
        <style>
            #shopList {
                display: inline;
                border : 2px solid black;  
                padding: 5px 5px 5px 5px;
            }
            #productName :hover {
                background-color: #99ffcc;
            }


        </style>
    </head>
    <%
        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
    %>       
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="../homepage.jsp">P2T.com</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Courses<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="../course?userID=${sessionScope.id}&courseID=1">Strokes</a></li>
                            <li><a href="../course?userID=${sessionScope.id}&courseID=2">Serving</a></li>
                            <li><a href="../course?userID=${sessionScope.id}&courseID=3">Tactics</a></li>
                        </ul>
                    </li>
                    <li><a href="productlist.jsp">Shop</a></li>
                    <li><a href="../feedback.jsp?userID=${sessionScope.id}">Feedback</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li style="color: white; padding-top: 13px">Hello ${sessionScope.username}</li>
                    <li><a href="../userInfo?userID=${sessionScope.id}" target="blank"><span class="glyphicon glyphicon-user"></span> Info</a></li>
                    <li><a href="../logout" target='blank'><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <h2>List of items in our shop : </h2>
            <%
                if (session.getAttribute("shoppingcart") != null) {
            %>
            
            <form class="form-horizontal" action="../shopping/view" method="GET" style="padding-left: 80px">
                    <input type="hidden" name="txtID" value="${sessionScope.id}">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="submit" type="submit" class="btn btn-default">Go To My Cart</button>
                    </div>
                </form>
            <%}%>
            <%
                for (Product p : products) {
                    pageContext.setAttribute("p", p);
            %>
            <div class="col-lg-4" id="shopList">
                <div id="productName" class="alert alert-info">
                    <h4 style="text-align: center"><strong><%= p.getName()%></strong></h4>
                </div>
                <img src="<%= p.getImageUrl()%>" height="300px" width="300"><br>
                <div class="alert alert-info">
                    <p style="text-align: center">Price : <strong style="color: red"><%= String.valueOf(p.getPrice())%> VND</strong></p>
                </div>
                <form class="form-horizontal" action="../shopping/buy" method="POST" style="padding-left: 80px">
                    <input type="hidden" name="productID" value="<%= p.getID()%>">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="submit" type="submit" class="btn btn-default">Add To Cart</button>
                    </div>
                </form>
            </div>

            <%}%>
        </div>
    </body>
</html>
