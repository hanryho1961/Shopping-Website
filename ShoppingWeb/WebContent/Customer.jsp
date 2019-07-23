<%@page import="entities.DanhMuc"%>
<%@page import="model.DanhMucModel"%>
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
	<title>Customer</title>
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
  			height: 400px; 
		}
		.body {
			overflow: hidden;
  			background-color: #d9d9d9;
  			margin-top: 0px;
  			width: 1440px; /* Full width */
  			height: 1320px; 
		}
		td {
			background-color: white;
			width: 240px;
			height: 350px;
		}
		p {
			margin: 10px;
			font-size: 15px;
		}
		#buyNow {
			border-radius: 4px;
			border: none;
			float: left;
			margin-left: 0%;
			margin-top: 0%;
			padding-left:20%;
			padding-right:20%;
			padding-top:6%;
			padding-bottom: 6%;
			font-size: 15px;
			background-image: linear-gradient(to right, #00B9FF , #0004FF);
			color: white;
		}
		#addCart {
			border-radius: 4px;
			border: none;
			float: left;
			margin-left: 0%;
			margin-top: 0%;
			padding-left:11%;
			padding-right:11%;
			padding-top:6%;
			padding-bottom: 6%;
			font-size: 15px;
			background-image: linear-gradient(to right, #ff80b3 , #ff0066);
			color: white;
		}
		.category {
			border: 1px solid black;
			background-color: white;
			float: left;
			margin-left: 100px;
			margin-top: 17px;
			width: 250px;
			height: 360px;
		}
		.categoryTitle {
			border: 0px solid black;
			width: 100%;
			height: 60px;
		}
		.categoryMenu {
			border: 0px solid black;
			overflow-y: scroll;
			width: 100%;
			height: 295px;
		}
		.newProduct {
			border: 1px solid black;
			background-color: white;
			float: left;
			margin-left: 10px;
			margin-top: 17px;
			width: 990px;
			height: 360px;
		}
		.title {
			border: 1px solid black;
			width: 100%;
			height: 60px;
		}
		.product {
			border: 1px solid black;
			width: 100%;
			height: 298px;
		}
		.work {
			border-right: 1px solid black;
			width: 49.5%;
			float: left;
			height: 298px;
			margin-left: 0.25%;
		}
		.workImage {
			border-right: 1px solid black;
			width: 49%;
			float: left;
			height: 298px;
		}
		.workInfo {
			border: 0px solid black;
			width: 50%;
			float: left;
			height: 298px;
		}
		.workDetail {
			border-bottom: 1px solid black;
			width: 100%;
			height: 80%;
		}
		.workAction {
			border: 0px solid black;
			width: 100%;
			height: 19%;
		}
		.game {
			border: 0px solid black;
			width: 49.5%;
			float: left;
			height: 298px;
		}
	</Style>
