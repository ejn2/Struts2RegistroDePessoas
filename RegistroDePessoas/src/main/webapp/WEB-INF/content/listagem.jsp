<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	
		.item {
			padding: 50px;
			border-radius: 5px;
			height: 100px;
			width: 30%;
			margin: 0 auto;
			border: solid 1px gray;
			background-color: orange;
			overflow: hidden;
		}
		
		.title {
			font-size: 25px;
			color: white;
		}
		
		a {
			font-size: 20px;
		}
		
		.title h4 {
			color: white;
		}
		
		.title {
			width: 100%;
			background-color: orange;
			padding: 2px;
			text-align: center;
			font-family: arial;
		}
		
	</style>
<title>Listagem</title>
</head>
<body>
	<div class="title"><h1>Listagem</h1></div>
	<hr>
	<br>

	<s:iterator value="listPessoa">
		<div class="item">
			<h1 class="title"><s:property value="nome"/></h1>
				<s:url action="delete.action" var="url_del">
					<s:param name="id">
						<s:property value="id"/>
					</s:param>
				</s:url>
				<s:a href="%{url_del}" >Del</s:a>
		</div>
			<br>
	</s:iterator>
</body>
</html>