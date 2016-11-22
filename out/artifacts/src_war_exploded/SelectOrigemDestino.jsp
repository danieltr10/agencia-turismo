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

<form method="post" action="<%= request.getContextPath() %>/CityController">

<div class="container">
    <h1>Criar Roteiro</h1>
    <h2>Selecione a origem e o destino</h2>


    <label for="sel1">Origem</label>
    <select class="form-control" id="sel1" name="origem">
        <%
            List<City> cidadesOrigem = (List) request.getAttribute("cidades");
            int i;

            for (i = 0; i < cidadesOrigem.size(); i++) {
        %>
        <option value="<%=cidadesOrigem.get(i).getId()%>">
            <%= cidadesOrigem.get(i).getName() %>
        </option>
        <%
            }
        %>
    </select>
    <br>

    <label for="sel1">Destino</label>
    <select class="form-control" id="sel2" name="destino">
        <%
            List<City> cidadesDestino = (List) request.getAttribute("cidades");

            for (i = 0; i < cidadesDestino.size(); i++) {
        %>
        <option value="<%=cidadesDestino.get(i).getId()%>">
            <%= cidadesDestino.get(i).getName() %>
        </option>
        <%
            }
        %>
    </select>
    <br>
   <input type="hidden" name="page" value="ProcessaCidades"/>
    <button type="submit" class="btn btn-primary btn-block" >Listar Cidades</button>

</div>

</form>

</body>

</html>
