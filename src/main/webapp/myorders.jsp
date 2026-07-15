<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Orders" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>
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

header{
    background:#ff5a5f;
    color:white;
    padding:15px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    box-shadow:0 2px 8px rgba(0,0,0,.15);
}

.logo{
    display:flex;
    align-items:center;
    gap:10px;
    font-size:28px;
    font-weight:bold;
}

.logo img{
    width:45px;
    height:45px;
    object-fit:contain;
}

header h2{
    font-size:24px;
    font-weight:bold;
}

nav{
    display:flex;
    gap:30px;
}

nav a{
    color:white;
    text-decoration:none;
    font-size:17px;
    font-weight:600;
}

nav a:hover{
    color:#ffe8e8;
}

.container{
    width:80%;
    margin:30px auto;
}

.order-card{
    background:white;
    padding:20px;
    margin-bottom:25px;
    border-radius:12px;
    box-shadow:0 4px 10px rgba(0,0,0,.1);
}

.order-header{
    display:flex;
    justify-content:space-between;
    margin-bottom:15px;
}

.order-header h3{
    color:#ff5a5f;
}

.details p{
    margin:8px 0;
}

button{
    margin-top:18px;
    background:#ff5a5f;
    color:white;
    border:none;
    padding:10px 18px;
    border-radius:6px;
    cursor:pointer;
}

button:hover{
    background:#e64a50;
}
</style>

</head>
<body>


    
   
    <header>

    <div class="logo">
        <img src="<%=request.getContextPath()%>/image/logo.png" alt="Logo">
        <span>TasteIt</span>
    </div>

    <h2>My Orders</h2>

    <nav>
        <a href="callRestaurantServlet">Home</a>
        <a href="ProfileServlet">Profile</a>
        <a href="LogoutServlet">Logout</a>
    </nav>



</header>
<%
List<Orders> orders = (List<Orders>)request.getAttribute("orders");
%>

<div class="container">

<%
if(orders != null && !orders.isEmpty()){

    for(Orders order : orders){
%>

<div class="order-card">

    <div class="order-header">
        <h3>Order #<%=order.getOrder_id()%></h3>
        <span><%=order.getStatus()%></span>
    </div>

    <div class="details">

        <p>
            <strong>Order Date :</strong>
            <%=order.getOrderdate()%>
        </p>

        <p>
            <strong>Total :</strong>
            ₹<%=order.getFinalprice()%>
        </p>

        <p>
            <strong>Payment :</strong>
            <%=order.getPayment()%>
        </p>

        <p>
            <strong>Delivery Address :</strong>
            <%=order.getDelivery_address()%>
        </p>
        <a href="viewdetailServlet?orderId=<%=order.getOrder_id()%>">
    <button>View Details</button>
</a>

    </div>

</div>

<%
    }
}
else{
%>

<h2 style="text-align:center;margin-top:50px;">
No Orders Found
</h2>

<%
}
%>


        

    </div>


</body>
</html>