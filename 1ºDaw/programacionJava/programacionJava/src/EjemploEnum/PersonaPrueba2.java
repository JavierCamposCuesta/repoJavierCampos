package EjemploEnum;

public class PersonaPrueba2 {

	private String nombre;
	private Transporte transporte;
	
	public PersonaPrueba2(String nombre, Transporte transporte) {
		this.nombre=nombre;
		this.transporte=transporte;
	}
	public void cacularVelocidad() {
		transporte.getVelocidad();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

}
