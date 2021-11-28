function buscarTrabajosPorNombreTrabajo(){
    console.log("txt_buscar: ejecutando...");
    var listaTrabajos = document.getElementById("datos");
    var nombreTrabajoBuscar = document.getElementById("txtbuscar").value.toLowerCase();
    console.log("(txt_buscar: Nombre trabajo: "+nombreTrabajoBuscar);
    //var cboTipoTrabajo = document.getElementById("cboTipoTrabajo");
    /*var opcionSeleccionadaTipoTrabajo = cboTipoTrabajo.options[cboTipoTrabajo.selectedIndex].text.toLowerCase();
    console.log("Tipo trabajo: "+opcionSeleccionadaTipoTrabajo);
    var cboEmpresa = document.getElementById("cboEmpresa");
    var opcionSeleccionadaEmpresa = cboEmpresa.options[cboEmpresa.selectedIndex].text.toLowerCase();
    console.log("Nombre empresa: "+opcionSeleccionadaEmpresa);*/
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararConNombreTrabajo = "";
   /* var compararConTipoTrabajo = "";
    var compararConNombreEmpresa = "";*/
    buscarTrabajosPorTipo1();
    buscarNombreEmpresa1();
    console.log("num trabajos: "+listaTrabajos.getElementsByTagName("form").length);
    for(var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++){
        itemListaTrabajosBuscar = document.getElementById("trabajo"+i);
        compararConNombreTrabajo = document.getElementById("nomTrabajo"+i).innerHTML.toLowerCase();
        /*compararConTipoTrabajo = document.getElementById("tipoTrabajo" + i).innerHTML.toLowerCase();
        compararConNombreEmpresa = document.getElementById("nomEmpresa" + i).innerHTML.toLowerCase();*/
        console.log(compararConNombreTrabajo);
        encontrado = false;
        console.log("txt_buscar: display = "+itemListaTrabajosBuscar.getAttribute("display"));
        if(nombreTrabajoBuscar.length === 0){
            itemListaTrabajosBuscar.setAttribute("display","");
        }else{
            if (itemListaTrabajosBuscar.getAttribute("display") === "" || itemListaTrabajosBuscar.getAttribute("display") === null) {
                if (compararConNombreTrabajo.indexOf(nombreTrabajoBuscar) > -1) {
                    encontrado = true;
                    console.log("se cambio el estado a true");
                }
                if (encontrado) {
                    itemListaTrabajosBuscar.setAttribute("display", "");
                    itemListaTrabajosBuscar.style.display = "";
                    console.log("Se muestra el " + compararConNombreTrabajo);
                } else {
                    itemListaTrabajosBuscar.setAttribute("display", "none");
                    itemListaTrabajosBuscar.style.display = "none";
                    console.log("No se muestra el " + compararConNombreTrabajo);
                }
            }
        }
    }
}

