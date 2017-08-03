package servletBooks;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;

import dataObj.Book;
import dataObj.Product;
import utils.DBUtils;
import utils.MyUtils;


@WebServlet(urlPatterns = { "/ajaxBookCreateNew" })
public class AjaxBookCreateNew extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AjaxBookCreateNew() {
	      super();
	  }
	 
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
	      Connection conn = MyUtils.getStoredConnection(request);
	      
	      String bookName = (String) request.getParameter("bookName");
	      String bookPublisher = (String) request.getParameter("bookPublisher");
	      String bookPage = (String) request.getParameter("bookPage");
	      Integer page = 0;
	      Integer id = 0;
	      try {
	          page = Integer.parseInt(bookPage);
	      } catch (Exception e) {
	      }
	      Book book = new Book(id, bookName, bookPublisher, page);
	 
	      String errorString = null;
	 
	      String regex = "\\w+";
	 
//	      if (errorString == null) {
	          try {
	              DBUtils.insertBook(conn, book);
	          } catch (SQLException e) {
	              e.printStackTrace();
	              errorString = e.getMessage();
	          }
//	      }
          response.setContentType("text/plain");
		  PrintWriter out = response.getWriter();
          if (errorString != null) {
        	  out.print("ERR:"+errorString);
          }
	      else {
	    	  out.print("ADD BOOK:" +bookName+"SUCCESS!");
	      }
	  }
	 
	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
	      doGet(request, response);
	  }

}
