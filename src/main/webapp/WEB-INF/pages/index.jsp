<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:url value="/personalPage/" var="personalPage"/>
<spring:url value="/market/" var="marketUrl"/>
<spring:url value="/logout/" var="logOutUrl"/>

<html>
<body>
<h1>${welcomeMessage}</h1>

<br/>
<a href="${personalPage}">Personal Page</a>
<br/>
<a href="${marketUrl}">Market</a>
<br/>

<sec:authorize access="isAuthenticated()">
    <br/>
    <form action="${logOutUrl}" method="post">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>

</body>
</html>
