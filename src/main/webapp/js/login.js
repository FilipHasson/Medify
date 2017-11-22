$('#forgotPass').on('click', function () {location.href = "forgotPassword.html"});
$('#createAccount').on('click', function () {location.href = "createAccount.html"});

function showPassword() {
    var x = document.getElementById("pwd");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function login() {
    clearErrors();
    var email = document.getElementById("email");
    var password = document.getElementById("pwd");

    if (email.value == "" || password.value == ""){
        var loginError = document.getElementById("loginError");
        loginError.innerHTML = "Email and/or password cannot be left blank!";
    } else {
        //Below is the call to the backend!
        //$.get("/login?email=" + email + "&password=" + password, function(userID){
            //This is a temp variable for now
            var userID = 1234;

            if (userID != null) {
                location.href = "./login";
            } else {
                var loginError = document.getElementById("loginError");
                loginError.innerHTML = "Email and/or password is incorrect!";
            }
        //});
    }
}

function clearErrors() {
    var loginError = document.getElementById("loginError");
    loginError.innerHTML = "";
}
