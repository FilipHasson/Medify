$('#back').on('click', function () {location.href = "login.html"});

function sendEmail() {
    clearErrors();
    var email = document.getElementById("email");

    if (email.value == ""){
        var emailError = document.getElementById("emailError");
        emailError.innerHTML = "Email cannot be left blank!";
    } else {
        var emailSuccess = document.getElementById("emailSuccess");
        emailSuccess.innerHTML = "Email has been sent!"
    }
}

function clearErrors() {
    var emailError = document.getElementById("emailError");
    emailError.innerHTML = "";
    var emailSuccess = document.getElementById("emailSuccess");
    emailSuccess.innerHTML = "";
}
