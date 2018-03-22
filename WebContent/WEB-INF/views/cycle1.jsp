<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.* , beans.Cycle1" %>
 
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Cycle 1</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>Cycle Test 1</h3>
    <%-- --%>
   <p style="color: red;">${errorString}</p>  
    <form method="POST" action="doCycle1">
            <select name="Dept">
                   <option value="Cse">Cse</option>
               </select>
               <input type="submit" value="Go" />
    </form> 
   
   <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
       
          <th>Rollno</th>
          <th >Regno</th>
          <th >Name</th>
          <th>Dept</th>
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
       List<Cycle1> list = (List<Cycle1>)     request.getAttribute("Cycle1");
       
     
       for(Cycle1 cycle1: list){
    	   
       %>
    
           <tr>
             <td><%= cycle1.getRollno() %></td>
             <td><%= cycle1.getRegno() %></td>
             <td><%= cycle1.getName() %></td>
             <td><%= cycle1.getDept() %></td>
             <td><%= cycle1.gets1() %></td>
             <td><%= cycle1.gets2() %></td>
             <td><%= cycle1.gets3() %></td>
             <td><%= cycle1.gets4() %></td>
             <td><%= cycle1.gets5() %></td>
             <td><%= cycle1.gets6() %></td>
             
             <td>
                <a href="editCycle1?Rollno=<%= cycle1.getRollno()%>">Edit</a>
             </td>
             <td>
                <a href="deleteCycle1?Rollno=<%= cycle1.getRollno()%>">Delete</a>
             </td>

          </tr>
          
          <%
             }
       
          %>   
    

    <tr>
     <form method="POST" action="doCreatecycle1">
       
   
              
             <td><input type="text" name="Rollno" value="${cycle1.Rollno}" /></td>
         
            
             <td><input type="text" name="Regno" value="${cycle1.Regno}" /></td>
         
             <td><input type="text" name="Name" value="${cycle1.Name}" /></td>
          
             <td><input type="text" name="s1" value="${cycle1.s1}" /></td>
         
             <td><input type="text" name="s2" value="${cycle1.s2}" /></td>
        
             <td><input type="text" name="s3" value="${cycle1.s3}" /></td>
         
             <td><input type="text" name="s4" value="${cycle1.s4}" /></td>
         
             <td><input type="text" name="s5" value="${cycle1.s5}" /></td>
             
             <td><input type="text" name="s6" value="${cycle1.s6}" /></td>
          
           <td>
                  <input type="submit" value="Submit" />
             </td>
          
          </tr>
          
          </table>
    </form>
   
    
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>