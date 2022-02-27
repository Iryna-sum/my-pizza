<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Profile</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/navbar.jsp"></c:import>

<p></p>
<button type="button" class="btn btn-success">История заказов</button>
<c:if test="${ sessionScope.user_role == 'administrator' or sessionScope.user_role == 'manager' }">
    <li class="profile-item">
        <form action="/FrontController" method="get">
            <input type="hidden" name="commandType" value="products">
            <input type="submit" value="Настройки продуктов" class="btn btn-success" />
        </form>
    </li>
</c:if>
<p></p>
<c:set var="user" value="${ requestScope.user }" />
<table class="table">
    <tbody>
    <tr>
        <td class="info">Текущая скидка</td>
        <td class="info">${ user.discount }%</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${ user.name }</td>
    </tr>
    <tr>
        <td>Фамилия</td>
        <td>${ user.lastName }</td>
    </tr>
    <tr>
        <td>Номер телефона</td>
        <td>${ user.phoneNumber }</td>
    </tr>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
