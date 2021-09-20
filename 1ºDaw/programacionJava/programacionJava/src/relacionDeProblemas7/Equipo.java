package relacionDeProblemas7;

public class Equipo {
	private String nombre;
	private String estadio;
	private String ciudad;
	private int goles;
	private int totalGoles;
	private int partidosGanados;
	
	public Equipo() {
	}
	
	public Equipo(String nombre, String estadio, String ciudad) {
		this.nombre=nombre;
		this.estadio=estadio;
		this.ciudad=ciudad;
	}

	

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", estadio=" + estadio + ", ciudad=" + ciudad + ", Total goles=" + this.totalGoles
				+ ", partidosGanados=" + partidosGanados + "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEstadio() {
		return estadio;
	}
	
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public int getGoles() {
		return goles;
	}
	
	public void setGoles(int goles) {
		this.goles = goles;
	}
	
	public int getPartidosGanados() {
		return partidosGanados;
	}
	
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	
	
	public int getTotalGoles() {
		return totalGoles;
	}
	
	public void setTotalGoles(int totalGoles) {
		this.totalGoles = totalGoles;
	}
	
	
	
	
	

}
