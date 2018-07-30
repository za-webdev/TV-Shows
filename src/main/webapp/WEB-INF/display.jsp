<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">

<title>Tv Show Display</title>
</head>
<body>
	
	<section class="hero is-primary">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title">
	        ${show.title}
	      </h1>
	      <h2 class="subtitle">
	        Network: ${show.network}
	      </h2>
	    </div>
	  </div>
	</section>
	<a href="/dashboard" class="button is-link is-outlined">Go to Dashboard</a>
	<div class="rating-table">
		<h2 class="title is-2">Users who rated this show!</h2>
		<div class="center">
			<table class="table is-striped">
			<tr>
				<th>Name</th>
				<th>Rating</th>
			</tr>
			
				<c:forEach items="${show.rating}" var="r">
					<tr>
					<td>${r.user.username}</td>
					<td>${r.rating}</td>
					<tr>
				</c:forEach>
			
			</table>
					<div class="rating">
						<form:form method="POST" action="/rate/${show.id}" modelAttribute="my_rating">
						<div class="select is-rounded">
							<form:select path="rating">
								<form:option value="1" label="1" />
								<form:option value="2" label="2" />
								<form:option value="3" label="3" />
								<form:option value="4" label="4" />
								<form:option value="5" label="5" />
							</form:select>
						</div>
							<form:errors path="rating"/>
							<input type="hidden" name="tvshow" value="${show.id}"/>
					       
					        <button type="submit" class="button is-info">Rate!</button>
						</form:form>
				<p class="errors">${errors}</p>
			</div>
		</div>
	</div>
</body>
</html>