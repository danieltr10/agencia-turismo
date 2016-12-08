<%@ page import="java.util.List" %>
<%@ page import="br.usp.pcs.mvc.Venda.data.VendaPacote" %><%--
  Created by IntelliJ IDEA.
  User: andreebr
  Date: 08/12/16
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Relatório Gerencial</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<% List<VendaPacote> vendaPacotes = (List<VendaPacote>) request.getAttribute("vendasPacote"); %>
<div class="container">
    <h2 align="center">Relatório de vendas</h2>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th colspan="3">Resumo das Vendas</th>

        </tr>
        </thead>
        <tbody>
            <tr class="active">
                <th colspan="2">Total</th>
                <th>Um numero</th>
            </tr>

            <tr>
                <th colspan="3">Pacotes Mais Vendidos</th>
            </tr>

            <tr class="success">

                <% for (int i = 0; i < vendaPacotes.size(); i++) {%>
                <th colspan="2"><%= vendaPacotes.get(i).getPacote().getPackageName()%></th>
                <%= ; %>
                <th>Qtd Vendidos</th>
                <%
                    }
                %>
            </tr>

            <tr>
                <th colspan="3">Companhias mais utilizadas</th>
            </tr>

            <tr class="info">
                <th colspan="2">Nome Companhia</th>
                <th>Vendas</th>
            </tr>

            <tr class="active">
                <th colspan="2">Total Arrecadado</th>
                <th>Oto Numero</th>
            </tr>
        </tbody>
    </table>
</div>

</body>
</html>
