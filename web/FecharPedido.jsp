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

    <script type="text/javascript">
        function treatPayment() {
            if (document.getElementById("paymentType").value.localeCompare("Dinheiro")) {
                document.getElementById("cardField").style.display = 'block';
            } else {
                document.getElementById("cardField").style.display = 'none';
            }

            return true;
        }
    </script>


</head>
<body>

<%
    IPackage pacote = (IPackage) request.getAttribute("package");
    ListIterator<Transport> transports = pacote.getTransports();
    ListIterator<Hotel> hotels = pacote.getHotels();
    ListIterator<Attraction> attractions = pacote.getAttractions();
    boolean isHotTopic = (boolean) request.getAttribute("isHotTopic");
    session.setAttribute("packageID", pacote.getPackageId());
%>

<form method="post" action="<%= request.getContextPath() %>/CityController">

    <div class="container">
        <div class="jumbtron">
            <h2 align="center">Resumo do Pacote</h2>
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
                    <td colspan="2"><%= hotel.getName()%>
                    </td>
                    <td>R$ <%= hotel.getPrice() + hotel.getPrice()*0.1*(isHotTopic ? 1 : 0) %>
                    </td>
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
                    <td><%= transport.getCompany()%>
                    </td>
                    <td><%= transport.getType()%>
                    </td>
                    <td>R$ <%= transport.getPrice() + transport.getPrice()*0.1*(isHotTopic ? 1 : 0)%>
                    </td>
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
                    <td><%= attraction.getName()%>
                    </td>
                    <td><%= attraction.getDescription()%>
                    </td>
                    <td>R$ <%= attraction.getPrice() + attraction.getPrice()*0.1*(isHotTopic ? 1 : 0)%>
                    </td>
                </tr>

                <%
                    }
                %>

                <tr class="active">
                    <td colspan=2>
                        Valor Total do Pacote:
                    </td>
                    <td>R$ <%= pacote.getTotalPrice() + pacote.getTotalPrice()*0.1*(isHotTopic ? 1 : 0)%>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <input type="hidden" name="packageID" value="<%= pacote.getPackageId()%>"/>
        <input type="hidden" name="page" value="SelecionarCliente"/>
        <%-- Region Daniel --%>
        <br>

        <label for="paymentType">Selecione uma forma de pagamento:</label>
        <select class="form-control" id="paymentType" name="payment" onchange="treatPayment()">
            <option value="Cartão de Crédito">
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
