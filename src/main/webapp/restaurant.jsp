<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="com.tap.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurent" %>
<%
User loggedInUser = (User) session.getAttribute("user");

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TasteIt</title>
<link rel="icon" type="image/png" href="image/logo.png">
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

/* ================= NAVBAR ================= */
.profile-menu{
    position:relative;
    display:inline-block;
}

.profile-circle{
    width:42px;
    height:42px;
    border-radius:50%;
    background:white;
    color:#ff4d4d;
    font-size:20px;
    font-weight:bold;
    display:flex;
    justify-content:center;
    align-items:center;
    cursor:pointer;
    border:2px solid white;
}

.dropdown{
    position:absolute;
    top:45px;
    right:0;
    width:180px;
    background:white;
    border-radius:10px;
    box-shadow:0 5px 20px rgba(0,0,0,.25);
    overflow:hidden;

    visibility:hidden;
    opacity:0;

    transition:0.2s;
    z-index:999;
}

/* This removes the gap between profile and dropdown */
.profile-menu::after{
    content:"";
    position:absolute;
    top:42px;
    right:0;
    width:180px;
    height:15px;
}

.profile-menu:hover .dropdown{
    visibility:visible;
    opacity:1;
}

.user-name{
    padding:15px;
    text-align:center;
    font-size:17px;
    font-weight:bold;
    color:black !important;
}

.dropdown hr{
    margin:0;
    border:1px solid #eee;
}

.dropdown a{
    display:block;
    padding:12px 15px;
    text-decoration:none;
    color:black !important;
    font-size:16px;
    font-weight:600;
}

.dropdown a:hover{
    background:#ff4d4d;
    color:white !important;
}

.navbar{
    background: #ff4d4d;
    display: flex;
    justify-content: space-between;
    align-items: center;

    padding: 8px 50px;

    position: fixed;
    top: 0;
    left: 0;
    width: 100%;

    box-sizing: border-box;

    z-index: 1000;

    box-shadow: 0 2px 10px rgba(0,0,0,0.2);
}
.logo{
    display: flex;
    align-items: center;
    gap: 12px;
}

.logo h2{
    color: white;
    font-size: 38px;
    font-weight: bold;
    margin: 0;
}

.logo img{
    width: 55px;
    height: 55px;
    object-fit: contain;
}


.nav-links{
    display: flex;
    list-style: none;
    gap: 35px;
}

.nav-links li{
    list-style: none;
}

.nav-links a,
.nav-links a{
    text-decoration: none;
    color: white;
    font-size: 20px;
    font-weight: 600;
    transition: 0.3s;
}

.nav-links a:hover{
    color: gold;
}
.user-links{
    display: flex;
    align-items: center;
    gap: 25px;
}
.user-links a{
    text-decoration: none;
    color: white;
    font-size: 19px;
    font-weight: 600;
    transition: 0.3s;
}

.user-links a:hover{
    color: gold;
}
/* ================= SEARCH ================= */
/* ================= SEARCH ================= */


/* ================= HERO ================= */
/* ================= HERO ================= */

.hero{
    height:90vh;
    background-image:
        linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)),
        url("image/foodbg.png");
    background-size:cover;
    background-position:center;
    background-repeat:no-repeat;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
}

.hero h1{
    color:white;
    font-size:55px;
    text-align:center;
    margin-bottom:35px;
}

/* ================= SEARCH ================= */

.search-container{
    width:700px;
}

.search-form{
    position:relative;
}

.search-form input{
    width:100%;
    height:60px;
    padding:0 60px 0 25px;
    border:none;
    border-radius:40px;
    background:#ffffff;
    color:#333;
    font-size:18px;
    outline:none;
    box-shadow:0 5px 15px rgba(0,0,0,0.25);
    transition:0.3s;
}

.search-form input::placeholder{
    color:#888;
}

.search-form input:focus{
    background:#ffffff;
    border:none;
    outline:none;
    box-shadow:0 5px 18px rgba(0,0,0,0.30);
}

