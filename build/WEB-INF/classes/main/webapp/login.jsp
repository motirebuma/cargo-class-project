<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in</title>
    <link rel="stylesheet" href="CSS/login.css">

    <!-- cdn for login, phone,mail and location icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
</head>
<body>
	<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
    <div class="container">
        <div class="loginBox">
            <form action="signin" method="post">
                <i class="fas fa-user"></i>
                <h1>Sign in</h1>
                <input type="email" placeholder="email" name="email" required>
                <input type="password" placeholder="password" name="password" required>
                <div class="sec">
                <div class="rem">
                    <input type="checkbox"><span>Remember me</span>
                </div> <a href="#">Register</a></div>
                <h2 id="loginFailed"></h2>
            <button type="submit">Login</button>
            </form>
        </div>
    </div>
    <div class="footer">
        <div class="about details">
            <h2>About</h2>
            <h4>Egele Egele's company</h4>
            <h4>something something..</h4>
        </div>
        <div class="quicklinks details">
            <h2>Quick Links</h2>
            <ul>
                <li><a href="#">Freight transportation</a></li>
                <li><a href="#">Register</a></li>
            </ul>
        </div>
        <div class="contact details">
            <h2>Contact</h2>
            <div class="subdetails">
                <i class="fa-solid fa-phone"></i><h4>+251 (0000) (000)</h4>
            </div>
            <div class="subdetails">
                <i class="fa-solid fa-envelope"></i><h4>egele@gmail.com</h4>
            </div>
            <div class="subdetails">
                <i class="fa-solid fa-location-dot"></i><h4>Adama Ethiopia</h4>
            </div>

        </div>
    </div>
    <script type="text/javascript">
    	let status = document.getElementById("status").value;
    	let test = document.getElementById("loginFailed")
    	if(status === "failed"){
    		//console.log("Login Failed");
    		test.innerHTML = "Login Failed";
    	}
    </script>
</body>
</html>