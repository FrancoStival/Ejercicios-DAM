// Guardado de elementos en constantes
const button1 = document.getElementById('button1');
const button2 = document.getElementById('button2');
const button3 = document.getElementById('button3');
const colorSelector = document.getElementById('colorSelector');
const box1 = document.querySelector('.box1');
const box3 = document.querySelector('.box3');
const allBoxes = document.querySelectorAll('.box');
const box4 = document.querySelector('.box4');

// Cambiar color de Caixa 1
button1.addEventListener('click', () => {
    box1.style.backgroundColor = 'yellow';
});

// Afegir/treure classe a totes les caixes
button2.addEventListener('click', () => {
    allBoxes.forEach(box => {
        box.classList.toggle('highlight');
    });
});

// Mostrar/ocultar Caixa 3
button3.addEventListener('click', () => {
    box3.style.display = box3.style.display === 'none' ? 'flex' : 'none';
});

// Canviar color de Caixa 4 segons el selector
colorSelector.addEventListener('change', (event) => {
    box4.style.backgroundColor = event.target.value;
});
