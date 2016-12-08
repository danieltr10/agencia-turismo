<%--
  Created by IntelliJ IDEA.
  User: Mauricio
  Date: 12/8/16
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Transporte</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form name="form1" method="post" action="<%= request.getContextPath() %>/CityController"
<div class="container">
    <h1>Cadastrar Transporte</h1>

    <div class="form-group">
        <label for="tipo-input">Tipo</label>
        <input type="name" class="form-control" id="tipo-input" name="tipo">
    </div>

    <div class="form-group">
        <label for="price-input">Preço</label>
        <input type="number" class="form-control" id="price-input" name="price">
    </div>

    <div class="form-group">
        <label for="origin-input">ID Origem</label>
        <input type="number" class="form-control" id="origin-input" name="originid">
    </div>

    <div class="form-group">
        <label for="destinationid-input">ID Destino</label>
        <input type="number" class="form-control" id="destinationid-input" name="destinationid">
    </div>


    <div class="form-group">
        <label for="company-input">Companhia</label>
        <input type="name" class="form-control" id="company-input" name="company">
    </div>
    <input type="hidden" name="page" value="RealizaCadastroTransporte"/>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
</div>
</form>
</body>
</html>
