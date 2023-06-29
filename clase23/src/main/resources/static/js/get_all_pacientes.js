window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de pacientes con el método GET
      //nos devolverá un JSON con una colección de pacientes
      const url = '/pacientes';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de pacientes del JSON
         for(paciente of data){
            //por cada paciente armaremos una fila de la tabla
            var table = document.getElementById("pacientesTable");
            var pacienteRow =table.insertRow();
            let tr_id = 'tr_' + paciente.id;
            pacienteRow.id = tr_id;

            pacienteRow.innerHTML =
                    //'<td>' + updateButton + '</td>' +
                    '<td class=\"td_id\">' + paciente.id + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.documento.toUpperCase() + '</td>'+
                    '<td class=\"td_nombre\">' + paciente.fechaIngreso.toUpperCase() + '</td>'+
                    '<td class=\"td_nombre\">' + paciente.domicilio.id.toUpperCase() + '</td>'+
                    '<td class=\"td_nombre\">' + paciente.email.toUpperCase() + '</td>'
                    //+'<td>' + deleteButton + '</td>';

        };

    })
    })


    })