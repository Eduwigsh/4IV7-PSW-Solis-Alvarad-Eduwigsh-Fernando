function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}
function validars(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = "si" + "no"

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}


function año(){
    var añoN = document.formulario.año_nacimiento.value;
    var añoA  = document.formulario.año_actual.value;
    var cumpleaños=document.formulario.cumpleaños.value;
    var edad
     if (cumpleaños=="si")
         edad= parseFloat(añoA)-parseFloat(añoN)+1
     
     if (cumpleaños=="no")
         edad= parseFloat(añoA)-parseFloat(añoN)
     
    document.formulario.edad.value = edad;
 
}

function borrar(){
    document.formulario.año_nacimiento.value= " ";
    document.formulario.año_actual.value= " ";
    document.formulario.cumpleaños.value = " ";
    document.formulario.edad.value ="";
}