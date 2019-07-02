<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<% UserBean whoami = (UserBean)session.getAttribute("user"); %>
<% String user_id = (String)request.getAttribute("user_id"); %>
<% String user_name = (String)request.getAttribute("user_name"); %>
<% int administrator = (Integer)request.getAttribute("administrator"); %>
<% int role_1 = (Integer)request.getAttribute("role_1"); %>
<% int role_2 = (Integer)request.getAttribute("role_2"); %>
<% int role_3 = (Integer)request.getAttribute("role_3"); %>
<% int role_4 = (Integer)request.getAttribute("role_4"); %>
<% int role_5 = (Integer)request.getAttribute("role_5"); %>
<% int role_6 = (Integer)request.getAttribute("role_6"); %>
<% int role_7 = (Integer)request.getAttribute("role_7"); %>
<% int role_8 = (Integer)request.getAttribute("role_8"); %>
<% int role_9 = (Integer)request.getAttribute("role_9"); %>

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
  				<li class="nav-item"><a href="#" class="nav-link">トップ</a></li>
  				<li class="dropdown active">
  					<a class="nav-link dropdown-toggle" data-toggle="dropdown">ユーザ</a>
  					<div class="dropdown-menu">
  						<a href="/CBT/jsp/admin/userRegister.jsp" class="dropdown-item">登録</a>
  						<a href="#" class="dropdown-item">一覧</a>
  					</div>
  				</li>
   				<li class="dropdown">
  					<a class="nav-link dropdown-toggle" data-toggle="dropdown">問題</a>
  					<div class="dropdown-menu">
  						<a href="#" class="dropdown-item">登録</a>
  						<a href="#" class="dropdown-item">一覧</a>
  					</div>
  				</li> 			
  			</ul>
  			<ul class="navbar-nav ml-auto">
  				<li class="nav-item"><a href="#" class="nav-link">パスワード変更</a></li> 		
  				<li class="nav-item"><a href="/CBT/jsp/logout" class="nav-link">ログアウト</a></li>
  			</ul>
  		</nav>
  		
  		<h1 class="mt-4 mb-5">ユーザ登録完了</h1>
  		<div class="card bg-light">
  			<div class="card-body">
  				<h5 class="card-title">以下の内容で登録されました</h5>
  			</div>
  		</div>

		<br>

  		<table class="table table-hover">
  			<thead class="thead-dark">
  				<tr><th>ユーザID</th><th>名前</th><th>ユーザ区分</th><th>Backend</th><th>Frontend</th><th>Android</th><th>iOS</th><th>Architect</th><th>PM</th></tr>
  			</thead>
  			<tbody>
  				<tr>
  					<td><%=user_id %></td>
  					<td><%=user_name %></td>
  					<% if(administrator == 0){ %><td>受験者</td><% } else { %><td>管理者</td><% } %>
  					<% if(role_1 == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(role_2 == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(role_3 == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(role_4 == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(role_5 == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(role_6 == 0){ %><td></td><% } else { %><td>○</td><% } %>
  				</tr>
  			</tbody>
  		</table>
  		
  	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>