document.getElementById('creditForm').addEventListener('submit', function (e) {
    e.preventDefault();

    // Obtener los valores del formulario
    const nombre = document.getElementById('nombre').value;
    const monto = document.getElementById('monto').value;

    // Crear el objeto JSON para enviar al backend
    const solicitud = {
        cliente: { nombre: nombre },
        monto: parseFloat(monto)
    };

    // Enviar la solicitud al backend
    fetch('http://localhost:8080/api/credit/submit', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(solicitud)
    })
    .then(response => response.json())
    .then(data => {
        // Mostrar el resultado en la página
        const resultadoDiv = document.getElementById('resultado');
        resultadoDiv.innerHTML = `Resultado: ${data.estadoAprobacion}`;

        // Cambiar el estilo del resultado basado en la aprobación/rechazo
        if (data.estadoAprobacion === 'APROBADO') {
            resultadoDiv.classList.add('aprobado');
            resultadoDiv.classList.remove('rechazado');
        } else {
            resultadoDiv.classList.add('rechazado');
            resultadoDiv.classList.remove('aprobado');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('resultado').innerHTML = 'Ocurrió un error. Inténtalo de nuevo.';
    });
});
