<%@page import="br.usp.pcs.mvc.Cidade.data.City"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Criar Roteiro</h1>
    <h2>Selecione a origem e o destino</h2>

    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Origem
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <%
                List<City> cidadesOrigem = (List) request.getAttribute("cidades");

                int i;
                for (i = 0; i < cidadesOrigem.size(); i++) {
            %>
            <li>
                <a> <%= cidadesOrigem.get(i).getName() %> </a>
            </li>
            <%
                }
            %>

        </ul>
    </div>
    <select class="selectpicker">
        <optgroup label="Picnic">
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
        </optgroup>
        <optgroup label="Camping">
            <option>Tent</option>
            <option>Flashlight</option>
            <option>Toilet Paper</option>
        </optgroup>
    </select>

</body>
</html>
