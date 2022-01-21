<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <meta charset="UTF-8">

    <title>Castings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

</head>
<body>

<!--Header-->
<div class="container-fluid" style=" background-color: #343a40;  text-align: center">
    <h1>АТ "ДнСЗ"</h1>
    <h2>Банк конструкторско-технологической документации</h2>
</div>
<!--Header-->


<!--Menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark" role="navigation">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="navbar-brand" href="/">
                    <img src="../../pics/h-logo.png" class="img-fluid" alt="Responsive image">
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="allCastings">Вся продукция <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    СЛЦ№1
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="allCastings?type=CORE">Сердечники</a>
                    <a class="dropdown-item" href="allCastings?type=FROG">Крестовины</a>
                    <a class="dropdown-item" href="allCastings?type=PLATE">Плиты</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="allCastings?shop=SLC1">Вся продукция СЛЦ №1</a>

                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                   data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    СЛЦ№2
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="allCastings?type=PAD">Подкладки</a>
                    <a class="dropdown-item" href="allCastings?type=CLEAT">Клеммы</a>
                    <a class="dropdown-item" href="allCastings?type=INSERT">Вкладыши</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="allCastings?shop=SLC2">Вся продукция СЛЦ №2</a>
                </div>
            </li>
            <c:if test="${admin}">
                <li class="nav-item">
                    <c:url value="/addCasting" var="addCastingUrl"/>
                    <form action="${addCastingUrl}" method="POST">
                        <button class="btn btn-outline-success btn-sm" type="submit">Add casting</button>
                    </form>
                </li>

                <li class="nav-item">
                    <c:url value="/register" var="register"/>
                    <form action="${register}">
                        <button class="btn btn-outline-success btn-sm" type="submit">Register new user</button>
                    </form>
                </li>
                <li class="nav-item">
                    <c:url value="/allUsers" var="users"/>
                    <form action="${users}">
                        <button class="btn btn-outline-success btn-sm" type="submit">Show all users</button>
                    </form>
                </li>
            </c:if>
        </ul>
        <c:url value="/search" var="searching"/>
        <form class="form-inline" action="${searching}" method="get">
            <input class="form-control mr-sm-2" type="search" id="search" name="search" placeholder="Search"
                   aria-label="Search">
            <button class="btn btn-outline-success btn-sm" type="submit">Search</button>
        </form>
    </div>
</nav>
<!--Menu-->

<%--<!--Data-->--%>
<%--<div class="container">--%>
<%--    <table class="table table-striped table-light">--%>
<%--        <tr>--%>
<%--            <td>Название:</td>--%>
<%--&lt;%&ndash;            <td><c:out value="${casting.name}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <c:if test="${admin}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <c:url value="/update?drawing=${casting.drawingNumber}" var="update"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <form action="${update}" method="Post">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <input type="text" name="name" value="${casting.name}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <button class="btn btn-outline-warning btn-sm" type="submit">Изменить</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </c:if>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Цех:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><c:out value="${casting.castingShopEnum.getShopName()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Тип:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><c:out value="${casting.castingTypeEnum.getType()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Рельс:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><c:out value="${casting.castingRailEnum.getRailName()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Масса:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><c:out value="${casting.castingWeight}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <c:if test="${admin}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <c:url value="/update?drawing=${casting.drawingNumber}" var="update"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <form action="${update}" method="Post">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <input type="text" name="castingWeight" value="${casting.castingWeight}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <button class="btn btn-outline-warning btn-sm" type="submit">Изменить</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </c:if>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Марка стали:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><c:out value="${casting.steelGrade.getSteelGrate()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Чертеж детали:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><a href="<c:out value="${casting.documentation.detailDrawing}"/>" target="_blank">Открыть</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Чертеж отливки:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><a href="<c:out value="${casting.documentation.castingDrawing}"/>" target="_blank">Открыть</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Монтажные чертежи:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><a href="<c:out value="${casting.documentation.installationDrawing}"/>" target="_blank">Открыть</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Паспорт отливки:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><a href="<c:out value="${casting.documentation.passportBlank}"/>" target="_blank">Открыть</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Чертеж детали 3Д:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><a href="<c:out value="${casting.documentation.detailDrawing3D}"/>" target="_blank">Скачать</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Чертеж отливки 3Д:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><a href="<c:out value="${casting.documentation.castingDrawing3D}"/>" target="_blank">Скачать</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <c:forEach items="${casting.modls}" var="modl">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>3Д модель ${modl.modelId}:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td><a href="<c:out value="${modl.modelDrawing3D}"/>" download="">Скачать</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <c:if test="${admin}">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <c:url value="/addModel?drawing=${casting.drawingNumber}" var="addModel"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>Добавить 3Д модель:</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <form action="${addModel}" method="Post">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <button class="btn btn-outline-success btn-sm" type="submit">Добавить</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </c:if>&ndash;%&gt;--%>
<%--    </table>--%>
<%--</div>--%>
<%--<!--Data-->--%>

<%--<div class="footer text-center">--%>
<%--    <div class="btn-group" role="group" aria-label="Basic example">--%>
<%--        <c:url value="/logout" var="logoutUrl"/>--%>
<%--        <form action="${logoutUrl}">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">logout</button>--%>
<%--        </form>--%>
<%--        <c:url value="/" var="index"/>--%>
<%--        <form action="${index}">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Home</button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
<link rel="stylesheet" type="text/css" href="../../style.css">

</html>
