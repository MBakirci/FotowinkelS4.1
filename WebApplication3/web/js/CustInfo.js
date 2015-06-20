/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Omdat het lang kan duren en mensen niet het gevoel te geven dat de pagina het niet doet een loading screen.
this.$('.js-loading-bar').modal({
    backdrop: 'static',
    show: false
});

$('a.edit').click(function () {
    var $modal = $('.js-loading-bar'),
            $bar = $modal.find('.progress-bar');
    $modal.modal('show');
    $bar.addClass('animate');
    setTimeout(function () {
        $bar.removeClass('animate');
        $modal.modal('hide');
    }, 1400);
});

$('#btnSave').click(function () {
    var btn = $('#btnSave').val();
    var fname = $('#Voornaam').val();
    var tname = $('#Tussenvoegsel').val();
    var lname = $('#Achternaam').val();
    var street = $('#Straat').val();
    var housenumber = $('#Huisnr').val();
    var zipcode = $('#Postcode').val();
    var city = $('#Stad').val();
    var telnr = $('#Telefoon').val();

    $.ajax({
        url: 'UserController',
        data: {btnSave: btn, fname: fname, tname: tname, lname: lname,
            street: street, housenumber: housenumber, zipcode: zipcode, city: city,
            telnr: telnr},
        type: 'post',
        success: function (data) {
            $('#CustDetails').append('<div class="alert alert-success" role="alert">Uw wijzigingen zijn doorgevoerd!</div>');
            setTimeout(function () {
                window.location.reload(1);
            }, 3000);
        }
    });
    return false;
});
$('#btnActive').click(function () {
    var btn = $('#btnActive').val();
    var eMail = $('#Email').val();

    $.ajax({
        url: 'UserController',
        data: {btnActive: btn, eMail: eMail},
        type: 'post',
        success: function (data) {
            $('#CustDetails').append('<div class="alert alert-success" role="alert">Uw wijzigingen zijn doorgevoerd!</div>');
            setTimeout(function () {
                window.location.reload(1);
            }, 3000);
        }
    });
    return false;
});

$('#btnDisable').click(function () {
    var btn = $('#btnDisable').val();
    var eMail = $('#Email').val();

    $.ajax({
        url: 'UserController',
        data: {btnDisable: btn, eMail: eMail},
        type: 'post',
        success: function (data) {
            $('#CustDetails').append('<div class="alert alert-success" role="alert">Uw wijzigingen zijn doorgevoerd!</div>');
            setTimeout(function () {
                window.location.reload(1);
            }, 3000);
        }
    });
    return false;
});

//Ajax request en backend interactie
$('a.edit').click(function (e) {
    e.preventDefault();
    var td_email = $(this).closest('tr').find('#td_email').html();
    $.ajax({
        url: 'UserController',
        data: {
            eMail: td_email
        }
        ,
        type: 'get',
        success: function (data) {
            $('#Modal_currUser').find('.modal-body').html(data);
            $('#Modal_currUser').modal({
                show: true
            });
        }
    });
    return false;
});

//onze Searchbox
var options = {
    valueNames: ['email', 'name', 'activated']
};

var userList = new List('payload', options);
