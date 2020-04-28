<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>ログイン</title>
<link rel="stylesheet" href="css/search.css">
</head>
<body>
	<div id="wrapper">
		<h1>DBアクセス操作</h1>
		&nbsp;<font color="red">${msg}</font>
		<fieldset>
			<legend>詳細</legend>
			<spring:url value="/login" var="url" htmlEscape="true" />
			<form:form action="${url}" method="POST" modelAttribute="login" accept-charset="UTF-8">
				<label>ID</label>
				<div>
					<form:input path="id" />
				</div>
				<br />
				<label>ユーザー名</label>
				<div>
					<form:input path="name" />
				</div>
				<br />
				<label>操作</label>
				<br>
				<div>
					<form:radiobutton path="todo" value="1" label="登録" />
					<form:radiobutton path="todo" value="2" label="検索" />
					<form:radiobutton path="todo" value="3" label="更新" />
					<form:radiobutton path="todo" value="4" label="削除" />
				</div>
				<br />
				<input type="submit" value="確認" />
				<br />
			</form:form>
		</fieldset>
	</div>
</body>
</html>