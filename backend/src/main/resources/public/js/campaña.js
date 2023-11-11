document.getElementById('miBoton').addEventListener('click', function() {
    console.log("hola");
    Swal.fire({
        title: '¡Atención!',
        text: 'Debes loguearte para crear una nueva campaña',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Quiero Loguearme'
    }).then((result) => {
        if (result.isConfirmed) {
            // Redirige al usuario a la URL deseada
            window.location.href = '/login';
        }
    });
});