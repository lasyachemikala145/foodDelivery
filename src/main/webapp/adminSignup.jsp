<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurant Admin Sign Up</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:linear-gradient(rgba(0,0,0,0.55),rgba(0,0,0,0.55)),
    url("https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=1600");
    background-size:cover;
    background-position:center;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.signup-box{
    width:430px;
    background:#fff;
    padding:35px;
    border-radius:15px;
    box-shadow:0 8px 25px rgba(0,0,0,.25);
}

.signup-box h1{
    color:#e23744;
    text-align:center;
    margin-bottom:25px;
}

.input-box{
    margin-bottom:15px;
}

.input-box label{
    display:block;
    margin-bottom:5px;
    font-weight:bold;
}

.input-box input{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
}

button{
    width:100%;
    padding:13px;
    border:none;
    background:#e23744;
    color:white;
    font-size:17px;
    border-radius:8px;
    cursor:pointer;
}

button:hover{
    background:#c71f2f;
}

.bottom{
    text-align:center;
    margin-top:20px;
}

.bottom a{
    color:#e23744;
    text-decoration:none;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="signup-box">

<h1>Restaurant Admin Registration</h1>

<form action="./callsignupServlet" method="post">

<input type="hidden" name="role" value="admin">



<div class="input-box">
<label>Email</label>
<input type="email" name="email" required>
</div>

<div class="input-box">
<label>Password</label>
<input type="password" name="password" required>
</div>

<div class="input-box">
<label>Restaurant ID</label>
<input type="number" name="restaurant_id" required>
</div>

<button type="submit">
Create Admin Account
</button>

<%
String msg=(String)request.getAttribute("errorMessage");
if(msg!=null){
%>

<p style="color:red;text-align:center;margin-top:15px;">
<%=msg%>
</p>

<%
}
%>

</form>

<div class="bottom">
<a href="signup.jsp">← Back</a>
</div>

</div>

</body>
</html>