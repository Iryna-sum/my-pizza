<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Add-pizza</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/navbar.jsp"></c:import>

<div class="container">
        <p class="font-weight-bold">Добавить пиццу</p>
        <form action="/FrontController" method="post">
            <div class="input-group">
                <input type="hidden" name="commandType" value="add_pizza_save">
                <div class="mb-3">
                  <p></p>
                <label for="name" id="nameLabel">Название</label>
                <input type="text" name="name" id="name" class="form-control">
                <p></p>
                <label for="price" id="priceLabel">Цена на размер 23см</label>
                <input type="text" name="price" id="price" class="form-control">
                <p></p>
                <label for="image" id="imageLabel">Ссылка на изображение</label>
                <input type="text" name="image" id="image" class="form-control">
                    <p></p>
                    <label for="ingredients" id="ingredientsLabel">Ингредиенты</label>
                    <input type="text" name="ingredients" id="ingredients" class="form-control">
                    <p></p>
                    <input class="form-check-input" type="checkbox" name="visibility" id="visibility">
                    <label for="visibility" id="visibilityLabel">Сделать видимым на главной странице?</label>
                    <p></p>
                <input type="submit" class="btn btn-success" value="Добавить">
                </div>
            </div>
        </form>
</div>
</body>
</html>
