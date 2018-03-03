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

import beans.Retest1;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/retest1List" })
public class Retest1ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Retest1ListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Retest1> list = new ArrayList<Retest1>();
        try {
            list = DBUtils.queryRetest1(conn);
        	
        	
        	
        	
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("Retest1", list);
         
     
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/retest1.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}