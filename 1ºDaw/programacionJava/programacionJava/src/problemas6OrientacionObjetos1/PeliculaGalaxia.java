package problemas6OrientacionObjetos1;

public class PeliculaGalaxia {
	//Atributos
	
	private String nombre;
	private int yearEstreno;
	private String personajeImportante1;
	private String personajeImportante2;
	private String personajeImportante3;
	
	
	//Constructores
	
	public PeliculaGalaxia() {}
	public void setYearEstreno(int yearEstreno) {
		this.yearEstreno = yearEstreno;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public PeliculaGalaxia(String nombre, int yearEstreno, String personajeImportante1, String personajeImportante2, String personajeImportante3){
		this.nombre=nombre;
		this.yearEstreno=yearEstreno;
		this.personajeImportante1=personajeImportante1;
		this.personajeImportante2=personajeImportante2;
		this.personajeImportante3=personajeImportante3;
	}
	
	//Metodos
	
	
//	public String peliculaMasNueva(PeliculaGalaxia pelicula2) {
//		String resultado;
//		if (this.yearEstreno>pelicula2.getYearEstreno()) {
//			resultado="La pelicula " +this.nombre + " es mas moderna que "+ pelicula2.getNombre();
//		}
//		else if (this.yearEstreno<pelicula2.getYearEstreno()) {
//			resultado="La pelicula " + getNombre()+ " es mas moderna que "+ this.nombre;
//		}
//		else {
//			resultado="Las peliculas son de la misma fecha";
//		}
//		return resultado;
//
//		
//	}
	
	public String poderMaximoPersonajes(int poderPersonaje1, int poderPersonaje2, int poderPersonaje3) {
		return "El poder del primer personaje es de: "+poderPersonaje1
				+ " \n El poder del segundo personaje es de: "+ poderPersonaje2
				+" \n El poder del tercer personaje es de: "+poderPersonaje3;
	}
	
	public String poderMaximoPelicula(int poderPersonaje1, int poderPersonaje2, int poderPersonaje3) {
		int poderMaximo=poderPersonaje1 + poderPersonaje2 + poderPersonaje3;
		return "El poder máximo de la peícula es de "+ poderMaximo;
	}
	
	@Override 
	public String toString() {
		return this.nombre + " (" + this.yearEstreno +") "+ this.personajeImportante1 +", "+this.personajeImportante2 +", " + this.personajeImportante3;
	}
	
}
