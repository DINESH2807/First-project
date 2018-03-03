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

import beans.Retest2;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/retest2List" })
public class Retest2ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Retest2ListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Retest2> list = new ArrayList<Retest2>();
        try {
            list = DBUtils.queryRetest2(conn);
        	
        	
        	
        	
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("Retest2", list);
         
     
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/retest2.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}