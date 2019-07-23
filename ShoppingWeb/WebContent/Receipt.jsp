<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
	<title>Receipt</title>
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
			/* background-image: url('Images/background.png'); */
			background-color: transparent;
			top: 0px;
			left: 50px;
			width: 1340px;
			height: 725px;
		}
		.imageleft {
			border: 0px solid black;
			background-color: transparent;
			float: left;
			margin-left: 2.5px;
			width: 360px;
			height: 724px;
		}
		.info {
			border: 1px solid black;
			background-color: white;
			float: left;
			width: 605px;
			height: 724px;
		
		}
		.imageright {
			border: 0px solid black;
			background-color: transparent;
			float: left;
			width: 360px;
			height: 724px;
		}
		.logo {
			border: 0.1px solid black;
			background-color: #4B4B4B;
			margin-top: 10px;
			margin-left: 2%;
			width: 96%;
			height: 150px;
		}
		#logoImage {
			width: 100px; 
			height: 100px; 
			padding-top: 4%; 
			padding-left: 40%;
		}
		.name {
			border: 0.1px solid black;
			background-color: #c4c4c4;
			margin-top: 1px;
			margin-left: 2%;
			width: 96%;
			height: 60px;
		}
		#nameInput {
			font-size: 30px;
			margin-top: 12px;
			margin-left: 26%;
		}
		.price {
			border: 0.1px solid black;
			background-color: white;
			margin-top: 1px;
			margin-left: 2%;
			width: 96%;
			height: 300px;
		}
		#priceInput {
			font-size: 100px;
			font-weight: bold;
			margin-top: 85px;
			text-align: center;
		}
		#buyInfo {
			font-size: 20px;
			margin-top: -100px;
			text-align: center;
			
		}
		.date {
			border: 0.1px solid black;
			background-color: #c4c4c4;
			margin-top: 1px;
			margin-left: 2%;
			width: 96%;
			height: 60px;
		}
		#paid {	
			font-size: 30px;
			margin-top: 12px;
			text-align: center;
		}
		.greet {
			border: 0.1px solid black;
			background-color: #c4c4c4;
			margin-top: 1px;
			margin-left: 2%;
			width: 96%;
			height: 60px;
		}
		#greeting {
			font-size: 30px;
			margin-top: 12px;
			text-align: center;
		}
		.end {
			border: 0.1px solid black;
			background-color: #4B4B4B;
			margin-top: 1px;
			margin-left: 2%;
			width: 96%;
			height: 60px;
		}
	</Style>
</head>
<body>
	<div class="menu">
		<form action="ReceiptServlet?task=home&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Logo3.png" alt="Logo" id="logo">
		</form>
		<form action="ReceiptServlet?task=search" method="post">
			<input type="text" placeholder="Enter your search text" id="searchBox" name="searchBox"> 
			<input type="submit" value="Search" class="searchButton">
		</form>
		<form action="CustomerPageServlet?task=cart&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Cart.png" alt="Cart" id="shoppingCart">
		</form>
		<form action="ReceiptServlet?task=details&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="submit" value="<%=session.getAttribute("customername") %>" id="loginButton">
		</form>
	</div>
	<div class="shade">
	</div>
	<div class="introduction">
		<div class="body">	
			<div class="imageleft"></div>
			<div class="info">
				<div class="logo">
					<input type="image" src="Images/Logo3.png" alt="Logo" id="logoImage">
				</div>
				<div class="name">
					<p id="nameInput">Your Shop Cart Receipt</p>
				</div>
				<div class="price">
					<p id="priceInput">$<%=session.getAttribute("total") %></p>
					<p id="buyInfo">Buying Products</p>
				</div>
				<div class="date">
					<% 
						Date date = (Date) session.getAttribute("date");
						SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
					%>
					<p id="paid">Paid on <%=df.format(date) %></p>
				</div>
				<div class="greet">
					<p id="greeting">Thanks for your business!</p>
				</div>
				<div class="end">
				</div>
			</div>
			<div class="imageright"></div>
		</div>
		<p style="font-size: 20px; font-weight: normal; margin-top:15px; left: 640px; position: relative; color: white;">FA Topgun 2018 ©</p>
	</div>
</body>
</html>