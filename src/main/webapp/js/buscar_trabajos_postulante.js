function buscarTrabajosPorNombreTrabajo(){
    
    var listaTrabajos = document.getElementById("datos");
    var nombreTrabajoBuscar = document.getElementById("txtbuscar").value.toLowerCase();
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararCon = "";
    console.log("num trabajos: "+listaTrabajos.getElementsByTagName("form").length);
    for(var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++){
        itemListaTrabajosBuscar = document.getElementById("trabajo"+i);
        compararCon = document.getElementById("nomTrabajo"+i).innerHTML.toLowerCase();
        console.log(compararCon);
        encontrado = false;
        if(nombreTrabajoBuscar.length == 0 || (compararCon.indexOf(nombreTrabajoBuscar)) > -1){
            encontrado = true;
            console.log("se cambio el estado a true");
        }
        if(encontrado){
            itemListaTrabajosBuscar.style.display = "";
            console.log("Se muestra el "+compararCon);
        }else{
            itemListaTrabajosBuscar.style.display = "none";
            console.log("No se muestra el "+compararCon);
        }
    }
}

function buscarTrabajosPorTipo(){
    var listaTrabajos = document.getElementById("datos");
    var cboTipoTrabajo = document.getElementById("cboTipoTrabajo");
    var opcionSeleccionada = cboTipoTrabajo.options[cboTipoTrabajo.selectedIndex].text.toLowerCase();
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararCon = "";
    console.log("num trabajos: " + listaTrabajos.getElementsByTagName("form").length);
    for (var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++) {
        itemListaTrabajosBuscar = document.getElementById("trabajo" + i);
        console.log(opcionSeleccionada);
        encontrado = false;
        compararCon = document.getElementById("tipoTrabajo" + i).innerHTML.toLowerCase();
        console.log(compararCon);
        if (opcionSeleccionada == "todos" || (compararCon.indexOf(opcionSeleccionada)) > -1) {
            encontrado = true;
            console.log("se cambio el estado a true");
        }
        if (encontrado) {
            itemListaTrabajosBuscar.style.display = "";
            console.log("Se muestra el " + compararCon);
        } else {
            itemListaTrabajosBuscar.style.display = "none";
            console.log("No se muestra el " + compararCon);
        }
    }
}


