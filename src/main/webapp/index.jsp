<%--
  Created by IntelliJ IDEA.
  User: isumarevich
  Date: 18.02.22
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<c:import url="WEB-INF/jsp/navbar.jsp"></c:import>

<img src="https://primepizza.ru/uploads/images/8a68fb61e38f903410d5b281d1043893c71b2240.jpg" class="mx-auto d-block rounded" alt="banner">
<p class="text-center fs-1">Меню</p>

<div class="container">
    <c:forEach var="elem" items="${ requestScope.pizzas }" varStatus="status">
    <div class="row row-cols-4">
        <div class="card" style="width: 18rem;">
            <img src="../${ elem.image }" class="card-img-top" alt="pizza">
            <div class="card-body">
                <h5 class="card-title"><c:out value="${ elem.name }" /></h5>
                <p class="card-text">Описание пиццы</p>
                <a href="#" class="btn btn-danger">Выбрать</a>
            </div>
        </div>
    </div>
        </c:forEach>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
