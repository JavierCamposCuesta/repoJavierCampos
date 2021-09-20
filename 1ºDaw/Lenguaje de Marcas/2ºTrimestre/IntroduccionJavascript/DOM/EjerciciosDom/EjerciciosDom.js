
// Ejercicios DOM-Entrega 15-4-2020

// 1.-Introduce en el apartado de script el código necesario para extraer:
//     §El número de párrafos de la página.
//     §El texto del segundo párrafo.
//     §El número de enlaces de la página.
//     §La dirección del primer enlace.
//     §La dirección del penúltimo enlace.
//     §El número de enlaces del primer párrafo.
    
//     Para agregar texto en la página deberás introducir una etiqueta div con el id=info y 
//     añadir en ella toda la información detallada mediante:
//     Var info=document.getElementById(“info”);
//     Info.innerHTML = “Texto informativo”;
    
//     2.-Crea  una  página  web  que  tenga  un  listado  de  tipo  <ul>  con  un  <li>  de  
//     muestra.Introduce  un  botón  en  la  página  que,  cuando  lo  pulses,  te  muestre  
//     un  prompt  para  que  el usuario introduzca un texto.Una  vez  cerrado  el  prompt  
//     el  valor  se  añadirá  como  un  nuevo  <li>  a  la  lista  creada.Añade  dos  
//     botones  más  con  texto  “Borrar  primer  li”  y  “Borrar  último  li”  de  modo  
//     que  cuando pulses  el  primer  botón  borre  el  primer  elemento  de  la  lista  
//     y  cuando  pulses  el  último  borre  el último elemento de la lista.
    
//     3.-Necesitamos almacenar en un programa todos los discos de música que tenemos en casa. 
//     Ahora  que  sabemos  crear  nuestros  propios  objetos  es  el  mejor  modo  de  guardar  
//     esta información.
    
//     3.1.-Crea un objeto “disco” que almacene la siguiente información:
//         §Nombre del disco.
//         §Grupo de música o cantante.
//         §Año de publicación.
//         §Tipo de música (podrá ser “rock”, “pop”, “punk” o “indie”);
//         §Localización: almacenará un número de estantería.
//         §Prestado: almacenará un valor booleano. Por defecto será false.
        
//         Además tendrá los siguientes métodos:

//         §Un  constructor  sin  parámetros  (las  4  primeras  propiedades  serán  cadenas  vacías,  la localización será 0 por defecto y prestado estará a false).
//         §Un  constructor  con  parámetros  (se  pasarán  sololas  cinco  primeras  propiedades;  la propiedad prestado será false).
//         §Un método que permitirá cambiar el número de estantería en la localización.§Un método que permitirá cambiar la propiedad Prestado.
//         §Un método que muestre toda la información de un disco.
//         §Guarda todo el código en un archivo llamado disco.js
        
//     3.2 .-Prepara un formulario diseñado para almacenar los discos con los que trabajamos en el ejercicio anterior.  
//     Recuerda  qué  elementos  se  almacenaban,  y  elije  el  componente  de formulario más adecuado:
//     §Nombre del disco.
//     §Grupo de música o cantante.§Año de publicación.
//     §Tipo de música (podrá ser “rock”, “pop”, “punk” o “indie”);
// §   Localización: almacenará un número de estantería.
//     §Prestado: almacenará un valor booleano. Por defecto será false.
    
//     3.3.-A partir del formulario creado en la actividadanterior, realiza las funciones necesarias para validarlo teniendo en cuenta:
//         §Nombre del disco: 20 caracteres, obligatorio.
//         §Grupo de música o cantante: 20 caracteres, obligatorio.
//         §Año de publicación: 4 caracteres numéricos.
//         §Tipo de música (podrá ser “rock”, “pop”, “punk” o “indie”): sin comprobación.
//         §Localización: almacenará un número de estantería: vacío o numérico.
//         §Prestado: sin comprobación.Tendrás que tener en cuenta, además:
//         §Que utilizarás un método window.onload.
//         §Que la validación se asignará al formulario mediante un AddEventListener.
//         §Que los campos nombre del disco y grupo de música se validarán en la misma función (campo20).Ampliación:
//         §Modifica las funciones de tal manera que, en caso de que se produzca un error en la validación, el campo implicado tenga el reborde rojo, y 
//         la etiqueta que lo acompaña también aparezca de color rojo.
//         §Para ello deberás crear las clases css necesarias (puedes incluirlas en el propio html si lo deseas) para que se visualice correctamente.
//         §Ten en cuenta que si el usuario mete correctamente el nombre, deberá volver a su color habitual.
        
//     3.4.-Crea de manera dinámica (es decir, al cargarse la páginacon JavaScript en vez de html) el formulario que definimos en el ejercicio anterior.
//     Ten en cuenta que el formulario deberá tener los atributos necesarios para que, al crearse, tenga la misma funcionalidad que el que creaste en html.
//     No olvides añadir las etiquetas <label> a cada uno de los elementos.
    
//     4.-Crea  una  aplicación  que  te  permitirá  generar  tus  propios  formularios  de  manera  dinámica. Para ello dibuja una tabla de una sola fila 
//     y varias columnas. En cada columna habrá un botón que realice lo siguiente:
//         1.Crear un input de tipo texto. Le preguntará al usuario mediante un prompt qué nombre (atributo name) tiene el input.
//         2.Crear  un  input  de  tipo  password.  Le  preguntará  al  usuario  mediante  un  prompt  qué nombre (atributo name) tiene el input.
//         3.Crear un textarea. Le preguntará al usuario el nombre y generará automáticamente un textarea de 40 columnas y 5 filas.
//         4.Crear un label. Preguntará al usuario a qué input va referido (atributo for).
//         5.Crear una imagen. Preguntará al usuario qué ruta tiene la imagen (atributo src).
//         6.Crear un checkbox. Preguntará al usuario el nombre y el valor (atributosname y value).
//         7.Crear un radio. Preguntará al usuario el nombre y el valor (atributos name y value).
//         8.Crear un botón (submit). Preguntará al usuario el nombre y el valor (atributos name y value).
