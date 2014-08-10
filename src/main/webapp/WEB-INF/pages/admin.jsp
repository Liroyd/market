<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/" var="homeUrl"/>
<spring:url value="/logout/" var="logOutUrl"/>

<html>

<head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
        .green { font-weight: bold; color: green; }
        .message { margin-bottom: 10px; }
        label { width:70px; display:inline-block;}
        .hide { display: none; }
        .error { color: red; }
    </style>
</head>

<body>
<h1>Admin Page</h1>
<p>----------------------</p>
<h1>${greetingMessage}</h1>
<p>----------------------</p>

<form id="addUserForm">
    <h1>Add new user?</h1>
    <label id="userNameLabel" for="userName">Name</label>
    <input id="userName" name="Name" id="userName"/>
    <label id="userPasswordLabel" for="userPassword">Password</label>
    <input id="userPassword" name="Password" id="userPassword"/>
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
    <input type="submit" value="Delete user"/>
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


<script type="text/javascript">

    $(document).ready(function() {

        $('#addUserForm').submit(function(e) {
            var userName = $('#userName').val();
            var roles = $('#userRoles').val();
            var userPassword = $('#userPassword').val();
            if(!validateUser(userName, userPassword, roles)) {
                return false;
            }

            $.post('${pageContext.request.contextPath}/admin/create', $(this).serialize(), function(response) {
                if (response.length <= 0) {
                    var userExistsErrorId = $('#userExistsErrorId');
                    userExistsErrorId.show();
                } else {
                    var successCreationMessage = $('#successCreationMessage');
                    successCreationMessage.text(response);
                    successCreationMessage.show();

                    var userName = $('#userName').val();
                    $("#users").append('<option value="'+userName+'">'+userName+'</option>');
               }
            });
            e.preventDefault();
        });

        $('#deleteUserForm').submit(function(e) {
            hideMessagesAndWarnings();
            $.post('${pageContext.request.contextPath}/admin/delete', $(this).serialize(), function(response) {
                if (response.length <= 0) {
                    $('#adminDeletionErrorId').show();
                } else {
                    var $successDeletionMessage = $('#successDeletionMessage');
                    $successDeletionMessage.text(response);
                    $successDeletionMessage.show();

                    var user = $('#users');
                    users.remove(users.selectedIndex);
                }
            });
            e.preventDefault();
        });

    });

    function validateUser(userName, userPassword, roles) {
        hideMessagesAndWarnings();
        if(userName == null || userName.length <= 0 || userPassword == null || userPassword.length <= 0 || roles == null) {
            $('#invalidParametersErrorId').show();
            return false;
        }
        else {
            return true;
        }
    }

    function hideMessagesAndWarnings() {
        $('#invalidParametersErrorId').hide();
        $('#userExistsErrorId').hide();
        $('#successCreationMessage').hide();
        $('#successDeletionMessage').hide();
        $('#adminDeletionErrorId').hide();
    }

</script>

</body>
</html>