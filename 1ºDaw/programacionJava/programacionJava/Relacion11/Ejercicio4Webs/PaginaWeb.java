package Ejercicio4Webs;

import java.time.LocalDateTime;

public class PaginaWeb {
	private String url;
	public LocalDateTime fecha;
	
	public PaginaWeb(String url, LocalDateTime fecha) {
		this.url=url;
		this.fecha=fecha;
	}

	@Override
	public String toString() {
		return "PaginaWeb [url=" + url + ", fecha de consulta =" + fecha + "]";
	}
	
	

}
