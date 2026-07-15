<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.CartItem"%>

<%
Cart cart=(Cart)session.getAttribute("cart");
double grandTotal=0;
%>
<%@ page import="com.tap.model.User" %>
<%
Integer restaurantId = (Integer)session.getAttribute("restaurantId");
%>
<%
User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>
<link rel="icon"
      type="image/png"
      href="<%=request.getContextPath()%>/image/logo.png">
<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Segoe UI,sans-serif;
}

body{
background:#f4f4f4;
}

/* Navbar */

.navbar{
height:70px;
background:white;
display:flex;
justify-content:space-between;
align-items:center;
padding:0 50px;
box-shadow:0 2px 10px rgba(0,0,0,.1);
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

.nav-links a{
text-decoration:none;
margin-left:25px;
font-weight:600;
color:#333;
}

.container{
width:90%;
margin:30px auto;
display:flex;
gap:30px;
}

/* Left Side */

.left{
flex:2;
}

.cart-card{

background:white;
padding:20px;
border-radius:15px;
margin-bottom:20px;
box-shadow:0 2px 10px rgba(0,0,0,.08);

}

.food-name{

font-size:22px;
font-weight:bold;
color:#333;
margin-bottom:15px;

}

.row{

display:flex;
justify-content:space-between;
margin:8px 0;
font-size:18px;

}

.quantity{

display:flex;
align-items:center;
gap:15px;
margin-top:15px;

}

.quantity form{
display:inline;
}

.qty-btn{

width:35px;
height:35px;
border:none;
border-radius:50%;
background:#ff5200;
color:white;
font-size:20px;
cursor:pointer;

}

.remove{

margin-top:20px;
background:red;
color:white;
padding:8px 15px;
border:none;
border-radius:8px;
cursor:pointer;

}

/* Bill */

.right{

flex:1;

}

.bill{

background:white;
padding:25px;
border-radius:15px;
box-shadow:0 2px 10px rgba(0,0,0,.08);
position:sticky;
top:20px;

}

.bill h2{

margin-bottom:20px;

}

.bill-row{

display:flex;
justify-content:space-between;
margin:12px 0;

}

.total{

font-size:22px;
font-weight:bold;

}

.checkout{

width:100%;
margin-top:20px;
padding:15px;
background:#16a34a;
border:none;
color:white;
font-size:18px;
border-radius:10px;
cursor:pointer;

}

.add{

width:100%;
margin-top:15px;
padding:15px;
background:#fff3ed;
color:#ff5200;
border:none;
font-size:17px;
border-radius:10px;
cursor:pointer;

}

.empty{

background:white;
padding:60px;
text-align:center;
border-radius:15px;
font-size:25px;

}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">
    <img src="<%=request.getContextPath()%>/image/logo.png" alt="Logo">
    <span>TasteIt</span>
</div>

<div class="nav-links">

<a href="callRestaurantServlet">Home</a>

<a href="#">Orders</a>

<a href="#">Profile</a>

</div>

</div>

<div class="container">

<div class="left">
<%
if(cart == null || cart.getItems().isEmpty()){
%>

<div class="empty">

<h2>🛒 Your Cart is Empty</h2>

<br>

<p>Add your favourite food and enjoy delicious meals!</p>

<br><br>

<a href="callRestaurantServlet">

<button class="add">Browse Restaurants</button>

</a>

</div>

<%
}
else{

for(CartItem item : cart.getItems().values()){//items contain key valu i want only value 

double total=item.getPrice()*item.getQuantity();
grandTotal+=total;

%>

<div class="cart-card">

<div class="food-name">

<%=item.getName()%>

</div>

<div class="row">

<span>Price</span>

<span>₹ <%=item.getPrice()%></span>

</div>

<div class="row">

<span>Total</span>

<span>₹ <%=total%></span>

</div>

<div class="quantity">

<form action="callCartServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden" name="menu_id"
value="<%=item.getMenu_id()%>">

<input type="hidden" name="res_id"
value="<%=item.getRes_id()%>">

<input type="hidden" name="quantity"
value="<%=item.getQuantity()-1%>">

<button class="qty-btn">-</button>

</form>
<b><%=item.getQuantity()%></b>

<form action="callCartServlet" method="post">

<input type="hidden" name="action" value="update">

<input type="hidden" name="menu_id"
value="<%=item.getMenu_id()%>">

<input type="hidden" name="res_id"
value="<%=item.getRes_id()%>">

<input type="hidden" name="quantity"
value="<%=item.getQuantity()+1%>">

<button class="qty-btn">+</button>

</form>

</div>

<form action="callCartServlet" method="post">

<input type="hidden" name="action" value="remove">

<input type="hidden" name="menu_id"
value="<%=item.getMenu_id()%>">
<input type="hidden" name="res_id"
value="<%=item.getRes_id()%>">

<button class="remove">
Remove Item
</button>

</form>

</div>

<%
}
}
%>
<%
double deliveryFee = 40;
double platformFee = 10;
double gst = 20;

double finalTotal = grandTotal + deliveryFee + platformFee + gst;
%>

</div>

<!-- Right Side -->
<div class="right">

    <div class="bill">

        <h2>Bill Details</h2>

        <div class="bill-row">
            <span>Item Total</span>
            <span>₹ <%=grandTotal%></span>
        </div>

        <div class="bill-row">
            <span>Delivery Fee</span>
            <span>₹ <%=deliveryFee%></span>
        </div>

        <div class="bill-row">
            <span>Platform Fee</span>
            <span>₹ <%=platformFee%></span>
        </div>

        <div class="bill-row">
            <span>GST</span>
            <span>₹ <%=gst%></span>
        </div>

        <hr>

        <div class="bill-row total">
            <span>Grand Total</span>
            <span>₹ <%=finalTotal%></span>
        </div>

        <br>

        <h3>Delivery Address</h3>
        <p><%= user.getAddress() %></p>

        <br>

       <!-- <h3>Payment Method</h3>  -->

        <%--
<input type="radio" name="payment" checked> Cash On Delivery
<br><br>

<input type="radio" name="payment"> UPI
<br><br>

<input type="radio" name="payment"> Credit / Debit Card
--%>

        <a href="menu?restaurantID=<%=restaurantId%>">
    <button class="add">
        + Add More Items
    </button>
</a>
	<a href="checkout.jsp">
        <button class="checkout">

        Proceed To Checkout

        </button>
        </a>

    </div>

</div>

</div>

</body>
</html>