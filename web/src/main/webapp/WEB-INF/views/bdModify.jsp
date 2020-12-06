
<%--
  Created by IntelliJ IDEA.
  User: TM
  Date: 2020. 11. 30.
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;encoding=UTF-8 charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Módosítás</title>
</head>
<body>
<table>
    <c:url var="action" value="/modify"></c:url>
<form:form method="post" action="${action}" modelAttribute="bd2">
    <form:input type="hidden" path="id"/>
    <tr><td><form:label path="name">Név</form:label></td><td><form:input path="name"/></td></tr>
    <tr><td> <form:label path="releaseDate">Kiadási Dátum</form:label></td><td> <form:input type="date" path="releaseDate" /></td></tr>
    <tr><td> <form:label path="distributor">Forgalmazó</form:label></td><td> <form:input path="distributor" /></td></tr>
    <tr><td> <form:label path="numOfDisc">Lemezek száma</form:label></td><td><form:input path="numOfDisc" /> </td></tr>
    <tr><td><form:label path="rate">Korhatár</form:label>
        <form:select path="rate" >
            <form:options items="${Rate1}"/>
        </form:select></td></tr> </td><td>
    <input type="submit" value="Módosítás">
    </form:form>
</table>


</body>
</html>
