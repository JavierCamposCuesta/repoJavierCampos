package Ciudades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;



public class Ciudad implements Comparable<Ciudad>{
	private int idCiudad;
	private String nombreCiudad;
	public HashSet<Direccion> listaDirecciones;
	
	public Ciudad(int idCiudad, String nombreCiudad) {
		super();
		this.idCiudad=idCiudad;
		this.nombreCiudad=nombreCiudad;
		this.listaDirecciones = new HashSet<Direccion>();
	}

	
	
	
	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCiudad;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		if (idCiudad != other.idCiudad)
			return false;
		return true;
	}

	@Override
	public String toString() {
		ArrayList<Direccion> lista1 = new ArrayList(listaDirecciones);
		Collections.sort(lista1);
		StringBuilder sb= new StringBuilder();
		sb.append("Ciudad [idCiudad=" + idCiudad + ", nombreCiudad=" + nombreCiudad +"\n" );
		for(Direccion direccion : lista1) {
			sb.append("\t" + direccion.toString() + "\n");
		}
				
		
		
		return sb.toString();
	}
	
	public boolean addDireccion(Direccion d) {
		return listaDirecciones.add(d);
	}




	@Override
	public int compareTo(Ciudad arg0) {
		int resultado=0;
		if(this.listaDirecciones.size()>arg0.listaDirecciones.size()) {
			resultado=-1;
		}
		else if(this.listaDirecciones.size()<arg0.listaDirecciones.size()) {
			resultado=1;
		}
		else {
			resultado=this.getNombreCiudad().compareTo(arg0.getNombreCiudad());
		}
		return 0;
	}


	
	

}
