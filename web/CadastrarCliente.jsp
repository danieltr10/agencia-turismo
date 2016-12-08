<%--
  Created by IntelliJ IDEA.
  User: Mauricio
  Date: 12/8/16
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Pessoa</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form name="form1" method="post" action="<%= request.getContextPath() %>/CityController"
<div class="container">
    <h1>Cadastrar Pessoa</h1>

    <div class="form-group">
        <label for="tipo-input">Nome</label>
        <input type="name" class="form-control" id="tipo-input" name="name">
    </div>

    <div class="form-group">
        <label for="price-input">CPF</label>
        <input type="number" class="form-control" id="price-input" name="cpf">
    </div>

    <div class="form-group">
        <label for="telefone-input">Telefone</label>
        <input type="number" class="form-control" id="telefone-input" name="telefone">
    </div>

    <div class="form-group">
        <label for="type-input">Tipo</label>
        <input type="number" min="1" max="3" class="form-control" id="type-input" name="id">
    </div>
    <input type="hidden" name="page" value="RealizaCadastroCliente"/>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
</div>
</form>
</body>
</html>
