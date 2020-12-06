<%--
  Created by IntelliJ IDEA.
  User: TM
  Date: 2020. 11. 29.
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>Blu-ray kiadványok</title>
</head>
<body>

<c:url var="action" value="/byRate"></c:url>
<form:form method="post" action="${action}" modelAttribute="bd1">
<tr><td><form:label path="rate">Rate</form:label>
    <form:select path="rate" >
        <form:options items="${Rate1}"/>
    </form:select></td></tr> </td><td>
    <input type="submit" value="Szűrés">
    </form:form>

    <c:url var="action2" value="/searchById"></c:url>
    <form:form method="post" action="${action2}" modelAttribute="bd1">
    <tr><td><form:label path="">Keresendő ID: </form:label>
     <form:input path="id" title=" "/>
    </td></tr> </td><td>
    <input type="submit" value="Keresés">
    </form:form>

    <form action="${pageContext.servletContext.contextPath}/bds">
    <input type="submit" value="Teljes Kiadvány Lista"/>
    </form>


<c:if test="${!empty bds}">
    <table frame="border" rules="all">
        <tr><th>ID</th><th>Név</th><th>Kiadási dátum</th><th>Korhatár</th><th>Forgalmazó</th><th>lemezek száma</th></tr>
        <c:forEach items="${bds}" var="bd">
            <tr><td><a href="${pageContext.servletContext.contextPath}/bd/${bd.id}">${bd.id}</a></td><td>${bd.name}</td><td>${bd.releaseDate}</td><td>${bd.rate}</td><td>${bd.distributor}</td><td>${bd.numOfDisc}</td><td><a href="${pageContext.servletContext.contextPath}/removeBd/${bd.id}">X</a></td><td><a href="${pageContext.servletContext.contextPath}/modifyBd/${bd.id}">M</a></td></tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty bds}">
    <c:out value="Nincs Blu Ray lemezünk"/>
</c:if>

<form action="${pageContext.servletContext.contextPath}/addBd">
    <input type="submit" value="Kiadvány hozzáadása hozzáadása">
</form>
</body>
</html>
