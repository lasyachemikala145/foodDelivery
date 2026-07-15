<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User" %>

<%
User user = (User)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Address</title>
<link rel="icon"
      type="image/png"
      href="<%=request.getContextPath()%>/image/logo.png">
<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    background:#f4f4f4;
}

.navbar{
    background:#ff4d4d;
    color:white;
    padding:18px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.logo{
    display:flex;
    align-items:center;
    gap:10px;
    color:#ff5200;
    font-size:30px;
    font-weight:bold;
}

.logo img{
    width:50px;
    height:50px;
    object-fit:contain;
}

.navbar a{
    color:white;
    text-decoration:none;
    margin-left:25px;
    font-size:18px;
}

.container{
    width:500px;
    margin:60px auto;
}

.card{
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0 2px 10px rgba(0,0,0,.2);
}

h2{
    color:#ff4d4d;
    margin-bottom:25px;
}

label{
    font-weight:bold;
    display:block;
    margin-top:15px;
}

.current{
    background:#f7f7f7;
    padding:12px;
    border-radius:8px;
    margin-top:8px;
}

textarea{
    width:100%;
    height:120px;
    margin-top:10px;
    padding:10px;
    border-radius:8px;
    border:1px solid #ccc;
    resize:none;
    font-size:16px;
}

button{
    width:100%;
    margin-top:25px;
    padding:14px;
    background:#ff4d4d;
    color:white;
    border:none;
    border-radius:8px;
    font-size:18px;
    cursor:pointer;
}

button:hover{
    background:#e53935;
}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">
    <img src="<%=request.getContextPath()%>/image/logo.png" alt="Logo">
    <span>TasteIt</span>
</div>

<div>
<a href="ProfileServlet">Profile</a>
<a href="callRestaurantServlet">Home</a>
</div>

</div>

<div class="container">

<div class="card">

<h2>Edit Address</h2>

<form action="UpdateAddressServlet" method="post">

<label>Current Address</label>

<div class="current">
<%=user.getAddress()%>
</div>

<label>New Address</label>

<textarea name="address"
placeholder="Enter your new address"
required></textarea>

<button type="submit">
Update Address
</button>

</form>

</div>

</div>

</body>

</html>