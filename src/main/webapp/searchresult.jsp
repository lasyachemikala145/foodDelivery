<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Restaurent"%>
<%@ page import="com.tap.model.User"%>

<%@ page import="com.tap.model.Menu"%>
<%
User loggedInUser = (User)session.getAttribute("user");

List<Restaurent> restaurentlist =
(List<Restaurent>)request.getAttribute("restaurentlist");

List<Menu> menuList =
(List<Menu>)request.getAttribute("menuList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
<%
String type = (String)request.getAttribute("type");
%>

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

/* NAVBAR */

.navbar{
    background:#ff4d4d;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:8px 50px;
    position:fixed;
    top:0;
    left:0;
    width:100%;
    z-index:1000;
}

.logo{
    display:flex;
    align-items:center;
    gap:12px;
}

.logo img{
    width:55px;
    height:55px;
}

.logo h2{
    color:white;
    font-size:38px;
}

.nav-links{
    display:flex;
    list-style:none;
    gap:35px;
}

.nav-links a{
    text-decoration:none;
    color:white;
    font-size:20px;
    font-weight:600;
}

.user-links{
    display:flex;
    gap:25px;
}

.user-links a{
    text-decoration:none;
    color:white;
    font-size:19px;
    font-weight:600;
}
.search-container{
    width:100%;
    display:flex;
    justify-content:center;
    align-items:center;
    margin-top:30px;
}

.search-form{
    width:50%;              /* Half of the page */
    display:flex;
    align-items:center;
}

.search-form input{
    flex:1;
    height:55px;
    padding:0 20px;
    border:none;
    border-radius:30px 0 0 30px;
    font-size:18px;
    outline:none;
}

.search-form button{
    width:150px;
    height:55px;
    border:none;
    background:#ff5252;
    color:white;
    font-size:18px;
    cursor:pointer;
    border-radius:0 30px 30px 0;
    transition:.3s;
}

.search-form button:hover{
    background:#e53935;
}

/* RESULTS */

.container{
    margin-top:110px;
    width:95%;
    margin-left:auto;
    margin-right:auto;
}

.container h1{
    margin-bottom:20px;
}

/* CARDS */

.restaurant-container{
    display:grid;
    grid-template-columns:repeat(4,1fr);
    gap:20px;
}
.menu-grid{
    display:grid;
    grid-template-columns:repeat(4,1fr);
    gap:20px;
}

.restaurant-container a{
    text-decoration:none;
    color:black;
}

.card{
    background:white;
    border-radius:12px;
    overflow:hidden;
    box-shadow:0 2px 8px rgba(0,0,0,.15);
}

.card img{
    width:100%;
    height:180px;
    object-fit:cover;
}

.content{
    padding:12px;
}

.top{
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.rating{
    background:green;
    color:white;
    padding:4px 8px;
    border-radius:5px;
}

.discount{
    color:red;
    font-weight:bold;
    margin:8px 0;
}

.info{
    display:flex;
    justify-content:space-between;
}

.left{
    width:65%;
}

.right{
    width:35%;
    text-align:right;
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

<nav class="navbar">

<div class="logo">
<img src="<%=request.getContextPath()%>/image/logo.png">
<h2>TasteIt</h2>
</div>

<ul class="nav-links">
<li><a href="RestaurantServlet">Home</a></li>
<li><a href="#">Offers</a></li>
<li><a href="#">Contact</a></li>
</ul>

<div class="user-links">

<% if(loggedInUser==null){ %>

<a href="login.jsp">Login</a>
<a href="signup.jsp">Sign Up</a>

<% } else { %>

<a href="myorderServlet">My Orders</a>
<a href="ProfileServlet">Profile</a>
<a href="LogoutServlet">Logout</a>

<% } %>

</div>

</nav>

<div class="container">

<h1>Search Results</h1>

<% if("restaurant".equals(type)){ %>

<div class="restaurant-container">
<%
if(restaurentlist!=null && !restaurentlist.isEmpty()){

for(Restaurent res:restaurentlist){
%>

<a href="menu?restaurantID=<%=res.getRes_id()%>">
<div class="card">

<img src="<%=res.getImageUrl()%>">
<div class="content">

<div class="top">

<h2><%=res.getName()%></h2>

<div class="rating">
<%=res.getRating()%>
</div>

</div>

<div class="discount">
<%=res.getDiscount()%>% OFF
</div>

<div class="info">

<div class="left">

<p><%=res.getCuisineType()%></p>

<p><%=res.getAddress()%></p>

</div>

<div class="right">

<p><%=res.getDeliveryTime()%> mins</p>


</div>

</div>

</div>

</div>

</a>

<%
}


}
%>
<% } else if("menu".equals(type)){ %>

<div class="menu-grid">

<%
if(menuList!=null && !menuList.isEmpty()){

for(Menu menu:menuList){

%>
<div class="card">

    <img src="<%=menu.getImgurl()%>">

    <div class="content">

        <div class="top">

            <h2><%=menu.getNameofitem()%></h2>

            <div class="rating">
                <%=menu.getRating()%> ★
            </div>

        </div>

        <div class="discount">
            ₹ <%=menu.getPrice()%>
        </div>

        <div class="info">

            <div class="left">

                <p>Category : <%=menu.getCategory()%></p>

                <p>Restaurant : <%=menu.getRestaurantName()%></p>

            </div>

            <div class="right">

                <form action="callCartServlet">

                    <input type="hidden" name="menu_id" value="<%=menu.getMenu_id()%>">

                    <input type="hidden" name="res_id" value="<%=menu.getRes_id()%>">

                    <input type="hidden" name="quantity" value="1">

                    <input type="hidden" name="action" value="add">

                    <button>Add To Cart</button>

                </form>

            </div>

        </div>

    </div>

</div>
<%
}
}else{
%>

<h2>No Items Found</h2>

<%
}
%>

</div>

<%
}
%>
</div>
    <div>
    <button class="back-btn" onclick="history.back()">
← Back
</button>

</div>

</div>

</body>
</html>