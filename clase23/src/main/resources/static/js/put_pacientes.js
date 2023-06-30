document.getElementById("modificar-paciente-form").addEventListener("submit", function(event) {
    event.preventDefault();

    const pacienteData = {
        id: document.querySelector('#paciente-id').value,
        nombre: document.querySelector('#paciente-nombre').value,
        apellido: document.querySelector('#paciente-apellido').value,
        documento: document.querySelector('#paciente-documento').value,
        fechaIngreso: document.querySelector('#paciente-fechaIngreso').value,
        email: document.querySelector('#paciente-email').value
    };

    // Obtener el domicilio del paciente existente
    fetch(`/pacientes/id/${pacienteData.id}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Error en la solicitud: " + response.status);
            }
        })
        .then(existingPaciente => {
            pacienteData.domicilio = existingPaciente.domicilio; // Mantener el domicilio existente

            // Realizar la solicitud PUT con los datos actualizados
            return fetch(`/pacientes`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(pacienteData)
            });
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