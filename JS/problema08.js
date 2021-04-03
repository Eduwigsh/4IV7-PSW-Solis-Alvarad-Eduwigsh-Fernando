function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function calcular(){
    var numero1 = document.formulario.numero1.value;
    var numero2 = document.formulario.numero2.value;
    var numero3 = document.formulario.numero3.value;
    var numeroGrande
    
    
    if (numero1 > numero2) {
        if (numero1 > numero3) {
            numeroGrande = numero1;
        }
        else{
            var num_3 = numero3;
        }
   
    } else {
        if (numero2 > numero3) {
            numeroGrande = numero2;
        } else {
            numeroGrande = numero3;
        }
    }

    document.formulario.numeroGrande.value = numeroGrande;
}

function borrar(){
    document.formulario.numero1.value = " ";
    document.formulario.numero2.value = " ";
    document.formulario.numero3.value = " ";
    document.formulario.numeroGrande.value = " ";
}