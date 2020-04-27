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
<!--
	<br>
	<div id="form1">
		<fieldset>
			<legend>バリデーション１</legend>
			<form:form method="post" modelAttribute="validationForm1"
				action="test/validationTest/form1" class="form-horizontal">
				<div>
					<form:label path="zipCode" cssErrorClass="error-label">郵便番号</form:label>
					<form:input path="zipCode" cssErrorClass="error-input" />
					<form:errors path="zipCode" cssClass="error-messages" />
				</div>
				<br>
				<form:button>確認</form:button>
			</form:form>
		</fieldset>
	</div>

	<br>
	<div id="form2">
		<fieldset>
			<legend>バリデーション２</legend>
			<form:form method="post" modelAttribute="validationForm2"
				action="test/validationTest/form2" class="form-horizontal">
				<div>
					<form:label path="itemCode" cssErrorClass="error-label">商品コード</form:label>
					<form:input path="itemCode" cssErrorClass="error-input" />
					<form:errors path="itemCode" cssClass="error-messages" />
				</div>
				<br>
				<form:button>確認</form:button>
			</form:form>
		</fieldset>
	</div>
 -->
 <br>
	<div id="form3">
		<fieldset>
			<legend>バリデーション２</legend>
			<form:form method="post" modelAttribute="validationForm3"
				action="test/validationTest/form3" >
				<div>
					日付期間：
					<form:input path="dateFrom" cssErrorClass="error-input" />
					-
					<form:input path="dateTo" cssErrorClass="error-input" />
					<br>
					<form:errors path="dateFrom" cssClass="error-messages" />
					<form:errors path="dateTo" cssClass="error-messages" />
					<form:errors path="validDate" cssClass="error-messages" />
				</div>
				<br>
				<form:button>確認</form:button>
			</form:form>
		</fieldset>
	</div>
</body>
</html>