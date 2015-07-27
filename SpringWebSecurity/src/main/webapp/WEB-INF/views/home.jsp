<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is my Home page</title>
</head>
<body>
<h1>Home Page</h1>
<c:url value="/viewstudents" var="studt"/>
<!-- Custom Logout -->
<%-- <c:url value="/logout" var="logOut"/> --%> 
<c:url value="/j_spring_security_logout" var="logOut"/>
<h2><a href="${studt}">View Students</a></h2>
<br/>
<br/>
<h2><a href="${logOut}">Logout</a></h2>
</body>
</html>