<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<% UserBean whoami = (UserBean)session.getAttribute("user"); %>
<% String error = (String)request.getAttribute("error");
      if(error==null){
    	  error="";
      }
%>
<% if(whoami == null) request.getRequestDispatcher("/jsp/login.jsp").forward(request, response); %>

<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>CBT</title>
  </head>
  <body style="padding-top:5rem">
  	<div class="container">
  		<nav class="navbar navbar-expand navbar-light bg-light fixed-top">
  			<a class="navbar-brand"><%=whoami.getUserName() %> さん</a>
  			<ul class="navbar-nav">
  				<li><div id="real-clockbox">&nbsp;</div></li>
  			</ul>
  			<ul class="navbar-nav ml-auto">
  				<li class="nav-item"><a href="/CBT/jsp/logout" class="nav-link">ログアウト</a></li>
  			</ul>
  		</nav>
  		
  		<br>
  		<br>
  		
  		<div class="card">
  			<h4 class="card-header">テスト実施要領</h4>
  			<div class="card-body">
  				<h5 class="card-title">【テスト実施要領】</h5>
  				<p></p>
  			</div>
  		</div>
  		
  		<br>
  		
  		<form action="./examinee/exam" method="post">
  			<div class="text-center">
  				<div class="form-check">
  					<input class="form-check-input" type="checkbox" id="consent" required>
  					<label class="form-check-label" for="consent">確認した</label>
  				</div>
  				<div>
  					<input type="submit" value="受験する" class="btn btn-primary">
  				</div>
  				<br>
  				<div class="text-left">
  					<font color="red">
  						<%= error %>
  					</font>
  				</div>
  			</div>
  		</form>
  		
  	</div>
    <!-- Optional JavaScript -->
    <script src="/CBT/js/realTime.js"></script>
    <script>
    	history.pushState(null, null, null);
    	$(window).on("popstate", function (event) {
    		if (!event.originalEvent.state) {
    			history.pushState(null, null, null);
    			return;
    		}
    	});
    </script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>