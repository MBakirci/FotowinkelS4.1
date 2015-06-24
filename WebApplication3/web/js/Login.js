$('#frmLogin').submit(function (e) {
    e.preventDefault();
    var btn = $('#btnLogin').val();
    var Email = $('#Email').val();
    var Pass = $('#Password').val();

    $.ajax({
        type: 'post',
        url: 'LoginController',
        data: {btnLogin: btn, Email: Email, Pass: Pass},
        success: function (data) {
            if (data === "unsuccess") {
                $('#loginAlert').show();
            }
            else {
                location.href = "index.jsp";
            }
        }
    });
});

//Register User aanmaken
$("#frmRegist").submit(function (e) {
    e.preventDefault();

    var data = $("#frmRegist").serialize();
    var finaldata = data + "&btnRegister=btnRegister";

    $.ajax({
        type: 'post',
        url: $("#frmRegist").attr("action"),
        data: finaldata,
        success: function (result) {
            if (result === "unsuccess") {
                $('#RegisterAlert').show();
            }
            else {
                $('#Modal_Register').find('.modal-body').html(result);
                $('#Modal_Register').modal({
                    backdrop: 'static',
                    keyboard: false,
                    show: true
                });
            }
        }
    });
    return false;
});

//Register user info bijvullen
$("#frmRegister").submit(function (e) {
    e.preventDefault();

    var data = $("#frmRegister").serialize();
    var finaldata = data + "&btnRegisterAddInfo=btnRegisterAddInfo";

    $.ajax({
        type: 'post',
        url: $("#frmRegister").attr("action"),
        data: finaldata,
        success: function (result) {
            if (result === "unsuccess") {
                $('#RegisterAlert').show();
            }
            else {
                $('#RegisterAlertSuccess').show();
                setTimeout(function () {
                    location.href = "Login.jsp";
                }, 3000);
            }
        }
    });
    return false;
});

