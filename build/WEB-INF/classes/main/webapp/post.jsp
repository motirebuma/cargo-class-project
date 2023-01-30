<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post</title>
    <link rel="stylesheet" href="CSS/post.css">
    <!-- bootsrap -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <!-- cdn for login, phone,mail and location icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
    <div class="box">
        <h1><span>Post</span>job</h1>
        <form action="postjob" method="post">
            <div class="custom">
                <i class="fa-solid fa-file-signature"></i>
                <input type="text" placeholder="job title" name="jobTitle" required>
            </div> 
            <div class="custom">
                <i class="fa-solid fa-puzzle-piece"></i>
                <input type="text" placeholder="job type" name="jobType" required>
            </div>
            <div class="custom">
                <i class="fa-solid fa-hand-holding-dollar"></i>
                <input type="text" placeholder="price" name="price" required>
            </div>
            <div class="custom">
                <i class="fa-solid fa-truck-fast"></i>
                <select id="" name="truckType" required>
                    <option value="" >truck type </option>
                    <option value="small" >small</option>
                    <option value="medium" >medium</option>
                    <option value="big" >big</option>
                </select>
            </div>
            <textarea placeholder="Job description" name="description" required></textarea>
            <button type="submit">post <i class="fa-solid fa-upload"></i></button>
        </form>
    </div>
</body>
</html>