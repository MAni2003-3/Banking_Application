<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
	<link rel="stylesheet" href="index.css">
</head>
<body>
	<div class="container">
		<h2>Hey!! Welcome to </h2>
		<h1>Trust Motive Bank</h1>
		<h4>Building trust, securing your future.<br><br>Your trust, our foundation.</h4>
	</div>
	<form class="form" method="post" action="login">
	<%!String email;
		String password;
	%>
		<span class="input-span">
			<label for="email" class="label">Email</label>
			<input type="email" name="email" id="email" />
			<%String email= (String) request.getAttribute("email");
			if(email!=null){%>
			<p style="color: red"><%=email%></p>
			<%} %>
			</span>
		<span class="input-span">
			<label for="password" class="label">Password</label>
			<input type="password" name="password" id="password" />
			<%String password= (String) request.getAttribute("password");
			if(password!=null){%>
			<p style="color: red"><%=password%></p>
			<%} %>
			</span>
		<span class="span"><a href="forgetpassword.jsp">Forgot password?</a></span>
		<input class="submit" type="submit" value="Log in" />
		<span class="span">Don't have an account? <a href="register.jsp">Sign up</a></span>
	</form>
	
	
</body>
</html>