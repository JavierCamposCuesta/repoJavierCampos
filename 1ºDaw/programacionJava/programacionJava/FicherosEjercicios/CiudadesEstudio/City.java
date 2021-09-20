package CiudadesEstudio;

import java.util.ArrayList;

public class City {
	private int idCity;
	private String nombreCity;
	private ArrayList<Address> listaDirecciones;
	
	
	public City(int idCity, String nombreCity) {
		super();
		this.idCity = idCity;
		this.nombreCity = nombreCity;
		this.listaDirecciones = new ArrayList<Address>();
	}


	
	
	

}
