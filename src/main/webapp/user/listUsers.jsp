<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<logic:empty name="listUser">
		<p>Not have any user!!!</p>
	</logic:empty>
	
	<logic:notEmpty name="listUser">
		<table>
			<tr>
				<th><bean:message key="user.name" /></th>
				<th><bean:message key="user.age" /></th>
				<th><bean:message key="user.email" /></th>
				<th><bean:message key="user.phoneNumber" /></th>
				<th><bean:message key="user.sex" /></th>
			</tr>
			<logic:iterate id="userList" name="userList">
				<td><bean:write name="user" property="name" /></td>
				<td><bean:write name="user" property="age" /></td>
				<td><bean:write name="user" property="email" /></td>
				<td><bean:write name="user" property="phoneNumber" /></td>
				<td><bean:write name="user" property="sex" /></td>
			</logic:iterate>
		</table>
	</logic:notEmpty>
</body>
</html>