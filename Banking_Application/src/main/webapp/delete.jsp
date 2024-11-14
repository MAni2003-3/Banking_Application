<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Account</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
            color: #333;
            background-image: linear-gradient(75deg, skyblue, black);S
        }

		.title {
		  font-size: 25px;
		  font-weight: 600;
		  letter-spacing: -1px;
		  color: royalblue;
		  text-align: center;
		  margin-bottom: 4px;
		  margin-top:5px;
		  
		}
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: left;
            height: 300px;
        }

        label {
            display: block;
            margin-bottom: 12px;
            font-size: 14px;
            color: #333;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="email"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #4a90e2;
            box-shadow: 0 0 5px rgba(74, 144, 226, 0.2);
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 10px;
            border: none;
            border-radius: 5px;
            background-color: #d9534f;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>
    <form action="delete" method="POST">
    	<h2 class="title">Delete Account</h2>
        <label>Email: <input type="email" name="email" placeholder="Enter your email" required></label>
        <label>Password: <input type="password" name="password" placeholder="Enter your password" required></label>
        <button type="submit">Delete Account</button>
    </form>

</body>
</html>