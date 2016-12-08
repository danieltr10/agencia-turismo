<%@ page import="java.util.List" %>
<%@ page import="br.usp.pcs.mvc.Client.data.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selecionar Pacotes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form method="post" action="<%= request.getContextPath() %>/CityController">

    <input type="hidden" name="payment" value="<%= request.getParameter("payment") %>">
    <div class="container">

        <div class="jumbotron">

            <h1 style="text-align: center">Selecionar Cliente</h1>

            <br>

            <label for="sel1">Selecione um cliente:</label>
            <select class="form-control" id="sel1" name="cpf">
                <%
                    List<Client> clients = (List<Client>) request.getAttribute("clients");

                    for (int i = 0; i < clients.size(); i++) {
                %>
                <option value="<%=clients.get(i).getCPF()%>">
                    <%= clients.get(i).getName() %>
                </option>
                <%
                    }
                %>
            </select>
            <br>

            <input type="hidden" name="produto" value="<%= request.getAttribute("produto") %>"/>
            <input type="hidden" name="nPessoas" value="<%= request.getAttribute("nPessoas")%>">
            <input type="hidden" name="packageID" value="<%= session.getAttribute("packageID")%>">
            <input type="hidden" name="page" value="ConcluirVendaPacote"/>
            <button type="submit" class="btn btn-primary btn-block">Concluir</button>
        </div>
    </div>

</form>

</body>
</html>
