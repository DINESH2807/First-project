<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
    <style>
      body{
      	
      	color:#6a6f8c;
      }
</style>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>WELCOME</h3>
 
    User Name: <b>${user.userName}</b>
    <br />
 <%-- Gender: ${user.gender } <br />  --%> 
  
  Id: ${user.id } <br />
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>