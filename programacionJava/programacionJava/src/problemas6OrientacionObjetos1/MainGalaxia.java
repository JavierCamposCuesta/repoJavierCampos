package problemas6OrientacionObjetos1;

public class MainGalaxia {

	public static void main(String[] args) {
		
		
		PeliculaGalaxia pelicula1 = new PeliculaGalaxia();
		PeliculaGalaxia pelicula2= new PeliculaGalaxia("3 Patas Pa un Banco", 2010, "Resines", "Frank de la Jungla", "Tragabuche");
		PersonajeGalaxia personaje1 = new PersonajeGalaxia("El tio Paco", 85, pelicula1.getNombre(), 1.77, "Sobre Humano", 64);
		PersonajeGalaxia personaje2 = new PersonajeGalaxia("Paca Pacheco", 85, pelicula2.getNombre(), 1.77, "Sobre Humano", 64);
		PersonajeGalaxia personaje3 = new PersonajeGalaxia("El gordo de los Morancos", 85, pelicula2.getNombre(), 1.77, "Sobre Humano", 64);
		 pelicula1= ("Los Estrellados", 1998, personaje1.getNombre(), personaje2.getNombre(), personaje3.getNombre());
			System.out.println(pelicula1.peliculaMasNueva(pelicula2));
		
		
		System.out.println(pelicula1.poderMaximoPelicula(15, 45, 78));
		System.out.println(pelicula1.poderMaximoPersonajes(45, 62, 78));
		System.out.println(pelicula1);
		
		
		System.out.println(personaje1);

	}

}
