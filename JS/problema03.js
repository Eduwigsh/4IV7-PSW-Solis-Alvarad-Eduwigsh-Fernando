function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function dinero(){
    var pago = document.formulario.pago.value;
    var descuento  = pago - pago*.15;


    document.formulario.descuento.value = "$ "+descuento;
  
}

function borrar(){
    document.formulario.pago.value = " ";
    document.formulario.descuento.value = " ";
}