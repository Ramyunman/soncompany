<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록2</title>
</head>
<style>
	h1 {
		text-align:center;
	}
	table {
		border-collapse:collapse;
		margin:40px auto;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
	}
	ul {
		width:600px;
		height:50px;
		margin:10px auto;
	}
	li {
		list-style:none;
		width:50px;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	}
	form {
		text-align:center;
		margin:50px
	}
</style>
<body>
<h1>게시판 목록2</h1>
	<table >
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<c:forEach items="${list}" var="board2">
			 <tr>
				<td>${board2.b_idx}</td>
				<td>${board2.b_title}</td>
				<td>${board2.b_content}</td>
		     <tr>
		</c:forEach>
	</table>
</body>
</html>
