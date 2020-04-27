<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>バリデーションテスト</title>
<link rel="stylesheet" href="css/search.css">
</head>
<body>
	<br>
	<div id="validationForm4">
		<fieldset>
			<legend>バリデーション２</legend>
			<form:form method="post" modelAttribute="validationForm4"
				action="${pageContext.request.contextPath}/test/validation4">
				<div>
					期日：
					<form:radiobutton path="period" value="A" label="当日" />
					<form:radiobutton path="period" value="B" label="期間指定" />
					<form:input path="dueDate" cssErrorClass="error-input" />
					<form:errors path="dueDate" cssClass="error-messages" />
					<br>
					<form:button>確認</form:button>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>