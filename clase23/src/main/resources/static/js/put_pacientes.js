document.getElementById("modificar-odontologo-form").addEventListener("submit", function(event) {
    event.preventDefault();

    const pacienteData = {
        id: document.querySelector('paciente-id').value,
        nombre: document.querySelector('#paciente-nombre').value,
        apellido: document.querySelector('#paciente-apellido').value,
        documento: document.querySelector('#paciente-documento').value,
        fechaIngreso: document.querySelector('#paciente-fechaIngreso').value,
        domicilio:{
            calle: document.querySelector('#paciente-calleDomicilio').value,
            numero: document.querySelector('#paciente-numeroDomicilio').value,
            localidad: document.querySelector('#paciente-localidadDomicilio').value,
            provincia: document.querySelector('#paciente-provinciaDomicilio').value
        },
    };

    fetch(`/pacientes`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pacienteData)
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error("Error en la solicitud: " + response.status);
        }
    })
    .then(data => {
        document.getElementById("mensaje").innerHTML = "<p>" + data + "</p>";
    })
    .catch(error => {
        console.error("Error en la solicitud:", error);
        document.getElementById("mensaje").innerHTML = "<p>Ocurrió un error al modificar el paciente. Por favor, inténtalo de nuevo más tarde.</p>";
    });
});