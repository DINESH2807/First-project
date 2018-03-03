<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>ADD DETAIL</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>ADD DETAIL</h3>
    
    <p style="color: red;">${errorString}</p>
    
    <form method="POST" action="doCreateRow">
       <table border="0">
          <tr>
             <td>Rollno</td>
             <td><input type="text" name="Rollno" value="${feedback.Rollno}" /></td>
          </tr>
          <tr>
             <td>Regno</td>
             <td><input type="text" name="Regno" value="${feedback.Regno}" /></td>
          </tr>
          <tr>
             <td>Name</td>
             <td><input type="text" name="Name" value="${feedback.Name}" /></td>
          </tr>
          <tr>
             <td>DOC</td>
             <td><input type="text" name="Dept" value="${feedback.DOC}" /></td>
          </tr>
          <tr>
             <td>Topic</td>
             <td><input type="text" name="GPA" value="${feedback.Topic}" /></td>
          </tr>
             <tr>
             <td>Action Taken</td>
             <td><input type="text" name="GPA" value="${feedback.Action_Taken}" /></td>
          </tr>
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="Submit" />
                 <a href="List1">Cancel</a>
             </td>
          </tr>
       </table>
    </form>
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>