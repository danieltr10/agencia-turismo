<%@ page import="br.usp.pcs.mvc.Cidade.data.City" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel" %>
<%@ page import="br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seleção de Transportes e Hotéis</title
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<script type="text/javascript">
    function setHotelPrice(elementID) {
        document.getElementById("custo"+elementID).innerHTML="Custo: R$" + document.getElementById(elementID).value;
        return true;
    }
</script>
<%
    ArrayList<City> cidades = (ArrayList<City>) request.getAttribute("cidadesEscolhidas");
    ArrayList<ArrayList<Hotel>> hotels = (ArrayList<ArrayList<Hotel>>) request.getAttribute("hoteisPorCidade");
    ArrayList<ArrayList<Transport>> transports = (ArrayList<ArrayList<Transport>>) request.getAttribute("transportesPorCidade");
    ArrayList<Hotel> hotelsPerCity;
    ArrayList<Transport> transportsBetweenCities;
 %>
<div class="container" style="outline: hidden">
    <h2>Seleção de Transportes e Hoteis</h2>

    <% for (int i = 0; i < cidades.size(); i++) {%>
    <div>
        <div class="jumbotron">

            <div class="media">
                <div class="media-left">
                    <img class="media-object img-rounded"
                         src="<%=cidades.get(i).getImageURL()%>"
                         width=300px height="200px" alt="<%=cidades.get(i).getName()%>">
                </div>
                <div class="media-body">
                    <h2 class="media-heading"><%= cidades.get(i).getName() %>
                    </h2>
                    <p><%=cidades.get(i).getDescription()%>
                    </p>
                </div>
            </div>

            <label for="<%=cidades.get(i).getId()%>" style="margin-top: 5%">Hotel</label>
            <select class="form-control" id="<%=cidades.get(i).getId()%>" name="Hotel" onchange="setHotelPrice(<%=cidades.get(i).getId()%>)">
            <%
                hotelsPerCity = hotels.get(i);
                for (int j = 0; j < hotelsPerCity.size(); j++) {
            %>
                <option value="<%=hotelsPerCity.get(j).getPrice()%>">
                    <%= hotelsPerCity.get(j).getName() %>
                </option>
            <%
                }
            %>
            </select>

            <p id="<%="custo" + cidades.get(i).getId()%>">Custo: R$ <%=hotelsPerCity.size() > 0 ? hotelsPerCity.get(0).getPrice() : "0"%> </p>

        </div>
        <label for="sel2">Transporte</label>
        <select class="form-control" id="sel2" name="Transporte">
            <%
                transportsBetweenCities = transports.get(i);
                for (int j = 0; j < transportsBetweenCities.size(); j++) {
            %>
            <option value="Transport">
                <%= transportsBetweenCities.get(j).getCompany() + " - " + transportsBetweenCities.get(j).getType() + ": R$" + transportsBetweenCities.get(j).getPrice()%>
            </option>
            <%
                }
            %>
        </select>
        <br>
    </div>
    <%
        }
    %>
</div>

</body>
</html>