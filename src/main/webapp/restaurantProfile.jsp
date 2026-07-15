<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.Restaurent"%>

<%
    Restaurent restaurant = (Restaurent)request.getAttribute("restaurant");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Profile</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}
.back-btn{
    margin-top:25px;
    text-align:center;
}

.back-btn a{
    display:inline-block;
    background:#dc3545;
    color:white;
    text-decoration:none;
    padding:12px 35px;
    border-radius:8px;
    font-size:17px;
    font-weight:bold;
    transition:0.3s;
}

.back-btn a:hover{
    background:#b02a37;
    transform:scale(1.05);
}
body {
	background: #f5f5f5;
}

.container {
	width: 60%;
	margin: 40px auto;
	background: white;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h2 {
	text-align: center;
	margin-bottom: 25px;
}

.input-box {
	margin-bottom: 18px;
}

.input-box label {
	display: block;
	margin-bottom: 6px;
	font-weight: bold;
}

.input-box input, .input-box textarea {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
}

textarea {
	resize: none;
}

button {
	width: 100%;
	padding: 12px;
	background: #28a745;
	color: white;
	border: none;
	border-radius: 6px;
	font-size: 16px;
	cursor: pointer;
}

button:hover {
	background: #218838;
}
</style>

</head>
<body>

	<div class="container">

		<h2>Restaurant Profile</h2>

		<form action="updateRestaurant" method="post">

			<input type="hidden" name="res_id"
				value="<%=restaurant.getRes_id()%>">

			<div class="input-box">
				<label>Restaurant Name</label> <input type="text" name="name"
					value="<%=restaurant.getName()%>">
			</div>


			<div class="input-box">
				<label>Address</label> <input type="text" name="address"
					value="<%=restaurant.getAddress()%>">
			</div>


			<div class="input-box">
				<label>Cuisine Type</label> <input type="text" name="cuisineType"
					value="<%=restaurant.getCuisineType()%>">
			</div>


			<div class="input-box">
				<label>Delivery Time</label> <input type="number"
					name="deliveryTime" value="<%=restaurant.getDeliveryTime()%>">
			</div>


			<div class="input-box">
				<label>Discount</label> <input type="text" name="discount"
					value="<%=restaurant.getDiscount()%>">
			</div>


			<div class="input-box">
				<label>Rating</label> <input type="text" name="rating"
					value="<%=restaurant.getRating()%>">
			</div>


			<div class="input-box">
				<label>Open Time</label> <input type="time" name="openTime"
					value="<%=restaurant.getOpenTime()%>">
			</div>


			<div class="input-box">
				<label>Close Time</label> <input type="time" name="closeTime"
					value="<%=restaurant.getCloseTime()%>">
			</div>


			<div class="input-box">
				<label>Image URL</label> <input type="text" name="imageUrl"
					value="<%=restaurant.getImageUrl()%>">
			</div>


			<div class="input-box">
				<label>Description</label>

				<textarea rows="4" name="description"><%=restaurant.getDescription()%></textarea>
			</div>


			<button type="submit">Update Restaurant</button>

		</form>
		<div class="back-btn">
    <a href="adminDashboard">← Back</a>
</div>

	</div>

</body>
</html>