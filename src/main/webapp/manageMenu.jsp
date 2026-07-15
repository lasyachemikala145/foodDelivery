<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Menu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Menu</title>
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
.logo{
    display:flex;
    align-items:center;
    gap:10px;
    color:#FFD700;
    font-size:30px;
    font-weight:bold;
    padding-left: 20px;
}

.logo img{
    width:50px;
    height:50px;
    object-fit:contain;
}

body{
    background:#f5f6fa;
}

.container{
    display:flex;
}

/* Sidebar */

.sidebar{
    width:240px;
    min-height:100vh;
    background:#e23744;
    color:white;
    position:fixed;
}

.logo{
    padding:25px;
    font-size:30px;
    font-weight:bold;
    text-align:center;
}

.sidebar ul{
    list-style:none;
}

.sidebar ul li{
    padding:18px 30px;
}

.sidebar ul li:hover{
    background:#c62839;
}

.sidebar ul li a{
    text-decoration:none;
    color:white;
    font-size:18px;
    display:block;
}

/* Main */

.main{
    margin-left:240px;
    width:calc(100% - 240px);
    padding:30px;
}

.heading{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:25px;
}

.heading h1{
    color:#333;
}

.addBtn{
    background:#28a745;
    color:white;
    padding:12px 20px;
    text-decoration:none;
    border-radius:8px;
    font-weight:bold;
}

.addBtn:hover{
    background:#218838;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
    border-radius:10px;
    overflow:hidden;
    box-shadow:0 3px 10px rgba(0,0,0,.15);
}

th{
    background:#e23744;
    color:white;
    padding:15px;
}

td{
    padding:15px;
    text-align:center;
    border-bottom:1px solid #ddd;
}

img{
    width:90px;
    height:70px;
    border-radius:10px;
}

.edit{
    background:#007bff;
    color:white;
    padding:8px 14px;
    border-radius:5px;
    text-decoration:none;
}

.delete{
    background:red;
    color:white;
    padding:8px 14px;
    border-radius:5px;
    text-decoration:none;
}

.edit:hover{
    background:#0056b3;
}

.delete:hover{
    background:#c82333;
}

</style>

</head>

<body>

<div class="container">

    <!-- Sidebar -->

    <div class="sidebar">

         <div class="logo">
    <img src="<%=request.getContextPath()%>/image/logo.png" alt="Logo">
    <span>TasteIt</span>
</div>

        <ul>

            <li>
                <a href="adminDashboard">🏠 Dashboard</a>
            </li>

            <li>
                <a href="manageMenu">🍔 Manage Menu</a>
            </li>

            <li>
                <a href="manageOrders">📦 Orders</a>
            </li>

            <li>
                <a href="restaurantProfile">🏪 Restaurant Profile</a>
            </li>

            <li>
                <a href="login.jsp">🚪 Logout</a>
            </li>

        </ul>

    </div>



    <!-- Main -->

    <div class="main">

        <div class="heading">

            <h1>Manage Menu</h1>

            <a class="addBtn" href="addMenu.jsp">
                + Add Menu Item
            </a>

        </div>


        <table>

            <tr>

                <th>ID</th>

                <th>Image</th>

                <th>Item Name</th>

                <th>Category</th>

                <th>Price</th>

                <th>Rating</th>

                <th>Action</th>

            </tr>

            <%

            List<Menu> menuList=(List<Menu>)request.getAttribute("menuList");

            if(menuList!=null){

            for(Menu m:menuList){

            %>

            <tr>

                <td><%=m.getMenu_id()%></td>

                <td>

                <img src="<%=m.getImgurl()%>">

                </td>

                <td><%=m.getNameofitem()%></td>

                <td><%=m.getCategory()%></td>

                <td>₹ <%=m.getPrice()%></td>

                <td><%=m.getRating()%></td>

                <td>

                    <a class="edit"
                    href="editMenu?menu_id=<%=m.getMenu_id()%>">

                    Edit

                    </a>

                    &nbsp;

                    <a class="delete"
                    href="deleteMenu?menu_id=<%=m.getMenu_id()%>"
                    onclick="return confirm('Delete this menu item?')">

                    Delete

                    </a>

                </td>

            </tr>

            <%

            }

            }

            else{

            %>

            <tr>

                <td colspan="7">

                    No Menu Items Found

                </td>

            </tr>

            <%

            }

            %>

        </table>

    </div>

</div>

</body>
</html>