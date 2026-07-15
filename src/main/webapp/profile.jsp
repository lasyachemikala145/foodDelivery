<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User"%>

<%
User user = (User)request.getAttribute("user");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>My Profile</title>
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

background:#f5f5f5;

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

width:60%;
margin:50px auto;

}

.card{

background:white;
padding:35px;
border-radius:15px;
box-shadow:0 3px 12px rgba(0,0,0,.15);

}

.card h2{

margin-bottom:25px;
color:#ff4d4d;

}

.row{

margin:20px 0;

}

.label{

font-weight:bold;

}

.value{

margin-top:5px;
color:#555;

}

button{

margin-top:30px;
padding:12px 25px;
background:#ff4d4d;
color:white;
border:none;
border-radius:8px;
font-size:16px;
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

<a href="callRestaurantServlet">Home</a>

<a href="LogoutServlet">Logout</a>

</div>

</div>

<div class="container">

<div class="card">

<h2>My Profile</h2>

<div class="row">

<div class="label">

Name

</div>

<div class="value">

<%=user.getUserName()%>

</div>

</div>

<div class="row">

<div class="label">

Email

</div>

<div class="value">

<%=user.getEmail()%>

</div>

</div>
<div class="row">

    <div class="label">
        Phone
    </div>

    <div class="value">
        <%= user.getPhone() %>
    </div>

</div>

<div class="row">

<div class="label">

Address

</div>

<div class="value">

<%=user.getAddress()%>

</div>

</div>

<div class="row">

<div class="label">

Role

</div>

<div class="value">

<%=user.getRole()%>

</div>

</div>

<form action="editAddress.jsp" method="get">
    <button type="submit">
        Edit Address
    </button>
</form>

</div>

</div>

</body>

</html>