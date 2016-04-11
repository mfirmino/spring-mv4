<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Adicionar Contas</title>
	</head>
<body>

	<h3>Adiconar Contas</h3>
	<form action="adicionaConta" method="post">
		Descrição: <br/>
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<form:errors path="conta.descricao" />
		<br/>
		Valor:<br/>
		<input type="text" name="valor"/>
		<form:errors path="conta.valor" />
		<br/>
		Tipo:
		<select name="tipo">
			<option value="ENTRADA">Entrada</option>
			<option value="SAIDA">Saída</option>
		</select>
		<form:errors path="conta.tipo" />
		<br/>
		<br/>
		
		<input type="submit" value="Adicionar">
	</form>


</body>
</html>