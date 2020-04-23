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
<title>検索画面</title>
</head>
<body>
	<div id="wrapper">
		<h1>検索ツール</h1>
		<fieldset>
			<legend>検索条件</legend>
			<form:form method="get" modelAttribute="findForm">
				<div>
					<form:label path="todoTitle">タイトル</form:label>
					<form:input path="todoTitle" />
					<form:errors path="todoTitle" />
				</div>
				<div>
					<form:label path="createdAt">登録日付</form:label>
					<form:input path="createdAt" />
					<form:errors path="createdAt" />
				</div>
				<div>
					<label>状態</label>
					<div>
						<form:radiobutton path="finished" value="" label="全部" />
						<form:radiobutton path="finished" value="true" label="完了" />
						<form:radiobutton path="finished" value="false" label="作成中" />
						<form:errors path="finished" />
					</div>
				</div>
				<form:button>検索</form:button>
			</form:form>
		</fieldset>
		<hr>
		<fieldset>
			<legend>検索結果</legend>
			<c:choose>
				<c:when test="${page != null && page.totalPages != 0}">
					<table>
						<thead>
							<tr>
								<th>項番</th>
								<th>タイトル</th>
								<th>登録日付</th>
								<th>状態</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="baseCount" value="${page.number * page.size}" />
							<c:forEach var="todo" items="${page.content}" varStatus="status">
								<tr>
									<td>${baseCount + status.count}</td>
									<td><a
										href="${pageContext.request.contextPath}/details/${todo.todoId}">${todo.todoTitle}</a></td>
									<td><fmt:formatDate value="${todo.createdAt}"
											pattern="yyyy-MM-dd" /></td>
									<td>${todo.finished ? '完了.' : '作成中'}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
        検索結果が見つかりませんでした...
      </c:otherwise>
			</c:choose>
		</fieldset>
	</div>
</body>
</html>
