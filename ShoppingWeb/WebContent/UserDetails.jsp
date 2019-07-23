<%@page import="entities.UserDetails"%>
<%@page import="entities.User"%>
<%@page import="model.UserDetailsModel"%>
<%@page import="model.UserModel"%>
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
	<title>User Details</title>
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
			left: 0px; 
			text-align: center;
			position: relative;
			font: {
				size: 20vw;
				family: $font;
			};
		}
		.info {
			overflow: none;
			border: 0px solid black;
			margin-left: 170px;
			margin-top: -50px;
			width: 1000px;
			height: 550px;
		}
		.account {
			position: relative;
			border: 1px solid black;
			width: 1000px;
			height: 150px;
		}
		.username {
			border: 0px solid black;
			width: 1000px;
			height: 70px;
		}
		.password {
			border: 0px solid black;
			width: 1000px;
			height: 70px;
		}
		.renewButton {
			border: none;
			float: right;
			margin-top: 10px;
			margin-right: 30px;
			margin-left: 0px;
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
		.detail {
			position: relative;
			margin-top: 10px;
			margin-left: 0px;
			border: 1px solid black;
			width: 1000;
			height: 370px;
		}
		.firstname {
			border: 0px solid black;
			width: 1000px;
			height: 70px;
		}
		.lastname {
			border: 0px solid black;
			width: 1000px;
			height: 70px;
		}
		.dateofbirth {
			border: 0px solid black;
			width: 1000px;
			height: 70px;
		}
		.gender {
			border: 0px solid black;
			width: 1000px;
			height: 70px;
		}
		.action {
			border: 0px solid black;
			width: 1000px;
			height: 70px;
		}
		.edit {
			border: none;
			float: left;
			margin-top: 10px;
			margin-right: 30px;
			margin-left: 0px;
			background-color: #0099ff;
			width: 300px;
			height: 50px;
			font-size: 25px;
			color: white;
		}
		.edit:hover {
			background-color: #008ae6;
			color: white;
		}
		.history {
			border: none;
			float: left;
			margin-top: 10px;
			margin-right: 30px;
			margin-left: 0px;
			background-color: #0099ff;
			width: 300px;
			height: 50px;
			font-size: 25px;
			color: white;
		}
		.history:hover {
			background-color: #008ae6;
			color: white;
		}
		
	</Style>
</head>
<body>
	<div class="menu">
		<form action="UserDetailsServlet?task=home&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Logo3.png" alt="Logo" id="logo">
		</form>
		<form action="UserDetailsServlet?task=search" method="post">
			<input type="text" placeholder="Enter your search text" id="searchBox" name="searchBox"> 
			<input type="submit" value="Search" class="searchButton">
		</form>
		<form action="CustomerPageServlet?task=cart&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Cart.png" alt="Cart" id="shoppingCart">
		</form>
		<input type="submit" value="<%=session.getAttribute("customername") %>" id="loginButton">		
	</div>
	<div class="shade">
	</div>
	<div class="introduction">
		<div class="body">	
			<% 
				String customername = session.getAttribute("customername").toString();
				UserModel userModel = new UserModel();
				UserDetailsModel userDetailsModel = new UserDetailsModel();
				User user = userModel.getUser(customername);
				UserDetails userDetails = userDetailsModel.getUser(customername);
			%>
			<p class="text"><%=user.getUsername() %></p>
			<div class="info">
				<div class="account">
					<div class="username"">
						<h1 style="float: left; font-size: 30px;">Username: </h1>
						<p style="float: left; font-size: 30px; margin-left: 15px; margin-top: 20px;"><%=user.getUsername() %></p>
					</div>
					<div class="password"">
						<h1 style="float: left; font-size: 30px; margin-left: -312px">Password: </h1>
						<p style="float: left; font-size: 30px; margin-left: -160px; margin-top: 20px;"><%=user.getPassword() %></p>
						<form action="UserDetailsServlet?task=newpassword&customername=<%=session.getAttribute("customername") %>" method="post">
							<input type="submit" value="Create New Password" class="renewButton">
						</form>
					</div>
				</div>
				<div class="detail">
					<div class="firstname">
						<h1 style="float: left; font-size: 30px;">Firstname: </h1>
						<p style="float: left; font-size: 30px; margin-left: 15px; margin-top: 20px;"><%=userDetails.getUserFirstname() %></p>
					</div>
					<div class="lastname">
						<h1 style="float: left; font-size: 30px; margin-left: -288px;">Lastname: </h1>
						<p style="float: left; font-size: 30px; margin-left: -130px; margin-top: 20px;"><%=userDetails.getUserLastname() %></p>
					</div>
					<div class="dateofbirth">
						<h1 style="float: left; font-size: 30px; margin-left: -195px;">Date of Birth: </h1>
						<p style="float: left; font-size: 30px; margin-left: 0px; margin-top: 20px;"><%=userDetails.getDate() %></p>
					</div>
					<div class="gender">
						<h1 style="float: left; font-size: 30px; margin-left: -330px;">Gender: </h1>
						<p style="float: left; font-size: 30px; margin-left: -200px; margin-top: 20px;"><%=userDetails.getGender() %></p>
					</div>
					<div class="action">
						<form action="UserDetailsServlet?task=edit&customername=<%=session.getAttribute("customername") %>&firstname=<%=userDetails.getUserFirstname() %>&lastname=<%=userDetails.getUserLastname() %>&birth=<%=userDetails.getDate() %>&gender=<%=userDetails.getGender() %>" method="post">
							<input type="submit" value="Edit Profile" class="edit">
						</form>
						<form action="UserDetailsServlet?task=history&customername=<%=session.getAttribute("customername") %>" method="post">
							<input type="submit" value="Order History" class="history">
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<p style="font-size: 20px; font-weight: normal; margin-top: 15px; left: 640px; position: relative; color: white;">FA Topgun 2018 ©</p>
	</div>
</body>
</html>