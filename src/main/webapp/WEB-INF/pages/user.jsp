<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/" var="homeUrl" />
<spring:url value="/j_spring_security_logout" var="logOut" />
<html>
<body>
<h1>${userGreeting}</h1>

<a href="${homeUrl}">Go Home!</a>
<br>
<br>
<a href="${logOut}">Logout</a>

</body>
</html>