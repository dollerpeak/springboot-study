<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<input type="hidden" id="id" value="${object.id}">
		<div class="form-group">
			<label for="title">제목</label>
			<input value="${object.title}" type="text" class="form-control" placeholder="Enter title" id="title">
		</div>
		<div class="form-group">
			<label for="contents">내용</label>
			<textarea class="form-control summernote" rows="5" id="contents">${object.contents}</textarea>
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">수정</button>
</div>

<script>
  $('.summernote').summernote({
    tabsize: 2,
    height: 300
  });
</script>

<script src="/js/metacoding/panel/panel.js"></script>
<%@ include file="../layout/footer.jsp"%>


