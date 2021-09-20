/*  Función que ordena la tabla según los puntos de cada equipo */
function tableOrder (reverse = false) {
    // Obtenemos elementos
    let blockResult = document.getElementById('result');
    let elements = blockResult.getElementsByTagName('tr');

    // Transformamos elementos
    elements = Array.from(elements);    // Transformamos el HTMLCollection en un array
    elements.sort(compareAlphabetic);   // Ordenamos nuestros elementos
    blockResult.innerHTML = '';

    // Si llamamos con tableOrder('reverse') invertimos el orden
    if (reverse === 'reverse') {
        elements.reverse();
    }
    
    // Construimos nuevos elementos
    elements.map((element, index) => {
        let tr = document.createElement('tr');
        let pos = document.createElement('td');
        let name = document.createElement('td');
        let points = document.createElement('td');

        // Asignamos las clases
        pos.className = 'team-pos';
        name.className = 'team-name';
        points.className = 'team-points';

        // A los elementos creados le asignamos el valor que corresponde
        pos.innerText = (index + 1) + 'º';
        name.innerText = element.getElementsByClassName('team-name')[0].innerText;
        points.innerText = element.getElementsByClassName('team-points')[0].innerText;

        // Añadimos los elementos dentro de sus padres correspondientes
        // result > tr > td
        tr.appendChild(pos);
        tr.appendChild(name);
        tr.appendChild(points);
        blockResult.appendChild(tr);
    });
}

/*  Función que añade una nueva fila a la tabla, solicitando al usuario los valores.
*   Tras añadir la nueva entrada vuelve a ordenar la clasificación teniendo en cuenta el nuevo equipo
*/
function insertTeam () {
    // Pedimos valores al usuario
    let newName = prompt('Nombre del equipo');
    let newPoints = prompt('Puntos del equipo');

    // Obtenemos elementos
    let blockResult = document.getElementById('result');

    // Creamos elemento
    let tr = document.createElement('tr');
    let pos = document.createElement('td');
    let name = document.createElement('td');
    let points = document.createElement('td');

    // Asignamos las clases
    pos.className = 'team-pos';
    name.className = 'team-name';
    points.className = 'team-points';

    // A los elementos creados le asignamos el valor que corresponde
    pos.innerText = '';
    name.innerText = newName;
    points.innerText = newPoints;

    // Añadimos los elementos dentro de sus padres correspondientes
    // result > tr > td
    tr.appendChild(pos);
    tr.appendChild(name);
    tr.appendChild(points);
    blockResult.appendChild(tr);

    // Tras añadir el nuevo elemento volvemos a "Ordenar clasificación"
    tableOrder();
}


/********************************************************************** */

/* Funciones auxiliares */
function compareAlphabetic (a, b) {
    // Cogemos los puntos
    // <td class="team-points">XX</td>
    a = a.getElementsByClassName('team-points')[0];
    b = b.getElementsByClassName('team-points')[0];

    if (a.innerText < b.innerText) {
        return 1
    }
    if (a.innerText > b.innerText) {
        return -1
    }
    return 0
}