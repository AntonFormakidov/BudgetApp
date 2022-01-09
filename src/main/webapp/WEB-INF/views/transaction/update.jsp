<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update transaction</title>
</head>
<body>
<table>

    <form:form method="post" modelAttribute="transaction">
        <form:hidden path="id"/>
    <label>budget
        <form:select itemValue="id" itemLabel="name" path="budget" items="${budget}"/>
    </label><br/>
    <label>category
        <form:select itemValue="id" itemLabel="name" path="category" items="${category}"/>
    </label><br/>
    <label>amount
        <form:input path="amount"/>
    </label><br/>
    <label>date
        <form:input path="date" placeholder="dd.MM.yyyy"/>
    </label><br/>
    <label>name
        <form:input path="name"/>
    </label><br/>
    <input type="submit" value="Save">
    </form:form>
</body>
</html>
