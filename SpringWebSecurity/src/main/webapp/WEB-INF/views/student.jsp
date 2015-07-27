<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Managament</title>
</head>
<body>
<a href="./viewstudents?locale=en">English</a> || <a href="./viewstudents?locale=tl">Telugu</a> || <a href="./viewstudents?locale=hn">Hindi</a>  
<br/><br/>
<h1><spring:message code="student.title"  /></h1>
<c:url value="studentops" var="stdUrl"/>
<form:form action="${stdUrl}" commandName="student" method="POST">
	<table>
		<tr>
			<td><spring:message code="student.id"  /></td>
			<td><form:input path="id"/></td> 
		</tr>
		<tr>
			<td><spring:message code="student.firstname"  /></td>
			<td><form:input path="firstName"/></td> 
		</tr>
		<tr>
			<td><spring:message code="student.lastname"  /></td>
			<td><form:input path="lastName"/></td> 
		</tr>
		<tr>
			<td><spring:message code="Student.rank"  /></td>
			<td><form:input path="rank"/></td> 
		</tr>
		<tr>
			<td>
				<input type="submit" value="Add" name="operation"/>
				<input type="submit" value="Delete" name="operation"/>
				<input type="submit" value="Update" name="operation"/>
				<input type="submit" value="GetStudent" name="operation"/>
			</td>
		</tr>
	</table>
</form:form>

<br/> <br/>

<table border="1">
	<tr>
		<th><spring:message code="student.id"  /></th>
		<th><spring:message code="student.firstname"  /></th>
		<th><spring:message code="student.lastname"  /></th>
		<th><spring:message code="Student.rank"  /></th>
	</tr>
	<c:forEach items="${allStudents}" var="student">
		<tr>
			<td>${student.id}</td>
			<td>${student.firstName}</td>
			<td>${student.lastName}</td>
			<td>${student.rank}</td>
		</tr>	
	</c:forEach>
	
</table>
</body>
</html>