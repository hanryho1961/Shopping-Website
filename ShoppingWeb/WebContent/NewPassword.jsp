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
	<title>Renew Password</title>
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
			margin-left: 13%;
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
		.verification {
			border: 0px solid black;
			margin-top: -50px;
			margin-left: 170px;
			width: 1000px;
			height: 50px;
		}
		#oldpassword {
			width: 500px;
			height: 30px;
			font-size: 25px;
			position: relative;
			float: left;
			margin-top: 7px;
			margin-left: 61px;
		}		
		.newpass {
			border: 0px solid black;
			margin-top: 5px;
			margin-left: 170px;
			width: 1000px;
			height: 50px;
		}
		#newpassword {
			width: 500px;
			height: 30px;
			font-size: 25px;
			position: relative;
			float: left;
			margin-top: 7px;
			margin-left: 52px;
		}
		.retype {
			border: 0px solid black;
			margin-left: 170px;
			margin-top: 5px;
			width: 1000px;
			height: 50px;
		}
		#retype {
			width: 500px;
			height: 30px;
			font-size: 25px;
			position: relative;
			float: left;
			margin-top: 7px;
			margin-left: 20px;
		}
		.message {
			border: 0px solid black;
			margin-left: 170px;
			margin-top: 5px;
			width: 1000px;
			height: 50px;
		}
		.action {
			border: 0px solid black;
			margin-left: 170px;
			margin-top: 5px;
			width: 1000px;
			height: 70px;
		}
		.renewButton {
			border: none;
			float: left;
			margin-top: 0px;
			margin-right: 30px;
			margin-left: 350px;
			background-color: #0099ff;
			width: 300px;
			height: 50px;
			font-size: 25px;
			color: white;
		}
		.renewButton:hover {
			background-color: #008ae6;
			color: white;
		}
	</Style>
</head>
<body>
	<div class="menu">
		<form action="NewPasswordServlet?task=home&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Logo3.png" alt="Logo" id="logo">
		</form>
		<form action="NewPasswordServlet?task=search" method="post">
			<input type="text" placeholder="Enter your search text" id="searchBox" name="searchBox"> 
			<input type="submit" value="Search" class="searchButton">
		</form>
		<form action="CustomerPageServlet?task=cart&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Cart.png" alt="Cart" id="shoppingCart">
		</form>
		<form action="NewPasswordServlet?task=details&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="submit" value="<%=session.getAttribute("customername") %>" id="loginButton">
		</form>
	</div>
	<div class="shade">
	</div>
	<div class="introduction">
		<div class="body">	
			<form action="NewPasswordServlet?task=renew&customername=<%=session.getAttribute("customername") %>" method="post">
				<p class="text">Renew Password</p>
				<div class="verification">
					<p style="font-size: 30px; font-weight: bold; margin-top: 7px; margin-left: 80px; position: relative; color: black; float: left">Input Old Password: </p>
					<input type="password" name="verification" id="oldpassword">
				</div>
				<div class="newpass">
					<p style="font-size: 30px; font-weight: bold; margin-top: 7px; margin-left: -268px; position: relative; color: black; float: left">Input New Password: </p>
					<input type="password" name="newpass" id="newpassword">
				</div>
				<div class="retype">
					<p style="font-size: 30px; font-weight: bold; margin-top: 7px; margin-left: -277px; position: relative; color: black; float: left">Reinput New Password: </p>
					<input type="password" name="retype" id="retype">
				</div>
				<div class="message">
					<p style="font-size: 30px; font-weight: bold; margin-top: 7px; margin-left: -305px; position: relative; color: black; float: left"><font color="red"><%=session.getAttribute("message") %></font></p>
				</div>
				<div class="action">
					<input type="submit" value="Renew" class="renewButton">
				</div>
			</form>
		</div>
		<p style="font-size: 20px; font-weight: normal; margin-top:15px; left: 640px; position: relative; color: white;">FA Topgun 2018 ©</p>
	</div>
</body>
</html>