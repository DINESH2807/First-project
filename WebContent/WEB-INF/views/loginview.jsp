<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>

<h2> Login Form</h2>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Enter</button>

<div id="id01" class="modal">
  
  <form method="POST" class="modal-content animate" action="doLogin">
   <%--  <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="download.jpeg" alt="Avatar" class="avatar">
    </div>
--%>
    <div class="container">
      <label for="userName"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="userName" required value= "${user.userName}">

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required value= "${user.password}">
        
     <button type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>

    <%-- <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>--%>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>

<%-- 
<!DOCTYPE html>
<html>

 <head>
    <meta charset="UTF-8">
    <title>Login</title>
 <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

      <style>
      body{
    
      	margin:0;
      	color:#6a6f8c;

      	font:600 16px/18px 'Open Sans',sans-serif;
      }
      *,:after,:before{box-sizing:border-box}
      .clearfix:after,.clearfix:before{content:'';display:table}
      .clearfix:after{clear:both;display:block}
      a{color:inherit;text-decoration:none}

      .login-wrap{
      	width:100%;
      	margin:auto;
      	max-width:525px;
      	min-height:670px;
      	position:relative;
      	background:url("http://wallpoop.com/wp-content/uploads/2013/03/wallpaper-elegant-background-grey-illumination-wallpaper-wallpapers.jpg") no-repeat center;
      	box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
      }
      .login-html{
      	width:100%;
      	height:100%;
      	position:absolute;
      	padding:90px 70px 50px 70px;
      }
      .login-html .sign-in-htm,
      .login-html .sign-up-htm{
      	top:0;
      	left:0;
      	right:0;
      	bottom:0;
      	position:absolute;
      	-webkit-transform:rotateY(180deg);
      	        transform:rotateY(180deg);
      	-webkit-backface-visibility:hidden;
      	        backface-visibility:hidden;
      	-webkit-transition:all .4s linear;
      	transition:all .4s linear;
      }
      .login-html .sign-in,
      .login-html .sign-up,
      .login-form .group .check{
      	display:none;
      }
      .login-html .tab,
      .login-form .group .label,
      .login-form .group .button{
      	text-transform:uppercase;
      }
      .login-html .tab{
      	font-size:22px;
      	margin-right:15px;
      	padding-bottom:5px;
      	margin:0 15px 10px 0;
      	display:inline-block;
      	border-bottom:2px solid transparent;
      }
      .login-html .sign-in:checked + .tab,
      .login-html .sign-up:checked + .tab{
      	color:#fff;
      	border-color:#1161ee;
      }
      .login-form{
      	min-height:345px;
      	position:relative;
      	-webkit-perspective:1000px;
      	        perspective:1000px;
      	-webkit-transform-style:preserve-3d;
      	        transform-style:preserve-3d;
      }
      .login-form .group{
      	margin-bottom:15px;
      }
      .login-form .group .label,
      .login-form .group .input,
      .login-form .group .button{
      	width:100%;
      	color:#fff;
      	display:block;
        font-size:18px;
      }
      .login-form .group .input,
      .login-form .group .button{
      	border:none;
      	padding:15px 20px;
      	border-radius:25px;
      	background:rgba(255,255,255,.1);
      }
      .login-form .group input[data-type="password"]{
      	text-security:circle;
      	-webkit-text-security:circle;
      }
      .login-form .group .label{
      	color:#aaa;
      	font-size:12px;
      }
      .login-form .group .button{
      	background:#1161ee;
      }
      .login-form .group label .icon{
      	width:15px;
      	height:15px;
      	border-radius:2px;
      	position:relative;
      	display:inline-block;
      	background:rgba(255,255,255,.1);
      }
      .login-form .group label .icon:before,
      .login-form .group label .icon:after{
      	content:'';
      	width:10px;
      	height:2px;
      	background:#fff;
      	position:absolute;
      	-webkit-transition:all .2s ease-in-out 0s;
      	transition:all .2s ease-in-out 0s;
      }
      .login-form .group label .icon:before{
      	left:3px;
      	width:5px;
      	bottom:6px;
      	-webkit-transform:scale(0) rotate(0);
      	        transform:scale(0) rotate(0);
      }
      .login-form .group label .icon:after{
      	top:0px;
      	right:0;
      	-webkit-transform:scale(0) rotate(0);
      	        transform:scale(0) rotate(0);
      }
      .login-form .group .check:checked + label{
      	color:#fff;
      }
      .login-form .group .check:checked + label .icon{
      	background:#1161ee;
      }
      .login-form .group .check:checked + label .icon:before{
      	-webkit-transform:scale(1) rotate(45deg);
      	        transform:scale(1) rotate(45deg);
      }
      .login-form .group .check:checked + label .icon:after{
      	-webkit-transform:scale(1) rotate(-45deg);
      	        transform:scale(1) rotate(-45deg);
      }
      .login-html .sign-in:checked + .tab + .sign-up + .tab + .login-form .sign-in-htm{
      	-webkit-transform:rotate(0);
      	        transform:rotate(0);
      }
      .login-html .sign-up:checked + .tab + .login-form .sign-up-htm{
      	-webkit-transform:rotate(0);
      	        transform:rotate(0);
      }

      .hr{
      	height:2px;
      	margin:60px 0 50px 0;
      	background:rgba(255,255,255,.2);
      }
      .foot-lnk{
      	text-align:center;
      }
</style>


 </head>
 
  <body style="background-color:#1e1d1d">

    <style>
  html, body {
    height: 100%;
  }
  #tableContainer-1 {
    height: 100%;
    width: 100%;
    display: table;
  }
  #tableContainer-2 {
    vertical-align: middle;
    display: table-cell;
    height: 100%;
  }
</style>
<div id="tableContainer-1">
  <div id="tableContainer-2">
       
    <form method="POST" action="doLogin" >
       <table border="1" align="Center" bgcolor="d5d5d5" cellpadding="25px">
          <tr>
        <td> <h2 ALIGN="CENTER">Login Page</h2> </td>
       </tr>
    <p style="color: red;">${errorString} </p>
          
          
          <tr>
             
             <td><input type="text" name="userName" class="form-control" placeholder="Username" autofocus= ""  value= "${user.userName}" /> </td>
          </tr>
          <tr>
             
             <td><input type="password" name="password" class="form-control" placeholder="Password" autofocus= "" value= "${user.password}" /> </td>
          </tr>
          <tr>
             <td colspan ="2" align="center">
                <input type="submit" value= "Submit" />
                <a href="${pageContext.request.contextPath}/">Cancel</a>
             </td>
          </tr>
       </table>
       </form>
       </div>
      </div>
   </body> 
 </html>
 --%>