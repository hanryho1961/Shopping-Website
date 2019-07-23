<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.OrderHistory"%>
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
	<title>Order History</title>
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
			overflow-y: scroll;
			position: relative;
			top: 0px;
			left: 50px;
			background-color: white;
			width: 1340px;
			height: 675px;
		}
		th, td {
			padding: 8px;
  			text-align: left;
  			border-bottom: 1px solid #ddd;
		}
	</Style>
</head>
<body>
	<div class="menu">
		<form action="CartPageServlet?task=home&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Logo3.png" alt="Logo" id="logo">
		</form>
		<form action="CartPageServlet?task=search" method="post">
			<input type="text" placeholder="Enter your search text" id="searchBox" name="searchBox"> 
			<input type="submit" value="Search" class="searchButton">
		</form>
		<form action="CustomerPageServlet?task=cart&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Cart.png" alt="Cart" id="shoppingCart">
		</form>
		<form action="CartPageServlet?task=details&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="submit" value="<%=session.getAttribute("customername") %>" id="loginButton">
		</form>
	</div>
	<div class="shade">
	</div>
	<div class="introduction">
		<div class="body">
			<h1 style="margin-left: 20px;">Order List</h1>
			<table style="border-top: 1px solid black; border-collapse: collapse; width: 1300px; margin-left: 20px">
				<tr>
					<th>No.</th>
					<th>Order Date</th>
					<th>Cost</th>
					<th>Action</th>
				</tr>
				<%
					ArrayList<OrderHistory> list = (ArrayList<OrderHistory>) session.getAttribute("list");
					SimpleDateFormat formater = new SimpleDateFormat("MM-dd-yyyy");
					int number = 1;
					for (OrderHistory orderHistory: list) {
				%>
					<tr>
						<td><%=number %></td>
						<% number = number + 1; %>
						<td><%=formater.format(orderHistory.getDateOrder()) %></td>
						<td><%=orderHistory.getCost() %></td>
						<td><a href="OrderDetail.jsp?orderid=<%=orderHistory.getOrderId() %>">Detail</a></td>
					</tr>
					
				<%
					}
				%>	
			</table>
		</div>		
		<p style="font-size: 20px; font-weight: normal; margin-top: 15px; left: 640px; position: relative; color: white;">FA Topgun 2018 ©</p>
	</div>
</body>
</html>