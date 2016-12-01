<%@ page import="br.usp.pcs.mvc.Package.Interfaces.IPackage" %>
<%@ page import="br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel" %>
<%@ page import="br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction" %>
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

<%
    IPackage pacote = (IPackage) request.getAttribute("package");
    ListIterator<Transport> transports = pacote.getTransports();
    ListIterator<Hotel> hotels = pacote.getHotels();
    ListIterator<Attraction> attractions = pacote.getAttractions();
%>

<div class="container">
    <h2 align="center">Resumo do Roteiro</h2>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Decrição</th>
            <th>Preço</th>
        </tr>
        </thead>
        <tbody>
        <tr class="active">
            <td><%= pacote.getPackageName()%>
            </td>
            <td colspan="2"><%= pacote.getPackageDescription()%>
            </td>
        </tr>

        <tr>
           <td colspan="3">Hotéis</td>
        </tr>

        <%
            Hotel hotel;
            while (hotels.hasNext()) {
                hotel = hotels.next();
        %>

        <tr class="success">
            <td colspan="2"><%= hotel.getName()%></td>
            <td>R$ <%= hotel.getPrice()%></td>
        </tr>

        <%
            }
        %>

        <tr>
            <td colspan="3">Transportes</td>
        </tr>

        <%
            Transport transport;
            while (transports.hasNext()) {
                transport = transports.next();
        %>

        <tr class="info">
            <td><%= transport.getCompany()%></td>
            <td><%= transport.getType()%></td>
            <td>R$ <%= transport.getPrice()%></td>
        </tr>

        <%
            }
        %>


        <tr>
            <td colspan="3">Atrações</td>
        </tr>

        <%
            Attraction attraction;
            while (attractions.hasNext()) {
                attraction = attractions.next();
        %>

        <tr class="warning">
            <td><%= attraction.getName()%></td>
            <td><%= attraction.getDescription()%></td>
            <td>R$ <%= attraction.getPrice()%></td>
        </tr>

        <%
            }
        %>

        <tr class="active">
            <td colspan=2>
                Valor Total do Pacote:
            </td>
            <td>R$ <%= pacote.getTotalPrice()%></td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