/* Remove browser blue effect */

.search-form input:focus-visible{
    outline:none;
}

.search-form button{
    position:absolute;
    top:50%;
    right:18px;
    transform:translateY(-50%);
    border:none;
    background:transparent;
    cursor:pointer;
    font-size:22px;
    color:#555;
    width:auto;
    height:auto;
    padding:0;
    box-shadow:none;
}

.search-form button:hover{
    background:transparent;
    color:#ff4d4d;
}

.search-form button:focus{
    outline:none;
    box-shadow:none;
}

/* Chrome Autofill */

input,
input:focus,
input:active{
    outline:none;
    -webkit-appearance:none;
    appearance:none;
}

input:-webkit-autofill,
input:-webkit-autofill:hover,
input:-webkit-autofill:focus{
    -webkit-box-shadow:0 0 0px 1000px white inset !important;
    -webkit-text-fill-color:#333 !important;
}
.filter-bar{
    display:flex;
    align-items:center;
    gap:12px;
    flex-wrap:wrap;
    margin:30px 40px;
}

.filter-chip{

    height:45px;
    min-width:120px;

    padding:0 18px;

    border:1px solid #ddd;

    border-radius:999px;

    background:#fff;

    font-size:15px;

    font-weight:600;

    color:#444;

    cursor:pointer;

    outline:none;

    transition:.3s;
}

.filter-chip:hover{

    border-color:#ff4d4d;

    color:#ff4d4d;
}

.apply-btn{

    height:45px;

    padding:0 25px;

    border:none;

    border-radius:999px;

    background:#ff4d4d;

    color:white;

    font-weight:bold;

    cursor:pointer;
}

/* ================= RESTAURANT ================= */

.restaurant-container{
    width: 95%;
    margin: 25px auto;

    display: grid;
    grid-template-columns: repeat(4, 1fr);

    gap: 15px;
}

.card{
    width: 100%;
    background: #fff;
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 2px 8px rgba(0,0,0,.12);
    transition: 0.3s;
}

.card:hover{
    transform: scale(0.98);
}
.restaurant-container a{
    text-decoration: none;
    color: inherit;
    display: block;
}
.card img{
    width:100%;
    height:180px;
    object-fit:cover;
}
.content{
    padding:10px;
}

