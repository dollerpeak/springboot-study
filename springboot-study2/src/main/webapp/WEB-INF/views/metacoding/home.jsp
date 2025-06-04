<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="./layout/header.jsp"%>

<div class="container">

	<!-- panel list -->
	<c:forEach var="panel" items="${list}">
		<div class="card m-2">
			<!-- <img class="card-img-top" src="img_avatar1.png" alt="Card image"> -->
			<div class="card-body">
				<h4 class="card-title">${panel.title}</h4>
				<h6>${panel.frstRegUserId}, 조회 ${panel.hits}회</h6>
				<!-- <p class="card-text">내용영역</p> -->
				<a href="/metacoding/panel/detailPanel/${panel.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>

</div>

<%@ include file="./layout/footer.jsp"%>


