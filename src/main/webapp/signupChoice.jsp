<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Signup</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(rgba(0,0,0,.5),rgba(0,0,0,.5)),
    url("https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=1600");
    background-size:cover;
    background-position:center;
}

.container{
    width:420px;
    background:white;
    padding:35px;
    border-radius:15px;
    text-align:center;
    box-shadow:0 0 15px rgba(0,0,0,.3);
}

h1{
    color:#e23744;
    margin-bottom:10px;
}

p{
    color:#555;
    margin-bottom:30px;
}

a{
    display:block;
    text-decoration:none;
    background:#e23744;
    color:white;
    padding:14px;
    border-radius:8px;
    margin-bottom:20px;
    font-size:18px;
    font-weight:bold;
}

a:hover{
    background:#c62839;
}

.back{
    background:#555;
}

.back:hover{
    background:#333;
}

</style>

</head>

<body>

<div class="container">

    <h1>Create Account</h1>

    <p>Select your account type</p>

    <a href="signup.jsp.jsp">
        👤 Customer Signup
    </a>

    <a href="adminSignup.jsp">
        🏪 Restaurant Admin Signup
    </a>

    <a href="login.jsp" class="back">
        ← Back to Login
    </a>

</div>

</body>
</html>