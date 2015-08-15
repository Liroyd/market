$(document).ready(function() {

    $('#addUserForm').submit(function(e) {
        var userName = $('#userName').val();
        var roles = $('#userRoles').val();
        var userPassword = $('#userPassword').val();
        if(!validateUser(userName, userPassword, roles)) {
            return false;
        }

        $.post('/admin/create', $(this).serialize(), function(response) {
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
        $.post('/admin/delete', $(this).serialize(), function(response) {
            if (response.length <= 0) {
                $('#adminDeletionErrorId').show();
            } else {
                var $successDeletionMessage = $('#successDeletionMessage');
                $successDeletionMessage.text(response);
                $successDeletionMessage.show();

                $('#users option:selected').remove();
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