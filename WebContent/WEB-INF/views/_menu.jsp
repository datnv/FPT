<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
	
<div style="padding: 5px;">
    <script type="text/javascript">
            $(document).ready(function () {
                // Create a jqxMenu
                $("#jqxMenu").jqxMenu({ width: '100%', height: 30});
            });
        </script>
    <div id='jqxMenu'>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/bookList">Book List</a></li>
        <li><a href="${pageContext.request.contextPath}/userInfo">My Account Info</a></li>
        <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
    </ul>
</div>
</div>  