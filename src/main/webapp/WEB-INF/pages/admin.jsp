<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/" var="homeUrl"/>
<spring:url value="/logout/" var="logOutUrl"/>

<html>
<body>
<h1>Admin Page</h1>
<p>----------------------</p>
<h1>${greetingMessage}</h1>
<p>----------------------</p>
<h1>Add new user?</h1>
<label id="userNameLabel">Name</label>
<form:input path="userName"/>
<label id="userRolesLabel">Select Role</label>
<form:select path="userRoles" items="${userRoles}">Select Role</form:select>

<p>----------------------</p>

<br/>
<br/>
<a href="${homeUrl}">Go Home!</a>
<br/>
<br/>
<a href="${logOutUrl}">Logout</a>

</body>
</html>