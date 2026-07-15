<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TasteIt - Login</title>
<link rel="icon"
      type="image/png"
      href="<%=request.getContextPath()%>/image/logo.png">

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(rgba(0,0,0,0.45),rgba(0,0,0,0.45)),
    url("https://images.unsplash.com/photo-1513104890138-7c749659a591?w=1600");
    background-size:cover;
    background-position:center;
}

.login-container{
    width:420px;
    background:#ffffff;
    border-radius:18px;
    padding:35px;
    box-shadow:0 8px 30px rgba(0,0,0,0.25);
}

.logo{
    display:flex;
    align-items:center;
    gap:10px;
    font-size:30px;
    font-weight:bold;
}

.logo img{
    width:50px;
    height:50px;
    object-fit:contain;
}

.subtitle{
    text-align:center;
    color:#666;
    margin-bottom:25px;
}

.input-box{
    margin-bottom:18px;
}

.input-box label{
    display:block;
    margin-bottom:6px;
    font-weight:600;
    color:#333;
}

.input-box input{
    width:100%;
    padding:13px;
    border:1px solid #dcdcdc;
    border-radius:10px;
    outline:none;
    font-size:15px;
    transition:0.3s;
}

.input-box input:focus{
    border-color:#e23744;
}

.forgot{
    text-align:right;
    margin-top:-8px;
    margin-bottom:20px;
}

.forgot a{
    text-decoration:none;
    color:#e23744;
    font-size:14px;
}

button{
    width:100%;
    padding:14px;
    border:none;
    border-radius:10px;
    background:#e23744;
    color:white;
    font-size:17px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#c71e2f;
}

.bottom{
    margin-top:22px;
    text-align:center;
    color:#555;
}

.bottom a{
    text-decoration:none;
    color:#e23744;
    font-weight:bold;
}

.or{
    margin:20px 0;
    text-align:center;
    color:#999;
    position:relative;
}

.or::before,
.or::after{
    content:"";
    position:absolute;
    top:50%;
    width:40%;
    height:1px;
    background:#ddd;
}

.or::before{
    left:0;
}

.or::after{
    right:0;
}
</style>

</head>

<body>

<div class="login-container">

    <div class="logo">
    <img src="<%=request.getContextPath()%>/image/logo.png" alt="Logo">
    <span>TasteIt</span>
</div>
    <div class="subtitle">
        Welcome Back! Login to continue ordering.
    </div>

    <form action="./LoginServlet" method="post">

        <div class="input-box">
            <label>Email</label>
            <input type="email"
                   name="email"
                   placeholder="Enter your email"
                   required>
        </div>

        <div class="input-box">
            <label>Password</label>
            <input type="password"
                   name="password"
                   placeholder="Enter your password"
                   required>
        </div>
        <div class="input-box">
    <label>Login As</label>

    <select name="role" required>
        <option value="">Select Role</option>
        <option value="customer">Customer</option>
        <option value="Restaurant Admin">Restaurant Admin</option>
    </select>
</div>

        <div class="forgot">
            <a href="#">Forgot Password?</a>
        </div>

        <button type="submit">
            Login
        </button>
        
<%
String msg = (String)request.getAttribute("errorMessage");

if(msg != null){
%>

<p style="color:red;
          text-align:center;
          margin-top:10px;
          font-weight:bold;">
    <%= msg %>
</p>

<%
}
%>

        

    </form>

    <div class="or">
        OR
    </div>

    <div class="bottom">
        Don't have an account?
        <a href="signup.jsp">Sign Up</a>
    </div>

</div>

</body>
</html>
    