<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>Bank of casting documentation</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">

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
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Add casting</button>
                    </form>
                </li>

                <li class="nav-item">
                    <c:url value="/register" var="register"/>
                    <form action="${register}">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Register new user</button>
                    </form>
                </li>
            </c:if>
        </ul>
        <c:url value="/search" var="searching"/>
        <form class="form-inline" action="${searching}" method="get">
            <input class="form-control mr-sm-2" type="search" id="search" name="search" placeholder="Search"
                   aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<!--Menu-->

<div class="container">

    <div align="center">
        <c:url value="/saveCasting" var="saveCasting"/>

        <form action="${saveCasting}" method="POST">

            <div class="row">
                <div class="col-4" align="right">Название:</div>
                <div class="col-8" align="left"><input type="text" name="name" value="Отливка"></div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Чертеж:</div>
                <div class="col-8" align="left"><input type="text" name="drawingNumber" value="Чертеж"></div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Масса, кг:</div>
                <div class="col-8" align="left"><input type="text" name="castingWeight" value="0"></div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Марка стали:</div>
                <div class="col-8" align="left">
                    <select class="form-select" aria-label="Default select example" name="steelGrade">
                        <option selected value="STEEL">---</option>
                        <option value="STEEL20L">20Л</option>
                        <option value="STEEL25L">25Л</option>
                        <option value="STEEL30L">30Л</option>
                        <option value="STEEL35L">35Л</option>
                        <option value="STEEL40L">40Л</option>
                        <option value="STEEL110G13L">110Г13Л</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Тип отливки:</div>
                <div class="col-8" align="left">
                    <select class="form-select" aria-label="Default select example" name="castingTypeEnum">
                        <option selected value="OTHER">---</option>
                        <option value="FROG">Крестовина</option>
                        <option value="CORE">Сердечник</option>
                        <option value="MONOBLOCK">Моноблок</option>
                        <option value="PLATE">Плита</option>
                        <option value="PAD">Подкладка</option>
                        <option value="INSERT">Вкладыш</option>
                        <option value="CLEAT">Клемма</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Тип рельса:</div>
                <div class="col-8" align="left">
                    <select class="form-select" aria-label="Default select example" name="castingRailEnum">
                        <option selected value="OTHER">---</option>
                        <option value="R65">Р65</option>
                        <option value="R50">Р50</option>
                        <option value="R43">Р43</option>
                        <option value="R33">Р33</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Цех:</div>
                <div class="col-8" align="left">
                    <select class="form-select" aria-label="Default select example" name="castingShopEnum">
                        <option selected value="SLC1">СЛЦ №1</option>
                        <option value="SLC2">СЛЦ №2</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Материал модели:</div>
                <div class="col-8" align="left">
                    <select class="form-select" aria-label="Default select example" name="modelMaterialEnum">
                        <option selected value="OTHER">---</option>
                        <option value="STEEL">Сталь</option>
                        <option value="AL">Аллюминий</option>
                        <option value="PLASTIC">Пластик</option>
                        <option value="WOOD">Дерево</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Год модели:</div>
                <div class="col-8" align="left"><input type="text" name="modelYear" value="2022"></div>
            </div>
            <div class="row">
                <div class="col-4" align="right">3Д модели:</div>
                <div class="col-8" align="left"><input type="text" name="modelDrawing3D" value="3Д"></div>
            </div>
            <div class="row">
                <div class="col-4" align="right">Чертеж детали:</div>
                <div class="col-8" align="left"><input type="text" name="detailDrawing" value="Деталь"></div>
            </div>
            <div class="row">
                <div class="col-4" align="right"></div>
                <div class="col-8" align="left"><input type="submit"/></div>
            </div>

        </form>
    </div>
</div>
<!--Data-->

<div class="footer fixed-bottom text-center">
    <div class="btn-group" role="group" aria-label="Basic example">
        <c:url value="/logout" var="logoutUrl"/>
        <form action="${logoutUrl}">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">logout</button>
        </form>
        <c:url value="/" var="index"/>
        <form action="${index}">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Home</button>
        </form>
    </div>
</div>
</body>
<link rel="stylesheet" type="text/css" href="../../style.css">

</html>
