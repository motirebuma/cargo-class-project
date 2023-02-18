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
</head>
<body>
    <!-- navbar -->
    <div class="navbar">
        <div class="logo">
            <!-- <i class="fa-solid fa-truck-front"></i> -->
            <h1 class="logo">Admin-<span>Panel</span></h1>
        </div>
        <div>
            <a class="log" href="jobslist_admin">PostedJobs</a>
            <a class="log" href="acceptedjobs_info">AcceptedJobs</a>
            <a class="log" href="customers_info">Customers</a>
            <a class="log" href="truckers_info">Truckers</a>
        </div>
    </div>
    
    <% for(int i=0; i<infoRec.size(); i++){ %>
        <% Info info = (Info)infoRec.get(i);%>
    <div class="container">
        <div class="head">
            <i class="fa-regular fa-user"></i><h1>User Information</h1>
        </div>
        <form action="#" method="get">
            <div class="info">
                <label for="">Full Name: <%= info.getFullname() %>  </label>
                <label for="">Username: <%= info.getUsername() %></label>
                <label for="">Email: <%= info.getEmail() %></label>
                <label for="">ID number: <%= info.getPhone() %></label>
                <label for="">Region: <%= info.getRegion() %></label>
                <label for="">Town: <%= info.getTown() %></label>
                <label for="">Kebele: <%= info.getKebele() %></label>
                <label for="">House Number: <%= info.getHauseNumber() %></label>
                <!-- <button type="submit">Delete User</button> -->
            </div>
        </form>
    </div>
    <% } %> 
</body>
</html>