<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 17/11/16
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agência Decolou</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lobster+Two" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Glegoo" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<form name="formNav" method="post" action="<%= request.getContextPath() %>/CityController">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">#Decolou</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav">
                    <li>
                        <a href="<%= request.getContextPath() %>/CityController?page=CadastraHotel">Cadastrar Hotel</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath() %>/CityController?page=CadastrarCidade">Cadastrar Cidades</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">

                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</form>
<form name="form1" method="post" action="<%= request.getContextPath() %>/CityController">
    <div class="jumbotron">
        <h1 align="center" style="font-family: 'Lobster Two', cursive;">Agência Decolou</h1>
        <p align="center" style="margin-top: 5%; font-family: 'Glegoo', serif;">Seja bem vindo ao sistema de agendamento
            de viagens da agência decolou.</p>
        <p align="center" style="margin-top: 5%; font-family: 'Glegoo', serif;">Aqui você poderá criar roteiros e
            comprar pacotes de viagem com rapidez e conforto.</p>
        <p align="center" style="margin-top: 5%; font-family: 'Glegoo', serif;">Selecione uma das opções abaixo para
            continuar.</p>
        <div class="buttons">
            <input type="hidden" name="page" value="processarBotao"/>
            <button name="criarRoteiro" class="btn btn-primary col-xs-12"
                    style="width: 280px; height: 50px; margin-right: 40px">Criar Roteiro
            </button>
            <button name="comprarPacote" class="btn btn-primary col-xs-12" style="width: 280px; height: 50px">Comprar
                Roteiro
            </button>
        </div>
    </div>

    <div id="myCarousel" class="carousel slide" style="z-index: 0; position: relative;" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="http://pt.freeimages.com/download/file/78b7005a578cb52c535a55e8ea303512/1600x1200"
                     alt="Chania">
                <div class="carousel-caption">
                    <h3>Cuba</h3>
                    <p>Clima latino ímpar e infinitas belezas naturais.</p>
                </div>
            </div>

            <div class="item">
                <img src="http://www.freeimages.com/download/file/3e4b4abe7eb5ae6ee86cda452ae8d220/1600x1200"
                     alt="Matterhorn">
                <div class="carousel-caption">
                    <h3>Matterhorn</h3>
                    <p>Conheça as maravilhosas paisagens de Matterhorn, na Suiça.</p>
                </div>
            </div>

            <div class="item">
                <img src="http://www.freeimages.com/download/file/4e22b6bc6ebed6058dba4d417b890462/1600x1200"
                     alt="Matterhorn">
                <div class="carousel-caption">
                    <h3>Guarapari</h3>
                    <p>Lindas praias com muito sol em Guarapari, divirta-se!</p>
                </div>
            </div>

        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</form>
</body>

<style>
    .jumbotron {
        z-index: 1;
        width: 1200px;
        height: 70%;
        position: absolute;
        margin: auto;
        right: 25%;
        left: 50%;
        margin-left: -600px;
        margin-top: 5%;
        background: rgb(255, 255, 255); /* This is for ie8 and below */
        background: rgba(255, 255, 255, 0.6);
    }

    .item {
        width: 100%;
        height: 100%;
        background-position: center center;
        background-repeat: no-repeat;
    }

    .carousel-caption {
        alignment: center;
        height: 20%;
    }

    .carousel-control.left, .carousel-control.right {
        background-image: none;
        opacity: 0;
        filter: alpha(opacity=0); /* IE support */
    }

    .buttons {
        width: 600px;
        max-width: 600px;
        position: absolute;
        bottom: 5%;
        left: 50%;
        margin-left: -300px;
    }

</style>

</html>
