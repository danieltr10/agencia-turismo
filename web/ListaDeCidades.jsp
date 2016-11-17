<%@page import="br.usp.pcs.mvc.Cidade.data.City"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Cidades</title>
</head>
<body>
<table width="600px" border="1">
<tr>
	<td> <span style="font-weight: bold;">ID</span> </td> <td> <span style="font-weight: bold;">Nome</span> </td>
</tr>
<%
	List<City> cidades = (List) request.getAttribute("cidades");

	int i;
	for (i = 0; i < cidades.size(); i++) {
%>
<tr>
	<td> <%= cidades.get(i).getId() %> </td>
	<td> <a href="<%= request.getContextPath() %>/?page=details&id=<%= cidades.get(i).getId() %>"> <%= cidades.get(i).getName() %> </a> </td>
</tr>
<%
	}
%>

</table>
</body>
</html>