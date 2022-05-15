myStorage = window.localStorage;

function signup() {
    var username = $('#register_username').val();
    var password = $('#register_password').val();
    var email = $('#register_email').val();

    $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: "/dsaApp/user",
            data: JSON.stringify({username: username, password: password, email: email}),
            dataType: 'json',
            success: function (result) {
                alert("Sign up completed. Nice to meet you!");
                localStorage.setItem("activeUser", username);
                window.location.href = "userProfile.html";
            },
            error : function(error) {
                if (username == "" || password == "" || email == "")
                    alert("You left something blank. Please try again!");
                else
                    alert("Username or email already in use. Please try again!");
                //window.location.href = "signup.html";
            }
    });
}

function login() {
    var username = $('#login_username').val();
    var password = $('#login_password').val();

     $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: "/dsaApp/user/logIn",
            data: JSON.stringify({name: username, password: password}),
            dataType: 'json',
            success: function (result) {
                alert("Login successful. Welcome back!");
                localStorage.setItem("activeUser", username);
                window.location.href = "userProfile.html";
            },
            error : function(error) {
                if (username == "" || password == "")
                    alert("You left something blank, please try again!");
                else
                    alert("Wrong Username or Password, please try again!");
                //window.location.href = "login.html";
            }
     });
}

function logout() {
    localStorage.setItem("activeUser", null);
    alert('Come back soon!');
    window.location.href = "index.html";
}

function updateUser() {
    var oldUsername = localStorage.getItem("activeUser");
    var username = $('#update_username').val();
    var password = $('#update_password').val();
    var email = $('#update_email').val();

    $.ajax({
            contentType: "application/json",
            type: 'PUT',
            url: "/dsaApp/user",
            data: JSON.stringify({oldUsername: oldUsername, username: username, password: password, email: email}),
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
            }
    });
}

function deleteUser() {
    var user = localStorage.getItem("activeUser");

    $.ajax({
            contentType: "application/json",
            type: 'DELETE',
            url: "/dsaApp/user",
            data: JSON.stringify({username: username}),
            dataType: 'json',
            success: function (result) {
                alert("User deleted successfully. We are sad to see you go :(");
                localStorage.setItem("activeUser", null);
                window.location.href = "index.html";
            },
            error : function(error) {
                alert("User could not be deleted. Please try again later!");
            }
    });
}

function setUpStore() {

}

//INCOMPLETE
function buyItem() {
    var user = localStorage.getItem("activeUser");
    //var item = el item que hagi seleccionat

    $.ajax({
            contentType: "application/json",
            type: 'PUT',
            url: "/dsaApp/item/buyItem/" + item,
            data: JSON.stringify({item: item, username: user}),
            dataType: 'json',
            success: function (result) {
                alert("Successfully purchased " + item);
            },
            error : function(error) {
                 alert('Purchase failed. Might not have enough coins or already have it');
            }
    });
}

//INCOMPLETE
function getInventory() {
    var user = localStorage.getItem("activeUser");

    $.ajax({
            contentType: "application/json",
            type: 'GET',
            url: "/dsaApp/item/inventoryList/" + user,
            data: JSON.stringify({username: user}),
            dataType: 'json',
            success: function (result) {
                //tallar llista i visualització
            },
            error : function(error) {
                 alert('Could not fetch inventory. Please try again later!');
            }
    });
}