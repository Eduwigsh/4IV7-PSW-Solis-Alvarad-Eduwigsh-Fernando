function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function calificacion(){
    var parciales = document.formulario.parciales.value;
    var examen = document.formulario.examen.value;
    var trabajo = document.formulario.trabajo.value;
    var final  = parseFloat((parciales*5.5)/10)+parseFloat((examen*3.0)/10)+parseFloat((trabajo*1.5)/10)


    document.formulario.final.value = final;
  
}

function borrar(){
    document.formulario.parciales.value = " ";
    document.formulario.examen.value = " ";
    document.formulario.trabajo.value = " ";
    document.formulario.final.value = " ";
}