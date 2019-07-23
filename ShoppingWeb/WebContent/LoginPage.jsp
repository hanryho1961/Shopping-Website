<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style>
		body {
			height: 880px;
			
		}
		.body {
			overflow: hidden;
			border: 0px solid black;
			position: fixed;
			/* float: left;  */
			width:476px;
			height: 880px;
			padding: 0px;
			top: 0px;
			left: 0px;
			background-color: #d9d9d9;
			bottom: 0px;
		}
		.imageBody {
			overflow: hidden;
			border: 0px solid black;
			position: fixed;
			float: left;
			bottom: 0px;
			width: 964px;
			height: 880px;
			top: 0px;
			right: 0px;
			bottom: 0px;
		}
		#logoLeft {
			position: relative;
			margin-left: 190px;
			margin-top: 120px;
		}
		#username {
			margin-top: 10px;
			margin-left: 80px;
			width: 280px;
			height: 50px;
			font-size: 25px;
			padding-left: 10px;
		}
		#password {
			margin-top: 10px;
			margin-left: 80px;
			width: 280px;
			height: 50px;
			font-size: 25px;
			padding-left: 10px;
		}
		#message {
			font-size: 20px;
			color: red;
			font-weight: bold;
		}
		input[type="checkbox"] {
			float: left;
			margin-left: 40px;	
			margin-top: -10px;
			zoom: 2.0;
		}
		#remember {
			margin-top: -16px;
			margin-left: 10px;
			font-size: 20px;
			float: left;
		}
		.login {
			border-radius: 4px;
			border: 1px solid #a64dff;
			float: left;
			margin-left: 81px;
			margin-top: 0.4%;
			padding-left:26%;
			padding-right:26%;
			padding-top: 3%;
			padding-bottom: 3%;
			font-size: 20px;
			background-color: #a64dff;
			color: white;
		}
		.login:hover {
			border: 1px solid #8c1aff;
			background-color: #8c1aff;
			color: white;
		}
		#newUser {
			float: left;
			margin-top: 10px;
			margin-left: 150px;
			font-size: 20px;
		}
		#signup {
			margin-top: 10px;
			margin-left: 10px;
			text-decoration: none;
			font-size: 20px;
			float: left;
		}
		#facebook {
			border: 0px solid black;
			position: fixed;
			margin-top:550px;
			margin-left: 75px;
			width: 296px;
			height: 53px;
		}
		#google {
			border: 0px solid black;
			position: fixed;
			margin-top:610px;
			margin-left: 75px;
			width: 295px;
			height: 53px;
		}
		/* Shared */
		.loginBtn1 {
		  box-sizing: border-box;
		  position: relative;
		  /* width: 13em;  - apply for fixed size */
		  margin: 0em;
		  padding: 10px 46px 10px 70px;
		  border: none;
		  text-align: left;
		  line-height: 34px;
		  white-space: nowrap;
		  border-radius: 0.2em;
		  font-size: 20px;
		  color: #FFF;
		}
		.loginBtn1:before {
		  content: "";
		  box-sizing: border-box;
		  position: absolute;
		  top: 0;
		  left: 0px;
		  width: 50px;
		  height: 100%;
		}
		.loginBtn1:focus {
		  outline: none;
		}
		.loginBtn1:active {
		  box-shadow: inset 0 0 0 32px rgba(0,0,0,0.1);
		}
		.loginBtn2 {
		  box-sizing: border-box;
		  position: relative;
		  /* width: 13em;  - apply for fixed size */
		  margin: 0em;
		  padding: 10px 50px 10px 70px;
		  border: none;
		  text-align: left;
		  line-height: 34px;
		  white-space: nowrap;
		  border-radius: 0.2em;
		  font-size: 20px;
		  color: #FFF;
		}
		.loginBtn2:before {
		  content: "";
		  box-sizing: border-box;
		  position: absolute;
		  top: 0;
		  left: 0px;
		  width: 50px;
		  height: 100%;
		}
		.loginBtn2:focus {
		  outline: none;
		}
		.loginBtn2:active {
		  box-shadow: inset 0 0 0 32px rgba(0,0,0,0.1);
		}
		/* Facebook */
		.loginBtn--facebook {
		  background-color: #4C69BA;
		  background-image: linear-gradient(#4C69BA, #3B55A0);
		  /*font-family: "Helvetica neue", Helvetica Neue, Helvetica, Arial, sans-serif;*/
		  text-shadow: 0px -1px 0 #354C8C;
		}
		.loginBtn--facebook:before {
		  border-right: #364e92 1px solid;
		  background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_facebook.png') 15px 15px no-repeat;
		}
		.loginBtn--facebook:hover,
		.loginBtn--facebook:focus {
		  background-color: #5B7BD5;
		  background-image: linear-gradient(#5B7BD5, #4864B1);
		}
		/* Google */
		.loginBtn--google {
		  /*font-family: "Roboto", Roboto, arial, sans-serif;*/
		  background: #DD4B39;
		}
		.loginBtn--google:before {
		  border-right: #BB3F30 1px solid;
		  background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_google.png') 15px 15px no-repeat;
		}
		.loginBtn--google:hover,
		.loginBtn--google:focus {
		  background: #E74B37;
		}
		
	</style>
</head>
<body>
	<div class="body">
		<form action="LoginServlet?task=login" method="post">
			<img src="Images/logoLeft.png" height="90px" width = "90px" id="logoLeft">
			<input type="text" placeholder="Username" name="username" id="username">
			<input type="password" placeholder="Password" name="password" id="password">
			<br>
			<p align="center" id="message"><%=session.getAttribute("message")%></p>
			<br>
			<input type="checkbox" name="remember" value="remember" class="checkBox">
			<p id="remember">Remember me</p>
			<br>
			<input type="submit" value="Login" class="login">
		</form>
		<p id="newUser">New User ?</p>
		<a href="NewUser.jsp" id="signup">Signup</a> <!-- Change href to page to add account -->
	</div>
	<div id="facebook">
		<button class="loginBtn1 loginBtn--facebook">
  			Login with Facebook
		</button>
	</div>
	<div id="google">
		<button class="loginBtn2 loginBtn--google">
 			Signin with Google+
		</button>
	</div>
	<div class="imageBody">
		<img src="Images/right.png" height="880px" width="964px">
	</div>

</body>
</html>