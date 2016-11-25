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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
            <select class="form-control" id="sel2" name="City" align="center">
                <%--<%--%>
                    <%--List<City> cidades = (List) request.getAttribute("cidades");--%>

                    <%--for (int i = 0; i < cidades.size(); i++) {--%>
                <%--%>--%>
                <option value="<%--<%=cidades.get(i).getId()%>--%>">
                    <%--<%= cidades.get(i).getName() %>--%>
                </option>
                <%--<%--%>
                    <%--}--%>
                <%--%>--%>
            </select>
            <br>
            <%--<div class="form-group">--%>
                <%--<label for="cityid-input">Cidade</label>--%>
                <%--<input type="number" class="form-control" id="cityid-input" name="cityId" align="center">--%>
            <%--</div>--%>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </div>
    </div>
</form>
</body>
</html>