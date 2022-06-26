function logout() {
    localStorage.setItem("activeUser", null);
    alert('Come back soon!');
    window.location.href = "index.html";
}

function login() {
    var username = $('#login_username').val();
    var password = $('#login_password').val();

    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url: '/dsaApp/user/logIn',
        data: JSON.stringify({"username": username, "password": password}),
        dataType: 'json',
        success: function (result) {
            alert("Login successful. Welcome back, " + username);
            localStorage.setItem("activeUser", username);
            window.location.href = "userProfile.html";
        },
        error : function(error) {
            if (username == "" || password == "")
                alert("You left something blank, please try again!");
            else
                alert("Wrong Username or Password, please try again!");
        }
    });
}

function signup() {
    var username = $('#signup_username').val();
    var password = $('#signup_password').val();
    var email = $('#signup_email').val();

    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url: '/dsaApp/user/addUser',
        data: JSON.stringify({"username": username, "password": password, "email": email}),
        dataType: 'json',
        success: function (result) {
            alert("Sign up completed. Nice to meet you, " + username);
            localStorage.setItem("activeUser", username);
            window.location.href = "userProfile.html";
        },
        error : function(error) {
            if (username == "" || password == "" || email == "")
                alert("You left something blank. Please try again!");
            else
                alert("Username or email already in use. Please try again!");
        }
    });
}

function deleteUser() {
        var username = localStorage.getItem("activeUser");
        $.ajax({
            contentType: "application/json",
            type: 'DELETE',
            url: "/dsaApp/user/delete/"+username,
            dataType: 'json',
            success: function (result) {
                alert("User deleted successfully. We are sad to see you go :(");
                localStorage.setItem("activeUser", null);
                window.location.href = "index.html";
            },
            error : function(error) {
                alert("User could not be deleted. Please try again later!");
                window.location.href = "userProfile.html";
            }
        });
}

function updateUser() {
            var oldUsername = localStorage.getItem("activeUser");
            var username = $('#user').val();
            var password = $('#password').val();
            var email = $('#mail').val();

            $.ajax({
                contentType: "application/json",
                type: 'PUT',
                url: "/dsaApp/user/update/"+oldUsername,
                data: JSON.stringify({username: username, password: password, email: email}),
                dataType: 'json',
                success: function (result) {
                alert("Information updated successfully");
                    localStorage.setItem("activeUser", username);
                    window.location.href = "userProfile.html";
                },
                error : function(error) {
                    if (username == "" || password == "" || email == "")
                        alert("You left something blank. Please try again!");
                    else
                        alert("Username or email already in use. Please try again!");
                    window.location.href = "update.html";
                }
            });
}

function getPointRanking() {
            $.ajax({
            contentType: "application/json",
            type: 'GET',
            url: "/dsaApp/user/pointRanking",
            dataType: 'json',
            success: function (result) {
                for (var i=0; i<data.length; ++i) {
                    $(points).append('<div class="points"> + result[i].points + '</>');
                    $(username).append('<div class="username"> + result[i].username + '</>');
                }
            },
            error : function(error) {
                alert("Rankings not available right now. Please try again later!");
                window.location.href = "userProfile.html";
            }
        });
}