const botaoCadastro = document.querySelector('#btnCadastro');
const botaoCancelar = document.querySelector('#cancelar');
const botaoEnviar = document.querySelector('#enviar');
var dialogoCadastro = document.querySelector('#cadastro');
const form = document.querySelector('#usuarioForm');
botaoCadastro.addEventListener('click', function() {
dialogoCadastro.showModal();
})
botaoCancelar.addEventListener('click', function() {
    dialogoCadastro.close();
})

botaoEnviar.addEventListener('click', msg);
form.addEventListener('submit', event =>{
event.preventDefault();

const formData = new FormData(form);
const data = Object.fromEntries(formData);

fetch("http://localhost:8080/usuarios", {
    method: 'POST',
    headers: {
        'Content-Type':'application/json',
    },
    body: JSON.stringify(data)

}).then(res => res.json)
.then(data => console.log(data))
.catch(error => console.log(error))
})

function msg() {
    alert("Usuário salvo com sucesso!");
    //window.location.reload(true);
}