<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<% UserBean whoami = (UserBean)session.getAttribute("user"); %>
<% ArrayList adminList = (ArrayList)request.getAttribute("admin-list"); %>
<% String questionId = (String)request.getAttribute("question_id"); %>
<% String text = (String)request.getAttribute("text"); %>
<% String choice1 = (String)request.getAttribute("choice_1"); %>
<% String choice2 = (String)request.getAttribute("choice_2"); %>
<% String choice3 = (String)request.getAttribute("choice_3"); %>
<% String choice4 = (String)request.getAttribute("choice_4"); %>
<% int correct = (Integer)request.getAttribute("correct"); %>
<% int role_1 = (Integer)request.getAttribute("role_1"); %>
<% int role_2 = (Integer)request.getAttribute("role_2"); %>
<% int role_3 = (Integer)request.getAttribute("role_3"); %>
<% int role_4 = (Integer)request.getAttribute("role_4"); %>
<% int role_5 = (Integer)request.getAttribute("role_5"); %>
<% int role_6 = (Integer)request.getAttribute("role_6"); %>
<% int role_7 = (Integer)request.getAttribute("role_7"); %>
<% int role_8 = (Integer)request.getAttribute("role_8"); %>
<% int role_9 = (Integer)request.getAttribute("role_9"); %>
<% int pattern = (Integer)request.getAttribute("pattern"); %>
<% String owner = (String)request.getParameter("owner"); %>

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
  			<ul class="navbar-nav ml-auto">
  				<li class="nav-item"><a href="/CBT/jsp/admin/passwordChange.jsp" class="nav-link">パスワード変更</a></li> 		
  				<li class="nav-item"><a href="/CBT/jsp/logout" class="nav-link">ログアウト</a></li>
  			</ul>
  		</nav>
  		
  		<h1 class="mt-4 mb-5">問題登録</h1>
  		<form action="./questionUpdate" method="post">
  			<div class="form-group mb-4">
  				<label for="question_id">設問ID</label>
  				<input type="text" class="form-control" id="question_id" name="question_id" value="<%=questionId %>" readonly>
  			</div>
  			<div class="form-group mb-4">
  				<label for="text">問題文</label>
  				<textarea rows="5" class="form-control" id="text" name="text" required><%=text %></textarea>
  			</div>
  			<div class="form-group mb-4">
  				<label for="choice_1">選択肢１</label>
  				<input type="text" class="form-control" id="choice_1" name="choice_1" value="<%=choice1 %>" required>
  			</div>
  			<div class="form-group mb-4">
  				<label for="choice_2">選択肢２</label>
  				<input type="text" class="form-control" id="choice_2" name="choice_2" value="<%=choice2 %>" required>
  			</div>
  			<div class="form-group mb-4">
  				<label for="choice_3">選択肢３</label>
  				<input type="text" class="form-control" id="choice_3" name="choice_3" value="<%=choice3 %>" required>
  			</div>
  			<div class="form-group mb-4">
  				<label for="choice_4">選択肢４</label>
  				<input type="text" class="form-control" id="choice_4" name="choice_4" value="<%=choice4 %>" required>
  			</div>
  			<div class="form-group mb-4">正解<br>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="radio" name="correct" id="no_1" value="1" <% if(correct==1){ %>checked<% } %>>
  					<label class="form-check-label" for="no_1">選択肢１</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="radio" name="correct" id="no_2" value="2" <% if(correct==2){ %>checked<% } %>>
  					<label class="form-check-label" for="no_2">選択肢２</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="radio" name="correct" id="no_3" value="3" <% if(correct==3){ %>checked<% } %>>
  					<label class="form-check-label" for="no_3">選択肢３</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="radio" name="correct" id="no_4" value="4" <% if(correct==4){ %>checked<% } %>>
  					<label class="form-check-label" for="no_4">選択肢４</label>
  				</div>
  			</div>
  			<div class="form-group mb-4">出題対象<br>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="checkbox" name="role_1" id="role_1" value="1" <% if(role_1 == 1){ %>checked<% } %>>
  					<label class="form-check-label" for="role_1">Backend</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="checkbox" name="role_2" id="role_2" value="1" <% if(role_2 == 1){ %>checked<% } %>>
  					<label class="form-check-label" for="role_2">Frontend</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="checkbox" name="role_3" id="role_3" value="1" <% if(role_3 == 1){ %>checked<% } %>>
  					<label class="form-check-label" for="role_3">Android</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="checkbox" name="role_4" id="role_4" value="1" <% if(role_4 == 1){ %>checked<% } %>>
  					<label class="form-check-label" for="role_4">iOS</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="checkbox" name="role_5" id="role_5" value="1" <% if(role_5 == 1){ %>checked<% } %>>
  					<label class="form-check-label" for="role_5">Architect</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="checkbox" name="role_6" id="role_6" value="1" <% if(role_6 == 1){ %>checked<% } %>>
  					<label class="form-check-label" for="role_6">PM</label>
  				</div>
  			</div>
  			<div class="form-group mb-4">パターン<br>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="radio" name="pattern" id="common" value="0" <% if(pattern == 0){ %>checked<% } %>>
  					<label class="form-check-label" for="common">共通</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="radio" name="pattern" id="pattern_A" value="1" <% if(pattern == 1){ %>checked<% } %>>
  					<label class="form-check-label" for="pattern_A">パターンA</label>
  				</div>
  				<div class="form-check form-check-inline mr-4">
  					<input class="form-check-input" type="radio" name="pattern" id="pattern_B" value="2" <% if(pattern == 2){ %>checked<% } %>>
  					<label class="form-check-label" for="pattern_B">パターンB</label>
  				</div>
  			</div>
  			<div>
  				<label for="owner">問題管理者</label>
  				<select class="form-control" id="owner" name="owner" value="<%=owner %>">
  					<% for(int i=0; i<adminList.size(); i++){ %>
  					<% UserBean user = (UserBean)adminList.get(i); %>
  					<option value="<%=user.getUserName() %>"><%=user.getUserName() %></option>
  					<% } %>
  				</select>
  			</div>
  			
  			<br>
  			<div>
  				<input type="submit" value="編集" class="btn btn-warning">&nbsp;
  				<a href="/CBT/jsp/admin/questionListFetch" class="btn btn-light">キャンセル</a>
  			</div>
  			
  		</form>
  	
  	<br><br>
  		
  	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>