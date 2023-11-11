const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});

const contraseña = document.getElementById('contraseña');
const repetirContraseña = document.getElementById('repetirContraseña');

function validarContraseña() {
    if (contraseña.value != repetirContraseña.value) {
        repetirContraseña.setCustomValidity('Las contraseñas no coinciden');
    } else {
        repetirContraseña.setCustomValidity('');
    }
}