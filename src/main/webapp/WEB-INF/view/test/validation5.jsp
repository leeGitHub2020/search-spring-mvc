<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<form:form method="post" modelAttribute="validationForm5"
				action="${pageContext.request.contextPath}/test/validation5">
				<div>
					<table>
						<tr>
							<th>No.</th>
							<th>商品</th>
							<th>数量</th>
							<th>単価</th>
							<th></th>
						</tr>
						<c:set var="baseCount" value="0" />
						<c:forEach var="childList"
							items="${validationForm5.validationForm5ChildList}"
							varStatus="status">
							<tr>
								<td>${baseCount + status.count}</td>
								<td>
									<form:input path="validationForm5ChildList[${status.index}].item" cssErrorClass="fieldError" />
									<form:errors path="validationForm5ChildList[${status.index}].item" cssErrorClass="error-messages" />
								</td>
								<td>
									<form:input path="validationForm5ChildList[${status.index}].qty" cssErrorClass="fieldError" />
									<form:errors path="validationForm5ChildList[${status.index}].qty" cssErrorClass="error-messages" />
								</td>
								<td>
									<form:input path="validationForm5ChildList[${status.index}].price" cssErrorClass="fieldError" />
									<form:errors path="validationForm5ChildList[${status.index}].price" cssErrorClass="error-messages" />
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br>
				<form:button>確認</form:button>
			</form:form>
		</fieldset>
	</div>
</body>
</html>