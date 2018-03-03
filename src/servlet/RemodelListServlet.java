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


import beans.Remodel;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/remodelList" })
public class RemodelListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public RemodelListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Remodel> list = new ArrayList<Remodel>();
        try {
            list = DBUtils.queryRemodel(conn);
        	
        	
        	
        	
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("Remodel", list);
         
     
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/remodel.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}