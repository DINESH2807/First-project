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

import beans.Cycle1;
import beans.Student;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/cycle1List" })
public class Cycle1ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Cycle1ListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Cycle1> list = new ArrayList<Cycle1>();
        try {
            list = DBUtils.queryCycle1(conn);
        	
        	
        	
        	
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("Cycle1", list);
         
     
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cycle1.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}