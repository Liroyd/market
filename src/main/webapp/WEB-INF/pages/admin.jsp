<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/" var="homeUrl" />
<spring:url value="/logout/" var="logOutUrl" />

<html>
<body>
<h1>Admin Page</h1>
<h1>${greetingMessage}</h1>

<a href="${homeUrl}">Go Home!</a>
<br/>
<br/>
<a href="${logOutUrl}">Logout</a>

</body>
</html>