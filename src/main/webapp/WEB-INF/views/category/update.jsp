<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update category</title>
</head>
<body>
<table>

    <form:form method="post" modelAttribute="category">
        <form:hidden path="id"/>
    <label>name
        <form:input path="name"/>
        <form:errors path="name" cssClass="error" />
    </label><br/>
    <label>description
        <form:input path="description"/>
    </label><br/>

    <input type="submit" value="Save">
    </form:form>
</body>
</html>
