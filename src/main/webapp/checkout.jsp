<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User"%>
<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.CartItem"%>
<title>checkout</title>
<link rel="icon"
      type="image/png"
      href="<%=request.getContextPath()%>/image/logo.png">

<%
User user = (User)session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}

Cart cart = (Cart)session.getAttribute("cart");

double itemTotal = 0;

if(cart != null){

    for(CartItem item : cart.getItems().values()){

        itemTotal += item.getPrice() * item.getQuantity();

    }

}

double deliveryFee = 40;
double platformFee = 10;
double grandTotal = itemTotal + deliveryFee + platformFee;
%>
<head>
<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f4f4f4;
    padding:40px;
}

.page-title{
    margin-bottom:30px;
}

.page-title hr{
    border:none;
    height:1px;
    background:#ddd;
    margin-bottom:12px;
}

.page-title h1{
    font-size:32px;
    color:#333;
}

/* Main Container */

.container{
    width:90%;
    margin:40px auto;
    display:flex;
    gap:30px;
    align-items:flex-start;
}

/* Left Side */

.left{
    flex:2;
    background:#fff;
    padding:30px;
    border-radius:12px;
    box-shadow:0 2px 10px rgba(0,0,0,.1);
}

.left h2{
    margin-bottom:20px;
    color:#333;
}

label{
    display:block;
    font-weight:bold;
    margin:15px 0 8px;
}

input[type=text],
textarea{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
    outline:none;
}

input[type=text]:focus,
textarea:focus{
    border-color:#ff5200;
}

textarea{
    height:120px;
    resize:none;
}

.payment{
    margin-top:15px;
}

.payment label{
    display:block;
    font-weight:normal;
    margin:10px 0;
}

/* Right Side */

.right{
    flex:1;
}

.summary{
    background:#fff;
    padding:25px;
    border-radius:12px;
    box-shadow:0 2px 10px rgba(0,0,0,.1);
    position:sticky;
    top:20px;
}

.summary h2{
    margin-bottom:20px;
}

.item,
.bill,
.total{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin:12px 0;
}

.summary hr{
    margin:15px 0;
    border:none;
    border-top:1px solid #ddd;
}

.total{
    font-size:20px;
    font-weight:bold;
    color:#ff5200;
}

/* Buttons */

.btn{
    width:100%;
    padding:14px;
    border:none;
    border-radius:8px;
    font-size:16px;
    cursor:pointer;
    margin-top:15px;
}

.place{
    background:#ff5200;
    color:white;
}

.place:hover{
    background:#e64900;
}

.back{
    background:white;
    color:#ff5200;
    border:2px solid #ff5200;
}

.back:hover{
    background:#fff4ed;
}

/* Mobile */

@media(max-width:900px){

.container{
    flex-direction:column;
}

.right{
    width:100%;
}

}

</style>
</head>
<body>

<div class="page-title">
    <hr>
    <h1>Checkout</h1>
</div>

<form action="CheckoutServlet" method="post">

<div class="container">

    <!-- LEFT SIDE -->
    <div class="left">

        <h2>Delivery Details</h2>

        <label>Full Name</label>

        <input type="text"
               value="<%=user.getUserName()%>"
               readonly>

        <label>Mobile Number</label>

        <input type="text"
               value="<%=user.getPhone()%>"
               readonly>

        <label>Delivery Address</label>

<textarea name="deliveryAddress"><%=user.getAddress()%></textarea>

        <label>Payment Method</label>

        <div class="payment">

            <input type="radio" name="payment" value="COD" checked>
Cash On Delivery

<input type="radio" name="payment" value="UPI">
UPI

<input type="radio" name="payment" value="Credit Card">
Credit Card

<input type="radio" name="payment" value="Debit Card">
Debit Card

        </div>

    </div>


    <!-- RIGHT SIDE -->

    <div class="right">

        <div class="summary">

            <h2>Order Summary</h2>

            <%
            if(cart != null && !cart.getItems().isEmpty()){

                for(CartItem item : cart.getItems().values()){

                    double total=item.getPrice()*item.getQuantity();
            %>

            <div class="item">

                <span>
                    <%=item.getName()%> × <%=item.getQuantity()%>
                </span>

                <span>
                    ₹ <%=total%>
                </span>

            </div>

            <%
                }
            }
            else{
            %>

            <p>Your Cart is Empty</p>

            <%
            }
            %>

            <hr>

            <div class="bill">
                <span>Items Total</span>
                <span>₹ <%=itemTotal%></span>
            </div>

            <div class="bill">
                <span>Delivery Fee</span>
                <span>₹ <%=deliveryFee%></span>
            </div>

            <div class="bill">
                <span>Platform Fee</span>
                <span>₹ <%=platformFee%></span>
            </div>

            <hr>

            <div class="total">
                <span>Grand Total</span>
                <span>₹ <%=grandTotal%></span>
            </div>
            <input type="hidden" name="grandTotal" value="<%=grandTotal%>">

            <button type="submit" class="btn place">
    Place Order
</button>

           <button type="button"
        class="btn back"
        onclick="location.href='cart.jsp'">
    Back To Cart
</button>
        </div>

    </div>

</div>
</form>

</body>
</html>