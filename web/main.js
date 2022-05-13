myStorage = window.localStorage;

function signup() {
    var username = $('#register_username').val();
    var password = $('#register_password').val();
    var email = $('#register_email').val();

    localStorage.setItem("activeUser", username);

    $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: "/dsaApp/user",
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
            window.location.href = "signup.html";
            }
        });
}

function login() {
    var username = $('#login_username').val();
    var password = $('#login_password').val();

    localStorage.setItem("activeUser", username);

     $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: "/dsaApp/user/logIn",
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
            window.location.href = "login.html";
        });
}

function logout() {
    localStorage.setItem("activeUser", null);
    alert('Come back soon!');
    window.location.href = "index.html";
}

function updateUser() {

}

function deleteUser() {

}

function getStore() {

}

function buyItem() {

}

function getInventory() {

}