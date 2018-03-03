<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.* , beans.Details" %>
 
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
          <th >Dept</th>
          <th>D.O.C</th>
          <th> Topic</th>
           <th>Actions</th>
            <th>GPA</th>
             <th>Counsellors</th>
              <th>Edit</th>
          <th>Delete</th>
       </tr>
     <%
       List<Details> list = (List<Details>)     request.getAttribute("Details3");
       
     
       for(Details cycle2: list){
    	   
       %>
    
           <tr>
             <td><%= cycle2.getRollno() %></td>
             <td><%= cycle2.getRegno() %></td>
             <td><%= cycle2.getName() %></td>
             <td><%= cycle2.getDept() %></td>
             <td><%= cycle2.getDOC() %></td>
             <td><%= cycle2.getTopic() %></td>
             <td><%= cycle2.getActions() %></td>
             <td><%= cycle2.getGPA() %></td>
             <td><%= cycle2.getCounsellors() %></td>
             
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
   <script>var pfHeaderImgUrl = '';var pfHeaderTagline = '';var pfdisableClickToDel = 0;var pfHideImages = 0;var pfImageDisplayStyle = 'right';var pfDisablePDF = 0;var pfDisableEmail = 0;var pfDisablePrint = 0;var pfCustomCSS = '';var pfBtVersion='2';(function(){var js,pf;pf=document.createElement('script');pf.type='text/javascript';pf.src='//cdn.printfriendly.com/printfriendly.js';document.getElementsByTagName('head')[0].appendChild(pf)})();</script>
  <a href="https://www.printfriendly.com" style="color:#6D9F00;text-decoration:none;" class="printfriendly" onclick="window.print();return false;" title="Printer Friendly and PDF"><img style="border:none;-webkit-box-shadow:none;box-shadow:none;" src="//cdn.printfriendly.com/buttons/printfriendly-pdf-email-button-md.png" alt="Print Friendly and PDF"/></a>
 
    
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>