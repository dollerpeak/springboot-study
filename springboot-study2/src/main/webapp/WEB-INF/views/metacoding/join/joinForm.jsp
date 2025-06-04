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
		<div class="form-group">
			<label for="email">Email:</label> <input type="email"
				class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button id="btn-join" class="btn btn-primary">회원가입</button>
</div>

<script src="/js/metacoding/join/join.js"></script>
<%@ include file="../layout/footer.jsp"%>


