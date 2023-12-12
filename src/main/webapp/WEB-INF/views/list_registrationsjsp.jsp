<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@taglib prefix = "C" uri ="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SearchRecord" method="post">
<input type="text"  id="Search" name="Search"/>
<input type="submit" value="search"/>
    <a href="logout">Logout</a>

</form>
 <table >
  <tr>
  
  <th>Firstname</th>
    <th>LastName</th>
    <th>Mobile</th>
    <th>Email</th>
    <th>Delete</th>
    <th>Update</th>
    
    </tr>
 <C:forEach var ="registration" items = "${registrations}">
 <tr>
 <td>${registration.firstName }</td>
  <td>${registration.lastName }</td>
  <td>${registration.email }</td>
 <td>${registration.mobile }</td>
  <td><a href = "delete?id=${registration.id }">delete</a></td>
    <td><a href = "update?id=${registration.id }">update</a></td>
  
 
 </tr>
</C:forEach>
  
  
  </table>
${Ir }

</body>
</html>