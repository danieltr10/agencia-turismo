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

<script
        type="text/javascript">
    function setTotalPrice(qtdPessoas, preco) {

        document.getElementById("custo").innerHTML = "R$" + qtdPessoas * preco;

        return true;
    }

    function treatPayment() {
        if (document.getElementById("paymentType").value.localeCompare("Dinheiro")) {
            document.getElementById("cardField").style.display = 'block';
        } else {
            document.getElementById("cardField").style.display = 'none';
        }

        return true;
    }
</script>

<form method="post" action="<%= request.getContextPath() %>/CityController">
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
                if (i > 0) { %>
            <tr class="success">
                <td><%=route.getCities().get(i).getName()%>
                </td>
                <td><%=route.getHotels().get(i).getName()%>
                </td>
                <td>R$ <%=route.getHotels().get(i).getPrice()%>
                </td>
            </tr>
            <% price += route.getHotels().get(i).getPrice();
            } else if (i == 0) { %>
            <tr class="info">
                <td><%=route.getCities().get(i).getName()%>
                </td>
                <td> -</td>
                <td> -</td>
            </tr>
            <% } %>
            <tr class="warning">
                <td colspan=2>
                    Transporte: <%=route.getTransports().get(i).getCompany()%>
                    - <%=route.getTransports().get(i).getType()%>
                </td>
                <td>R$ <%=route.getTransports().get(i).getPrice()%>
                </td>
            </tr>
            <% price += route.getTransports().get(i).getPrice();
            }%>

            <tr class="active">
                <td colspan=2>
                    Valor Total do Pacote:
                </td>
                <td id="custo">R$ <%=price%>
                </td>
            </tr>
            </tbody>
        </table>
        <p>A cidade em azul refere-se à cidade de origem e as células em laranja referem-se aos transportes entre as
            cidades.</p>


    <div>
        <div class="form-group">
            <label for="id-input">Número de pessoas:</label>
            <input type="number" min="1" class="form-control" id="id-input" name="nPessoas" value="1"
                   onchange="setTotalPrice(document.getElementById('id-input').value, <%= price%>)">
        </div>
    </div>

    <input type="hidden" name="produto" value="roteiro"/>
    <input type="hidden" name="page" value="SelecionarCliente"/>
    <%-- Region Daniel --%>
    <br>

    <label for="paymentType">Selecione uma forma de pagamento:</label>
    <select class="form-control" id="paymentType" name="payment" onchange="treatPayment()">
        <option value="Cartao de Credito">
            Cartão de Crédito
        </option>
        <option value="Dinheiro">
            Dinheiro
        </option>
    </select>

    <div id="cardField" style="display:block">

        <input type="number" class="form-control">
    </div>
    <br>

    <button type="submit" class="btn btn-primary btn-block">Continuar</button>


    </div>
</form>

</body>
</html>