function buscarTrabajosPorTipo(){
    console.log("cboTipoTrabajo: Me ejecute");
    var listaTrabajos = document.getElementById("datos");
    var cboTipoTrabajo = document.getElementById("cboTipoTrabajo");
    //var txtBuscar = document.getElementById("txtbuscar");
    var opcionSeleccionada = cboTipoTrabajo.options[cboTipoTrabajo.selectedIndex].text.toLowerCase();
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararCon = "";
    buscarTrabajosPorNombreTrabajo1();
    buscarNombreEmpresa1();
    console.log("cboTipoTrabajo: Num trabajos: " + listaTrabajos.getElementsByTagName("form").length);
    for (var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++) {
        itemListaTrabajosBuscar = document.getElementById("trabajo" + i);
        console.log("cboTipoTrabajo: Opción seleccionada: "+opcionSeleccionada);
        encontrado = false;
        compararCon = document.getElementById("tipoTrabajo" + i).innerHTML.toLowerCase();
        console.log("cboTipoTrabajo: trabajo"+i+"su tipo de trabajo es: "+compararCon);
        if (opcionSeleccionada === "todos") {
            itemListaTrabajosBuscar.setAttribute("display", "");
        } else {
            if (itemListaTrabajosBuscar.getAttribute("display") === "" || itemListaTrabajosBuscar.getAttribute("display") === null) {
                if (compararCon.indexOf(opcionSeleccionada) > -1) {
                    encontrado = true;
                    console.log("cboTipoTrabajo: se cambio el estado a true");
                }
                if (encontrado) {
                    itemListaTrabajosBuscar.setAttribute("display", "");
                    itemListaTrabajosBuscar.style.display = "";
                    console.log("cboTipoTrabajo: Se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                } else {
                    itemListaTrabajosBuscar.setAttribute("display", "none");
                    itemListaTrabajosBuscar.style.display = "none";
                    console.log("cboTipoTrabajo: No se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                }
            }
        }
    }
}

function buscarNombreEmpresa(){
    console.log("cboNombreEmpresa: Me ejecute");
    var listaTrabajos = document.getElementById("datos");
    var cboEmpresa = document.getElementById("cboEmpresa");
    //var txtBuscar = document.getElementById("txtbuscar");
    var opcionSeleccionada = cboEmpresa.options[cboEmpresa.selectedIndex].text.toLowerCase();
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararCon = "";
    buscarTrabajosPorNombreTrabajo1();
    buscarTrabajosPorTipo1();
    console.log("cboTipoTrabajo: Num trabajos: " + listaTrabajos.getElementsByTagName("form").length);
    for (var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++) {
        itemListaTrabajosBuscar = document.getElementById("trabajo" + i);
        console.log("cboTipoTrabajo: Opción seleccionada: "+opcionSeleccionada);
        encontrado = false;
        compararCon = document.getElementById("nomEmpresa" + i).innerHTML.toLowerCase();
        console.log("cboTipoTrabajo: trabajo"+i+"su tipo de trabajo es: "+compararCon);
        if(opcionSeleccionada === "todas"){
            itemListaTrabajosBuscar.setAttribute("display", "");
        }else{
            if (itemListaTrabajosBuscar.getAttribute("display") === "" || itemListaTrabajosBuscar.getAttribute("display") === null) {
                if (compararCon.indexOf(opcionSeleccionada) > -1) {
                    encontrado = true;
                    console.log("cboTipoTrabajo: se cambio el estado a true");
                }
                if (encontrado) {
                    itemListaTrabajosBuscar.setAttribute("display", "");
                    itemListaTrabajosBuscar.style.display = "";
                    console.log("cboTipoTrabajo: Se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                } else {
                    itemListaTrabajosBuscar.setAttribute("display", "none");
                    itemListaTrabajosBuscar.style.display = "none";
                    console.log("cboTipoTrabajo: No se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                }
            }
        }
    }
}

function buscarTrabajosPorNombreTrabajo1(){
    console.log("txt_buscar: ejecutando...");
    var listaTrabajos = document.getElementById("datos");
    var nombreTrabajoBuscar = document.getElementById("txtbuscar").value.toLowerCase();
    console.log("(txt_buscar: Nombre trabajo: "+nombreTrabajoBuscar);
    //var cboTipoTrabajo = document.getElementById("cboTipoTrabajo");
    /*var opcionSeleccionadaTipoTrabajo = cboTipoTrabajo.options[cboTipoTrabajo.selectedIndex].text.toLowerCase();
    console.log("Tipo trabajo: "+opcionSeleccionadaTipoTrabajo);
    var cboEmpresa = document.getElementById("cboEmpresa");
    var opcionSeleccionadaEmpresa = cboEmpresa.options[cboEmpresa.selectedIndex].text.toLowerCase();
    console.log("Nombre empresa: "+opcionSeleccionadaEmpresa);*/
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararConNombreTrabajo = "";
   /* var compararConTipoTrabajo = "";
    var compararConNombreEmpresa = "";*/
    //buscarTrabajosPorTipo1();
    //buscarNombreEmpresa1();
    console.log("num trabajos: "+listaTrabajos.getElementsByTagName("form").length);
    for(var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++){
        itemListaTrabajosBuscar = document.getElementById("trabajo"+i);
        compararConNombreTrabajo = document.getElementById("nomTrabajo"+i).innerHTML.toLowerCase();
        /*compararConTipoTrabajo = document.getElementById("tipoTrabajo" + i).innerHTML.toLowerCase();
        compararConNombreEmpresa = document.getElementById("nomEmpresa" + i).innerHTML.toLowerCase();*/
        console.log(compararConNombreTrabajo);
        encontrado = false;
        console.log("txt_buscar: display = "+itemListaTrabajosBuscar.getAttribute("display"));
        if(nombreTrabajoBuscar.length === 0){
            itemListaTrabajosBuscar.setAttribute("display","");
        }else{
            if (itemListaTrabajosBuscar.getAttribute("display") === "" || itemListaTrabajosBuscar.getAttribute("display") === null) {
                if (nombreTrabajoBuscar.length === 0 || compararConNombreTrabajo.indexOf(nombreTrabajoBuscar) > -1) {
                    encontrado = true;
                    console.log("se cambio el estado a true");
                }
                if (encontrado) {
                    itemListaTrabajosBuscar.setAttribute("display", "");
                    itemListaTrabajosBuscar.style.display = "";
                    console.log("Se muestra el " + compararConNombreTrabajo);
                } else {
                    itemListaTrabajosBuscar.setAttribute("display", "none");
                    itemListaTrabajosBuscar.style.display = "none";
                    console.log("No se muestra el " + compararConNombreTrabajo);
                }
            }
        }
    }
}

function buscarTrabajosPorTipo1(){
    console.log("cboTipoTrabajo: Me ejecute");
    var listaTrabajos = document.getElementById("datos");
    var cboTipoTrabajo = document.getElementById("cboTipoTrabajo");
    //var txtBuscar = document.getElementById("txtbuscar");
    var opcionSeleccionada = cboTipoTrabajo.options[cboTipoTrabajo.selectedIndex].text.toLowerCase();
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararCon = "";
    //buscarTrabajosPorNombreTrabajo1();
    //buscarNombreEmpresa1();
    console.log("cboTipoTrabajo: Num trabajos: " + listaTrabajos.getElementsByTagName("form").length);
    for (var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++) {
        itemListaTrabajosBuscar = document.getElementById("trabajo" + i);
        console.log("cboTipoTrabajo: Opción seleccionada: "+opcionSeleccionada);
        encontrado = false;
        compararCon = document.getElementById("tipoTrabajo" + i).innerHTML.toLowerCase();
        console.log("cboTipoTrabajo: trabajo"+i+"su tipo de trabajo es: "+compararCon);
        if (opcionSeleccionada === "todos") {
            itemListaTrabajosBuscar.setAttribute("display", "");
        } else {
            if (itemListaTrabajosBuscar.getAttribute("display") === "" || itemListaTrabajosBuscar.getAttribute("display") === null) {
                if (compararCon.indexOf(opcionSeleccionada) > -1) {
                    encontrado = true;
                    console.log("cboTipoTrabajo: se cambio el estado a true");
                }
                if (encontrado) {
                    itemListaTrabajosBuscar.setAttribute("display", "");
                    itemListaTrabajosBuscar.style.display = "";
                    console.log("cboTipoTrabajo: Se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                } else {
                    itemListaTrabajosBuscar.setAttribute("display", "none");
                    itemListaTrabajosBuscar.style.display = "none";
                    console.log("cboTipoTrabajo: No se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                }
            }
        }
    }
}

function buscarNombreEmpresa1(){
    console.log("cboNombreEmpresa: Me ejecute");
    var listaTrabajos = document.getElementById("datos");
    var cboEmpresa = document.getElementById("cboEmpresa");
    //var txtBuscar = document.getElementById("txtbuscar");
    var opcionSeleccionada = cboEmpresa.options[cboEmpresa.selectedIndex].text.toLowerCase();
    var itemListaTrabajosBuscar = "";
    var encontrado = false;
    var compararCon = "";
    //buscarTrabajosPorNombreTrabajo1();
    //buscarTrabajosPorTipo1();
    console.log("cboTipoTrabajo: Num trabajos: " + listaTrabajos.getElementsByTagName("form").length);
    for (var i = 1; i <= listaTrabajos.getElementsByTagName("form").length; i++) {
        itemListaTrabajosBuscar = document.getElementById("trabajo" + i);
        console.log("cboTipoTrabajo: Opción seleccionada: "+opcionSeleccionada);
        encontrado = false;
        compararCon = document.getElementById("nomEmpresa" + i).innerHTML.toLowerCase();
        console.log("cboTipoTrabajo: trabajo"+i+"su tipo de trabajo es: "+compararCon);
        if(opcionSeleccionada === "todas"){
            itemListaTrabajosBuscar.setAttribute("display", "");
        }else{
            if (itemListaTrabajosBuscar.getAttribute("display") === "" || itemListaTrabajosBuscar.getAttribute("display") === null) {
                if (compararCon.indexOf(opcionSeleccionada) > -1) {
                    encontrado = true;
                    console.log("cboTipoTrabajo: se cambio el estado a true");
                }
                if (encontrado) {
                    itemListaTrabajosBuscar.setAttribute("display", "");
                    itemListaTrabajosBuscar.style.display = "";
                    console.log("cboTipoTrabajo: Se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                } else {
                    itemListaTrabajosBuscar.setAttribute("display", "none");
                    itemListaTrabajosBuscar.style.display = "none";
                    console.log("cboTipoTrabajo: No se muestra el trabajo" + i);
                    console.log("cboTipoTrabajo: display = " + itemListaTrabajosBuscar.getAttribute("display"));
                }
            }
        }
    }
}




