document.getElementById("modificar-odontologo-form").addEventListener("submit", function(event) {
    event.preventDefault();
    const odontologoId = document.getElementById("odontologo-id").value;
    const nuevoNombre = document.getElementById("odontologo-nombre").value;
    const nuevoApellido = document.getElementById("odontologo-apellido").value;
    const nuevaMatricula = document.getElementById("odontologo-matricula").value;

    const odontologoData = {
        id: odontologoId,
        nombre: nuevoNombre,
        apellido: nuevoApellido,
        matricula: nuevaMatricula
    };

    fetch(`/odontologos`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(odontologoData)
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
        document.getElementById("mensaje").innerHTML = "<p>Ocurrió un error al modificar el odontólogo. Por favor, inténtalo de nuevo más tarde.</p>";
    });
});