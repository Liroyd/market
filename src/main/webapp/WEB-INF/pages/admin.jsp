<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/" var="homeUrl"/>
<spring:url value="/logout/" var="logOutUrl"/>

<html>

<head>
    <script src="<c:url value="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"/>"></script>
    <script src="${pageContext.request.contextPath}/js/admin.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" type="text/css"/>

</head>

<body>
<h1>Admin Page</h1>
<p>----------------------</p>
<h1>${greetingMessage}</h1>
<p>----------------------</p>

<form id="addUserForm">
    <h1>Add new user?</h1>
    <label id="userNameLabel" for="userName">Name</label>
    <input id="userName" name="Name"/>
    <label id="userPasswordLabel" for="userPassword">Password</label>
    <input id="userPassword" name="Password"/>
    <label id="userRolesLabel">Select Role(s)</label>
    <form:select path="userRoles" id="userRoles" items="${userRoles}" name="Roles" multiple="true"/>
    <input type="submit" value="Add user" />

    <div class="error hide" id="invalidParametersErrorId">Please enter valid user information!</div>
    <div class="error hide" id="userExistsErrorId">User exists!</div>
    <div id="successCreationMessage" class="green"></div>
</form>
<p>----------------------</p>

<form id="deleteUserForm">
    <h1>Delete Someone?</h1>
    <label id="userNameLabel" for="users">Name</label>
    <form:select path="users" id="users" items="${users}" name="Name"/>
    <input type="button" value="Delete user" id="deleteUserButton"/>
    <div id="successDeletionMessage" class="green"></div>
    <div class="error hide" id="adminDeletionErrorId"> You can't delete admin!</div>
</form>
<p>----------------------</p>

<br/>
<br/>
<a href="${homeUrl}">Go Home!</a>
<br/>
<br/>
<a href="${logOutUrl}">Logout</a>

</body>
</html>