document.getElementById("eliminar-odontologo-form").addEventListener("submit", function(event) {
    event.preventDefault();
    const odontologoId = document.getElementById("odontologo-id").value;

    fetch(`/odontologos/${odontologoId}`, {
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
        document.getElementById("mensaje").innerHTML = "<p>Ocurrió un error al eliminar el odontólogo. Por favor, inténtalo de nuevo más tarde.</p>";
    });
});