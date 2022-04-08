<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<html:link page="/addUser.html">Add New User</html:link>
	<logic:empty name="userList">
		<p>Not have any user!!!</p>
	</logic:empty>

	<logic:notEmpty name="userList">
		<table>
			<tr>
				<th><bean:message key="user.name" /></th>
				<th><bean:message key="user.age" /></th>
				<th><bean:message key="user.email" /></th>
				<th><bean:message key="user.phoneNumber" /></th>
				<th><bean:message key="user.sex" /></th>
				<th>Option</th>
			</tr>


			<logic:iterate id="user" name="userList">
				<tr>
					<td><bean:write name="user" property="name" /></td>
					<td><bean:write name="user" property="age" /></td>
					<td><bean:write name="user" property="email" /></td>
					<td><bean:write name="user" property="phoneNumber" /></td>
					<td><bean:write name="user" property="sex" /></td>
					<td>
						<html:link page="/updateUser.html" paramId="name" paramName="user" paramProperty="name">Edit</html:link>
						<html:link page="/deleteUser.html" paramId="name" paramName="user" paramProperty="name">Delete</html:link>
						<html:link page="/viewUser.html" paramId="name" paramName="user" paramProperty="name">View</html:link>
						
					</td>
				</tr>
			</logic:iterate>

		</table>

	</logic:notEmpty>
</body>
</html>