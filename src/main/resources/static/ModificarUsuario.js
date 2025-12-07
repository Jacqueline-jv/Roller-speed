function SeleccionarUsuario(idUsuario){

    var table = document.getElementById("tablaUsuarios");

    for (var i = 1, row; row = table.rows.length; i++) {

        table.rows[i].onclick = function(){

            document.getElementById("idActualizar").value = this.cells[0].innerHTML;
            document.getElementById("nombreActualizar").value = this.cells[1].innerHTML;
            document.getElementById("apellidoActualizar").value = this.cells[2].innerHTML;
            document.getElementById("telefonoActualizar").value = this.cells[3].innerHTML;
            document.getElementById("emailActualizar").value = this.cells[4].innerHTML;
        };
    }
}