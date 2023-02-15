<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList"%>
<%@ page import="main.java.projectpack.Info" %>
<% ArrayList infoRec = (ArrayList)request.getAttribute("infoRec"); %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My account</title>
    <link rel="stylesheet" href="CSS/account.css">
    <!-- cdn -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
    <!-- bootsrap -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-md">
        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler navbar-light" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>
         
        <div class="cssnav collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li>
                    <a href="jobs" class="nav-link">Job List</a>
                </li>
                <li class="nav-item">
                    <a href="postjob" class="nav-link">Post</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Notification</a>
                </li>
                <li class="nav-item">
                    <a href="myaccount" class="nav-link">Account</a>
                </li>
            </ul>
        </div>
    </nav>
    <% for(int i=0; i<infoRec.size(); i++){ %>
        <% Info info = (Info)infoRec.get(i);%>
    <div class="container">
        <div class="head">
            <i class="fa-regular fa-user"></i><h1>My Account</h1>
        </div>
        <form action="myaccount" method="get">
            <div class="info">
                <label for="">Full Name: <%= info.getFullname() %>  </label>
                <label for="">Username: <%= info.getUsername() %></label>
                <label for="">Email: <%= info.getEmail() %></label>
                <label for="">ID number: <%= info.getPhone() %></label>
                <label for="">Region: <%= info.getRegion() %></label>
                <label for="">Town: <%= info.getTown() %></label>
                <label for="">Kebele: <%= info.getKebele() %></label>
                <label for="">House Number: <%= info.getHauseNumber() %></label>
                <button type="submit">Edit info</button>
            </div>
        </form>
    </div>
    <% } %> 
</body>
</html>