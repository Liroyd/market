<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:url value="/admin/" var="adminUrl"/>
<spring:url value="/user/" var="userUrl"/>
<spring:url value="/logout/" var="logOut" />

<html>
<body>
<h1>${message}</h1>

<a href="${adminUrl}">Admin's page</a>
<br/>
<a href="${userUrl}">User's page</a>
<br/>

<sec:authorize access="isAuthenticated()">
    <br/>
    <a href="${logOut}">Logout</a>
</sec:authorize>

</body>
</html>
