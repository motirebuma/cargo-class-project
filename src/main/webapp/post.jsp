<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post</title>
    <link rel="stylesheet" href="CSS/post.css">
    <!-- cdn for login, phone,mail and location icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
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