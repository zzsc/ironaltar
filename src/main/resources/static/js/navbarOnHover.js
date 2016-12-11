
    $( document ).ready(function() {

    $( 'ul.nav li.dropdown' ).hover(function() {
        // you could also use this condition: $( window ).width() >= 768
        if ($('.navbar-toggle').css('display') === 'none' 
            && false === ('ontouchstart' in document)) {

            $( '.dropdown-toggle', this ).trigger( 'click' );
        }
    }, function() {
        if ($('.navbar-toggle').css('display') === 'none'
            && false === ('ontouchstart' in document)) {

            $( '.dropdown-toggle', this ).trigger( 'click' );
        }
    });

});
