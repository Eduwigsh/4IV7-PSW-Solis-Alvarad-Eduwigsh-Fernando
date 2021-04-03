function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function calculo(){
    var numero1 = document.formulario.numero1.value;
    var numero2 = document.formulario.numero2.value;
    var total 
    if (numero1==numero2)
    total= numero1*numero2
    if (numero1>numero2)
    total= parseFloat(numero1)-parseFloat(numero2)
    else
    total= parseFloat(numero1)+parseFloat(numero2)

    document.formulario.resultodo.value= total;
}

function borrar(){
    document.formulario.resultodo.value = " ";
    document.formulario.numero1.value = " ";
    document.formulario.numero2.value = " ";
}