<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			id=<span id="id">${object.id}</span>,
			userId=<span id="userId">${object.userId}</span>,
			hits=<span id="hits">${object.hits}</span>
		</div>
		<hr>
		<div class="form-group">
			<label for="title">제목</label>
			<h4 id="title">${object.title}</h4>
		</div>
		<hr>
		<div class="form-group">
			<label for="contents">내용</label>
			<div id="contents">${object.contents}</div>
		</div>
		<hr>			
		<div class="form-group">
			<div>
				frstRegUserId=<span id="frstRegUserId">${object.frstRegUserId}</span>,
				frstRegDate=<span id="frstRegDate">${object.frstRegDate}</span>
			</div>
			<div>
				lastChgUserId=<span id="lastChgUserId">${object.lastChgUserId}</span>,
				lastChgDate=<span id="lastChgDate">${object.lastChgDate}</span>
			</div>			
		</div>
		<hr>		
	</form>
	<!-- 임의로 spirng security userdetails.username과 frstRegUserId를 비교 -->
	<c:if test="${object.frstRegUserId == principal.username}">
		<a href="/metacoding/panel/updateForm/${object.id}" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>	
</div>

<script src="/js/metacoding/panel/panel.js"></script>
<%@ include file="../layout/footer.jsp"%>


