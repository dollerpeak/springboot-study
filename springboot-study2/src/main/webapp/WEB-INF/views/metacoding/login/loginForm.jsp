<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<!-- <form action="#" method="post"> -->
	<form action="/metacoding/auth/loginProc" method="post">	
		<div class="form-group">
			<label for="name">Name:</label> 
			<input type="text" name="name" class="form-control" placeholder="Enter name" id="name">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
	<button id="btn-login" class="btn btn-primary">로그인</button>
	</form>	
</div>

<!-- <script src="/js/metacoding/login/login.js"></script> -->
<%@ include file="../layout/footer.jsp"%>


