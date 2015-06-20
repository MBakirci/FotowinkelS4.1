$('#btnLogin').click(function () {
    var btn = $('#btnLogin').val();
    var Email = $('#Email').val();
    var Pass = $('#Password').val();

    $.ajax({
        url: 'LoginController',
        data: {btnLogin: btn, Email: Email, Pass: Pass},
        type: 'post',
        success: function (data) {
            if (data === "unsuccess") {
                $('#loginAlert').show();
            }
            else{
                window.location.replace("index.jsp");
            }
        }
    });
});


