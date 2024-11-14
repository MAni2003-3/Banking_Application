<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">
body{
	background-image: linear-gradient(75deg, skyblue,black);
	display :flex;
	align-items: center;
	justify-content: center;
}
.form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  max-width: 400px;
  padding: 0 20px 0 30px;
  border-radius: 20px;
  position: relative;
  background-color: white;
  color: black;
  border: 1px solid black;
}

.title {
  font-size: 28px;
  font-weight: 600;
  letter-spacing: -1px;
  position: relative;
  display: flex;
  align-items: center;
  padding-left: 30px;
  color: #0075BE;
}

.title::before {
  width: 28px;
  height: 18px;
}

.title::after {
  width: 18px;
  height: 18px;
  animation: pulse 1s linear infinite;
}

.title::before,
.title::after {
  position: absolute;
  content: "";
  height: 16px;
  width: 16px;
  border-radius: 50%;
  left: 0px;
  background-color: #00bfff;
}

.message{
	margin-top: -20px;
}
.message, 
.signin {
  font-size: 16px;
  color: black;
}

.signin {
  text-align: center;
}

.signin a:hover {
  text-decoration: underline royalblue;
}

.flex {
  display: flex;
  width: 100%;
  gap: 6px;
}
.column {
  display: flex;
  width: 100%;
  gap: 6px;
}

.form label {
  position: relative;
  margin-left: 1px;
  color: black;
}

.form label .input {
  background-color: white;
  width: 90%;
  padding: 20px 05px 05px 10px;
  outline: 0;
  border: 2px solid rgba(105, 105, 105, 0.397);
  border-radius: 10px;
  font-size: 0.9em;
  margin-left: -4px;
  margin-top:2px;
}

textarea{
	marign-top: 10px;
	margin-left: -10px;
	resize: none;
	outline: none;
	border-radius: 10px;
	border:  2px solid rgba(105, 105, 105, 0.397);
}

.form label .input:placeholder-shown {
  font-size: 0.9em;
}

.form label .input:focus + span,
.form label .input:valid + span {
  color: skyblue;
  top: 0px;
  font-size: 0.6em;
  font-weight: 600;
}
.form .gender-box {
  margin-top: 10px;
}

.form :where(.gender-option, .gender) {
  display: flex;
  align-items: center;
  column-gap: 20px;
  flex-wrap: wrap;
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
  transform: .3s ease;
  background-color: teal;
}

.submit:hover {
  background-color: teal;
}

@keyframes pulse {
  from {
    transform: scale(0.9);
    opacity: 1;
  }

  to {
    transform: scale(1.8);
    opacity: 0;
  }
}
</style>
</head>
<body>
<%!String email="null";
	String password ="null";
%>
<section id="container">
<form class="form" action="register">
    <p class="title">Register </p>
    <p class="message">Signup now and get full access to our app. </p>
    <%if(request.getAttribute("email")!=null){
    	email = (String) request.getAttribute("email");%>
    	<p style="color:red"><%=email %></p>
    <%}%>
    <div class="flex">
        <label>FirstName
            <input class="input" type="text" placeholder="Enter FirstName" required="" name="Fname">
            
        </label>

        <label>LastName
            <input class="input" type="text" placeholder="Enter lastname" required name="Lname">
        </label>
    </div>    
    <div class="column">
    <label>PhoneNumber
            <input class="input" type="telephone" placeholder="Enter phno" required name="phno">
        </label>
        <label>Enter DOB
           <input class="input" type="text" placeholder="01-jan-1900" required name="DOB">
        </label>
    </div>
     <label>Email
        <input class="input" type="text" placeholder="enter email" required name="email">
    </label>
    <div class="gender-box">
        <label>Gender</label>
        <div class="gender-option">
          <div class="gender">
            <input name="gender" id="check-male" type="radio" value="male">
            <label for="check-male">Male</label>
          </div>
          <div class="gender">
            <input name="gender" id="check-female" type="radio" value="female">
            <label for="check-female">Female</label>
          </div>
          <div class="gender">
            <input name="gender" id="check-other" type="radio" value="none">
            <label for="check-other">Prefer not to say</label>
          </div>
        </div>
      </div> 
     <label>Address
        <textarea rows="10" cols="50" name="address"></textarea>
    </label> 
        
    <label>Password
        <input class="input" type="password" placeholder="enter password" required name="password">
    </label>
    <%if(request.getAttribute("password")!=null){
    	password = (String) request.getAttribute("password");%>
    	<p style="color:red"><%=password %></p>
    <%}%>
    <label>Confirm Password
        <input class="input" type="password" placeholder="confirm password" name="confrimpassword" required>
    </label>
    <button class="submit">Submit</button>
    <p class="signin">Already have an account ? <a href="index.jsp">Sign in</a> </p>
</form>
</section>
</body>
</html>