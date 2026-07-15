<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ page import="com.tap.model.RestaurantAdmin"%>

<%
RestaurantAdmin admin = (RestaurantAdmin)session.getAttribute("admin");

if(admin == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<%
int totalOrders = (Integer)request.getAttribute("totalOrders");
int pendingOrders = (Integer)request.getAttribute("pendingOrders");
int deliveredOrders = (Integer)request.getAttribute("deliveredOrders");
float totalRevenue = (Float)request.getAttribute("totalRevenue");
int totalMenuItems = (Integer)request.getAttribute("totalMenuItems");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TasteIt | Admin Dashboard</title>

<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/image/logo.png">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

.logo {
	display: flex;
	align-items: center;
	gap: 10px;
	color: #ff5200;
	font-size: 30px;
	font-weight: bold;
	padding-left: 20px;
}

.logo img {
	width: 50px;
	height: 50px;
	object-fit: contain;
}

body {
	background: #f4f6f9;
}

/* ================= Sidebar ================= */
.sidebar {
	position: fixed;
	left: 0;
	top: 0;
	width: 240px;
	height: 100vh;
	background: #e23744;
	color: white;
	padding-top: 25px;
}

.logo {
	text-align: center;
	font-size: 30px;
	font-weight: bold;
	margin-bottom: 40px;
}

.logo span {
	color: #ffe082;
}

.sidebar ul {
	list-style: none;
}

.sidebar ul li {
	padding: 18px 28px;
	transition: .3s;
}

.sidebar ul li:hover {
	background: #c62839;
}

.sidebar ul li a {
	text-decoration: none;
	color: white;
	font-size: 17px;
	display: block;
}

/* ================= Main ================= */
.main {
	margin-left: 240px;
	padding: 30px;
}

/* ================= Top Bar ================= */
.topbar {
	background: white;
	border-radius: 12px;
	padding: 18px 25px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-shadow: 0 4px 10px rgba(0, 0, 0, .08);
}

.admin-name {
	font-size: 20px;
	font-weight: bold;
}

.admin-name span {
	color: #e23744;
}

.restaurant-id {
	color: #555;
}

/* ================= Welcome ================= */
.welcome {
	margin-top: 25px;
	background: #ffffff;
	color: #000000;
	padding: 30px;
	border-radius: 15px;
	border: 1px solid #ddd;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.welcome h1 {
	margin-bottom: 10px;
	color: #000000;
	font-size: 32px;
}

.welcome p {
	color: #333333;
	font-size: 16px;
}

/* ================= Cards ================= */
.cards {
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	gap: 20px;
	margin-top: 30px;
}

.card {
	background: white;
	border-radius: 15px;
	padding: 25px;
	box-shadow: 0 5px 12px rgba(0, 0, 0, .08);
	transition: .3s;
}

.card:hover {
	transform: translateY(-6px);
}

.card h2 {
	color: #e23744;
	margin-bottom: 10px;
}

.card p {
	color: #666;
}

/* ================= Quick Actions ================= */
.section-title {
	margin-top: 40px;
	margin-bottom: 18px;
	color: #333;
}

.actions {
	display: flex;
	gap: 20px;
}

.action-btn {
	flex: 1;
	text-decoration: none;
	background: white;
	padding: 20px;
	text-align: center;
	color: #333;
	border-radius: 12px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, .08);
	transition: .3s;
	font-weight: bold;
}

.action-btn:hover {
	background: #e23744;
	color: white;
}

/* ================= Restaurant Info ================= */
.info {
	margin-top: 40px;
	background: white;
	border-radius: 15px;
	padding: 25px;
	box-shadow: 0 5px 12px rgba(0, 0, 0, .08);
}

.info table {
	width: 100%;
	border-collapse: collapse;
}

.info td {
	padding: 14px;
	border-bottom: 1px solid #eee;
}

.info td:first-child {
	font-weight: bold;
	width: 220px;
}

/* ================= Responsive ================= */
@media ( max-width :1000px) {
	.cards {
		grid-template-columns: repeat(2, 1fr);
	}
	.actions {
		flex-direction: column;
	}
}

@media ( max-width :700px) {
	.sidebar {
		width: 70px;
	}
	.sidebar .text {
		display: none;
	}
	.main {
		margin-left: 70px;
	}
	.cards {
		grid-template-columns: 1fr;
	}
}
</style>

</head>

<body>

	<!-- Sidebar -->

	<div class="sidebar">

		<div class="logo">
			<img src="<%=request.getContextPath()%>/image/logo.png" alt="Logo">
			<span>TasteIt</span>
		</div>

		<ul>

			<li><a href="adminDashboard">🏠 <span class="text">Dashboard</span></a>
			</li>

			<li><a href="manageMenu">🍔 Manage Menu</a></li>

			<li><a href="manageOrders">📦 <span class="text">Orders</span></a>
			</li>

			<li><a href="restaurantProfile">🏪 <span class="text">Restaurant
						Profile</span></a></li>

			<li><a href="login.jsp">🚪 <span class="text">Logout</span></a>
			</li>

		</ul>

	</div>

	<!-- Main -->

	<div class="main">

		<div class="topbar">

			<div class="admin-name">
				👤 Welcome, <span><%=admin.getName()%></span>
			</div>

			<div class="restaurant-id">
				Restaurant ID : <b><%=admin.getRestaurant_id()%></b>
			</div>

		</div>

		<div class="welcome">

			<h1>Restaurant Admin Dashboard</h1>

			<p>Manage your restaurant, menu, customer orders and profile from
				one place.</p>

		</div>

		<!-- Cards -->

		<div class="cards">

    <div class="card">
        <h2><%=totalOrders%></h2>
        <p>Total Orders</p>
    </div>

    <div class="card">
        <h2><%=pendingOrders%></h2>
        <p>Pending Orders</p>
    </div>

    <div class="card">
        <h2><%=deliveredOrders%></h2>
        <p>Delivered Orders</p>
    </div>

    <div class="card">
        <h2>₹ <%=totalRevenue%></h2>
        <p>Total Revenue</p>
    </div>

    <div class="card">
        <h2><%=totalMenuItems%></h2>
        <p>Total Menu Items</p>
    </div>

</div>

		<!-- Quick Actions -->

		<h2 class="section-title">Quick Actions</h2>

		<div class="actions">

			<a href="manageMenu" class="action-btn"> 🍔 Manage Menu </a> <a
				href="manageOrders" class="action-btn"> 📦 View Orders </a> <a
				href="restaurantProfile" class="action-btn"> 🏪 Restaurant
				Profile </a>

		</div>

		<!-- Restaurant Information -->

		<div class="info">

			<h2 style="margin-bottom: 20px;">Restaurant Information</h2>

			<table>

				<tr>
					<td>Admin Name</td>
					<td><%=admin.getName()%></td>
				</tr>

				<tr>
					<td>Restaurant ID</td>
					<td><%=admin.getRestaurant_id()%></td>
				</tr>

				<tr>
					<td>Status</td>
					<td style="color: green; font-weight: bold;">🟢 Online</td>
				</tr>

				<tr>
					<td>Account Type</td>
					<td>Restaurant Admin</td>
				</tr>

			</table>

		</div>

	</div>

</body>
</html>