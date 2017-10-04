<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meal List</title>
    <style>
        .nomal {color: green}
        .exceeded {color:red}
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<table border="1" celpadding="8" cellparsing="0">
<c:forEach items="${meals}" var="meal">
    <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
    <tr class="${meal.exceed ? 'exceeded':'normal'}">
        <%--<c:set var="date" scope="session" value="${meal.dateTime.toString()}"/>--%>
        <td> ${fn:formatDateTime(meal.dateTime)}</td>
        <td>${meal.description}</td>
        <td>${meal.calories}</td>

    </tr>
</c:forEach>
</table>
</body>
</html>