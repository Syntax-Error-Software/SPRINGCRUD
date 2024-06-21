<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Details</h1>
	<table border="5" >
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Phone</th>
			<th>Employee Email</th>
			<th>Employee Gender</th>
			<th>Employee Designation</th>
			<th>Employee Salary</th>
		</tr>
		<tr>
			<td>${employee.getId()}</td>
			<td>${employee.getName()}</td>
			<td>${employee.getPhone()}</td>
			<td>${employee.getEmail()}</td>
			<td>${employee.getGender()}</td>
			<td>${employee.getDesig()}</td>
			<td>${employee.getSalary()}</td>
		</tr>
	</table>

</body>
</html>