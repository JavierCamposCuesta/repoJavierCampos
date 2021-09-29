document.getElementById("ordenar").addEventListener("click", functionOrdenar);

function functionOrdenar() {
    let tabla = document.getElementById("tabla");
    let element = tabla.getElementsByTagName("td");
    let resultado = document.getElementById("resultado");

    let listaElementos = Array.from(element);
    // debugger;
    listaElementos.sort(compareAlphabetic);

    // let listaElementos = [];

    for ( let index=0; index < document.getElementsByTagName("td").length; index++){
        debugger;
        listaElementos.push(document.getElementsByTagName("td")[index].innerText);
    }

    function compareAlphabetic (a, b) {
        if (a.innerText < b.innerText) {
            return -1
        }
        if (a.innerText > b.innerText) {
            return 1
        }
        return 0
    }




    for (let index = 0; index < element.length; index++) {
        let elementoLista = document.createElement("li");
        elementoLista.innerHTML = element[index];
        resultado.appendChild(elementoLista);
        
    }
}