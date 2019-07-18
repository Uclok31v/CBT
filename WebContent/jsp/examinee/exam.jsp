<%@page import="beans.QuestionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<% UserBean whoami = (UserBean)session.getAttribute("user"); %>
<% ArrayList questionList = (ArrayList)session.getAttribute("question-list"); %>
<% String error = (String)request.getAttribute("error");
      if(error==null){
    	  error="";
      }
%>

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
  		
  		<form action="./score" method="post">
  			<table  class="table table-hover">
  				<thead>
  					<tr><th>No.</th><th>問題</th><th>選択肢１</th><th>選択肢２</th><th>選択肢３</th><th>選択肢４</th></tr>
  				</thead>
  				<tbody>
  				<% for(int i=0; i<questionList.size(); i++){ %>
  				<% QuestionBean question = (QuestionBean)questionList.get(i); %>
  					<tr>
  						<td><%=i+1 %></td>
  						<td><%=question.getText() %></td>
  						<td>
  							<div class="form-check">
  								<input class="form-check-input" type="radio" name="answer<%=i %>" id="choice_1" value="1" required>
  								<label class="form-check-label" for="choice_1"><%=question.getChoice1() %></label>
  							</div>
  						</td>
  						<td>
  							<div class="form-check">
  								<input class="form-check-input" type="radio" name="answer<%=i %>" id="choice_2" value="2">
  								<label class="form-check-label" for="choice_2"><%=question.getChoice2() %></label>
  							</div>
  						</td>
  						<td>
  							<div class="form-check">
  								<input class="form-check-input" type="radio" name="answer<%=i %>" id="choice_3" value="3">
  								<label class="form-check-label" for="choice_3"><%=question.getChoice3() %></label>
  							</div>
  						</td>
  						<td>
  							<div class="form-check">
  								<input class="form-check-input" type="radio" name="answer<%=i %>" id="choice_4" value="4">
  								<label class="form-check-label" for="choice_4"><%=question.getChoice4() %></label>
  							</div>
  						</td>
  					</tr>
  					<input type="hidden" name="question<%=i %>" value="<%=question.getQuestionId() %>">
  				<% } %>
  				</tbody>
  			</table>
  			
  			<br>
  			
  			<input type="hidden" name="size" value="<%=questionList.size() %>">
  			
  			<div class="text-center">
  				<button class="btn btn-danger" data-toggle="modal" data-target="#Modal">採点</button>
  			</div>
  			
  			<!-- モーダル・ダイアログ -->
  			<div class="modal fade" id="Modal" tabindex="-1">
  				<div class="modal-dialog">
  					<div class="modal-content">
  						<div class="modal-header">
  							<button class="close" data-dismiss="modal"><span>&times;</span></button>
  						</div>
  						<div class="modal-body">
  							採点を実施してもよろしいですか？<br>※「採点」ボタンを押す前に解答を見直してください。
  						</div>
  						<div class="modal-footer">
  							<input type="submit" value="採点" class="btn btn-danger">
  							<button class="btn" data-dismiss="modal">キャンセル</button>
  						</div>
  					</div>
  				</div>
  			</div>
  			<!--  -->
  			
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