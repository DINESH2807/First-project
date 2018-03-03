<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

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