<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="name">Name:</label> <input type="text"
				class="form-control" placeholder="Enter name" id="name">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password">
		</div>
	</form>
	<button id="btn-login" class="btn btn-primary">로그인</button>
</div>

<script src="/js/metacoding/login/login.js"></script>
<%@ include file="../layout/footer.jsp"%>


