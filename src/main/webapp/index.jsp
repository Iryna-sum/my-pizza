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
<c:choose>
    <c:when test="${ requestScope.pizzas == null }">
        <c:redirect url="/FrontController?commandType=index"/>
    </c:when>
    <c:otherwise>
        <c:import url="WEB-INF/jsp/navbar.jsp"/>

        <img src="https://primepizza.ru/uploads/images/8a68fb61e38f903410d5b281d1043893c71b2240.jpg" class="mx-auto d-block rounded" alt="banner">
        <p class="text-center fs-1">Меню</p>

        <div class="container">
            <div class="row row-cols-4">
        <c:forEach var="elem" items="${ requestScope.pizzas }" varStatus="status">
                <div class="card" style="width: 18rem;">
                    <img src="../${ elem.image }" class="card-img-top" alt="pizza">
                    <div class="card-body">
                        <h5 class="card-title"><c:out value="${ elem.name }" /></h5>
                        <p class="card-text">
                        </p>
                        <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#customerChoice">Выбрать</a>
                    </div>
                </div>
        </c:forEach>
            </div>
            </div>

        <div class="modal fade" id="customerChoice" tabindex="-1" aria-labelledby="customerChoiceLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="customerChoiceLabel">Заказ</h5>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <img src="../${ elem.image }" alt="pizza">
                                </div>
                                <div class="col">
                                    <div class="btn-group">
                                        <input type="radio" class="btn-check" name="options-outlined" id="23см" autocomplete="off" checked>
                                        <label class="btn btn-outline-success" for="23см">23см</label>

                                        <input type="radio" class="btn-check" name="options-outlined" id="30см" autocomplete="off">
                                        <label class="btn btn-outline-success" for="30см">30см</label>

                                        <input type="radio" class="btn-check" name="options-outlined" id="36см" autocomplete="off">
                                        <label class="btn btn-outline-success" for="36см">36см</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-success" value="В корзину">
                            <input class="btn btn-secondary" type="button" onclick="window.location.replace('index.jsp')" value="Отмена" />
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
