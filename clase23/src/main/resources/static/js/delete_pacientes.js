document.getElementById("eliminar-paciente-form").addEventListener("submit", function(event) {
    event.preventDefault();
    const pacienteId = document.getElementById("paciente-id").value;

    fetch(`/pacientes/${pacienteId}`, {
        method: "DELETE"
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
        document.getElementById("mensaje").innerHTML = "<p>Ocurrió un error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.</p>";
    });
});