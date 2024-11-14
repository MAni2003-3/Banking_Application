
<%@page import="dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link rel="stylesheet" href="update.css">
</head>
<body>
    <section id="container" action="register">
<form class="form" action="update">
	<%!UserDto user = new UserDto("Enter_FirstName","Enter_lastname","",1234567890,"","01-jan-1900","","Enter_Address"); %>
	<%if(request.getAttribute("profile")!=null){
		user = (UserDto) request.getAttribute("profile");} %>
    <p class="title">Update Profile</p>
        <div class="flex">
        <label>FirstName
            <input class="input" type="text" value=<%=user.getfName() %> required name="Fname">
            
        </label>

        <label>LastName
            <input class="input" type="text" value=<%=user.getlName() %> required name="Lname">
        </label>
    </div>    
    <div class="column">
    <label>PhoneNumber
            <input class="input" type="telephone" value=<%=user.getPhNo() %> required name="phno">
        </label>
        <label>Enter DOB
           <input class="input" type="text" value=<%=user.getDOB() %> required name="DOB">
        </label>
    </div>
    <div class="gender-box">
        <label>Gender</label>
        <div class="gender-option">
          <div class="gender">
            <input name="gender" id="check-male" value="male" type="radio">
            <label for="check-male">Male</label>
          </div>
          <div class="gender">
            <input name="gender" id="check-female"  value = "female" type="radio">
            <label for="check-female">Female</label>
          </div>
          <div class="gender">
            <input name="gender" id="check-other" value="none" type="radio">
            <label for="check-other">Prefer not to say</label>
          </div>
        </div>
      </div>
    <label>Address
        <textarea rows="10" cols="60" value=<%=user.getAddress() %> name="address"></textarea>
    </label> 
    <button class="submit">Submit</button>
</form>
</section>
</body>
</html>