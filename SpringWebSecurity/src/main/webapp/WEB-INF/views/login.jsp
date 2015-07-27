<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom Login Page</title>
</head>
<body>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
</c:if>
<c:if test="${not empty sessionInfo}">
      <font color="red">
         <c:out value="${sessionInfo}"/>.
      </font>
</c:if>

<form action=<c:url value='j_spring_security_check' /> method="POST">
<table border="1">
	<tr>
		<td>Enter UserName</td>
		<td><input type="text" name="j_username"></td>
	</tr>
	<tr>
		<td>Enter Password</td>
		<td><input type="password" name="j_password"></td>
	</tr>
	<tr>
		<td><input type="submit" value="submit" name="submit"/></td>
		<td><input type="reset" value="reset" /></td>
	</tr>
</table>
</form>

</body>
</html>