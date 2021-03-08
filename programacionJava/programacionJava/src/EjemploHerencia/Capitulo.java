package EjemploHerencia;

public class Capitulo extends Libro{
	private String tituloCapitulo;
	private int numeroPaginascapitulo;
	
	public Capitulo() {
		super();
	}
	
	public Capitulo(String tituloCapitulo, int numeroPaginasCapitulo) {
		this.tituloCapitulo=tituloCapitulo;
		this.numeroPaginascapitulo=numeroPaginasCapitulo;
	}
	
	public void mostrarCaracteristicasCapitulo() {
		System.out.println("El titulo del libro es: "+ this.getTitulo() + " , el nombre del capítulo es: "+this.tituloCapitulo+" y el numero de paginas del capitulo es: "+this.numeroPaginascapitulo);
	}

	public String getTituloCapitulo() {
		return tituloCapitulo;
	}

	public void setTituloCapitulo(String tituloCapitulo) {
		this.tituloCapitulo = tituloCapitulo;
	}

	public int getNumeroPaginascapitulo() {
		return numeroPaginascapitulo;
	}

	public void setNumeroPaginascapitulo(int numeroPaginascapitulo) {
		this.numeroPaginascapitulo = numeroPaginascapitulo;
	}

}
