window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de turnos con el método GET
      //nos devolverá un JSON con una colección de turnos
      const url = '/turnos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de turnos del JSON
         for(turno of data){
            //por cada turno armaremos una fila de la tabla
            var table = document.getElementById("turnosTable");
            var turnoRow =table.insertRow();
            let tr_id = 'tr_' + turno.id;
            turnoRow.id = tr_id;

            turnoRow.innerHTML =
                    //'<td>' + updateButton + '</td>' +
                    '<td class=\"td_id\">' + turno.id + '</td>' +
                    '<td class=\"td_nombre\">' + turno.fecha.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + (turno.paciente.id ? turno.paciente.id : '') + '</td>' +
                    '<td class=\"td_nombre\">' + (turno.odontologo.id ? turno.odontologo.id : '') + '</td>'
                    //+'<td>' + deleteButton + '</td>';
        };

    })
    })

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/index.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
      })

    })