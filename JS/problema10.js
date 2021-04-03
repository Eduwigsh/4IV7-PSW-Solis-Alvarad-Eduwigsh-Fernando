function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function dinero(){
    var pago = document.formulario.paga.value;
    var comision  = (pago*.10)*3;
    var ganacia = parseFloat(pago)+parseFloat(comision);

    document.formulario.comisiones.value = "$ "+comision;
    document.formulario.ganancia.value ="$ "+ ganacia;
}

function borrar(){
    document.formulario.paga.value = " ";
    document.formulario.ganancia.value = " ";
    document.formulario.comisiones.value = " ";
}