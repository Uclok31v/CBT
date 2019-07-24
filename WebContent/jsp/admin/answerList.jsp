<%@page import="beans.AnswerBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<% UserBean whoami = (UserBean)session.getAttribute("user"); %>
<% ArrayList answerList = (ArrayList)request.getAttribute("answer-list"); %>
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
  				<li class="nav-item"><a href="/CBT/jsp/admin/goToAdminTop" class="nav-link">トップ</a></li>
  				<li class="dropdown active">
  					<a class="nav-link dropdown-toggle" data-toggle="dropdown">ユーザ</a>
  					<div class="dropdown-menu">
  						<a href="/CBT/jsp/admin/userRegister.jsp" class="dropdown-item">登録</a>
  						<a href="/CBT/jsp/admin/userListFetch" class="dropdown-item">一覧</a>
  					</div>
  				</li>
   				<li class="dropdown">
  					<a class="nav-link dropdown-toggle" data-toggle="dropdown">問題</a>
  					<div class="dropdown-menu">
  						<a href="/CBT/jsp/admin/goToQuestionRegister" class="dropdown-item">登録</a>
  						<a href="/CBT/jsp/admin/questionListFetch" class="dropdown-item">一覧</a>
  					</div>
  				</li> 			
  			</ul>
  			<form class="form-inline ml-auto" action="./userSearch" method="post">
  				<input type="search" class="form-control mr-sm-2" placeholder="ユーザIDで部分一致検索" name="keyword" required>
  				<button type="submit" class="btn btn-info my-2 my-sm-0">検索</button>
  			</form>
  			<ul class="navbar-nav">
  				<li class="nav-item"><a href="/CBT/jsp/admin/passwordChange.jsp" class="nav-link">パスワード変更</a></li> 		
  				<li class="nav-item"><a href="/CBT/jsp/logout" class="nav-link">ログアウト</a></li>
  			</ul>
  		</nav>
  		
  		
  		<h1 class="mt-4 mb-5">受験履歴</h1>
  		<table class="table">
  			<thead class="thead-dark">
  				<tr><th>回答時刻</th><th>ユーザID</th><th>設問ID</th><th>正否</th></tr>
  			</thead>
  			<tbody>
  			<% for(int i=0; i<answerList.size(); i++){ %>
  			<% AnswerBean answer = (AnswerBean)answerList.get(i); %>
  				<tr>
  					<td <%if(answer.getCorrectness()==0){%>class="table-danger"<%}%>><%=answer.getDateTime() %></td>
  					<td <%if(answer.getCorrectness()==0){%>class="table-danger"<%}%>><%=answer.getUserId() %></td>
  					<td <%if(answer.getCorrectness()==0){%>class="table-danger"<%}%>><%=answer.getQuestionId() %></td>
  					<td <%if(answer.getCorrectness()==0){%>class="table-danger"<%}%>><% if(answer.getCorrectness() == 1){ %>○<% }else{ %><font color="red">×</font><% } %></td>
  				</tr>
  			<% } %>
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