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

@WebServlet(urlPatterns = { "/ajaxGetBookList" })
public class AjaxGetBookList extends HttpServlet{
	
	 
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AjaxGetBookList() {
	      super();
	  }
	 
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
	      
		  Connection conn = MyUtils.getStoredConnection(request);
			 
	      String errorString = null;
	      List<Book> list = new ArrayList<Book>();
	      try {
	          list = DBUtils.queryBook(conn);
	      } catch (SQLException e) {
	          e.printStackTrace();
	          errorString = e.getMessage();
	      }
	      
	      Gson gson = new Gson();
	      	
	      String json = gson.toJson(list);
		  
		  response.setContentType("text/plain");
		  PrintWriter out = response.getWriter();
		  out.print(json);
		  
	  }
	 
	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
		  doGet(request, response);
		  
	  }

}
