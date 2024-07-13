<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<div class="social">
		<a href="twitter.com"><img src="images/facebook-logo.png"  height="21px"></a>
		<a href="youtube"><img src="images/Youtube.png" height="21px"></a>	
	</div>
	<div class="navigation" align="center">
		<ul class="nav">
			<li><a href="#">Home</a></li>
			<li><a href="#">About us</a></li>
			<li><a href="#">Contact Us</a></li>			
		</ul>
	</div>
	
<header>
<a href="#"><img src="images/logo.png" height="50px" width="200px"></a>
</header>	
<h2 align="center">User Management System</h2>	
<!-- <c:url value="/addUser" var="addUserURL"></c:url> -->
<div class="container">
<div class="main" align="center">
<form action="./addUser" method="post">
	Name: <input type="text" name="name"><br>
	Email Id: <input type="text" name="email"><br>
	Password: <input type="password" name="password"><br>
	<input type="submit" value="Add User"> 
</form>	
</div>	
</div>	
	
	
	
</body>
</html>