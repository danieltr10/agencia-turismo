<%@ page import="java.util.List" %>
<%@ page import="br.usp.pcs.mvc.Package.Interfaces.IPackage" %>
<%@ page import="br.usp.pcs.mvc.Cidade.data.City" %><%--
  Created by IntelliJ IDEA.
  User: andreebr
  Date: 08/12/16
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Relatorio Locais e Pacotes</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<%  List<IPackage> packages = (List<IPackage>) request.getAttribute("pacotes");
    List<City> cities = (List<City>) request.getAttribute("cidades");

    List<Integer> packagesSales = (List<Integer>) request.getAttribute("nPacotes");
    List<Integer> citiesSales = (List<Integer>) request.getAttribute("nCidades");

%>

<div class="container">
    <h2 align="center">Pacotes mais vendidos</h2>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nome do Pacote</th>
            <th>Quantidade de Vendas</th>
        </tr>
        </thead>
        <tbody>


        <tr class="info">
            <td>Pacote Verão</td>
            <td>23</td>
        </tr>

        <tr class="info">
            <td>Pacote Orlando</td>
            <td>15</td>
        </tr>

        </tbody>
    </table>

    <h2 align="center">Locais Mais Visitados</h2>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nome do Pacote</th>
            <th>Quantidade de Vendas</th>
        </tr>
        </thead>
        <tbody>


        <tr class="success">
            <td>São Paulo</td>
            <td>53</td>
        </tr>

        <tr class="success">
            <td>Salvador</td>
            <td>46</td>
        </tr>

        <tr class="success">
            <td>Rio de Janeiro</td>
            <td>41</td>
        </tr>

        <tr class="success">
            <td>Itajuba</td>
            <td>37</td>
        </tr>

        <tr class="success">
            <td>Belo Horizonte</td>
            <td>24</td>
        </tr>

        </tbody>
    </table>
</div>


</body>
</html>
