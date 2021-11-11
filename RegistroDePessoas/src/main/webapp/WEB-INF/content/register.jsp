<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
		
		* {
			overflow-x: hidden;
			margin: 0;
			padding: 0;
		}
		
		body {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			height: 100hv;
			
		}
	.form {
		width: 30%;
		margin: 0;
		padding: 0;
	}
	
	
	.form input {
		margin-bottom: 20px;
	}
	
	.errorMessage {
		color: red;
	}
	
	.errorMessage::after{
		content: ' *';
	}
	
	#submit {
		padding: 10px;
		cursor: pointer;
		margin-top: 20px;
	}
	
	.form input {
		padding: 10px;
	}
	
	.errorLabel {
		conf-size: 20px;
	}
	
</style>
</head>
<body>
	<h1>Register</h1>
	<hr>
	<s:form action="save" method="post" class="form">
		<s:textfield label="Nome" name="pessoa.nome"/><br><br>
		<s:textfield label="Telefone" name="contato.telefone"/><br><br>
		<s:textfield label="E-mail" name="contato.email"/><br><br>
		<s:textfield label="Rua" name="endereco.rua"/><br><br>
		<s:submit value="Salvar" id="submit" />
	</s:form>
</body>
</html>