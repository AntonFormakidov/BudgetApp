<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update budget</title>
</head>
<body>
<table>

    <form:form method="post" modelAttribute="budget">
        <form:hidden path="id"/>
    <label>name
        <form:input path="name"/>
    </label><br/>
    <label>description
        <form:input path="description"/>
    </label><br/>

    <input type="submit" value="Save">
    </form:form>
</body>
</html>
