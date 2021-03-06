package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Internal2;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/doInternal2" })
public class DoInternal2Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoInternal2Servlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       
       String Dept = (String) request.getParameter("Dept");
       Internal2 cycle1 = null;
 
       String errorString = null;
 
      
       // Product ID is the string literal [a-zA-Z_0-9]
       // with at least 1 character
       String regex = "\\w+";
 
       if (Dept == null || !Dept.matches(regex)) {
           errorString = "Dept invalid!";
       }
 
       if (errorString == null) {
           try {
               cycle1= DBUtils.findDept4(conn, Dept);
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           }
       }
        
       // Store information to request attribute, before forward to views.
      
 
       // If error, forward to Edit page.
       if (errorString != null && cycle1 == null) {
    	   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/internal2.jsp");
           dispatcher.forward(request, response);  
       }
 
       // If everything nice.
       // Redirect to the product listing page.            
       else {
    	   request.setAttribute("errorString", errorString);
           request.setAttribute("searchInternal2", cycle1);
           
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/internal2View.jsp");
           dispatcher.forward(request, response);  
       }
 
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
 
}