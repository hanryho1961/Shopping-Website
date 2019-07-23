<%@page import="model.SanPhamModel"%>
<%@page import="entities.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create New Account</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<Style>
		body {
			margin:0;
		}
		
		.menu {
  			overflow: hidden;
  			background-color: #4B4B4B;
  			/* position: fixed; /* Set the menuBar to fixed position */ */
  			top: 0; /* Position the navbar at the top of the page */
  			width: 1440px; /* Full width */
  			height: 60px; 
		}
		#logo {
			float: left;
			width: 50px; 
			height: 50px; 
			padding-top: 0.2%; 
			padding-left: 1%;
		}
		#searchBox {
			float: left;
			border-radius: 4px;
			float: left;
			margin-left: 20%;
			margin-top: 0.6%;
			width: 500px;
			height: 36px;
			padding-left: 1%; /*For Text Inside the Box*/
			font-size: 20px;
		}
		.searchButton {
			border-radius: 4px;
			border: none;
			float: left;
			margin-left: 1%;
			margin-top: 0.6%;
			padding-left:2%;
			padding-right:2%;
			padding-top:0.65%;
			padding-bottom: 0.65%;
			font-size: 20px; 
			background-image: linear-gradient(to right, #00B9FF , #0004FF);
			color: white;
		}
		#shoppingCart {
			float: left;
			width: 50px; 
			height: 50px; 
			margin-top: 0.2%; 
			margin-left: 20%;
		}
		#loginButton {
			border: none;
			background-color: #4B4B4B;
			color: white;
			font-weight: normal;
			margin-top: 1%;
			margin-left: 1%;
			font-size: 20px;
			
		}
		.shade {
			overflow: hidden;
  			background-color: #000000;
  			backgroud-image: linear-gradient(#000000, #666666);
  			margin-top: 0px;
  			width: 1440px; /* Full width */
  			height: 2px; 
		}
		.introduction {
			overflow: hidden;
  			background-color: #666666;
  			margin-top: 0px;
  			width: 1440px; /* Full width */
  			height: 775px; 
		}
		.body {
			overflow: hidden;
			position: relative;
			top: 0px;
			left: 50px;
			background-color: white;
			width: 1340px;
			height: 725px;
		}
		.text {
			text-transform: uppercase;
			background: linear-gradient(to right, #30CFD0 0%, #330867 100%);
			-webkit-background-clip: text;
			-webkit-text-fill-color: transparent;
			font-size: 70px; 
			margin-top: 50px; 
			left: 330px; 
			position: relative;
			font: {
				size: 20vw;
				family: $font;
			};
		}
		.account {
			border: 1px solid black;
			margin-top: -50px;
			margin-left: 330px;
			position: relative;
			float: left;
			width: 720px;
			height: 105px;
		}
		.userdiv {
			border: 0px solid black;
			margin-top: 10px;
			margin-left: 10px;
			width: 700px;
			height: 40px;
		}
		#username {
			width: 530px;
			height: 30px;
			font-size: 25px;
			position: relative;
			float: left;
			margin-top: 0px;
			margin-left: 20px;
		}
		.passdiv {
			border: 0px solid black;
			margin-top: 10px;
			margin-left: 10px;
			width: 700px;
			height: 40px;
		}
		#password {
			width: 530px;
			height: 30px;
			font-size: 25px;
			float: left;
			margin-top: 0px;
			margin-left: 20px;
		}
		.details {
			border: 1px solid black;
			margin-top: 10px;
			margin-left: 330px;
			position: relative;
			float: left;
			width: 720px;
			height: 150px;
		}
		.namediv {
			border: 0px solid black;
			margin-top: 10px;
			margin-left: 10px;
			width: 700px;
			height: 40px;
		}
		#firstname {
			width: 150px;
			height: 30px;
			font-size: 25px;
			position: relative;
			float: left;
			margin-top: 0px;
			margin-left: 20px;
		}
		.datediv {
			border: 0px solid black;
			margin-top: 10px;
			margin-left: 10px;
			width: 700px;
			height: 40px;
		}	
		#date {
			width: 489px;
			height: 30px;
			font-size: 25px;
			position: relative;
			float: left;
			margin-top: 0px;
			margin-left: -320px;
		}
		.genderdiv {
			border: 0px solid black;
			margin-top: 10px;
			margin-left: 10px;
			width: 700px;
			height: 40px;
		}
		input[type="radio"] {
			position: relative;
			float: left;
			margin-left: 20px;	
			margin-top: 5px;
			zoom: 1.5;
		}
		#male {
			position: relative;
			float: left;
			font-size: 30px;
			margin-top: 3px;
			margin-left: 5px;
			margin-right: 20px;
		}
		#female {
			position: relative;
			float: left;
			font-size: 30px;
			margin-top: 3px;
			margin-left: 5px;
		}
		.register {
			margin-top: 10px;
			margin-left: 600px;
			padding-left:2%;
			padding-right:2%;
			padding-top:0.2%;
			padding-bottom: 0.2%;
			font-size: 35px;
			background-color: #0066ff; 
			color: white;
		}
		.register:hover {
			background-color: #005ce6;
			color: white;
		}
	</Style>
