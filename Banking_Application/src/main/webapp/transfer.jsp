<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Transfer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-image: linear-gradient(75deg, skyblue, black);
        }
        form {
            width: 400px;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            box-sizing: border-box;
            margin: 20px 0 20px 0;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 40px;
        }
        label {
            font-size: 13px;
            display: block;
            color: #333;
            margin-bottom: 8px;
            text-align: left;
            margin-left:4px;
        }
        input[type="text"], input[type="password"], input[type="number"] {
            width: calc(100% - 10px); /* Adds right padding */
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 15px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="text"]:focus, input[type="password"]:focus, input[type="number"]:focus {
            border-color: #007bff;
            outline: none;
        }
        input::placeholder{
        	font-size: 13px;
        }
        button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 4px;
            background-color: teal;
            color: white;
            font-size: 16px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 10px;
            margin-bottom: 20px;
        }
        button:hover {
            background-color:teal;
        }
        
    </style>
</head>
<body>
	
	
	<%!String message; %>
	
    <form action="transfer" method="post" autocomplete="off">
        <h2>Transfer Amount</h2>
        <%if(request.getAttribute("message")!=null) {
		message = (String) request.getAttribute("message");%>
		<p style="color: red; text-align:center"><%=message %></p>
		<% }%>
        <label for="accountNumber">Bank Account</label>
        <input type="text" id="accountNumber" name="accountNumber" placeholder="Enter Account Number" required>

        <label for="ifscCode">IFSC Code</label>
        <input type="text" id="ifscCode" name="ifscCode" placeholder="Enter IFSC code" required>

        <label for="amount">Amount</label>
        <input type="number" id="amount" name="amount" min="1" placeholder="Enter Amount"  autocomplete="off" required>
        
        <label for="pin">PIN</label>
        <input type="password" id="pin" name="pin" placeholder="Enter pin" autocomplete="off" required>

        <button type="submit">Transfer</button>
    </form>

</body>
</html>