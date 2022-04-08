<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Name: </p> <bean:write name="user" property="name" scope="request"/>
<p>Age: </p> <bean:write name="user" property="age" format="##"/>

</body>
</html>