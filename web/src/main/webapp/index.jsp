<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Kezdőoldal</title>
</head>
<body>
<h2>Keretrendszer beadandó</h2>

<c:url var="action" value="/bds"></c:url>
<form action="${action}">
    <input type="submit" value="Ugrás a Kiadvány Listához"/>
</form>

</body>
</html>
