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
 
import beans.Student;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/doEdit1" })
public class DoEdit1Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoEdit1Servlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       String Rollno = (String) request.getParameter("Rollno");
       String Regno = (String) request.getParameter("Regno");
       String Name = (String) request.getParameter("Name");
       String Dept = (String) request.getParameter("Dept");
       String GPAStr = (String) request.getParameter("GPA");
       String Counsellors = (String) request.getParameter("Counsellors");
       float GPA = 0;
       try {
           GPA = Float.parseFloat(GPAStr);
       } catch (Exception e) {
       }
       Student student = new Student();
       student.setRollno(Rollno);
       student.setRegno(Regno);
       student.setName(Name);
       student.setDept(Dept);
       student.setGPA(GPA);
       student.setCounsellors(Counsellors);
 
       String errorString = null;
 
       try {
           DBUtils.updateStudent(conn, student);
       } catch (SQLException e) {
           e.printStackTrace();
           errorString = e.getMessage();
       }
 
       // Store information to request attribute, before forward to views.
       request.setAttribute("errorString", errorString);
       request.setAttribute("student", student);
 
 
       // If error, forward to Edit page.
       if (errorString != null) {
           RequestDispatcher dispatcher = request.getServletContext()
                   .getRequestDispatcher("/WEB-INF/views/editView.jsp");
           dispatcher.forward(request, response);
       }
        
       // If everything nice.
       // Redirect to the product listing page.            
       else {
           response.sendRedirect(request.getContextPath() + "/List1");
       }
 
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
 
}