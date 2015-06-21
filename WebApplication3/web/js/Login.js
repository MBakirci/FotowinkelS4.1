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


$("#frmRegist").submit(function (e) {
    e.preventDefault();

    var data = $("#frmRegist").serialize();
    var finaldata = data + "&btnRegister=btnRegister";

    $.ajax({
        type: 'post',
        url: $("#frmRegist").attr("action"),
        data: finaldata,
        success: function (result) {
            if (result === "success") {
                location.href = "Login.jsp";
            }
            else if (result === "unsuccess") {
                $('#RegisterAlert').show();
            }
        }
    });
    return false;
});


