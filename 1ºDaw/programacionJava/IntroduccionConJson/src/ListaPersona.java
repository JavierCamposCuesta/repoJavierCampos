import java.util.ArrayList;

public class ListaPersona {
	private ArrayList<Persona> lista;
	
	public ListaPersona() {
		lista = new ArrayList<Persona>();
	}
	
	public void addPersona(String nombre, String apellido, int edad) {
		this.lista.add(new Persona(nombre, apellido, edad));
	}

}
