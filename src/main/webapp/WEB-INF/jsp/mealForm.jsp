<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h2><spring:message code="meal.title"/></h2>
    <hr>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <form method="post" action="/topjava/meals">
        <input type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt>date</dt>
            <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime"></dd>
        </dl>
        <dl>
            <dt>description</dt>
            <dd><input type="text" value="${meal.description}" size=40 name="description"></dd>
        </dl>
        <dl>
            <dt>calories</dt>
            <dd><input type="number" value="${meal.calories}" name="calories"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>