<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Cadastrar Cidade</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <h1>Cadastrar Cidade</h1>

    <div class="form-group">
        <label for="id-input">ID</label>
        <input type="number" class="form-control" id="id-input" name="id">
    </div>

    <div class="form-group">
        <label for="name-input">Name</label>
        <input type="name" class="form-control" id="name-input" name="name">
    </div>

    <div class="form-group">
        <label for="province-input">Nome da Província/Estado</label>
        <input type="name" class="form-control" id="province-input" name="province">
    </div>

    <div class="form-group">
        <label for="country-input">Nome do País</label>
        <input type="name" class="form-control" id="country-input" name="country">
    </div>

    <div class="form-group">
        <label for="latitude-input">Latitude</label>
        <input type="number" class="form-control" id="latitude-input" name="latitude">
    </div>

    <div class="form-group">
        <label for="longitude-input">Longitude</label>
        <input type="number" class="form-control" id="longitude-input" name="longitude">
    </div>
    <div class="form-group">
        <label for="description-input">Descrição</label>
        <textarea class="form-control" id="description-input" name="description" rows="3"></textarea>
    </div>

    <div class="form-group">
        <label for="url-input">URL da Imagem</label>
        <input type="url" class="form-control" id="url-input" name="url">
    </div>
    <input type="hidden" name="page" value="RealizaCadastroCidade"/>
    <button type="submit" class="btn btn-primary">Cadastrar</button>
</div>
</body>
</html>