// Selecció dels elements
const llista = document.getElementById('llista');
const addBtn = document.getElementById('add-btn');
const removeBtn = document.getElementById('remove-btn');
const comptador = document.getElementById('comptador');

// Funció per actualitzar el comptador
function actualitzaComptador() {
    comptador.textContent = llista.children.length;
}

// Funció per afegir un element a la llista
addBtn.addEventListener('click', () => {
    const nouElement = document.createElement('li');
    nouElement.textContent = `Element ${llista.children.length + 1}`;
    llista.appendChild(nouElement);
    actualitzaComptador();
});

// Funció per eliminar l'últim element de la llista
removeBtn.addEventListener('click', () => {
    if (llista.lastChild) {
        llista.removeChild(llista.lastChild);
        actualitzaComptador();
    }
});

// Actualitza el comptador inicial
actualitzaComptador();
