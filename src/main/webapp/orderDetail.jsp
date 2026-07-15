<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Orders"%>
<%@ page import="com.tap.model.OrderItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>

<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/image/logo.png">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

body {
	background: #f5f6fa;
}

.container {
	display: flex;
}

.sidebar {
	width: 240px;
	min-height: 100vh;
	background: #e23744;
	position: fixed;
	color: white;
}

.logo {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 10px;
	padding: 25px;
	color: #FFD700;
	font-size: 30px;
	font-weight: bold;
}

.logo img {
	width: 50px;
	height: 50px;
}

.sidebar ul {
	list-style: none;
}

.sidebar ul li {
	padding: 18px 30px;
}

.sidebar ul li:hover {
	background: #c62839;
}

.sidebar ul li a {
	color: white;
	text-decoration: none;
	font-size: 18px;
	display: block;
}

.main {
	margin-left: 240px;
	padding: 30px;
	width: calc(100% - 240px);
}

.card {
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 3px 10px rgba(0, 0, 0, .2);
	margin-bottom: 25px;
}

.card p {
	margin: 10px 0;
	font-size: 17px;
}

table {
	width: 100%;
	border-collapse: collapse;
	background: white;
	box-shadow: 0 3px 10px rgba(0, 0, 0, .2);
}

th {
	background: #e23744;
	color: white;
	padding: 15px;
}

td {
	padding: 15px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

.updateBtn {
	background: #28a745;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 20px;
}

select {
	padding: 10px;
	width: 220px;
	margin-top: 20px;
}

.backBtn {
	display: inline-block;
	margin-top: 20px;
	text-decoration: none;
	background: #007bff;
	color: white;
	padding: 10px 20px;
	border-radius: 5px;
}
</style>

</head>

<body>

	<div class="container">

		<div class="sidebar">

			<div class="logo">

				<img src="<%=request.getContextPath()%>/image/logo.png"> <span>TasteIt</span>

			</div>

			<ul>

				<li><a href="adminDashboard.jsp">🏠 Dashboard</a></li>

				<li><a href="manageMenu">🍔 Manage Menu</a></li>

				<li><a href="manageOrders">📦 Orders</a></li>

				<li><a href="restaurantProfile">🏪 Restaurant Profile</a></li>

				<li><a href="login.jsp">🚪 Logout</a></li>

			</ul>

		</div>

		<div class="main">

			<%
			Orders order = (Orders) request.getAttribute("order");

			List<OrderItem> orderItemList = (List<OrderItem>) request.getAttribute("orderItemList");
			%>

			<div class="card">

				<h2>Order Details</h2>

				<br>

				<p>
					<b>Order ID :</b>
					<%=order.getOrder_id()%></p>

				<p>
					<b>Customer ID :</b>
					<%=order.getUser_id()%></p>

				<p>
					<b>Total Amount :</b> ₹
					<%=order.getFinalprice()%></p>

				<p>
					<b>Payment :</b>
					<%=order.getPayment()%></p>

				<p>
					<b>Delivery Address :</b>
					<%=order.getDelivery_address()%></p>

				<p>
					<b>Order Date :</b>
					<%=order.getOrderdate()%></p>

				<p>
					<b>Status :</b>
					<%=order.getStatus()%></p>

			</div>

			<table>

				<tr>

					<th>Item Name</th>

					<th>Quantity</th>

					<th>Price</th>

				</tr>

				<%
				for (OrderItem item : orderItemList) {
				%>

				<tr>

					<td><%=item.getItemName()%></td>

					<td><%=item.getQuantity()%></td>

					<td>₹ <%=item.getPrice()%></td>

				</tr>

				<%
				}
				%>

			</table>

			<form action="updateOrderStatus" method="post">

				<input type="hidden" name="order_id"
					value="<%=order.getOrder_id()%>"> <select name="status">

					<option value="Pending">Pending</option>

					<option value="Preparing">Preparing</option>

					<option value="Out For Delivery">Out For Delivery</option>

					<option value="Delivered">Delivered</option>

				</select> <br> <input type="submit" value="Update Status"
					class="updateBtn">

			</form>

			<a href="manageOrders" class="backBtn"> Back </a>

		</div>

	</div>

</body>

</html>