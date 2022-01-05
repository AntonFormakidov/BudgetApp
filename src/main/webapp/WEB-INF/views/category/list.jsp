<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories list</title>
</head>
<body>
<a href="/">Return to home page</a><br>
<a href="/category/add">Add new category</a><br>
<table>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>description</th>
    </tr>
    <c:forEach items="${category}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="/category/update/${category.id}">Update</a></td>
            <td><a href="/category/delete/${category.id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>


</body>
</html>