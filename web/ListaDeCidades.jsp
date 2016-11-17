<%@page import="br.usp.pcs.mvc.Cidade.data.City"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link href="<%= request.getContextPath() %>/ListaDeCidades.css"/>

<script type="text/javascript">
function checkBoxValidation() {
	boolean anyChecked = false;
	for(var i=0; i < document.form1.city.length; i++) {
		if(document.form1.city[i].checked) {
			anyChecked = true;
		}
	}
	if (!anyChecked) {
		alert("Por favor, selecione ao menos uma cidade")
	}
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Cidades</title>
</head>
<body>
<form name="form1" onsubmit="checkBoxValidation()">
        <div class="col-xs-6">
            <h3 class="text-center">Lista de Cidades</h3>
            <div class="well" style="max-height: 300px;overflow: auto;">
            	<ul id="check-list-box" class="list-group checked-list-box">
<%
	List<City> cidades = (List) request.getAttribute("cidades");


	int i;
	for (i = 0; i < cidades.size(); i++) {
%>
	
    	 <li class="list-group-item">
    	 	<div class="input-group">
    	 	<input type="checkbox" name="city" value="<%= cidades.get(i).getId() %>">
            	<%= cidades.get(i).getName() %>

            </div>
         </li>
	<%-- <td> <a href="<%= request.getContextPath() %>/?page=details&id=<%= cidades.get(i).getId() %>"> <%= cidades.get(i).getName() %> </a> </td> --%>
<%
	}
%>

    	 </ul>
                <br />
                <button class="btn btn-primary col-xs-12" onclick="checkBoxValidation()">Selecionar Cidades</button>
            </div>
          
        </div>
        </form>
        
        <%
String cities[]= request.getParameterValues("city");
if(cities != null) {
	for (int j = 0; j < cities.length; j++) {
%>
	<h4><%= cities[j]%></h4>
<%}
}%>
</body>
</html>