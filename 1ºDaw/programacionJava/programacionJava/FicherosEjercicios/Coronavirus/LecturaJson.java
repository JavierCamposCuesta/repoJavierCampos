package Coronavirus;

public class LecturaJson {
	String Id;
	String Url;
	String Titulo;
	String Subtitulo;
	ClaseDatos Datos;
	
	
	public LecturaJson(String id, String url, String titulo, String subtitulo, ClaseDatos datos) {
		super();
		Id = id;
		Url = url;
		Titulo = titulo;
		Subtitulo = subtitulo;
		Datos = datos;
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getUrl() {
		return Url;
	}


	public void setUrl(String url) {
		Url = url;
	}


	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
	}


	public String getSubtitulo() {
		return Subtitulo;
	}


	public void setSubtitulo(String subtitulo) {
		Subtitulo = subtitulo;
	}


	public ClaseDatos getDatos() {
		return Datos;
	}


	public void setDatos(ClaseDatos datos) {
		Datos = datos;
	}
	
	

}
