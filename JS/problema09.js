function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function Horas(){
    var Horas_T = document.formulario.Horas_T.value;
    document.formulario.Horas_E_D.value = 0;
    document.formulario.Horas_E_T.value =0;
    if (Horas_T>40){
    var Horas_E_D = Horas_T-40;
    document.formulario.Horas_E_D.value = Horas_E_D;
    if(Horas_T>48){
        document.formulario.Horas_E_D.value = 48;
    }
    }
    if (Horas_E_D>8){
    var Horas_E_T = Horas_E_D-8;
    document.formulario.Horas_E_T.value =Horas_E_T;
    }
}

function borrar(){
    document.formulario.Horas_T.value = " ";
    document.formulario.Horas_E_D.value = " ";
    document.formulario.Horas_E_T.value = " ";
}