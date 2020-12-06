<%--
  Created by IntelliJ IDEA.
  User: TM
  Date: 2020. 11. 30.
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Kiadvány form</title>
</head>
<body>

<form:form method="post" action="addBd" modelAttribute="bd1">
    <form:label path="name">Név</form:label>
    <form:input path="name"/>
    <form:label path="releaseDate">Kiadási Dátum</form:label>
    <form:input type="date" path="releaseDate"/>
    <form:label path="distributor">Forgalmazó</form:label>
    <form:input path="distributor"/>
    <form:label path="numOfDisc">Lemezek száma</form:label>
    <form:input path="numOfDisc"/>
    <form:label path="rate">Korhatár</form:label>
    <form:select path="rate">
        <form:options items="${Rate}"/>
    </form:select>
    <input type="submit" value="Küldés">
</form:form>
</body>
</html>
