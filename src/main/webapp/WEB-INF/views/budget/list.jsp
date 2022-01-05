<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Budgets list</title>
</head>
<body>
<a href="/">Return to home page</a><br>
<a href="/budget/add">Add new budget</a><br>
<table>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>description</th>
    </tr>
    <c:forEach items="${budget}" var="budget">
        <tr>
            <td>${budget.id}</td>
            <td>${budget.name}</td>
            <td>${budget.description}</td>
            <td><a href="/budget/update/${budget.id}">Update</a></td>
            <td><a href="/budget/delete/${budget.id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>


</body>
</html>