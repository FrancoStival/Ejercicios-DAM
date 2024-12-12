const titol = document.getElementById("titol")
const paragraf = document.getElementById("paragraf")
const boton = document.getElementById("toggle-btn")

boton.textContent = "Amagar Text"
titol.innerHTML = "Se usar JavaScript"
paragraf.innerHTML += "<strong><br>Esto es el texto adicional</Strong>"
paragraf.style.color = "blue";

function ocultarParagraf(){
    const paragraf = document.getElementById("paragraf")
    if (paragraf.style.display === "none") {
        paragraf.style.display = "block";
        boton.textContent = "Amagar Text"
    } else {
        paragraf.style.display = "none";
        boton.textContent = "Mostrar Text"
    }
}