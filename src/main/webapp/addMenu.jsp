
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Menu Item</title>

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
    box-shadow:0 0 10px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    margin-bottom:25px;
    color:#e23744;
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
    cursor:pointer;
    font-size:16px;
}

.btn:hover{
    background:#c62839;
}

.back-btn{
    display:block;
    margin-top:15px;
    text-align:center;
    text-decoration:none;
    color:#333;
    font-weight:bold;
}

</style>

</head>
<body>

<div class="container">

<h2>Add Menu Item</h2>

<form action="addMenu" method="post">

<div class="input-box">
<label>Item Name</label>
<input type="text" name="nameofitem" required>
</div>

<div class="input-box">
<label>Price</label>
<input type="number" step="0.01" name="price" required>
</div>

<div class="input-box">
<label>Rating</label>
<input type="number" step="0.1" name="rating" required>
</div>

<div class="input-box">
<label>Category</label>
<input type="text" name="category" required>
</div>

<div class="input-box">
<label>Image URL</label>
<input type="text" name="imgurl" required>
</div>

<!-- Temporary Restaurant ID -->
<input type="hidden" name="res_id" value="1">

<button class="btn" type="submit">
Add Menu Item
</button>

</form>

<a href="manageMenu" class="back-btn">← Back to Manage Menu</a>

</div>

</body>
</html>