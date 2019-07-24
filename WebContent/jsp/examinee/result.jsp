<%@page import="beans.AnswerBean"%>
<%@page import="beans.QuestionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.UserBean"%>
<!DOCTYPE html>
<% UserBean whoami = (UserBean)session.getAttribute("user"); %>
<% Float percentage = (Float)request.getAttribute("percentage"); %>
<% Integer result = (Integer)request.getAttribute("result"); %>
<% ArrayList questionList = (ArrayList)session.getAttribute("question-list"); %>
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
  				<li><div id="real-clockbox">&nbsp;</div></li>
  			</ul>
  			<ul class="navbar-nav ml-auto">
  				<li class="nav-item"><a href="/CBT/jsp/logout" class="nav-link">ログアウト</a></li>
  			</ul>
  		</nav>
  		
  		<br>
  		<br>
  		
  		<div class="card">
  			<div class="card-body">
  				<h5 class="card-title">テスト結果</h5>
  				<p>正答率：<%=percentage %>%</p>
  				<p><% if(result==1){ %><font color="red">合格</font><% }else{ %><font color="blue">不合格</font><% } %>です。</p>
  			</div>
  		</div>
  		
  		<br>
  		<br>
  		
  		<table  class="table table-hover">
  			<thead>
  				<tr><th>No.</th><th>問題</th><th>選択肢１</th><th>選択肢２</th><th>選択肢３</th><th>選択肢４</th><th>正解</th><th>あなたの解答</th><th>正否</th></tr>
  			</thead>
  			<tbody>
  			<% for(int i=0; i<answerList.size(); i++){ %>
  			<% QuestionBean question = (QuestionBean)questionList.get(i); %>
  			<% AnswerBean answer = (AnswerBean)answerList.get(i); %>
  				<tr>
  					<td><%=i+1 %></td>
  					<td><%=question.getText() %></td>
  					<td><%=question.getChoice1() %></td>
  					<td><%=question.getChoice2() %></td>
  					<td><%=question.getChoice3() %></td>
  					<td><%=question.getChoice4() %></td>
  					<td><%=question.getCorrect() %></td>
  					<td><%=answer.getAnswer() %></td>
  					<td><% if(question.getCorrect()==answer.getAnswer()){ %>○<% }else{ %><font color="red">×</font><% } %></td>
  				</tr>
  			<% } %>	
  			</tbody>		
  		</table>
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