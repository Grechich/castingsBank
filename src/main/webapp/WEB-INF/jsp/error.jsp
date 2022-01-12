<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <meta charset="UTF-8">

    <title>Bank of casting documentation</title>
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
        </ul>
    </div>
</nav>
<!--Menu-->


<!--Data-->
<div class="container">
    <div class="container-fluid" >
        <h1>Что-то пошло не так</h1>
        <h2>Некоректный ввод, отсутствует файл или у Вас нет прав доступа</h2>
    </div>
</div>
<!--Data-->

<div class="footer text-center">
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