.top{
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.top h2{
    font-size:22px;
    font-weight:600;
}
.rating{
    background:green;
    color:white;
    padding:4px 8px;
    border-radius:5px;
    font-weight:bold;
}

.discount{
    color:red;
    font-weight:bold;
}



.left{
    width:65%;
}

.right{
    width:35%;
    text-align:right;
}

.info{
    display:flex;
    justify-content:space-between;
    margin-top:5px;
}

.left p,
.right p{
    margin:2px 0;
    font-size:14px;
}
.card button{

    width:100%;
    padding:12px;
    background:#ff4d4d;
    color:white;
    border:none;
    cursor:pointer;
    font-size:16px;
}

.card button:hover{
    background:#e53935;
}
</style>

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar">

    <!-- Logo -->
    <div class="logo">
    <img src="<%=request.getContextPath()%>/image/logo.png" alt="TasteIt Logo">
    <h2>TasteIt</h2>
</div>
    <!-- Navigation -->
    <ul class="nav-links">
        <li><a href="#">Home</a></li>
        
        <li><a href="#">Offers</a></li>
        <li><a href="#">Contact</a></li>
    </ul>

    <!-- Right Side -->
    <div class="user-links">

<% if(loggedInUser == null){ %>

    <a href="login.jsp">Login</a>
    <a href="signup.jsp">Sign Up</a>

<% } else { %>

    <a href="myorderServlet">My Orders</a>
    <a href="ProfileServlet">Profile</a>

    <div class="profile-menu">

        <div class="profile-circle">
            <%= loggedInUser.getUserName().substring(0,1).toUpperCase() %>
        </div>

        <div class="dropdown">

            <div class="user-name">
                <%= loggedInUser.getUserName() %>
            </div>

            <hr>

            

            <a href="LogoutServlet">Logout</a>

        </div>

    </div>

<% } %>

</div>

</nav>

<!-- ================= SEARCH ================= -->

<div class="hero">

    <h1>Order Your Favorite Meals Anytime, Anywhere</h1>

    <div class="filter-bar">

    <form action="SearchServlet" method="get" class="search-form">

        <input
            type="text"
            name="Keyword"
            placeholder="Search restaurants or cuisines..."
            required>

        <button type="submit">
            🔍
        </button>

    </form>

</div>
</div>
<!-- ====filter== -->
<form action="FilterServlet" method="get" class="filter-bar">

    <!-- Hidden input -->
    <input type="hidden" name="category" id="category">

    <!-- Veg -->
    <button type="button"
            class="filter-chip"
            onclick="selectCategory('Veg',this)">
        🌱 Veg
    </button>

    <!-- Non Veg -->
    <button type="button"
            class="filter-chip"
            onclick="selectCategory('Non Veg',this)">
        🍗 Non Veg
    </button>

    <!-- Cuisine -->
    <select name="cuisine" class="filter-chip">
        <option value="">Cuisine</option>
        <option value="South Indian">South Indian</option>
        <option value="North Indian">North Indian</option>
        <option value="Chinese">Chinese</option>
        <option value="Italian">Italian</option>
    </select>

    <!-- Rating -->
    <select name="rating" class="filter-chip">
        <option value="">Rating</option>
        <option value="4">4★ & Above</option>
        <option value="4.5">4.5★ & Above</option>
    </select>

    <!-- Price -->
    <select name="price" class="filter-chip">
        <option value="">Price</option>
        <option value="200">Under ₹200</option>
        <option value="400">₹200 - ₹400</option>
        <option value="401">Above ₹400</option>
    </select>

    <!-- Sort -->
    <select name="sort" class="filter-chip">
        <option value="">Sort By</option>
        <option value="rating">Highest Rating</option>
        <option value="delivery">Fast Delivery</option>
        <option value="az">A-Z</option>
    </select>

    <button type="submit" class="apply-btn">
        Apply
    </button>

</form>

<script>

function selectCategory(category,btn){

    document.getElementById("category").value=category;

    document.querySelectorAll(".filter-chip").forEach(function(item){

        item.classList.remove("active-filter");

    });

    btn.classList.add("active-filter");

}

</script>
<!-- ================= RESTAURANTS ================= -->

<div class="restaurant-container">



<%
List<Restaurent> allrestaurants =
        (List<Restaurent>) request.getAttribute("allrestaurants");

if (allrestaurants != null && !allrestaurants.isEmpty()) {

    for (Restaurent res : allrestaurants) {
%>
<a href="menu?restaurantID=<%= res.getRes_id() %>">

    <div class="card">

    <img src="<%= res.getImageUrl() %>" alt="Restaurant Image">

    <div class="content">

        <!-- Top Row -->
        <div class="top">

            <h2><%= res.getName() %></h2>

            <div class="rating">
                <%= res.getRating() %> ★
            </div>

        </div>

        <!-- Discount -->
        <div class="discount">
            <%= res.getDiscount() %>% OFF
        </div>

        <!-- Left and Right Section -->

        <div class="info">

            <!-- Left Side -->

            <div class="left">

                <p> <%= res.getCuisineType() %></p>

                <p> <%= res.getDescription() %></p>

                <p> <%= res.getAddress() %></p>

            </div>

            <!-- Right Side -->

            <div class="right">

                <p><%= res.getRes_id() %></p>

                <p><%= res.getDeliveryTime() %> mins</p>

                <p><%= res.getOpenTime() %></p>

                <p><%= res.getCloseTime() %></p>

            </div>

        </div>



    </div>

</div>
</a>

<%
    }
} else {
%>

    <h2 style="text-align:center;">No Restaurants Available</h2>

<%
}
%>

</div>