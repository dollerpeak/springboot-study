<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="!isAuthenticated()">  
  <!-- 로그인 가능 -->
</sec:authorize>
<sec:authorize access="isAuthenticated()">
  <!-- 로그인된 사용자, 로그아웃 가능 -->
  <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>

<head>
	<title>metacoding-blog</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
	<link
		href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
		rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

</head>
<body>
	<h6>principal ==> ${principal}</h6>
	<%-- <h6>${principal.username}</h6> --%>
	<%-- <h6>${principal.password}</h6> --%>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">Main</a>
		<a class="navbar-brand" href="/metacoding/home">Metacoding</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<!-- <ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">Main</a></li>
				<li class="nav-item"><a class="nav-link" href="/metacoding/login/loginForm">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="/metacoding/join/joinForm">회원가입</a></li>
			</ul> -->
			
			<%-- <c:out value="${sessionScope.attributeName}" /> --%>
			
			<!-- 세션이 있을때와 없을때 처리 -->
			<c:choose>
				<%-- <c:when test="${empty sessionScope.principal}"> --%>
				<c:when test="${empty principal}">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/metacoding/auth/login/loginForm">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/metacoding/auth/join/joinForm">회원가입</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/metacoding/panel/insertForm">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="/metacoding/user/userForm">회원정보</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
			
			
		</div>
	</nav>
	<br>

