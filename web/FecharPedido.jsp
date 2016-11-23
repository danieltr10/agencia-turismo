<%@ page import="br.usp.pcs.mvc.Route.data.Route" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 23/11/16
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fechar Pacote</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<% Route route = (Route) request.getAttribute("rota");
    double price = 0;%>

<div class="container">
    <h2 align="center">Resumo do Roteiro</h2>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Cidade</th>
            <th>Hotel</th>
            <th>Preço</th>
        </tr>
        </thead>
        <tbody>
        <% for (int i = 0; i < route.getTransports().size(); i++) {
            if (i > 0 && i < route.getCities().size()) { %>
                <tr class="success">
                    <td><%=route.getCities().get(i).getName()%></td>
                    <td><%=route.getHotels().get(i-1).getName()%></td>
                    <td>R$ <%=route.getHotels().get(i-1).getPrice()%></td>
                </tr>
        <%  price += route.getHotels().get(i-1).getPrice();
            } else if (i == 0) { %>
                <tr class="info">
                    <td><%=route.getCities().get(i).getName()%></td>
                    <td> - </td>
                    <td> - </td>
                </tr>
        <%  } %>
                <tr class="warning">
                    <td colspan=2>
                        Transporte: <%=route.getTransports().get(i).getCompany()%> - <%=route.getTransports().get(i).getType()%>
                    </td>
                    <td>R$ <%=route.getTransports().get(i).getPrice()%></td>
                </tr>
        <%  price += route.getTransports().get(i).getPrice();
          }%>

            <tr class="active">
                <td colspan=2>
                    Valor Total do Pacote:
                </td>
                <td>R$ <%=price%></td>
            </tr>
        </tbody>
    </table>
    <p>A cidade em azul refere-se à cidade de origem e as células em laranja referem-se aos transportes entre as cidades.</p>
</div>

</body>
</html>
