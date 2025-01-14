document.getElementById('afegirProducteForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nom = document.getElementById('nom').value;
    const preu = document.getElementById('preu').value;
    const quantitat = document.getElementById('quantitat').value;

    afegirProducte(nom, preu, quantitat);

    document.getElementById('afegirProducteForm').reset();
});

function afegirProducte(nom, preu, quantitat) {
    const taulaProductes = document.getElementById('taulaProductes').getElementsByTagName('tbody')[0];
    const fila = document.createElement('tr');

    fila.innerHTML = `
        <td>${nom}</td>
        <td>${preu}€</td>
        <td class="quantitat">${quantitat}</td>
        <td>
            <button onclick="afegirAlCarret(this)">Afegir al Carret</button>
            <button onclick="eliminarProducte(this)">Eliminar</button>
        </td>
    `;

    if (quantitat < 5) {
        fila.classList.add('low-stock');
    }

    taulaProductes.appendChild(fila);
}

function afegirAlCarret(button) {
    const fila = button.parentElement.parentElement;
    const nom = fila.cells[0].textContent;
    const preu = fila.cells[1].textContent;
    let quantitat = fila.cells[2].textContent;

    if (quantitat > 0) {
        fila.cells[2].textContent = --quantitat;
        if (quantitat < 5) {
            fila.classList.add('low-stock');
        }

        actualitzarCarret(nom, preu);

        if (quantitat == 0) {
            fila.classList.add('no-stock');
        }
    }
}

function eliminarProducte(button) {
    const fila = button.parentElement.parentElement;
    fila.parentElement.removeChild(fila);
}

function actualitzarCarret(nom, preu) {
    const carret = document.getElementById('carretDeCompra');
    const items = carret.getElementsByTagName('div');
    let trobat = false;

    for (let i = 0; i < items.length; i++) {
        if (items[i].textContent.includes(nom)) {
            const parts = items[i].textContent.split(' - ');
            let quantitat = parseInt(parts[1]) + 1;
            items[i].textContent = `${nom} - ${quantitat} unitats - ${preu}`;
            trobat = true;
            break;
        }
    }

    if (!trobat) {
        const item = document.createElement('div');
        item.textContent = `${nom} - 1 unitat - ${preu}`;
        carret.appendChild(item);
    }

    actualitzarTotal(preu);
}

function actualitzarTotal(preu) {
    const totalCompra = document.getElementById('totalCompra');
    let total = parseFloat(totalCompra.textContent.replace('Total: ', '').replace('€', ''));
    total += parseFloat(preu.replace('€', ''));
    totalCompra.textContent = `Total: ${total.toFixed(2)}€`;
}
