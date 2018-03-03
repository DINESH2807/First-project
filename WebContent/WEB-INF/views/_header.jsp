<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<script>
function f1()
{
	
	}
</script>
</head>
</html>




<div style="opacity:0.5 ;color:black; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>Councellors Info </h1>
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
     <!-- User store in session with attribute: loginedUser -->
     Hello <b>${loginedUser.userName}</b>
     </br>
     <a href="${pageContext.request.contextPath}/logout">Logout</a>
   </div>
 
</div>
