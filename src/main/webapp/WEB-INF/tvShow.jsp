<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<title>Add a TV Show</title>
</head>
<body>
	
	<div class="outter-box">
		<fieldset>
			<legend class="subtitle is-1">Add a TV Show</legend>
			<div class="main-form">
				<form:form method="POST" action="/create" modelAttribute="tvshow">
					<div class="field">
						<div class="control">
						 	<form:label path="title">
						    	<form:input path="title" placeholder="Title" class="input is-primary"/>
						    	<form:errors path="title"/>
					    	</form:label><br>
					    </div>
					</div>  
					<div class="field">
						<div class="control">
						    <form:label path="network" >
							    <form:input path="network" placeholder="Network" class="input is-primary"/>
							    <form:errors path="network"/>
							 </form:label><br> 
							<input type="hidden" name="uploader" value="${user.id}"/>
							<input class="button is-primary" type="submit" value= "Create"/>
						</div>
					</div>   
				</form:form>
					<p class="errors">${error}</p>
				</div>
				
		</fieldset>
	</div>
	
</body>
</html>