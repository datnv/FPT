package servletBooks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dataObj.Book;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/ajaxBookDelete" })
public class AjaxBookDelete extends HttpServlet{
	
	 
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AjaxBookDelete() {
	      super();
	  }
	 
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
	      
		  Connection conn = MyUtils.getStoredConnection(request);
		  
		  String bookId = (String) request.getParameter("bookId");
		  Integer id = 0;
		  try {
			  id = Integer.parseInt(bookId);
	      } catch (Exception e) {
	      }
	      String errorString = null;
	 
	      try {
	          DBUtils.deleteBook(conn, id);
	      } catch (SQLException e) {
	          e.printStackTrace();
	          errorString = e.getMessage();
	      }
		  
	      response.setContentType("text/plain");
		  PrintWriter out = response.getWriter();
          if (errorString != null) {
        	  out.print("ERR:"+errorString);
          }
	      else {
	    	  out.print("Delete BOOK ID: " +id+" SUCCESS!");
	      }
	  }
	 
	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
		  doGet(request, response);
		  
	  }

}