</head>
<body>
	<div class="menu">
		<form action="NewUserServlet?task=home" method="post">
			<input type="image" src="Images/Logo3.png" alt="Logo" id="logo">
		</form>
		<form action="NewUserServlet?task=search" method="post">
			<input type="text" placeholder="Enter your search text" id="searchBox" name="searchBox"> 
			<input type="submit" value="Search" class="searchButton">
		</form>
		<form action="NewUserServlet?task=cart" method="post">
			<input type="image" src="Images/Cart.png" alt="Cart" id="shoppingCart">
		</form>
		<form action="NewUserServlet?task=login" method="post">
			<input type="submit" value="Login" id="loginButton">
		</form>
	</div>
	<div class="shade">
	</div>
	<div class="introduction">
		<div class="body">	
			<form action="NewUserServlet?task=register" method="post">
				<p class="text">Welcome New User</p>
				<div class="account">
					<div class="userdiv">
						<p style="font-size: 30px; font-weight: bold; margin-top: 0px; margin-left: 0px; position: relative; color: black; float: left">Username: </p>
						<input type="text" name="username" id="username">
					</div>
					<div class="passdiv">
						<p style="font-size: 30px; font-weight: bold; margin-top: 0px; margin-left: -133px; position: relative; color: black; float: left">Password: </p>
						<input type="password" name="password" id="password">
					</div>
				</div>
				<div class="details">
					<div class="namediv">
						<p style="font-size: 30px; font-weight: bold; margin-top: 0px; margin-left: 0px; position: relative; color: black; float: left">First name: </p>
						<input type="text" name="firstname" id="firstname">
						<p style="font-size: 30px; font-weight: bold; margin-top: 0px; margin-left: 50px; position: relative; color: black; float: left">Last name: </p>
						<input type="text" name="lastname" id="firstname">
					</div>
					<div class="datediv">
						<p style="font-size: 30px; font-weight: bold; margin-top: 0px; margin-left: -520px; position: relative; color: black; float: left">Date of Birth: </p>
						<input type="text" name="dateofbirth" id="date" placeholder="MM/DD/YYYY">
					</div>
					<div class="genderdiv">
						<p style="font-size: 30px; font-weight: bold; margin-top: 0px; margin-left: -177px; position: relative; color: black; float: left">Gender: </p>
						<input type="radio" name="gender" value="Male" checked>
						<p id="male">Male</p>
						<input type="radio" name="gender" value="Female">
						<p id="female">Female</p>
					</div>
				</div>
				<input type="submit" value="Register" class="register">
			</form>
		</div>
		<p style="font-size: 20px; font-weight: normal; margin-top: 15px; left: 640px; position: relative; color: white;">FA Topgun 2018 ©</p>
	</div>
</body>
</html>