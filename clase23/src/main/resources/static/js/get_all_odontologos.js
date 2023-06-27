window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de odontologos con el método GET
      //nos devolverá un JSON con una colección de odontologos
      const url = '/odontologos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de odontologos del JSON
         for(odontologo of data){
            //por cada odontologo armaremos una fila de la tabla
            var table = document.getElementById("odontologosTable");
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.id;
            odontologoRow.id = tr_id;

            odontologoRow.innerHTML =
                    //'<td>' + updateButton + '</td>' +
                    '<td class=\"td_id\">' + odontologo.id + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.matricula.toUpperCase() + '</td>'
                    //+'<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/peliculaList.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })