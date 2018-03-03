<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Edit Product</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <c:if test="${not empty student}">
       <form method="POST" action="doEdit1">
          <input type="hidden" name="Rollno" value="${student.Rollno}" />
          <table border="0">
             <tr>
                <td>Rollno</td>
                <td style="color:red;">${student.Rollno}</td>
             </tr>
             <tr>
                <td>Regno</td>
                <td><input type="text" name="regno" value="${student.Regno}" /></td>
             </tr>
             <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${student.Name}" /></td>
             </tr>
             <tr>
                <td>Dept</td>
                <td><input type="text" name="Dept" value="${student.Dept}" /></td>
             </tr>
             <tr>
                <td>GPA</td>
                <td><input type="text" name="GPA" value="${student.GPA}" /></td>
             </tr>
             <tr>
                <td>Counsellors</td>
                <td><input type="text" name="Counsellors" value="${student.Counsellors}" /></td>
             </tr>
             <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/infoList">Cancel</a>
                </td>
             </tr>
          </table>
       </form>
    </c:if>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>