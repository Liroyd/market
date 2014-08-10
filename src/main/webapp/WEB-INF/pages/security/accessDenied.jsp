<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="homeUrl"/>

<html>
<body>
<h1>HTTP Status 403 - Access is denied</h1>
<br/>
<h1>${accessDeniedMessage}</h1>
<br/>
<a href="${homeUrl}">Go Home!</a>

</body>
</html>