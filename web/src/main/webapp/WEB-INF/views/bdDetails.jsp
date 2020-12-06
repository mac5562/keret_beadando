<%--
  Created by IntelliJ IDEA.
  User: TM
  Date: 2020. 11. 30.
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${bd.name}</title>
</head>
<body>
<table>
    <tr><td>ID: </td><td>${bd.id}</td></tr>
    <tr><td>Név: </td><td>${bd.name}</td></tr>
    <tr><td>Kiadási Dátum: </td><td>${bd.releaseDate}</td></tr>
    <tr><td>Korhatár:</td><td>${bd.rate}</td></tr>
    <tr><td>Forgalmazó:</td><td>${bd.distributor}</td></tr>
    <tr><td>Lemezek száma:</td><td>${bd.numOfDisc}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}/bds">
    <input type="submit" value="Vissza a kiadványok listához">
</form>
</body>
</html>
