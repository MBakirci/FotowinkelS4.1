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
    }, 1500);
});

//Ajax request en backend interactie
$('a.edit').click(function (e) {
    e.preventDefault();
    var myModal = $('#Modal_currUser');

    var td_email = $(this).closest('tr').find('#td_email').html();
    $.ajax({
        url: 'UserController',
        data: {
            eMail: td_email
        }
        ,
        type: 'get',
        success: function (data) {
            var result = data;
            myModal.find('.modal-body').html(result);
            myModal.modal({
                show: true
            });
        }
    }
    );
    return false;
}
);


