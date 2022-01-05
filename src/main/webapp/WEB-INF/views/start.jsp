<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Budget app start page</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <h2>Please LogIn</h2>
    <a href="/login"><button>LogIn</button></a><br>
</sec:authorize>

<sec:authorize access="isAuthenticated()">

    <h2><i18n:message code="start"/></h2>

    <br>
    <a href="/transaction/list"><button>go to transactions list</button></a><br>
    <a href="/budget/list"><button>go to budgets list</button></a><br>
    <a href="/category/list"><button>go to categories list</button></a><br>
    <br>

    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>

</body>
</html>