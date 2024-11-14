<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance</title>
<style type="text/css">
body {
   background-image: linear-gradient(75deg, skyblue, black);
   height: 100vh;
   display: flex;
   justify-content: center;
   align-items: center;
   margin: 0;
}
#container {
   margin-top: 15px;
   margin-right:50px;
}
.form {
  width:350px;
  display: flex;
  flex-direction: column;
  gap: 12px; 
  max-width: 500px;
  padding: 20px;
  border-radius: 20px;
  background-color: white;
  color: black;
  border: 1px solid black;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
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
.form label {
  position: relative;
  margin-left:9px;
}

.form label .input {
  background-color: white;
  color: black;
  width: 90%;
  padding: 15px 10px;
  outline: 0;
  border: 2px solid rgba(105, 105, 105, 0.5);
  border-radius: 10px;
  font-size: 1em;
}

.input {
  font-size: medium;
}

.submit {
  border: none;
  outline: none;
  padding: 10px;
  border-radius: 10px;
  color: white;
  font-size: 16px;
  background-color: blue;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit:hover {
  background-color: skyblue;
}
</style>
</head>
<body>
<section id="container">
  <form class="form" method="post" action="balance">
    <h2 class="title">Check Balance</h2>
    <%!String message; %>
    <%if(request.getAttribute("message")!=null){
    	message = (String) request.getAttribute("message");%>
    	<p style="color: red; text-align:center"><%=message %></p>
    <%} %>
    <label>
      <input class="input" type="tel" placeholder="Enter phone number" required name="phno" pattern="\d{10}">
    </label>
    <label>
      <input class="input" type="password" placeholder="Enter 6-digit pin" minlength="6" maxlength="6" required name="pin">
    </label>
    <label>
      <input class="input" type="password" placeholder="Re-enter pin" minlength="6" maxlength="6" required name="confirmPin">
    </label>
    <button type="submit" class="submit">Submit</button>
  </form>
</section>
</body>
</html>