<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Welcome page</title>
</head>
<body>
	<div class="container">
		<div class="columns">
			<div class="main">
				<div class="wrapper-1">
					
					<h1 class="subtitle is-1">Sign up 
						<i class="fas fa-user-plus"></i>
					</h1>
			
					<div  class="is-three-fifths">
						<div class="column">
						<form action="/register" method="POST">
						<div class="field">
							  <p class="control has-icons-left">
							    <input class="input" type="text" placeholder="Username" name="username">
							    
							    <span class="icon is-small is-left">
							      <i class="fas fa-user"></i>
							    </span>
							    <p class="errors">${errors.username}</p>
							  </p>
							</div>
						<div class="field">
							<p class="control has-icons-left has-icons-right">
							    <input class="input" type="email" placeholder="Email" name="email">
							    <span class="icon is-small is-left">
							      <i class="fas fa-envelope"></i>
							    </span>
							    <span class="icon is-small is-right">
							      <i class="fas fa-check"></i>
							    </span>
							    <p class="errors">${errors.email}</p>
							</p>
						</div>
							<div class="field">
							  <p class="control has-icons-left">
							    <input class="input" type="password" placeholder="Password" name="password">
							    <span class="icon is-small is-left">
							      <i class="fas fa-lock"></i>
							    </span>
							    <p class="errors">${errors.password}</p>
							  </p>
							</div>
							<div class="field">
							  <p class="control has-icons-left">
							    <input class="input" type="password" placeholder="Confirm Password" name="confirm">
							    <span class="icon is-small is-left">
							      <i class="fas fa-lock"></i>
							    </span>
							    <p class="errors">${errors.confirm}</p>
							  </p>
							</div>
							<div class="field">
							  <p class="control">
							  	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
							    <button  type ="submit"class="button is-primary">
							      Register
							    </button>
							  </p>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="wrapper-2">
				<h1 class="subtitle is-1">Sign In 
					<i class="fas fa-sign-in-alt"></i>
				</h1>
			
				<div  class="is-three-fifths">
					<div class="column">
						<form action="/login" method="POST">
						<div class="field">
						  <p class="control has-icons-left has-icons-right">
						    <input class="input" name="email" placeholder="Email">
						    <span class="icon is-small is-left">
						      <i class="fas fa-envelope"></i>
						    </span>
						    <span class="icon is-small is-right">
						      <i class="fas fa-check"></i>
						    </span>
						    <p class="errors">${loginErr}</p>
						  </p>
					</div>
					<div class="field">
						<p class="control has-icons-left">
						    <input class="input" type="password" name="password" placeholder="Password">
						    <span class="icon is-small is-left">
						      <i class="fas fa-lock"></i>
						    </span>
						</p>
					</div>
					<div class="field">
					  	<p class="control">
					  		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
						    <button type="submit" class="button is-primary">
						      Login
						    </button>
					  	</p>
					</div>
					</form>
					</div>
				</div>
		</div>
	</div>
</div> 
	
</body>
</html>