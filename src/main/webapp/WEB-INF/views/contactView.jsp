<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

 <h1 style="color: blue; text-align: center">VIEW CONTACT PAGE!!</h1>   
 
 <a href="view">+Add New Contact</a><br/>
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
 <script src="
https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

 <script>
 $(document).ready(function() {
	    $('#contactTbl').DataTable( {
	        "pagingType": "full_numbers"
	    } );
	} );
 
	function deleteConfirm(){
		return confirm("Are you sure,you want to delete?");
		}
	</script>
 <table border="2"  id="contactTbl">
 	<thead>
 		<tr bgcolor="green">
 			<th>SINO</th>
 			<th>NAME</th>
 			<th>EMAIL</th>
 			<th>MOBNO</th>
 			<th>ACTION</th>
 		</tr>
 	</thead>
 	
 	<tbody >
 		<c:forEach items="${contact }" var="ob" varStatus="index">
 			<tr >
				<td >${index.count+1 }</td> 		
				<td >${ob.contactName }</td> 		
				<td >${ob.contactEmail }</td> 		
				<td >${ob.contactNumber }</td> 
				<td bgcolor="yellow"><a href="edit?id=${ob.contactId }">Edit</a> |		
									 <a href="delete?id=${ob.contactId }" onclick="deleteConfirm()">Delete</a></td>		
 			</tr>
 		 
 		</c:forEach>
 	</tbody> 
 	
 </table>