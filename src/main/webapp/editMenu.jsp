<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.Menu"%>

<%
Menu menu = (Menu) request.getAttribute("menu");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Menu Item</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:Arial,sans-serif;
}

body{
	background:#f5f6fa;
}

.container{
	width:500px;
	margin:40px auto;
	background:white;
	padding:30px;
	border-radius:10px;
	box-shadow:0 0 10px rgba(0,0,0,.2);
}

h2{
	text-align:center;
	color:#e23744;
	margin-bottom:25px;
}

.input-box{
	margin-bottom:18px;
}

.input-box label{
	display:block;
	margin-bottom:8px;
	font-weight:bold;
}

.input-box input{
	width:100%;
	padding:10px;
	border:1px solid #ccc;
	border-radius:6px;
	font-size:15px;
}

.btn{
	width:100%;
	padding:12px;
	background:#e23744;
	color:white;
	border:none;
	border-radius:6px;
	font-size:16px;
	cursor:pointer;
}

.btn:hover{
	background:#c62839;
}

.back{
	display:block;
	text-align:center;
	margin-top:15px;
	text-decoration:none;
	font-weight:bold;
	color:#333;
}

</style>

</head>
<body>

<div class="container">

<h2>Edit Menu Item</h2>

<form action="updateMenu" method="post">

<input type="hidden" name="menu_id"
value="<%=menu.getMenu_id()%>">

<input type="hidden" name="res_id"
value="<%=menu.getRes_id()%>">

<div class="input-box">

<label>Item Name</label>

<input type="text"
name="nameofitem"
value="<%=menu.getNameofitem()%>"
required>

</div>

<div class="input-box">

<label>Price</label>

<input type="number"
step="0.01"
name="price"
value="<%=menu.getPrice()%>"
required>

</div>

<div class="input-box">

<label>Rating</label>

<input type="number"
step="0.1"
name="rating"
value="<%=menu.getRating()%>"
required>

</div>

<div class="input-box">

<label>Category</label>

<input type="text"
name="category"
value="<%=menu.getCategory()%>"
required>

</div>

<div class="input-box">

<label>Image URL</label>

<input type="text"
name="imgurl"
value="<%=menu.getImgurl()%>"
required>

</div>

<button class="btn" type="submit">

Update Menu

</button>

</form>

<a href="manageMenu" class="back">

← Back

</a>

</div>

</body>
</html>