<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transactions list</title>
</head>
<body>
<a href="/">Return to home page</a><br>
<a href="/transaction/add">Add new transaction</a><br>
<table>
    <tr>
        <th>ID</th>
        <th>budget</th>
        <th>category</th>
        <th>amount</th>
        <th>date</th>
        <th>name</th>
    </tr>
    <c:forEach items="${transaction}" var="transaction">
        <tr>
            <td>${transaction.id}</td>
            <td>${transaction.budget.name}</td>
            <td>${transaction.category.name}</td>
            <td>${transaction.amount}</td>
            <td>${transaction.date}</td>
            <td>${transaction.name}</td>
            <td><a href="/transaction/update/${transaction.id}">Update</a></td>
            <td><a href="/transaction/delete/${transaction.id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>


</body>
</html>