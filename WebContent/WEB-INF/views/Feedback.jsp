<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp" ></jsp:include>
 <head>  
 <title>Couselling Feedback</title>
     <style>
      body{
      	
      	color:#6a6f8c;
      }
</style>
</head> 

<div style="padding: 5px;">

<h1 align = "center"> Couselling</h1>
 
  <table border="0" cellspacing="100" align = "center">
   
 <tr> <td> <a href="${pageContext.request.contextPath}/detailsList">Feedback 1</a> </td>   <td> <a href="${pageContext.request.contextPath}/details1List">Feedback 2</a> </td> </tr> 
   
 <tr>  <td><a href="${pageContext.request.contextPath}/details2List">Feedback 3</a></td>  <td> <a href="${pageContext.request.contextPath}/details3List">Feedback 4</a></td>  </tr>
   
   
  </table>
    
    
</div>  