package utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataObj.Book;
import dataObj.Product;
import dataObj.UserAccount;
 
public class DBUtils {
 
  public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
 
      String sql = "Select a.User_Name, a.Password, a.Gender from user_account a "
              + " where a.User_Name = ? and a.password= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.setString(2, password);
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
          String gender = rs.getString("Gender");
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setPassword(password);
          user.setGender(gender);
          return user;
      }
      return null;
  }
 
  public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
      String sql = "Select a.User_Name, a.Password, a.Gender from user_account a " + " where a.User_Name = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
 
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
          String password = rs.getString("Password");
          String gender = rs.getString("Gender");
          UserAccount user = new UserAccount();
          user.setUserName(userName);
          user.setPassword(password);
          user.setGender(gender);
          return user;
      }
      return null;
  }
 
  public static List<Product> queryProduct(Connection conn) throws SQLException {
      String sql = "Select a.Code, a.Name, a.Price from product a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Product> list = new ArrayList<Product>();
      while (rs.next()) {
          String code = rs.getString("Code");
          String name = rs.getString("Name");
          float price = rs.getFloat("Price");
          Product product = new Product();
          product.setCode(code);
          product.setName(name);
          product.setPrice(price);
          list.add(product);
      }
      return list;
  }
 
  public static Product findProduct(Connection conn, String code) throws SQLException {
      String sql = "Select a.Code, a.Name, a.Price from product a where a.Code=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, code);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          String name = rs.getString("Name");
          float price = rs.getFloat("Price");
          Product product = new Product(code, name, price);
          return product;
      }
      return null;
  }
 
  public static void updateProduct(Connection conn, Product product) throws SQLException {
      String sql = "Update product set Name =?, Price=? where Code=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getName());
      pstm.setFloat(2, product.getPrice());
      pstm.setString(3, product.getCode());
      pstm.executeUpdate();
  }
 
  public static void insertProduct(Connection conn, Product product) throws SQLException {
      String sql = "Insert into product(Code, Name,Price) values (?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getCode());
      pstm.setString(2, product.getName());
      pstm.setFloat(3, product.getPrice());
 
      pstm.executeUpdate();
  }
 
  public static void deleteProduct(Connection conn, String code) throws SQLException {
      String sql = "Delete From product where Code= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, code);
 
      pstm.executeUpdate();
  }
  
  
  ////////////////////////////////////
  
  
  public static List<Book> queryBook(Connection conn) throws SQLException {
      String sql = "Select a.id, a.name, a.publisher, a.page from book a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Book> list = new ArrayList<Book>();
      while (rs.next()) {
          Integer id = rs.getInt("id");
          String name = rs.getString("name");
          String publisher = rs.getString("publisher");
          Integer page = rs.getInt("page");
          Book book = new Book();
          book.setId(id);
          book.setName(name);
          book.setPublisher(publisher);
          book.setPage(page);
          list.add(book);
      }
      return list;
  }
 
  public static Book findBook(Connection conn, Integer bookId) throws SQLException {
      String sql = "Select a.id, a.name, a.publisher, a.page from book a where a.id=?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setInt(1, bookId);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
    	  Integer id = rs.getInt("id");
          String name = rs.getString("name");
          String publisher = rs.getString("publisher");
          Integer page = rs.getInt("page");
          Book book = new Book(id, name, publisher, page);
          return book;
      }
      return null;
  }
 
  public static void updateBook(Connection conn, Book book) throws SQLException {
      String sql = "Update book set name =?, publisher=?, page=? where id=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, book.getName());
      pstm.setString(2, book.getPublisher());
      pstm.setInt(3, book.getPage());
      pstm.setInt(4, book.getId());
      pstm.executeUpdate();
  }
 
  public static void insertBook(Connection conn, Book book) throws SQLException {
      String sql = "Insert into book(name,publisher,page) values (?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, book.getName());
      pstm.setString(2, book.getPublisher());
      pstm.setInt(3, book.getPage());
 
      pstm.executeUpdate();
  }
 
  public static void deleteBook(Connection conn, Integer id) throws SQLException {
      String sql = "Delete From book where id= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setInt(1, id);
 
      pstm.executeUpdate();
  }
 
}