<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Food Delivery - Sign Up</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:linear-gradient(rgba(0,0,0,0.55),rgba(0,0,0,0.55)),
    url("https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=1600");
    background-size:cover;
    background-position:center;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.signup-box{
    width:430px;
    background:#fff;
    padding:35px;
    border-radius:15px;
    box-shadow:0 8px 25px rgba(0,0,0,.25);
}

.signup-box h1{
    color:#e23744;
    text-align:center;
    margin-bottom:8px;
}

.signup-box p{
    text-align:center;
    color:gray;
    margin-bottom:25px;
}

.input-box{
    margin-bottom:15px;
}

.input-box label{
    display:block;
    margin-bottom:5px;
    font-weight:bold;
    color:#333;
}

.input-box input,
.input-box select{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    outline:none;
    font-size:15px;
}

.input-box input:focus,
.input-box select:focus{
    border-color:#e23744;
}

button{
    width:100%;
    padding:13px;
    border:none;
    background:#e23744;
    color:white;
    font-size:17px;
    border-radius:8px;
    cursor:pointer;
    margin-top:10px;
}

button:hover{
    background:#c71f2f;
}

.bottom{
    text-align:center;
    margin-top:18px;
}

.bottom a{
    color:#e23744;
    text-decoration:none;
    font-weight:bold;
}
</style>

</head>

<body>

<div class="signup-box">

<h1>Create Account</h1>

<p>Sign up to start ordering delicious food</p>

<form action="./callsignupServlet" method="post">

    <!-- user_id will be AUTO_INCREMENT in MySQL -->
    
    <div class="input-box">
        <label>Name</label>
        <input type="text" name="name" placeholder="Enter your name" required>
    </div>

    <div class="input-box">
        <label>Email</label>
        <input type="email" name="email" placeholder="Enter your email" required>
    </div>

    <div class="input-box">
        <label>Password</label>
        <input type="password" name="password" placeholder="Create password" required>
    </div>
     <div class="input-box">
        <label>Mobile number</label>
        <input type="text" name="phone" placeholder="Enter yourmobile number" required>
    </div>
    

    <div class="input-box">
        <label>Address</label>
        <input type="text" name="address" placeholder="Enter your address" required>
    </div>
    
    

<!-- Restaurant Details -->

<!-- Account Type -->

<div class="input-box">

    <label>Account Type</label>

    <button type="submit"
            name="role"
            value="customer">
        👤 Customer Sign Up
    </button>

    <a href="adminSignup.jsp"
       style="
       display:block;
       text-align:center;
       text-decoration:none;
       background:#e23744;
       color:white;
       padding:13px;
       border-radius:8px;
       margin-top:15px;
       font-size:17px;">
        🏪 Restaurant Admin Sign Up
    </a>

</div>

    <!-- createDate and lastLoginDate should be set in Java/MySQL -->

    <button type="submit">
        Create Account
    </button>
    <% String msg = (String)request.getAttribute("errorMessage"); 
    if(msg != null){
    	%> 
    	<p style="color:red; text-align:center; margin-top:12px; font-weight:bold;">
    	 <%= msg %> 
    	 </p> 
    	 <% } %>

</form>

<div class="bottom">
Already have an account?
<a href="login.jsp">Sign In</a>
</div>

</div>

</body>
</html>

    