</head>
<body>
	<%-- <% System.out.println(request.getParameter("sanPham")); %> --%>
	<div class="menu">
		<input type="image" src="Images/Logo3.png" alt="Logo" id="logo">
		<form action="CustomerPageServlet?task=search" method="post">
			<input type="text" placeholder="Enter your search text" id="searchBox" name="searchBox"> 
			<input type="submit" value="Search" class="searchButton">
		</form>
		<form action="CustomerPageServlet?task=cart&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="image" src="Images/Cart.png" alt="Cart" id="shoppingCart">
		</form>
		<form action="CustomerPageServlet?task=details&customername=<%=session.getAttribute("customername") %>" method="post">
			<input type="submit" value="<%=session.getAttribute("customername") %>" id="loginButton">
		</form>
	</div>
	<div class="shade">
	</div>
	<div class="introduction">
		<div class="category">
			<div class="categoryTitle">
				<p style="font-size: 30px; text-align: center;">Category</p>
			</div>
			<div class="categoryMenu">
				<%
					DanhMucModel danhMucModel = new DanhMucModel();
					ArrayList<DanhMuc> listDanhMuc = danhMucModel.getList();
					for (DanhMuc danhMuc : listDanhMuc) {
				%>
					<a href="CustomerProduct.jsp?madm=<%=danhMuc.getMadm() %>&customername=<%=session.getAttribute("customername") %>" style="font-size: 20px; text-decoration: none; margin-left: 10px"><%=danhMuc.getTendm() %></a>
					<br>
				<% } %>
			</div>
		</div>
		<div class="newProduct">
			<div class="title">
				<p style="text-align: center; font-size: 30px; font-weight: bold; margin-top: 13px;">Famous Products of the Month </p>
			</div>
			<div class="product">
				<div class="work">
					<div class="workImage">
						<img src="Images/h3.png" alt="Image not found" onerror="this.src='Images/Mountain.png';" height="99%" width="99%">
					</div>
					<div class="workInfo">
						<div class="workDetail">
							<p style="float: left; font-size: 20px; font-weight: bold;">Product: </p>
							<p style="float: left; font-size: 20px;">iPhone Xs </p> <br>
							<p style="float: left; font-size: 20px; font-weight: bold;">Price: </p>
							<p style="float: left; font-size: 20px;">1149 USD </p>
							<p style="float: left; font-size: 20px; font-weight: bold;">Product of: </p>
							<p style="float: left; font-size: 20px;">Apple </p>
							<p style="float: left; font-size: 20px; font-weight: bold;">Best for: </p>
							<p style="font-size: 20px; text-align: center;">Work/Entertainment </p>
						</div>
						<div class="workAction">
							<div style="border: 0px solid black; float: left; margin-top: 15px; margin-left: 15px; width: 100px; height: 30px">
								<form action="CustomerPageServlet?task=pay&masp=APL03&total=1149&customername=<%=session.getAttribute("customername") %>" method="post">
									<input type="submit" value="Buy Now" id="buyNow">
								</form>
							</div>
							<div style="border: 0px solid black; float: left; margin-top: 15px; margin-left: 13px; width: 100px; height: 30px">
								<form action="CustomerPageServlet?task=addCart&masp=APL03&customername=<%=session.getAttribute("customername") %>" method="post">
									<input type="submit" value="Add to Cart" id="addCart">
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="game">
					<div class="workImage">
						<img src="Images/h9.png" alt="Image not found" onerror="this.src='Images/Mountain.png';" height="99%" width="99%">
					</div>
					<div class="workInfo">
						<div class="workDetail">
							<p style="float: left; font-size: 20px; font-weight: bold;">Product: </p>
							<p style="float: left; font-size: 20px;">ROG Phone </p> <br>
							<p style="float: left; font-size: 20px; font-weight: bold;">Price: </p>
							<p style="float: left; font-size: 20px;">1500 USD </p>
							<p style="float: left; font-size: 20px; font-weight: bold;">Product of: </p>
							<p style="float: left; font-size: 20px;">ASUS </p>
							<p style="float: left; font-size: 20px; font-weight: bold;">Best for: </p>
							<p style="font-size: 20px; text-align: center;">Entertainment/Gaming </p>
						</div>
						<div class="workAction">
							<div style="border: 0px solid black; float: left; margin-top: 15px; margin-left: 15px; width: 100px; height: 30px">
								<form action="CustomerPageServlet?task=payNow&masp=AS01&total=1500&customername=<%=session.getAttribute("customername") %>" method="post">
									<input type="submit" value="Buy Now" id="buyNow">
								</form>
							</div>
							<div style="border: 0px solid black; float: left; margin-top: 15px; margin-left: 13px; width: 100px; height: 30px">
								<form action="CustomerPageServlet?task=addCart&masp=AS01&customername=<%=session.getAttribute("customername") %>" method="post">
									<input type="submit" value="Add to Cart" id="addCart">
								</form>
							</div>
	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="body">
		<label style="float: left; font-size:20px; margin-left: 62%; margin-top:1.3%">Sort by</label>
		<select style="float: left; margin-top: 1.0%; margin-left: 1%; width: 150px; -webkit-appearance: menulist-button;
   		height: 35px;" name="sortby">
			<option selected></option> 
			<option value="price(L)">Price(Low-High)</option>
			<option value="price(H)">Price(High-Low)</option>
			<option value="name">Name</option>
		</select>
		<label style="float:left; font-size:20px; margin-left: 4%; margin-top:1.3%">Page</label>
		<select style="float: left; margin-top: 1.0%; margin-left: 1%; width: 150px; -webkit-appearance: menulist-button;
   		height: 35px;" name="page"> 
			<option value="page1" selected>Page 1</option>
			<option value="page2">Page 2</option>
			<option value="page3">Page 3</option>
		</select>
		<% ArrayList<SanPham> list =  (new SanPhamModel()).getList(); %>
		<c:set var="total" value="<%=list.size() %>" scope="session" />
		<c:set var="count" value="0" scope="session" />
		<c:set var="row" value="1" scope="session"/>
		<table cellspacing="40">
			<tr>
				<c:forEach var="sanPham" items="<%=list %>">	
					<c:if test="${count % 5 == 0 && count != 0}">
						<c:set var="row" value="${row + 1}" scope="session"/>
						</tr>
						<c:if test="${ row < 4}">
							<tr>
						</c:if>
					</c:if>	
					<c:if test="${ row < 4}">
						<td>
							<div style="border: 0px solid black; margin-top: 0px; margin-left: 45px; width: 150px; height: 200px;">
								<img src="Images/${sanPham.hinh}" alt="Image not found" onerror="this.src='Images/Mountain.png';" height="200px" width="150px">
							</div>
							<div style="border: 0px solid black; float: left; margin-top: 15px; margin-left: 10px; width: 215px; height: 60px">
								<p>Product: ${sanPham.tensp }</p>
								<p>Price: ${sanPham.gia } USD</p>
							</div>
							<div style="border: 0px solid black; float: left; margin-top: 15px; margin-left: 10px; width: 100px; height: 30px">
								<form action="CustomerPageServlet?task=payNow&customername=<%=session.getAttribute("customername") %>&total=${sanPham.gia }&masp=${sanPham.masp }" method="post">
									<input type="submit" value="Buy Now" id="buyNow">
								</form>
							</div>
							<div style="border: 0px solid black; float: left; margin-top: 15px; margin-left: 13px; width: 100px; height: 30px">
								<form action="CustomerPageServlet?task=addCart&masp=${sanPham.masp }&customername=<%=session.getAttribute("customername") %>" method="post">
									<input type="submit" value="Add to Cart" id="addCart">
								</form>
							</div>
						</td>
						<c:set var="count" value="${count + 1 }" scope="session" />
					</c:if>
				</c:forEach>
		</table>
		<c:choose>
			<c:when test="${row == 1 && count == 0 }">
				<p style="font-size: 20px; font-weight: normal; margin-top: 1155px; margin-left: 650px; ">FA Topgun 2018 ©</p>
			</c:when>
			<c:when test="${row == 1 && count > 0 && count < 6}">
				<p style="font-size: 20px; font-weight: normal; margin-top: 800px; margin-left: 650px; ">FA Topgun 2018 ©</p>
			</c:when>
			<c:when test="${row == 2 && count > 5 && count < 11 }">
				<p style="font-size: 20px; font-weight: normal; margin-top: 410px; margin-left: 650px; ">FA Topgun 2018 ©</p>
			</c:when>
			<c:otherwise>
				<p style="font-size: 20px; font-weight: normal; margin-top: 20px; margin-left: 650px; ">FA Topgun 2018 ©</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>