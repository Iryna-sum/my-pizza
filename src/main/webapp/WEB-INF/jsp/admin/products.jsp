<%--
  Created by IntelliJ IDEA.
  User: isumarevich
  Date: 24.02.22
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Products</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/navbar.jsp"></c:import>


<div class="container">
    <div class="jumbotron">
        <p class="text-center">Текущие товары</p>
<div class="well offers">
<div class="container">
<c:if test="${ sessionScope.user_role == 'administrator' or sessionScope.user_role == 'manager' }">
    <form action="/FrontController" method="post">
    <div class="input-group">
    <input type="hidden" name="commandType" value="add_pizza_form" />
    <input type="submit" value="Добавить пиццу" class="btn btn-success" />
    </div>
    </form>
</c:if>
    <br>
</div>
<table>
<c:forEach var="elem" items="${ requestScope.pizzas }" varStatus="status">
    <tr>
    <td>
    <a href="#" title="click"><img src="../${ elem.image }" alt="pizza" /></a>
    </td>
    <td>
    <h4><c:out value="${ elem.name }" /></h4>
        </c:forEach>
</table>
</div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
