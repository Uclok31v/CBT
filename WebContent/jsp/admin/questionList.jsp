<%@page import="beans.QuestionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<% UserBean whoami = (UserBean)session.getAttribute("user"); %>
<% ArrayList questionList = (ArrayList)request.getAttribute("question-list"); %>
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
  				<li class="dropdown">
  					<a class="nav-link dropdown-toggle" data-toggle="dropdown">ユーザ</a>
  					<div class="dropdown-menu">
  						<a href="/CBT/jsp/admin/userRegister.jsp" class="dropdown-item">登録</a>
  						<a href="/CBT/jsp/admin/userListFetch" class="dropdown-item">一覧</a>
  					</div>
  				</li>
   				<li class="dropdown active">
  					<a class="nav-link dropdown-toggle" data-toggle="dropdown">問題</a>
  					<div class="dropdown-menu">
  						<a href="/CBT/jsp/admin/goToQuestionRegister" class="dropdown-item">登録</a>
  						<a href="/CBT/jsp/admin/questionListFetch" class="dropdown-item">一覧</a>
  					</div>
  				</li> 			
  			</ul>
  			<form class="form-inline ml-auto" action="./questionSearch" method="post">
  				<input type="search" class="form-control mr-sm-2" placeholder="問題文で部分一致検索" name="keyword" required>
  				<button type="submit" class="btn btn-info my-2 my-sm-0">検索</button>
  			</form>
  			<ul class="navbar-nav">
  				<li class="nav-item"><a href="/CBT/jsp/admin/passwordChange.jsp" class="nav-link">パスワード変更</a></li> 		
  				<li class="nav-item"><a href="/CBT/jsp/logout" class="nav-link">ログアウト</a></li>
  			</ul>
  		</nav>
  		
  		<h1 class="mt-4 mb-5">問題一覧</h1>
  		
  		<table  class="table table-hover">
			<thead class="thead-dark">
				<tr><th>設問ID</th><th>問題文</th><th>選択肢１</th><th>選択肢２</th><th>選択肢３</th><th>選択肢４</th><th>正解</th><th>Backend</th><th>Frontend</th><th>Android</th><th>iOS</th><th>Architect</th><th>PM</th><th>パターン</th><th>管理</th><th></th><th></th></tr>
			</thead>
			<tbody>
			<% for(int i=0; i<questionList.size(); i++){ %>
  			<% QuestionBean question = (QuestionBean)questionList.get(i); %>
				<tr>
					<td><%=question.getQuestionId() %></td>
					<td><%=question.getText() %></td>
					<td><%=question.getChoice1() %></td>
					<td><%=question.getChoice2() %></td>
					<td><%=question.getChoice3() %></td>
					<td><%=question.getChoice4() %></td>
					<td>選択肢<%=question.getCorrect() %></td>
					<% if(question.getRole1() == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(question.getRole2() == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(question.getRole3() == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(question.getRole4() == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(question.getRole5() == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(question.getRole6() == 0){ %><td></td><% } else { %><td>○</td><% } %>
  					<% if(question.getPattern() == 1){ %><td>A</td><% } else if(question.getPattern() == 2){ %><td>B</td><% } else { %><td>共通</td><% } %>
  					<td><%=question.getOwner() %></td>
  					<td>
  						<form action="./questionEdit" method="post">
  							<input type="hidden" name="question_id" value="<%=question.getQuestionId() %>">
  							<input type="hidden" name="text" value="<%=question.getText() %>">
  							<input type="hidden" name="choice_1" value="<%=question.getChoice1() %>">
  							<input type="hidden" name="choice_2" value="<%=question.getChoice2() %>">
  							<input type="hidden" name="choice_3" value="<%=question.getChoice3() %>">
  							<input type="hidden" name="choice_4" value="<%=question.getChoice4() %>">
  							<input type="hidden" name="correct" value="<%=question.getCorrect() %>">
  							<input type="hidden" name="role_1" value="<%=question.getRole1() %>">
  							<input type="hidden" name="role_2" value="<%=question.getRole2() %>">
  							<input type="hidden" name="role_3" value="<%=question.getRole3() %>">
  							<input type="hidden" name="role_4" value="<%=question.getRole4() %>">
  							<input type="hidden" name="role_5" value="<%=question.getRole5() %>">
  							<input type="hidden" name="role_6" value="<%=question.getRole6() %>">
  							<input type="hidden" name="role_7" value="<%=question.getRole7() %>">
  							<input type="hidden" name="role_8" value="<%=question.getRole8() %>">
  							<input type="hidden" name="role_9" value="<%=question.getRole9() %>">
  							<input type="hidden" name="pattern" value="<%=question.getPattern() %>">
  							<input type="hidden" name="owner" value="<%=question.getOwner() %>">
  							<input type="submit" value="編集" class="btn btn-warning">
  						</form>
  					</td>
  					<td>
  						<form action="./questionDeleteComfirm" method="post">
  							<input type="hidden" name="question_id" value="<%=question.getQuestionId() %>">
  							<input type="hidden" name="text" value="<%=question.getText() %>">
  							<input type="hidden" name="choice_1" value="<%=question.getChoice1() %>">
  							<input type="hidden" name="choice_2" value="<%=question.getChoice2() %>">
  							<input type="hidden" name="choice_3" value="<%=question.getChoice3() %>">
  							<input type="hidden" name="choice_4" value="<%=question.getChoice4() %>">
  							<input type="hidden" name="correct" value="<%=question.getCorrect() %>">
  							<input type="hidden" name="role_1" value="<%=question.getRole1() %>">
  							<input type="hidden" name="role_2" value="<%=question.getRole2() %>">
  							<input type="hidden" name="role_3" value="<%=question.getRole3() %>">
  							<input type="hidden" name="role_4" value="<%=question.getRole4() %>">
  							<input type="hidden" name="role_5" value="<%=question.getRole5() %>">
  							<input type="hidden" name="role_6" value="<%=question.getRole6() %>">
  							<input type="hidden" name="role_7" value="<%=question.getRole7() %>">
  							<input type="hidden" name="role_8" value="<%=question.getRole8() %>">
  							<input type="hidden" name="role_9" value="<%=question.getRole9() %>">
  							<input type="hidden" name="pattern" value="<%=question.getPattern() %>">
  							<input type="hidden" name="owner" value="<%=question.getOwner() %>">
  							<input type="submit" value="削除" class="btn btn-danger">
  						</form>
  					</td>
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