<%--
  Created by IntelliJ IDEA.
  User: isumarevich
  Date: 23.02.22
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>navbar</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">M-pizza</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="true" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mb-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Меню</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#/WEB-INF/jsp/no.jsp">Акции</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Контакты</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <c:choose>
                    <c:when test="${ sessionScope.userID != null }">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/FrontController?commandType=profile">Профиль</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Выйти</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#"><button type="button" class="btn btn-Light" data-bs-toggle="modal" data-bs-target="#sighUp">
                                Регистрация
                            </button>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#"><button type="button" class="btn btn-Light" data-bs-toggle="modal" data-bs-target="#sighIn">
                                Войти
                            </button>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="nav-item">
                    <button type="button" class="btn btn-danger">Корзина</button>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="modal fade" id="sighUp" tabindex="-1" aria-labelledby="sighUpLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="sighUpLabel">Регистрация</h5>
            </div>
            <form action="${pageContext.request.contextPath}/FrontController" method="post" name="signUpForm">
                <div class="modal-body">
                    <input type="hidden" name="commandType" value="registration">
                    <input type="hidden" name="currentPage" value="index.jsp">

                    <label for="firstName" id="firstNameLabel">Имя</label>
                    <input type="text" name="firstName" id="firstName" class="form-control">

                    <label for="lastName" id="lastNameLabel">Фамилия</label>
                    <input type="text" name="lastName" id="lastName" class="form-control">

                    <label for="userName" id="userNameLabel">Логин</label>
                    <input type="text" name="userName" id="userName" class="form-control">

                    <label for="password" id="passwordLabel">Пароль</label>
                    <input type="password" name="password" id="password" class="form-control">

                    <label for="repeatedPassword" id="repeatedPasswordLabel">Повторите пароль</label>
                    <input type="password" id="repeatedPassword" class="form-control">

                    <label for="phoneNumber" id="phoneNumberLabel">Номер телефона</label>
                    <input type="text" name="phoneNumber" id="phoneNumber" class="form-control">
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-success" value="Зарегистрировать">
                    <input class="btn btn-secondary" type="button" onclick="window.location.replace('index.jsp')" value="Отмена" />
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="sighIn" tabindex="-1" aria-labelledby="sighInLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="sighInLabel">Вход</h5>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/FrontController" method="post" name="signInForm">
                    <input type="hidden" name="commandType" value="login">
                    <input type="hidden" name="currentPage" value="index.jsp">

                    <label for="userName_sighIn" id="userName_sighIn_Label">Логин</label>
                    <input type="text" name="userName" id="userName_sighIn" class="form-control">

                    <label for="password_sighIn" id="password_sighIn_Label">Пароль</label>
                    <input type="password" name="password" id="password_sighIn" class="form-control">

                    <div class="modal-footer">
                        <input type="submit" class="btn btn-success" value="Войти">
                        <input class="btn btn-secondary" type="button" onclick="window.location.replace('index.jsp')" value="Отмена" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
