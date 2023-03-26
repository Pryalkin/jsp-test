<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cov" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <caption>Таблица пользователей</caption>
    <tr>
        <th>Имя пользователя</th>
        <th>Рейтинг</th>
        <th>Кол-во посещений</th>
        <th>Дата последнего входа</th>
    </tr>
        <jsp:useBean id="users" scope="request" type="java.util.List"/>
        <cov:forEach var="user" items="${users}">
            <tr>
                <td><cov:out value="${user.getUsername()}"/></td>
                <td><cov:out value="${user.getRating()}"/></td>
                <td><cov:out value="${user.getNumberOfVisits()}"/></td>
                <td><cov:out value="${user.getCurrentVisitingTime()}"/></td>
                <td><form action="update-user.jsp">
                    <input name="id" type="hidden" value="<cov:out value="${user.getUserId()}"/>"/>
                    <input type="submit" value="Редактировать" />
                </form></td>
            </tr>
        </cov:forEach>
</table>
</body>
</html>
