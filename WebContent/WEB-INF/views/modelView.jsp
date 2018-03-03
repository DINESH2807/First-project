<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Model</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Cycletest2</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Rollno</th>
          <th>Regno</th>
          <th>Name</th>
          <th>s1</th>
          <th>s2</th>
          <th> s3</th>
           <th>s4</th>
            <th>s5</th>
             <th>s6</th>
             
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${info}" var="model" >
          <tr>
             <td>${model.Rollno}</td>
             <td>${model.Regno}</td>
             <td>${model.Name}</td>
             <td>${model.s1}</td>
             <td>${model.s2}</td>
             <td>${model.s3}</td>
             <td>${model.s4}</td>
             <td>${model.s5}</td>
             <td>${model.s6}</td>
             
             <td>
                <a href="editModel?Rollno=${model.Rollno}">Edit</a>
             </td>
             <td>
                <a href="deleteModel1?Rollno=${model.Rollno}">Delete</a>
             </td>

          </tr>
       </c:forEach>
    </table>
 
    <a href="Createcycle2" >+</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>