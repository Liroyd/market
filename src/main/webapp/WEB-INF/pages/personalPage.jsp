<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<spring:url value="/" var="homeUrl"/>
<spring:url value="/logout/" var="logOutUrl"/>

<html>
<body>
<h1>${greetingMessage}</h1>

<a href="${homeUrl}">Go Home!</a>
<br>

<sec:authorize access="isAuthenticated()">
<br>
    <form action="${logOutUrl}" method="post">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>

</body>
</html>