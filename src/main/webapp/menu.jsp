<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,com.tap.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurant Menu</title>
<link rel="icon"
      type="image/png"
      href="<%=request.getContextPath()%>/image/logo.png">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f8f8f8;
}

/* Restaurant Header */

.header{
    width:100%;
    height:250px;
    background:url("https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?w=1400") center/cover;
    display:flex;
    align-items:end;
}

.overlay{
    width:100%;
    background:rgba(0,0,0,0.5);
    padding:30px;
    color:white;
}

.overlay h1{
    font-size:38px;
}

.overlay p{
    margin-top:8px;
    font-size:18px;
}

/* Menu Section */

.container{
    width:90%;
    margin:40px auto;
}

.container h2{
    margin-bottom:25px;
    color:#333;
}

/* Cards */

.menu-grid{
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 15px;
    width: 100%;
}

.card{
    width: 100%;
    background: white;
    border-radius: 15px;
    overflow: hidden;
    box-shadow: 0 3px 10px rgba(0,0,0,0.15);
    transition: 0.3s;
}

.card:hover{
    transform:translateY(-5px);
}

.card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.content{
    padding:18px;
}

.top{
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.top h3{
    color:#222;
}

.price{
    color:#e23744;
    font-size:22px;
    font-weight:bold;
}

.desc{
    margin-top:10px;
    color:#666;
    line-height:1.5;
}

button{
    margin-top:18px;
    width:100%;
    padding:10px;
    border:none;
    background:#e23744;
    color:white;
    font-size:17px;
    border-radius:8px;
    cursor:pointer;
}

button:hover{
    background:#c91d2d;
}
.buttons{
    margin-top:30px;
    display:flex;
    justify-content:space-between;
}

button{
    padding:12px 24px;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-size:16px;
    transition:.3s;
}

.back-btn{
    display: block;
    width: fit-content;
    margin: 30px auto;   /* Top-Bottom 30px, Left-Right auto */
    background: #FF4D4D;
    color: white;
    text-decoration: none;
    padding: 10px 25px;
    border:none;
    border-radius: 6px;
    font-size: 17px;
    font-weight: bold;
}

</style>

</head>

<body>

<div class="header">

    <div class="overlay">
        <h1>Restaurant</h1>
        <p>order please</p>
    </div>

</div>


<div class="container">
    <h2>Recommended Menu</h2>

    <div class="menu-grid">

    <%
    List<Menu> allMenuByRestaurant = (List<Menu>)request.getAttribute("allMenuByRestaurant");
    if (allMenuByRestaurant != null && !allMenuByRestaurant.isEmpty()) {
        for(Menu menu : allMenuByRestaurant) {
    %>

        <div class="card">
            <img src="<%= menu.getImgurl() %>" alt="Menu Image">

            <div class="content">
                <div class="top">
                    <h3><%= menu.getNameofitem() %></h3>
                    <span class="price">₹<%= menu.getPrice() %></span>
                </div>

                <p>Category : <%= menu.getCategory() %></p>
                <p>Rating : <%= menu.getRating() %></p>
                
                <form action="callCartServlet">
				<input type="hidden" name="menu_id" value="<%= menu.getMenu_id() %>">
				<input type="hidden" name="res_id"value="<%=menu.getRes_id() %>">
				<input type="hidden" name="quantity"value="1">
				<input type="hidden" name="action" value="add">

                <button>Add to cart</button>
                </form>
            </div>
        </div>


    <%
        }
    }
    %>
    </div>
    <div>
    <button class="back-btn" onclick="history.back()">
← Back
</button>

    </div>
</div>				