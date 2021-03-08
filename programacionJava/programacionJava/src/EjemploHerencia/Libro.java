package EjemploHerencia;

public class Libro {
	private String titulo;
	private int numeroPaginas;
	private String autor;
	private String resumen;
	private boolean pelicula;
	
	
	public Libro() {
		super();
	}
	
	public Libro(String resumen, boolean pelicula) {
		this.resumen = resumen;
		this.pelicula = pelicula;
	}
	
	public Libro(String resumen, boolean pelicula, String titulo, int numeroPaginas, String autor) {
		this(resumen, pelicula);
		this.titulo = titulo;
		this.numeroPaginas = numeroPaginas;
		this.autor = autor;
	}
	
	public void mostrarTituloConAutor() {
		System.out.println("El autor es: "+ this.autor+" y el título es: "+this.titulo);
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String nombre) {
		this.titulo = nombre;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public boolean isPelicula() {
		return pelicula;
	}

	public void setPelicula(boolean pelicula) {
		this.pelicula = pelicula;
	}
	
	
}
