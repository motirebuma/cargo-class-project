<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList"%>
<%@ page import="main.java.projectpack.Jobs" %>
<% ArrayList jobsRec = (ArrayList)request.getAttribute("jobRec"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!-- css -->
    <link rel="stylesheet" href="CSS/jobs.css">
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
                    <a href="#" class="nav-link">Job List</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Post</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Notification</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Account</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- jobType not added -->

    <% for(int i=jobsRec.size()-1; i >= 0; i--){ %>
        <% Jobs job = (Jobs)jobsRec.get(i);%>
    <div class="post">
        <div class="id">
            <h3>JOB ID: <%= job.getId()%></h3>
        </div>
        <div class="head">
            <h1><%= job.getTitle()%></h1>
        </div>
        <div class="details">
            <h2>Truck type: <%= job.getTruckType()%></h2>
            <p><%= job.getPrice()%></p>
            <div class="bp">
                <h4>Price: <span><%= job.getDescription()%></span> </h4>
                <button>Apply</button>
            </div>
        </div>          
    </div>
    <%}%>
</body>
</html>