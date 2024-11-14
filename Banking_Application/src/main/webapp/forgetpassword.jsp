<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: linear-gradient(75deg, skyblue, black);
        }
        form {
            background-color: #ffffff;
            padding: 40px;
            max-width: 400px;
            width: 100%;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            font-size: 24px;
            color: royalblue;
            margin-bottom: 10px;
            
        }
        p {
            color: #555;
            font-size: 14px;
            margin-bottom: 20px;
        }
        label {
            font-size: 14px;
            display: block;
            color: #333;
            margin-bottom: 8px;
            text-align: left;
            margin-left: 8px;
        }
        input[type="email"],
        input[type="password"] {
            width: 90%;
            padding: 12px 16px;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 16px;
            margin-bottom: 20px;
        }
        input[type="email"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #4a90e2;
        }
        button {
            background: teal;
            color: #fff;
            padding: 12px 0;
            width: 100%;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background: teal;
        }
    </style>
</head>
<body>
	<%!String password; %>
    <form action="forget" method="POST">
        <h2>Reset Your Password</h2>
        <p>Enter your email and new password below.</p>
         <%password =(String) request.getAttribute("password");
		if(password !=null){
		%>
		<p style="color: red"><%=password %></p>
		<%} %>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" required>
        
        <label for="new_password">New Password:</label>
        <input type="password" id="new_password" name="new_password" placeholder="Enter new password" required>

        <label for="confirm_password">Re-enter New Password:</label>
        <input type="password" id="confirm_password" name="confirm_password" placeholder="Re-enter new password" required>
        
        <button type="submit">Update Password</button>
    </form>

</body>
</html>