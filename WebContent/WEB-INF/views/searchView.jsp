<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.util.* , beans.Student" %> 

<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Search Info</title>
     <style>
      body{
      
      	color:#6a6f8c;
      }
</style>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Search Info</h3>
 
 
 	 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Rollno</th>
          <th>Regno</th>
          <th>Name</th>
          <th>Dept</th>
          <th>GPA</th>
          <%-- -<th>Counsellor</th> --%>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       
       <%
         Student student = (Student) request.getAttribute("searchList");
       
      
       
       %>
       
 
          <tr>
             <td><%= student.getRollno() %></td>
             <td><%= student.getRegno() %></td>
             <td><%= student.getName() %></td>
             <td><%= student.getDept() %></td>
             <td><%= student.getGPA() %></td>
            <%--  <td><%= student.getCounsellors() %></td>  --%>
             <td>
                <a href="edit1?Rollno=<%= student.getRollno() %>">Edit</a>
              </td>
             <td>
                <a href="delete1?Rollno=<%= student.getRollno() %>">Delete</a>
             </td>  
            
            
          </tr>

            
                 
    </table>
  <script>var pfHeaderImgUrl = '';var pfHeaderTagline = '';var pfdisableClickToDel = 0;var pfHideImages = 0;var pfImageDisplayStyle = 'right';var pfDisablePDF = 0;var pfDisableEmail = 0;var pfDisablePrint = 0;var pfCustomCSS = '';var pfBtVersion='2';(function(){var js,pf;pf=document.createElement('script');pf.type='text/javascript';pf.src='//cdn.printfriendly.com/printfriendly.js';document.getElementsByTagName('head')[0].appendChild(pf)})();</script>
  <a href="https://www.printfriendly.com" style="color:#6D9F00;text-decoration:none;" class="printfriendly" onclick="window.print();return false;" title="Printer Friendly and PDF"><img style="border:none;-webkit-box-shadow:none;box-shadow:none;" src="//cdn.printfriendly.com/buttons/printfriendly-pdf-email-button-md.png" alt="Print Friendly and PDF"/></a>
 
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>