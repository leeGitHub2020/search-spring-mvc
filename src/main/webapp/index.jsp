<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>検索画面</title>
	</head>
	<body>
<div id="wrapper">
  <h1>Find Todos</h1>
  <fieldset>
    <legend>Find Condition</legend>
    <form:form method="get" modelAttribute="findForm">
      <div>
        <form:label path="todoTitle">Title</form:label>
        <form:input path="todoTitle" />
        <form:errors path="todoTitle" />
      </div>
      <div>
        <form:label path="createdAt">CreatedAt</form:label>
        <form:input path="createdAt" />
        <form:errors path="createdAt" />
      </div>
      <div>
        <label>Status</label>
        <div>
          <form:radiobutton path="finished" value="" label="All" />
          <form:radiobutton path="finished" value="true" label="Finished" />
          <form:radiobutton path="finished" value="false" label="Working" />
          <form:errors path="finished" />
        </div>
      </div>
      <form:button>Find</form:button>
    </form:form>
  </fieldset>
  <hr>
  <fieldset>
    <legend>Todos by Condition</legend>
    <c:choose>
      <c:when test="${page != null && page.totalPages != 0}">
        <t:pagination page="${page}" criteriaQuery="${f:query(findForm)}" />
        <table>
          <thead>
            <tr>
              <th>No.</th>
              <th>Title</th>
              <th>Created</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <c:set var="baseCount" value="${page.number * page.size}" />
            <c:forEach var="todo" items="${page.content}"
              varStatus="status">
              <tr>
                <td>${baseCount + status.count}</td>
                <!-- (1) -->
                <td><a href="${pageContext.request.contextPath}/todos/${todo.todoId}">${f:h(todo.todoTitle)}</a></td>
                <td><fmt:formatDate value="${todo.createdAt}" pattern="yyyy-MM-dd" /></td>
                <td>${todo.finished ? 'Finished.' : 'Working.'}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:when>
      <c:otherwise>
        Not found...
      </c:otherwise>
    </c:choose>
  </fieldset>
</div>
	</body>
</html>
