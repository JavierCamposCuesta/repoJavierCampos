package EjemploHerencia;

public class Parrafo extends Capitulo{
	private int numeroParrafos;
	private int numeroLineas;

	
	public Parrafo() {
		super();
	}
	
	public Parrafo(int numeroParrafos, int numeroLineas) {
		this.numeroParrafos=numeroParrafos;
		this.numeroLineas=numeroLineas;
	}
	
	public void mostrarCaracteristicasParrafo() {
		System.out.println("El titulo del libro es: "+ this.getTitulo() + " , el nombre del capítulo es: "+ this.getTituloCapitulo() +" y el numero de paginas del capitulo es: " + this.getNumeroPaginascapitulo() + " y el parrafo tiene un total de: " + this.numeroParrafos +" parrafos");

	}

	public int getNumeroParrafos() {
		return numeroParrafos;
	}

	public void setNumeroParrafos(int numeroParrafos) {
		this.numeroParrafos = numeroParrafos;
	}

	public int getNumeroLineas() {
		return numeroLineas;
	}

	public void setNumeroLineas(int numeroLineas) {
		this.numeroLineas = numeroLineas;
	}
	
}
