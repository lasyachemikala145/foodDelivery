<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Orders"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Orders</title>

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
	color: white;
	position: fixed;
}

.logo {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 10px;
	color: #FFD700;
	font-size: 30px;
	font-weight: bold;
	padding: 25px;
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
	text-decoration: none;
	color: white;
	font-size: 18px;
	display: block;
}

.main {
	margin-left: 240px;
	width: calc(100% - 240px);
	padding: 30px;
}

.heading {
	margin-bottom: 25px;
}

.heading h1 {
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	background: white;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 3px 10px rgba(0, 0, 0, .15);
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

.view {
	background: #007bff;
	color: white;
	padding: 8px 15px;
	text-decoration: none;
	border-radius: 5px;
}

.view:hover {
	background: #0056b3;
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

				<li><a href="adminDashboard">🏠 Dashboard</a></li>

				<li><a href="manageMenu">🍔 Manage Menu</a></li>

				<li><a href="manageOrders">📦 Orders</a></li>

				<li><a href="restaurantProfile">🏪 Restaurant Profile</a></li>

				<li><a href="login.jsp">🚪 Logout</a></li>

			</ul>

		</div>

		<div class="main">

			<div class="heading">
				<h1>Manage Orders</h1>
			</div>

			<table>

				<tr>

					<th>Order ID</th>
					<th>Customer ID</th>
					<th>Total Price</th>
					<th>Payment</th>
					<th>Order Date</th>
					<th>Status</th>
					<th>Action</th>

				</tr>

				<%
				List<Orders> orderList = (List<Orders>) request.getAttribute("orderList");

				if (orderList != null && !orderList.isEmpty()) {

					for (Orders o : orderList) {
				%>

				<tr>

					<td><%=o.getOrder_id()%></td>

					<td><%=o.getUser_id()%></td>

					<td>₹ <%=o.getFinalprice()%></td>

					<td><%=o.getPayment()%></td>

					<td><%=o.getOrderdate()%></td>

					<td><%=o.getStatus()%></td>

					<td><a class="view"
						href="viewOrder?order_id=<%=o.getOrder_id()%>"> View </a></td>

				</tr>

				<%
				}

				} else {
				%>

				<tr>

					<td colspan="7">No Orders Found</td>

				</tr>

				<%
				}
				%>

			</table>

		</div>

	</div>

</body>

</html>