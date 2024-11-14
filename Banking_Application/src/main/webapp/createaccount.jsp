<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="create1.css">
</head>
<body>  
    <section id="container">
        <div class="form-container1">
            <h2 class="title">Create account</h2>
            <%!String message; %>
            <%if(request.getAttribute("message")!=null){
            	message = (String) request.getAttribute("message");%>
            	<p style="color: red; text-align:center"><%=message %></p> 
            <%} %>
            <form class="form" action="createaccount">
                <div class="input-box address">
                    <div class="column">
                        <div class="select-box">
                            <select name="type" required>
                                <option value="" hidden>Type</option>
                                <option value="Savings Account">Savings Acccount</option>
                                <option value="Salary Account">Salary Account</option>
                                <option value="Current Account">Current Account</option>
                                <option value="DEMAT Account">DEMAT Account</option>
                            </select>
                        </div><br>
                        <div class="select-box">
                            <select name="branch" required>
                                <option value="" hidden>Branch</option>
                                <option value="Kukatpally">Kukatpally</option>
                                <option value="Secundrabad">Secundrabad</option>
                                <option value="Punjagutta">Punjagutta</option>
                                <option value="JubliHills">JubliHills</option>
                            </select>
                        </div>
                    </div>
                </div>
                
                <input type="number" name="balance" class="input" placeholder="Enter amount to deposite" required>
                <input type="password" name="pin" class="input" placeholder="6-digit pin" minlength="6" maxlength="6" required>
                <input type="password" name="confrim_pin" class="input" placeholder="Confirm pin" minlength="6" maxlength="6" required>
                
                <button type="submit" class="form-btn">Create account</button>
            </form>
        </div>
    </section>
</body>
</html>