<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="utf-8">
<title>ToDo詳細画面</title>
</head>
<body>
	<div id="wrapper">
		<h1>ToDo内容</h1>
		<fieldset>
			<legend>詳細</legend>
			<table>
				<tbody>
					<tr>
						<th>タイトル</th>
						<td>${todo.todoTitle}</td>
					</tr>
					<tr>
						<th>登録日付</th>
						<td><fmt:formatDate value="${todo.createdAt}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<th>状態</th>
						<td>${todo.finished ? '完了' : '作成中'}</td>
					</tr>
				</tbody>
			</table>
			<form method="post">
				<button name="finish" ${todo.finished ? 'disabled' : ''}>完了</button>
				<button name="delete">削除</button>
			</form>
		</fieldset>
	</div>
</body>
</html>
