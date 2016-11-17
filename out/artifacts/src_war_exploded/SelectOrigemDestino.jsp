<%@page import="br.usp.pcs.mvc.Cidade.data.City"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selecao de Origem/Destino</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
    <h1>Criar Roteiro</h1>
    <h2>Selecione a origem e o destino</h2>

<div class="container">
    <label for="sel1">Origem</label>
    <select class="form-control" id="sel1">
        <%
            List<City> cidadesOrigem = (List) request.getAttribute("cidades");
            int i;

            for (i = 0; i < cidadesOrigem.size(); i++) {
        %>
        <option>
            <%= cidadesOrigem.get(i).getName() %>
        </option>
        <%
            }
        %>
    </select>
    <br>

    <label for="sel1">Destino</label>
    <select class="form-control" id="sel2">
        <%
            List<City> cidadesDestino = (List) request.getAttribute("cidades");

            for (i = 0; i < cidadesDestino.size(); i++) {
        %>
        <option>
            <%= cidadesDestino.get(i).getName() %>
        </option>
        <%
            }
        %>
    </select>
    <br>

    <button type="button" class="btn btn-primary btn-block">Listar Cidades</button>
</div>

</body>
</html>
