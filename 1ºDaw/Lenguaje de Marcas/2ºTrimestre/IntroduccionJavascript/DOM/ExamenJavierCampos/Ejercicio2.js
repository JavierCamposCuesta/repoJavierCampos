class Pelicula{
    reparto = [];
    constructor(titulo, director, reparto, year, genero){
        this.reparto=reparto;
        this.titulo=titulo;
        this.director=director;
        this.year=year;
        this.genero=genero;
    }
    informacion(){
        return (`Título: ${this.titulo}. Director: ${this.director}. Reparto: ${this.reparto}. Año: ${this.year}. Genero: ${this.genero}`);
    }

    compararPelicula(Pelicula){
        let resultado =0;
        if(Pelicula.year<this.year){
            resultado=1;
        }
        else if(Pelicula.year > this.year){
            resultado=-1;
        }
        return resultado;
    }

    addActor(actor){
        this.reparto.push(actor);
    }

    eliminarActor(actor){
        this.reparto.splice(this.reparto.indexOf(actor));
    }

}

let actores=['Carrie-Anne Moss','Guy Pearce','Joe Pantoliano'];
const pelicula1 = new Pelicula('Memento', 'Christopher Nolan', actores, 2000, 'thriller.');
const pelicula2 = new Pelicula('Apocalypse Now', 'rancis Ford Coppola', ['Martin Sheen','arlon Brando','Robert Duvall'], 1979, 'bélica.');
const pelicula3 = new Pelicula('Gladiator', 'Ridley Scott', ['Giannina Facio','Russell Crowe','oaquin Phoenix'], 2010, 'fiction.');

let arrayPeliculas=[pelicula1,pelicula2,pelicula3];
for(i=0;i<arrayPeliculas;i++){
    alert(arrayPeliculas[i].informacion);
}

//pruebas
console.log(pelicula1.addActor('javier'));
console.log(pelicula1.informacion());
console.log(pelicula1.eliminarActor('javier'));
console.log(pelicula1.informacion());

console.log(arrayPeliculas.sort());
