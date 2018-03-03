<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
     <style>
      body{
      	background-image:url("http://wallpoop.com/wp-content/uploads/2013/03/wallpaper-elegant-background-grey-illumination-wallpaper-wallpapers.jpg");
      	color:#6a6f8c;
      }
</style>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>feedback</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Rollno</th>
          <th>Regno</th>
          <th>Name</th>
          <th>DOC</th>
          <th>Topic</th>
          <th> Actions Taken </th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${Feedback}" var="feedback" >
          <tr>
             <td>${feedback.Rollno}</td>
             <td>${feedback.Regno}</td>
             <td>${feedback.Name}</td>
             <td>${feedback.DOC}</td>
              <td>${feedback.Topic}</td>
             <td>${feedback.Action_taken}</td>
             <td>
                <a href="editFeedback?Rollno=${feedback.Rollno}">Edit</a>
             </td>
             <td>
                <a href="deleteFeedback?Rollno=${feedback.Rollno}">Delete</a>
             </td>
             
            
			             
             
          </tr>
       </c:forEach>
    </table>
 
    <a href="create1" >+</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>