<%@page import="dto.ProfileDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
        body {
        	width:100%;
        	height: 100vh;
        	display: flex;
        	align-items: center;
        	justify-content: center;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-image: linear-gradient(75deg, skyblue, black);
        }
        .container {
            max-width: 400px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: royalblue;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="tel"] {
            width: 90%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="text"]:focus, input[type="tel"]:focus {
            border-color: #28a745;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
            width: 100%;
        }
    </style>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<div class="container">
<%!ProfileDto p =new ProfileDto("John Doe",123456789012l,"ABCD123456",9876543210l,"Main Branch","123 Street Name");
	String message;
%>
<%if(request.getAttribute("profile") !=null){
	p = (ProfileDto) request.getAttribute("profile");}%>
	<%if(request.getAttribute("message")!=null){
		message = (String) request.getAttribute("message");
	%>
	<p style="color: red"><%=message %></p>
	<%} %>
    <h2>Bank Account Information</h2>
    <form>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="John Doe" value=<%=p.getName()%> required readonly>

        <label for="account">Account Number:</label>
        <input type="text" id="account" name="account" placeholder="123456789012" value=<%=p.getAccountNumber()%> required readonly>
        
        <label for="ifsc">IFSC Code:</label>
        <input type="text" id="ifsc" name="ifsc" placeholder="ABCD123456" value=<%= p.getIfscCode() %> required readonly>

        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" placeholder="9876543210" value=<%=p.getPhone() %> pattern="[0-9]{10}" required readonly>

        <label for="branch">Branch:</label>
        <input type="text" id="branch" name="branch" placeholder="Main Branch" value=<%=p.getBranch() %> required readonly>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" placeholder="123 Street Name" value=<%=p.getAddress() %> required readonly>
    </form>
</div>
</body>
</html>