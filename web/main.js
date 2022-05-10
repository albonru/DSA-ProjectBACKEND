myStorage = window.localStorage;

function signup() {
    var username = $('#register_username').val();
    var password = $('#register_password').val();
    var m = $('#register_email').val();

    localStorage.setItem("loggedUser", username);

    $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: "/dsaApp/addUser",
            data: JSON.stringify({username: username, password: password, email: email}),
            dataType: 'json',
            success: function (result) {
                window.location.href = "userProfile.html";
            },
            error : function(error) {
            if (username == "" || password == "" || email == "")
                alert("You left something blank. Please try again!");
            else
                alert("Username or email already already in use. Please try again!");
            }
        });
}

function login() {
    var username = $('#login_username').val();
    var password = $('#login_password').val();

    localStorage.setItem("loggedUser", username);

     $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: "/dsaApp/logIn",
            data: JSON.stringify({name: username, password: password}),
            dataType: 'json',
            success: function (result) {
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

function logout() {
    localStorage.setItem("loggedUser", null);
    alert('Come back soon!');
    window.location.href = "index.html";
}

function storeSetUp() {
}