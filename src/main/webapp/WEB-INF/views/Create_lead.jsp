<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marketing Registration</title>
<style>
h2{
margin-left:700px;
}

</style>
<%@ include file="menu.jsp" %>

</head>
<body>
<h2>WELCOME</h2>

<form action="SaveReg" method="post">
<pre>
FirstName:<input type="text" name="firstName"/>
LastName:<input type="text" name="lastName"/>
Email:<input type="text" name="email"/>
Mobile:<input type="text" name="mobile"/>
<input type="submit" value="save">

</pre>
</form>
${msg}



</body>
</html>