function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function sacarPorcentaje(){
    var hombres= document.formulario.hombre.value;
    var mujeres  = document.formulario.mujer.value;
    var total = parseInt(hombres)+parseInt(mujeres)
    var porsentajeHombre=  (hombres/total)*100
    var porsentajeMujer=   (mujeres/total)*100
    
    document.formulario.porsentajeHombre.value = porsentajeHombre + "%";
    document.formulario.porsentajeMujer.value =porsentajeMujer+ "%";
}

function borrar(){
    document.formulario.porsentajeHombre.value = " ";
    document.formulario.porsentajeMujer.value = " ";
    document.formulario.hombre.value = " ";
    document.formulario.mujer.value = " ";
}