<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp" ></jsp:include>
 <head>  
     <style>
      body{
      	
      	color:#6a6f8c;
      }
</style>
</head> 

<div style="padding: 5px;">

<h1 align = "center"> Marks</h1>
 
  <table border="0" cellspacing="100" align = "center">
   
 <tr> <td> <a href="${pageContext.request.contextPath}/cycle1List">Cycle 1</a> </td>   <td> <a href="${pageContext.request.contextPath}/internal1List">Internal 1</a> </td> <td>  <a href="${pageContext.request.contextPath}/retest1List">Retest 1</a> </td></tr> 
   
 <tr>  <td><a href="${pageContext.request.contextPath}/cycle2List">Cycle 2</a></td>  <td> <a href="${pageContext.request.contextPath}/internal2List">Internal 2</a></td>  <td> <a href="${pageContext.request.contextPath}/retest2List">Retest 2</a> </td></tr> 
   
 <tr> <td> <a href="${pageContext.request.contextPath}/revisionList">Revision 1</a> </td> <td> <a href="${pageContext.request.contextPath}/modelList">Model</a></td>  <td> <a href="${pageContext.request.contextPath}/remodelList">Remodel</a> </td> </tr>
   
   
   
  </table>
    
    
</div>  