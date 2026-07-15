<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.model.Orders" %>
<%@ page import="com.tap.model.OrderItem" %>
<%@ page import="com.tap.model.Restaurent" %>
<%@ page import="java.util.List" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<link rel="icon"
      type="image/png"
      href="<%=request.getContextPath()%>/image/logo.png">
<%
Orders order = (Orders) request.getAttribute("order");
%>
<% 
Restaurent restaurent =  (Restaurent)request.getAttribute("res");
List<OrderItem> items=(List<OrderItem>)request.getAttribute("items");

%>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f4f4f4;
}

header{
    background:#ff5a5f;
    color:white;
    text-align:center;
    padding:18px;
    font-size:30px;
    font-weight:bold;
}

.container{
    width:80%;
    max-width:900px;
    margin:30px auto;
}

.card{
    background:white;
    border-radius:12px;
    box-shadow:0 5px 12px rgba(0,0,0,.12);
    padding:25px;
}

.section{
    margin-top:25px;
    border-top:1px solid #ddd;
    padding-top:20px;
}

.section h3{
    color:#ff5a5f;
    margin-bottom:15px;
}

.info{
    display:flex;
    justify-content:space-between;
    margin:10px 0;
}

.info span:first-child{
    font-weight:bold;
    color:#444;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:10px;
}

table th{
    background:#ff5a5f;
    color:white;
    padding:12px;
}

table td{
    padding:12px;
    text-align:center;
    border-bottom:1px solid #ddd;
}

.total{
    text-align:right;
    margin-top:20px;
    font-size:22px;
    font-weight:bold;
    color:#ff5a5f;
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
    background:#555;
    color:white;
}

.back-btn:hover{
    background:#333;
}

.reorder-btn{
    background:#ff5a5f;
    color:white;
}

.reorder-btn:hover{
    background:#e64a50;
}
</style>

</head>
<body>

<header>
Order Details
</header>

<div class="container">

<div class="card">

<!-- Order Information -->

<div class="section" style="margin-top:0;border-top:none;padding-top:0;">

<h3>Order Information</h3>

<div class="info">
<span>Order ID</span>
<span><%=order.getOrder_id ()%></span>
</div>

<div class="info">
<span>Order Date</span>
<span><%=order.getOrderdate() %></span>
</div>

<div class="info">
<span>Status</span>
<span>Delivered</span>
</div>

<div class="info">
<span>Payment Method</span>
<span><%= order.getPayment()%></span>
</div>

</div>

<!-- Restaurant -->

<div class="section">

<h3>Restaurant Information</h3>

<div class="info">
<span>Restaurant Name</span>
<span><%= restaurent.getName()%></span>
</div>

<div class="info">
<span>Restaurant Address</span>
<span><%=restaurent.getAddress()%></span>
</div>

</div>

<!-- Items -->

<div class="section">

<h3>Items Ordered</h3>

<table>

<tr>
<th>Item Name</th>
<th>Quantity</th>
<th>Price</th>
</tr>

<%
for(OrderItem item : items){
%>
<tr>
    <td><%= item.getItemName() %></td>
    <td><%= item.getQuantity() %></td>
    <td><%= item.getPrice() %></td>
</tr>
<%
}
%>



</table>

<div class="total">
Total : <%=order.getFinalprice() %>
</div>

</div>

<!-- Delivery -->

<div class="section">

<h3>Delivery Information</h3>

<div class="info">
<span>Delivery Address</span>
<span><%=order.getDelivery_address()%></span>
</div>

</div>

<!-- Buttons -->

<div class="buttons">

<button class="back-btn" onclick="history.back()">
← Back
</button>



</div>

</div>

</div>

</body>
</html>