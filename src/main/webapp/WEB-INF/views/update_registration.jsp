<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<%@ include file="menu.jsp" %>

</head>
<body>
<h2>update</h2>

<form action="updatereg" method="post">
<pre>
<input type="hidden" name="id" value="${registration.id }"/>
FirstName:<input type="text" name="firstName" value="${registration.firstName }"/>
LastName:<input type="text" name="lastName" value="${registration.lastName }"/>
Email:<input type="text" name="email" value="${registration.email}"/>
Mobile:<input type="text" name="mobile" value="${registration.mobile}"/>
<input type="submit" value="save">

</pre>
</form>

${up}
</body>
</html>