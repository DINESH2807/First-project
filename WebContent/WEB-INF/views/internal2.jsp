<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.* , beans.Internal2" %>
 
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
   
   <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
       
          <th>Rollno</th>
          <th >Regno</th>
          <th >Name</th>
          <th >s1</th>
          <th>s2</th>
          <th> s3</th>
           <th>s4</th>
            <th>s5</th>
             <th>s6</th>
              <th>Edit</th>
          <th>Delete</th>
       </tr>
     <%
       List<Internal2> list = (List<Internal2>)     request.getAttribute("Internal2");
       
     
       for(Internal2 cycle2: list){
    	   
       %>
    
           <tr>
             <td><%= cycle2.getRollno() %></td>
             <td><%= cycle2.getRegno() %></td>
             <td><%= cycle2.getName() %></td>
             <td><%= cycle2.gets1() %></td>
             <td><%= cycle2.gets2() %></td>
             <td><%= cycle2.gets3() %></td>
             <td><%= cycle2.gets4() %></td>
             <td><%= cycle2.gets5() %></td>
             <td><%= cycle2.gets6() %></td>
             
             <td>
                <a href="editCycle1?Rollno=<%= cycle2.getRollno()%>">Edit</a>
             </td>
             <td>
                <a href="deleteCycle1?Rollno=<%= cycle2.getRollno()%>">Delete</a>
             </td>

          </tr>
          
          <%
             }
       
          %>   
    

    <tr>
     <form method="POST" action="doCreatecycle2">
       
   
              
             <td><input type="text" name="Rollno" value="${cycle2.Rollno}" /></td>
         
            
             <td><input type="text" name="Regno" value="${cycle2.Regno}" /></td>
         
             <td><input type="text" name="Name" value="${cycle2.Name}" /></td>
          
             <td><input type="text" name="s1" value="${cycle2.s1}" /></td>
         
             <td><input type="text" name="s2" value="${cycle2.s2}" /></td>
        
             <td><input type="text" name="s3" value="${cycle2.s3}" /></td>
         
             <td><input type="text" name="s4" value="${cycle2.s4}" /></td>
         
             <td><input type="text" name="s5" value="${cycle2.s5}" /></td>
             
             <td><input type="text" name="s6" value="${cycle2.s6}" /></td>
          
           <td>
                  <input type="submit" value="Submit" />
             </td>
          
          </tr>
          
          </table>
    </form>
   
    
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>