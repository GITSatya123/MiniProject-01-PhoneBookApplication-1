<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	  <h1 style="color: red; text-align: center">SAVE CONTACT PAGE!!</h1>
	<form:form action="save" modelAttribute="contact" method="POST">

		<table border="1" bgcolor="cyan">
			<tr>
			<form:hidden path="contactId"/>
				<td>Contact Name:</td>
				<td><form:input path="contactName" placeholder="smith"/></td>
			</tr>
			<tr>
				<td>Contact Email:</td>
				<td><form:input path="contactEmail" placeholder="smith@gmail.com"/></td>
			</tr>
			<tr>
				<td>Contact Number:</td>
				<td><form:input path="contactNumber" placeholder="123456"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	
			
	</form:form> 
 			
 
 
 
 <p><font color="green">${succMsg }</font></p>		
 <p><font color="red">${errMsg }</font></p>
	<a href="all">View All Contact</a>