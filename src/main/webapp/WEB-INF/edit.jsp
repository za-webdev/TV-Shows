<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<title>Edit Page</title>
</head>
<body>
	<h1></h1>
	<div class="outter-box">
		<fieldset>
			<legend class="subtitle is-1">${tvshow.title}</legend>
			<div class="main-form">
				<form:form method="POST" action="/update/${tvshow.id}" modelAttribute="tvshow">
					 <form:label path="title">Title:
					  	<form:input path="title" class="input is-primary"/>
					    <form:errors path="title"/>
				    </form:label><br>
				    
				    <form:label path="network">Network:
					    <form:input path="network" class="input is-primary"/>
					    <form:errors path="network"/>
					 </form:label><br> 
					<input type="hidden" name="uploader" value="${user.id}"/>
					<input type="hidden" name="tvshow" value="${tvshow.id}"/>
					<input type="hidden" name="rating" value="${rating.id}"/>
					<input class="button is-primary" type="submit" value= "Edit"/>
				</form:form>
			</div>
		</fieldset>
	</div>
</body>
</html>