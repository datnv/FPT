$(document).ready(function () {
     
	listProduct();
	$('#jqxwindowEdit').jqxWindow({  width: 320,
        height: 200, resizable: false,
        isModal: true,
        autoOpen: false,
        cancelButton: $('#bookCancel1'),
       
        initContent: function () {
            $('#bookAdd1').jqxButton({ width: '80px', disabled: false });
            $('#bookCancel1').jqxButton({ width: '80px', disabled: false });
           
        }
    });
	$('#jqxwindow').jqxWindow({  width: 320,
        height: 200, resizable: false,
        isModal: true,
        autoOpen: false,
        cancelButton: $('#bookCancel'),
       
        initContent: function () {
            $('#bookAdd').jqxButton({ width: '80px', disabled: false });
            $('#bookCancel').jqxButton({ width: '80px', disabled: false });
           
        }
    });
	$("#add").click(function () {
	    $("#jqxwindow").jqxWindow('open');
	});
	
	$("#bookAdd").click(function(){
		var bookName = $("#bookName").val();
		var bookPublisher = $("#bookPublisher").val();
		var bookPage = $("#bookPage").val();
		$.ajax({
			type: "POST",
			url : 'ajaxBookCreateNew',
			data : {
				bookName : bookName, bookPublisher: bookPublisher, bookPage: bookPage
			},
			success : function(responseText) {
				$("#jqxwindow").jqxWindow('close');
				$("#responeId").text(responseText);
				listProduct();
			}
		});
	});
	
	$("#bookAdd1").click(function(){
		var bookId = $("#bookId1").val();
		var bookName = $("#bookName1").val();
		var bookPublisher = $("#bookPublisher1").val();
		var bookPage = $("#bookPage1").val();
		$.ajax({
			type: "POST",
			url : 'ajaxBookEdit',
			data : {
				bookId:bookId, bookName : bookName, bookPublisher: bookPublisher, bookPage: bookPage
			},
			success : function(responseText) {
				$("#jqxwindowEdit").jqxWindow('close');
				$("#responeId").text(responseText);
				listProduct();
			}
		});
	});
});





var listProduct = function(){
	   var url = "ajaxGetBookList";

 // prepare the data
 var source =
 {
     datatype: "json",
     datafields: [
         { name: 'id' },
         { name: 'name' },
         { name: 'publisher' },
         { name: 'page'}
     ],
     url: url,
     root: 'data'
 };
 var dataAdapter = new $.jqx.dataAdapter(source);
 $("#jqxgrid").jqxGrid(
 {
 	showemptyrow: false,
 	showtoolbar: true,
 	width: '100%',
     theme:'light',
     source: dataAdapter,
     columnsresize: true,
     pageable: true,
     altrows:true,
     columns: [
       { text: 'ID', dataField: 'id', width: 200 },
       { text: 'Name', dataField: 'name'},
       { text: 'Publisher', dataField: 'publisher', width: 150, cellsalign: 'right' },
       { text: 'Page', dataField: 'page', width: 100, cellsalign: 'right' }
     ],
     rendertoolbar: function (toolbar) {
     	var container = $("<div style='overflow: hidden; position: relative; margin: 5px;'></div>");
         var addButton = $("<div id='add' style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='image/Add-icon.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Add</span></div>");
        
         var reloadButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='image/Refresh.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Edit</span></div>");
         var deleteButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='image/delete.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Delete</span></div>");
         var searchButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='image/search.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>View</span></div>");
         container.append(addButton);
         container.append(reloadButton);
         container.append(deleteButton);
         
         container.append(searchButton);
         toolbar.append(container);
         addButton.jqxButton({  width: 60, height: 20 });
         deleteButton.jqxButton({  width: 65, height: 20 });
         reloadButton.jqxButton({  width: 65, height: 20 });
         searchButton.jqxButton({  width: 50, height: 20 });
         // add new row.
         addButton.click(function (event) {
        	 $("#jqxwindow").jqxWindow('open');
         });
         // delete selected row.
         deleteButton.click(function (event) {
             var selectedrowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
             var data = $('#jqxgrid').jqxGrid('getrowdata', selectedrowindex);
             $("#jqxgrid").jqxGrid('deleterow', id);
             
	             $.ajax({
	     			type: "POST",
	     			url : 'ajaxBookDelete',
	     			data : {
	     				bookId: data.id
	     			},
	     			success : function(responseText) {
	     				$("#responeId").text(responseText);
	     				listProduct();
	     			}
	     		});
             
         });
         // reload grid data.
         reloadButton.click(function (event) {
        	 var selectedrowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
             var data = $('#jqxgrid').jqxGrid('getrowdata', selectedrowindex);
             console.log(data);
             $("#jqxwindowEdit").jqxWindow('open');
             $("#bookId1").val(data.id);
             $("#bookName1").val(data.name);
             $("#bookPublisher1").val(data.publisher);
             $("#bookPage1").val(data.page);
        	 
         });
         // search for a record.
         searchButton.click(function (event) {
             var offset = $("#jqxgrid").offset();
             $("#jqxwindow").jqxWindow('open');
             $("#jqxwindow").jqxWindow('move', offset.left + 30, offset.top + 30);
         });
     }
 });

}
var renderer = function (row, column, value, rowData){
	return '<a onClick="buttonclick('+rowData.Code1+')" >aa</a>';
	
};

var buttonclick = function (rowData) {
	
}
var popupApp = function (row){
	alert(row);
};