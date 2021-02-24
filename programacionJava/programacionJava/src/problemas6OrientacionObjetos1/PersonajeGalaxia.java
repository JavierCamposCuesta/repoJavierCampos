package problemas6OrientacionObjetos1;

public class PersonajeGalaxia {
	//Atributos 
	private String nombre;
	private int capacidadDestruccion;
	private String primeraPelicula;
	private double estatura;
	private String especie;
	private double peso;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Constructores 
	public PersonajeGalaxia() {}

	public PersonajeGalaxia(String nombre, int capacidadDestruccion, String primeraPelicula, double estatura,
			String especie, double peso) {
		super();
		this.nombre = nombre;
		if (capacidadDestruccion >0 && capacidadDestruccion<100) {
			this.capacidadDestruccion = capacidadDestruccion;
		}
		this.primeraPelicula = primeraPelicula;
		this.estatura = estatura;
		this.especie = especie;
		this.peso = peso;
	}
	
	
	/**
	 * El   método   toString   del   personaje   debe   mostrar   el   nombre,   la   estatura,   
	 * la   especie,   y   acontinuación lo que sea mayor, la capacidad de destrucción o el peso
	 */
	@Override 
	public String toString() {
		double opcionMayor;
		if (this.capacidadDestruccion > this.peso) {
			opcionMayor=this.capacidadDestruccion;
		}
		else if(this.capacidadDestruccion < this.peso) {
			opcionMayor=this.peso;
		}
		else {
			opcionMayor=this.peso;
		}
		return this.nombre + " , la estatura es de: "+this.estatura + ", "+ opcionMayor;
	}

}
