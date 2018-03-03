package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/doSearch" })
public class DoSearchServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoSearchServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       String Rollno = (String) request.getParameter("Rollno");
     
    
    
       Student student = null;
       String errorString = null;
 
     
       // Product ID is the string literal [a-zA-Z_0-9]
       // with at least 1 character
       String regex = "\\w+";
 
       if (Rollno == null || !Rollno.matches(regex)) {
           errorString = "Student Rollno invalid!";
       }
 
    
	if (errorString == null) {
           try {
              student =  DBUtils.findStudent(conn, Rollno);
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           }
       }
        
	          // Store information to request attribute, before forward to views.
       
 
      
       if (errorString != null && student == null) {
    	   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/infoView.jsp");
           dispatcher.forward(request, response);  
         
       }
       else{
       request.setAttribute("errorString", errorString);
       request.setAttribute("searchList", student);
       
       
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/searchView.jsp");
       dispatcher.forward(request, response);  
       }
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
 
}