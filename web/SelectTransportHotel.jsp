<%@ page import="br.usp.pcs.mvc.Cidade.data.City" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.usp.pcs.mvc.Hotel.data.Hotel" %>
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
<%
    ArrayList<City> cidades = (ArrayList<City>) request.getAttribute("cidadesEscolhidas");
    ArrayList<ArrayList<Hotel>> hotels = (ArrayList<ArrayList<Hotel>>) request.getAttribute("hoteis por cidade");
    ArrayList<Hotel> hotelsPerCity;
 %>
<div class="container" style="outline: hidden">
    <h2>Seleção de Transportes e Hoteis</h2>

    <% for (int i = 0; i < cidades.size(); i++) {%>
    <div>
        <div class="jumbotron">

            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="media-object img-rounded"
                             src="http://www.cvc.com.br/media/6016178/galeria-salvador-elevador_lacerda_017-credito-divulga%C3%A7%C3%A3ocvc.jpg"
                             width=auto height="200px" alt="<%=cidades.get(i).getName()%>">
                    </a>
                </div>
                <div class="media-body">
                    <h2 class="media-heading"><%= cidades.get(i).getName() %>
                    </h2>
                    <p><%=cidades.get(i).getDescription()%>
                    </p>
                </div>
            </div>

            <label for="sel1" style="margin-top: 5%">Hotel</label>
            <select class="form-control" id="sel1" name="Hotel">
            <%
                hotelsPerCity = hotels.get(i);
                for (int j = 0; j < hotelsPerCity.size(); j++) {
            %>
                <option value="hotelsPerCity.get(j)">
                    <%= hotelsPerCity.get(j).getName() %>
                </option>
            <%
                }
            %>
            </select>
            <p>Custo: </p>

        </div>
        <label for="sel2">Transporte</label>
        <select class="form-control" id="sel2" name="Transporte">

            <option value="Transport">
                transporte
            </option>

        </select>
        <br>
    </div>
    <%
        }
    %>
</div>

</body>
</html>