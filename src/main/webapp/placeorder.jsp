<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmed</title>
<link rel="icon"
      type="image/png"
      href="<%=request.getContextPath()%>/image/logo.png">
<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    background:linear-gradient(135deg,#fff8f4,#ffe8dc);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.card{
    width:500px;
    background:white;
    border-radius:20px;
    padding:50px 40px;
    text-align:center;
    box-shadow:0 15px 40px rgba(0,0,0,.12);
}

.success-icon{
    width:120px;
    height:120px;
    margin:auto;
    border-radius:50%;
    background:#22c55e;
    display:flex;
    justify-content:center;
    align-items:center;
    color:white;
    font-size:65px;
    font-weight:bold;
}

h1{
    margin-top:30px;
    color:#222;
    font-size:34px;
}

h3{
    margin-top:10px;
    color:#22c55e;
    font-weight:600;
}

.message{
    margin-top:25px;
    color:#666;
    font-size:17px;
    line-height:30px;
}

.note{
    margin-top:25px;
    background:#f7f7f7;
    padding:18px;
    border-radius:12px;
    color:#555;
    line-height:28px;
}

.btn{
    margin-top:35px;
}

.btn a{
    text-decoration:none;
    background:#ff6b35;
    color:white;
    padding:14px 35px;
    border-radius:8px;
    font-size:17px;
    font-weight:bold;
    transition:.3s;
}

.btn a:hover{
    background:#e85b2d;
}

</style>

</head>
<body>

<div class="card">

    <div class="success-icon">
        ✓
    </div>

    <h1>Order Confirmed</h1>

    <h3>Your food is on its way!</h3>

    <div class="message">
        Thank you for choosing <b>TasteIt</b>.<br>
        Your order has been successfully placed 
    </div>

    <div class="note">
        We appreciate your order and hope you enjoy your meal.
        Thank you for ordering with us!
    </div>

    <div class="btn">
        <a href="callRestaurantServlet">Back to Home</a>
    </div>

</div>

</body>
</html>