function buscarTrabajosPorNombreTrabajo(){
    
    var listaTrabajos = document.getElementById("datos");
    var nombreTrabajoBuscar = document.getElementById("txtbuscar").value.toLowerCase();
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararCon = "";
    
    for(var i = 1; i < listaTrabajos.getElementsByTagName("*").length; i++){
        itemListaTrabajosBuscar = document.getElementById("trabajo"+i);
        compararCon = document.getElementById("nomTrabajo"+i).value.toLowerCase();
        encontrado = false;
        if(nombreTrabajoBuscar.length == 0 || (compararCon.indexOf(nombreTrabajoBuscar)) > -1){
            encontrado = true;
        }
        if(encontrado){
            itemListaTrabajosBuscar.style.display = "";
        }else{
            itemListaTrabajosBuscar.style.display = "none";
        }
    }
}


