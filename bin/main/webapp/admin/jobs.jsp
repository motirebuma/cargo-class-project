<!-- import -->
<%@page  import="java.util.ArrayList"%>
<%@ page import="main.java.projectpack.Jobs" %>
<% ArrayList jobsRec = (ArrayList)request.getAttribute("jobRec"); %>

<!-- session start -->
<% String password = (String)session.getAttribute("password"); %>
<%  if(null==password) {%>
<%    response.sendRedirect("login.jsp");%>
<% } %>
<!-- session done -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!-- css -->
    <link rel="stylesheet" href="CSS/jobs.css">

</head>
<body>
    <div class="nav">
        <div class="navbar">
            <div class="logo">
                <i class="fa-solid fa-truck-front"></i>
                <h1 class="logo">Admin-<span>Panel</span></h1>
            </div>
            <div class="links">
                <a class="log" href="jobslist_admin">PostedJobs</a>
                <a class="log" href="acceptedjobs_info">AcceptedJobs</a>
                <a class="log" href="customers_info">Customers</a>
                <a class="log" href="truckers_info">Truckers</a>
            </div>
        </div>
    </div>

    <!-- jobType not added -->
    <!-- reverse -->
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
                <!-- admin can not apply a job... -->
                <!-- <a href="apply">  
                    <button>Apply</button>
                </a> -->
            </div>
        </div>          
    </div>
    <%}%>
</body>
</html>