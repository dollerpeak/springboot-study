<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>codingrecipe-board</title>
    <style>
        table, tr, td, th {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
        }
    </style>
</head>
<body>
	<h2>codingrecipe board</h2>
	<h2>jsp</h2>
	<a href="/codingrecipe/home">뒤로</a>
	
	<table>
	    <tr>
	        <th>번호</th>
	        <td th:text="${boarddto.seq}"></td>
	    </tr>
	    <tr>
	        <th>제목</th>
	        <td th:text="${boarddto.title}"></td>
	    </tr>
	    <tr>
	        <th>내용</th>
	        <td th:text="${boarddto.contents}"></td>
	    </tr>
	    <tr>
	        <th>패스워드</th>
	        <td th:text="${boarddto.password}"></td>
	    </tr>
	    <tr>
	        <th>조회수</th>
	        <td th:text="${boarddto.hits}"></td>
	    </tr>
	    <tr>
	        <th>작성일</th>
	        <td th:text="${boarddto.frstRegDate}"></td>
	    </tr>
	    <tr>
	        <th>작성자</th>
	        <td th:text="${boarddto.frstRegUserId}"></td>
	    </tr>
	    <tr>
	        <th>수정일</th>
	        <td th:text="${boarddto.lastChgDate}"></td>
	    </tr>
	    <tr>
	        <th>수정자</th>
	        <td th:text="${boarddto.lastChgUserId}"></td>
	    </tr>
	</table>
</body>
</html>