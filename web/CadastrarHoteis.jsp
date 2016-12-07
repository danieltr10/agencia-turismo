<%@ page import="br.usp.pcs.mvc.Cidade.data.City" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Mauricio
  Date: 11/24/16
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Hotel</title>



    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
</html>

</head>
<body>
<form name="form1" method="post" action="<%= request.getContextPath() %>/CityController"
      onsubmit="checkBoxValidation()">
    <div class="container">
        <div class="jumbotron" style="margin-top: 5%; position: relative">
            <h1>Cadastrar Hotel</h1>


            <div class="form-group">
                <label for="name-input">Name</label>
                <input type="name" class="form-control" id="name-input" name="name" align="center">
            </div>

            <div class="form-group">
                <label for="price-input">Preço</label>
                <input type="name" class="form-control" id="price-input" name="price" align="center">
            </div>

            <label for="sel2">Cidade</label>
            <div class="inline">
                <select class="selectpicker" id="sel2" data-show-subtext="true" data-live-search="true" name="CityID"
                        align="center">
                    <%
                        List<City> cidades = (List) request.getAttribute("allCities");

                        for (int i = 0; i < cidades.size(); i++) {
                    %>
                    <option value="<%=cidades.get(i).getId()%>" data-subtext="<%= cidades.get(i).getProvince() %>" >
                        <%= cidades.get(i).getName() %>
                    </option>
                    <%
                        }
                    %>

                </select>
                <br>

                <input type="hidden" name="page" value="RealizaCadastro"/>
                <button type="submit" class="btn btn-primary">Cadastrar</button>

            </div>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
            <%--<div class="form-group">--%>
            <%--<label for="cityid-input">Cidade</label>--%>
            <%--<input type="number" class="form-control" id="cityid-input" name="cityId" align="center">--%>
            <%--</div>--%>


        </div>
    </div>
</form>
</body>
</html>