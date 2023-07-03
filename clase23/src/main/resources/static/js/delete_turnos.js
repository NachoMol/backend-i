document.getElementById("eliminar-turno-form").addEventListener("submit", function(event) {
    event.preventDefault();
    const turnoId = document.getElementById("turno-id").value;

    fetch(`/turnos/${turnoId}`, {
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
    });
});