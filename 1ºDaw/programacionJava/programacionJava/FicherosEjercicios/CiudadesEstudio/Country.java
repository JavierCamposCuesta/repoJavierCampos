package CiudadesEstudio;

import java.util.ArrayList;

public class Country {
	private int id;
	private String nombre;
	private ArrayList<City>listaCiudades;
	
	
	public Country(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaCiudades= new ArrayList<City>();
	}
	
	

}
