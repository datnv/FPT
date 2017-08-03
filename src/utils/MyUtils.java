package utils;
import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import dataObj.UserAccount;
 
public class MyUtils {
 
   public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
 
   private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
 
   // LÆ°u trá»¯ Connection vÃ o má»™t thuá»™c tÃ­nh cá»§a request.
   // ThÃ´ng tin lÆ°u trá»¯ chá»‰ tá»“n táº¡i trong thá»�i gian yÃªu cáº§u (request)
   // cho tá»›i khi dá»¯ liá»‡u Ä‘Æ°á»£c tráº£ vá»� trÃ¬nh duyá»‡t ngÆ°á»�i dÃ¹ng.
   public static void storeConnection(ServletRequest request, Connection conn) {
       request.setAttribute(ATT_NAME_CONNECTION, conn);
   }
 
   // Láº¥y Ä‘á»‘i tÆ°á»£ng Connection Ä‘Ã£ Ä‘Æ°á»£c lÆ°u trá»¯ trong 1 thuá»™c tÃ­nh cá»§a request.
   public static Connection getStoredConnection(ServletRequest request) {
       Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
       return conn;
   }
 
   // LÆ°u trá»¯ thÃ´ng tin ngÆ°á»�i dÃ¹ng Ä‘Ã£ login vÃ o Session
   public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
       // TrÃªn JSP cÃ³ thá»ƒ truy cáº­p ${loginedUser}
       session.setAttribute("loginedUser", loginedUser);
   }
 
   // Láº¥y thÃ´ng tin ngÆ°á»�i dÃ¹ng Ä‘Ã£ login trong session.
   public static UserAccount getLoginedUser(HttpSession session) {
       UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
       return loginedUser;
   }
 
   // LÆ°u thÃ´ng tin ngÆ°á»�i dÃ¹ng vÃ o Cookie.
   public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
       System.out.println("Store user cookie");
       Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());
       // 1 ngÃ y (Ä�Ã£ Ä‘á»•i ra giÃ¢y)
       cookieUserName.setMaxAge(24 * 60 * 60);
       response.addCookie(cookieUserName);
   }
 
   public static String getUserNameInCookie(HttpServletRequest request) {
       Cookie[] cookies = request.getCookies();
       if (cookies != null) {
           for (Cookie cookie : cookies) {
               if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                   return cookie.getValue();
               }
           }
       }
       return null;
   }
 
   // XÃ³a Cookie cá»§a ngÆ°á»�i dÃ¹ng
   public static void deleteUserCookie(HttpServletResponse response) {
       Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
       // 0 giÃ¢y. (Háº¿t háº¡n ngay láº­p tá»©c)
       cookieUserName.setMaxAge(0);
       response.addCookie(cookieUserName);
   }
 
}