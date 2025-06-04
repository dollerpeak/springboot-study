<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>codingrecipe-board</title>
</head>
<body>
	<h2>codingrecipe board</h2>
	<h2>jsp</h2>
	<a href="/codingrecipe/home">뒤로</a>
	
	<form action="/codingrecipe/insert" method="post">
		제목: <input type="text" name="title"><br>
		내용: <textarea name="contents" cols="30" rows="10"></textarea><br> 
		작성자: <input type="text" name="frstRegUserId"><br> 
		비밀번호: <input type="text" name="password"><br> 		 
		<input type="submit" value="작성">
	</form>
</body>
</html>