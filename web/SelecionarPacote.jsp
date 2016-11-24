<%@ page import="br.usp.pcs.mvc.Route.data.Route" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 24/11/16
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selecionar Pacotes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form method="post" action="<%= request.getContextPath() %>/CityController">

    <div class="container">

        <h1 style="text-align: center">Comprar Pacote</h1>

        <br>

        <label for="sel1">Selecione um pacote:</label>
        <select class="form-control" id="sel1" name="rota">
            <%
                ArrayList<Route> rotas = (ArrayList<Route>) request.getAttribute("listaRotas");

                for (int i = 0; i < rotas.size(); i++) {
            %>
            <option value="<%=rotas.get(i).getId()%>">
                <%= rotas.get(i).getName() %>
            </option>
            <%
                }
            %>
        </select>
        <br>


        <input type="hidden" name="page" value="FecharPedido"/>
        <button type="submit" class="btn btn-primary btn-block" >Ver Pacote</button>

    </div>

</form>

</body>
</html>
