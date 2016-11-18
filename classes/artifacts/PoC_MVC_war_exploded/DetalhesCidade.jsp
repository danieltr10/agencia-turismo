<%@page import="br.usp.pcs.mvc.Cidade.data.City"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhe Cidade</title>
</head>
<body>
<%

	City cidade = (City) request.getAttribute("cidade");

%>

<h2> Nome : <%= cidade.getName() %></h2>
<h2> Descrição : <%= cidade.getDescription() %></h2>
<h2> Estado: <%= cidade.getProvince() %></h2>
<h2> País : <%= cidade.getCountry() %></h2>
<h2> Latitude : <%= cidade.getLatitude() %></h2>
<h2> Longitude : <%= cidade.getLongitude() %></h2>

</body>
</html>