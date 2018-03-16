<%-- 
    Document   : shoppingCart
    Created on : Mar 14, 2018, 9:13:02 PM
    Author     : Admin
--%>

<%@page import="model.InvoiceLine"%>
<%@page import="model.Invoice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            function alert() {
                alert("Your invoice is completed!")
            }
        </script>
        <title>P2T.com - Your cart</title>
    </head>
    <%
        Invoice invoice = (Invoice) session.getAttribute("shoppingcart");
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
                    <li><a href="product/list">Shop</a></li>
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

            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
                <%for (InvoiceLine p : invoice.getLines()) {
                        pageContext.setAttribute("p", p);
                %>
                <tr>
                    <td><%= p.getProduct().getName()%></td>
                    <td><img src="<%= p.getProduct().getImageUrl()%>" width="100px" height="100px"></td>
                    <td><%= p.getProduct().getPrice()%></td>
                    <td><%= p.getQuantity()%></td>
                </tr>
                <%}%>
            </table>
            <div class="alert-info">
                <strong>Total : </strong> <%= invoice.getTotal()%> VND
            </div>
            <form class="form-horizontal" action="shopping/view" method="POST">
                <input type="hidden" name="txtID" value="${sessionScope.id}">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="payment">Payment Method :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="payment" placeholder="Enter method" name="method" required="required">
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-info btn-lg" onclick="alert()">Finish</button>
                    </div>
                </div>

                
            </form>
        </div>
    </body>
</html>
