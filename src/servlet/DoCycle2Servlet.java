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

import beans.Cycle2;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/doCycle2" })
public class DoCycle2Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoCycle2Servlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       
       String Dept = (String) request.getParameter("Dept");
       Cycle2 cycle1 = null;
 
       String errorString = null;
 
      
       // Product ID is the string literal [a-zA-Z_0-9]
       // with at least 1 character
       String regex = "\\w+";
 
       if (Dept == null || !Dept.matches(regex)) {
           errorString = "Dept invalid!";
       }
 
       if (errorString == null) {
           try {
               cycle1= DBUtils.findDept2(conn, Dept);
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           }
       }
        
       // Store information to request attribute, before forward to views.
      
 
       // If error, forward to Edit page.
       if (errorString != null && cycle1 == null) {
    	   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cycle2.jsp");
           dispatcher.forward(request, response);  
       }
 
       // If everything nice.
       // Redirect to the product listing page.            
       else {
    	   request.setAttribute("errorString", errorString);
           request.setAttribute("searchCycle2", cycle1);
           
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cycle2View.jsp");
           dispatcher.forward(request, response);  
       }
 
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
 
}