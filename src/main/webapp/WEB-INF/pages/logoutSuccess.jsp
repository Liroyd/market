<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/" var="homeUrl" />

<html>
<body>
<h1>${farewellMessage}</h1>
<br/>
<a href="${homeUrl}">Go Home!</a>

</body>
</html>