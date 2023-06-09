window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = {
            fecha: document.querySelector('#fecha').value,
            paciente: {
                id: parseInt(document.querySelector('#pacienteId').value),
                nombre: null,
                apellido: null,
                documento: null,
                fechaIngreso: null,
                domicilio: {
                    id: parseInt(document.querySelector('#pacienteId').value),
                    calle: null,
                    numero: null,
                    localidad: null,
                    provincia: null
                },
                email: null
            },
            odontologo: {
                id: parseInt(document.querySelector('#odontologoId').value),
                nombre: null,
                apellido: null,
                matricula: null
            }
        };

        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Turno agregado </div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            });
    });

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first-child").classList.add("active");
        } else if (pathname == "/peliculaList.html") {
            document.querySelector(".nav .nav-item a:last-child").classList.add("active");
        }
    })();
});