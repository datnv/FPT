<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
 
    
 	<script type="text/javascript" src="js/jqxgrid.js"></script>
    <script type="text/javascript" src="js/jqxgrid.selection.js"></script> 
    <script type="text/javascript" src="js/jqxgrid.columnsresize.js"></script> 
    <script type="text/javascript" src="js/jqxdata.js"></script> 
    <script type="text/javascript" src="js/jqxgrid.pager.js"></script>
    <script type="text/javascript" src="js/jqxlistbox.js"></script>
    <script type="text/javascript" src="js/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="js/jqxwindow.js"></script>
    <script type="text/javascript" src="js/jqxcheckbox.js"></script>
    
 
 	<script type="text/javascript" src="jsSource/listBooks.js"></script>
    
    <h3>Product List</h3>
    Note: select table row to delete, edit.
    <p id="responeId" style="color: red;"></p>
    <div id='jqxWidget' style="font-size: 13px; font-family: Verdana;">
        <div id="jqxgrid"></div>
    </div>
 
<div id="jqxwindow">
    <div>
    	<span id="captureContainer" style="float: left">Add New Book</span>
    </div>
    <div>
		<div style="margin: 10px">
			<table border="0">
				<tr>
					<td>Book ID</td>
					<td><input id="bookId" type="text" disabled /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input id="bookName" type="text"/></td>
				</tr>
				<tr>
					<td>Publisher</td>
					<td><input type="text" id="bookPublisher"/></td>
				</tr>
				<tr>
					<td>Page</td>
					<td><input type="text" id="bookPage"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div style="float: right">
							<input type="button" value="New" id="bookAdd" /> 
							<input type="button" value="Cancel" id="bookCancel" />
						</div>
					</td>
				</tr>
			</table>
         </div>
	</div>
</div>


<div id="jqxwindowEdit">
    <div>
    	<span id="captureContainer" style="float: left">Edit Book</span>
    </div>
    <div>
		<div style="margin: 10px">
			<table border="0">
				<tr>
					<td>Book ID</td>
					<td><input id="bookId1" type="text" disabled /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input id="bookName1" type="text"/></td>
				</tr>
				<tr>
					<td>Publisher</td>
					<td><input type="text" id="bookPublisher1"/></td>
				</tr>
				<tr>
					<td>Page</td>
					<td><input type="text" id="bookPage1"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div style="float: right">
							<input type="button" value="Update" id="bookAdd1" /> 
							<input type="button" value="Cancel" id="bookCancel1" />
						</div>
					</td>
				</tr>
			</table>
         </div>
	</div>
</div>
	<jsp:include page="_footer.jsp"></jsp:include>