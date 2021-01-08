<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Protokol</title>
</head>
<body>
<h2>Protokol list</h2>
<p><a href='<c:url value="/create_priyom" />'>Create new</a></p>
<table>
<tr><th>Name</th><th>Protokol</th></tr>
<c:forEach var="product" items="${priyoms}">
 <tr><td>${priyom.skarga}</td>
    <td>${priyom.diagnos}</td>
    <td>
    <a href='<c:url value="/edit_priyom?id=${priyom.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/deletepriyom" />' style="display:inline;">
        <input type="hidden" name="id" value="${priyom.id}">
        <input type="submit" value="Delete">
        <input type="text" name = "priyom">
       	<input type="submit" value="Search">

    </form>
    <p><input type="search" name="q" placeholder=""> 
   <input type="submit" value="Find"></p>
 </td></tr>
</c:forEach>
</table>
</body>
</html>