<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<title>Dashboard</title>
</head>
<body>
	<section class="hero is-primary">
		  <div class="hero-body">
		    <div class="container">
		      <h1 class="title">
		        Welcome ${user.username}
		      </h1>
		    </div>
		    <div id="log-out">
		     <a class="button is-danger" href="/logout">Log Out</a>
		    </div> 
		  </div>
	</section>
	<div class="dashboard">
		<h2 class="subtitle is-2">TV Shows</h2>
		
		<table class="table is-hoverable">
			<tr>
				<th>Show</th>
				<th>Network</th>
				<th>Avg Rating</th>
				<th>Action</th>
			</tr>
				 <c:forEach items="${allShows}" var="show">
			<tr>
				<td><a href="/show/${show.id}">${show.title}</a></td>
				<td>${show.network}</td>
				
				<td> ${String.format("%.1f",show.avgRating/show.rating.size())}</td>
				<td>
					<c:if test="${user.id == show.uploader.id}">
						<a href="/edit/${show.id}" class="button is-link is-outlined">Edit</a>
						<a href="/delete/${show.id}" class="button is-danger is-outlined">
    						<span>Delete</span>
    						<span class="icon is-small">
      							<i class="fas fa-times"></i>
    						</span>
  						</a>
					</c:if>
				</td>		
			</tr>
				
	            </c:forEach>
		</table>
		 <a class="button is-primary is-rounded" href="/addShow">Add a Show</a>
	</div>
	
	
</body>
</html>