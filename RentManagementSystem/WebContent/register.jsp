<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register form</title>
</head>
<body>
<h1>Rent Register Form</h1>

<form  action="doRegister" method="POST">
  <table style="width:25%">
    <tr>
		<td>FULLNAME:</td>
		<td><input name="fullname" type="text"/></td>
	</tr>
	 <tr>
		<td>ADDRESS:</td>
		<td><input name="address" type="text"/></td>
	</tr>
	<tr>
		<td>EMAIL:</td>
		<td><input name="email" type="email"/></td>
	</tr>
	<tr>
		<td>PHN NO:</td>
		<td><input name="phone" type="number"/></td>
	</tr>
	</table>
	<input type ="submit" value ="register"/>
</form>
</body>
</html>