<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/admin/" var="adminUrl"/>
<spring:url value="/user/" var="userUrl"/>
<spring:url value="/j_spring_security_logout" var="logOut" />

<html>
<body>
<h1>${message}</h1>

<a href="${adminUrl}">Admin's page</a>
<br/>
<a href="${userUrl}">User's page</a>
<br/>
<br/>
<a href="${logOut}">Logout</a>

</body>
</html>
