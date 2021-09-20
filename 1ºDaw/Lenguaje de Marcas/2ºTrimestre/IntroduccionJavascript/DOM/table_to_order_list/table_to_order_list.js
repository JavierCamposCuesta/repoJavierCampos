function tableToOrderList (reverse = false) {
    // Obtenemos elementos
    let table = document.getElementById('table');
    let elements = table.getElementsByTagName('td');
    let blockResult = document.getElementById('result');

    // Transformamos elementos
    blockResult.innerHTML = '';         // Limpiamos el bloque de resultados para evitar duplicidades
    elements = Array.from(elements);    // Transformamos el HTMLCollection en un array
    elements.sort(compareAlphabetic);   // Ordenamos nuestros elementos

    if (reverse === 'reverse') {
        elements.reverse();
    }
    
    // Construimos nuevos elementos
    elements.map(element => {
        let elementList = document.createElement('li');
        elementList.innerText = element.innerText;
        blockResult.appendChild(elementList);
    });
}

/* Funciones auxiliares */
function compareAlphabetic (a, b) {
    if (a.innerText < b.innerText) {
        return -1
    }
    if (a.innerText > b.innerText) {
        return 1
    }
    return 0
}