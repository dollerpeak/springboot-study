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
	<a href="/">main</a>
	<a href="/codingrecipe/insert">글작성</a>
	
	<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>패스워드</th>
        <th>조회수</th>
        <th>작성일</th>
        <th>작성자</th>
        <th>수정일</th>
        <th>수정자</th>
    </tr>
    <tr th:each="boarddto: ${boarddtolist}">
        <td th:text="${boarddto.seq}"></td>
        <td>
        	<!-- <a th:text="${board.boardTitle}" th:href="@{|/${board.id}|}"></a> -->
            <a th:text="${boarddto.title}" th:href="@{/codingrecipe/select/{seq}(seq=${boarddto.seq})}"></a>
        </td>
        <td th:text="${boarddto.contents}"></td>
        <td th:text="${boarddto.password}"></td>
        <td th:text="${boarddto.hits}"></td>
        <td th:text="${boarddto.frstRegDate}"></td>
        <td th:text="${boarddto.frstRegUserId}"></td>
        <td th:text="${boarddto.lastChgDate}"></td>
        <td th:text="${boarddto.lastChgUserId}"></td>
    </tr>
</table>
</body>
</html>