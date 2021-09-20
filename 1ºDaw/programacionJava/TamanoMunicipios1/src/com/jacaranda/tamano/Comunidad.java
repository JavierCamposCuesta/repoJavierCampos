package com.jacaranda.tamano;

import java.util.ArrayList;

public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;
	
	

	
	public Comunidad(String descrip) {
		
		this.nombre = descrip;
		listMunicipio = new ArrayList<Municipio>();
		
	}
	
	public String getDatosPorDescripcion(String descripcion, int year) {
		StringBuilder sb = new StringBuilder();
		Municipio municipio = new Municipio(descripcion);
		int aux = this.listMunicipio.indexOf(municipio);
		
		sb.append(this.listMunicipio.get(aux).getDescrip()+"\n");
		sb.append(this.listMunicipio.get(aux).getDatosPorYear(year));
		return sb.toString();
			
		
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Comunidad other = (Comunidad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}




	public String getNombre() {
		return nombre;
	}

	



	public ArrayList<Municipio> getListMunicipio() {
		return listMunicipio;
	}




	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Municipio municipio : listMunicipio) {
			sb.append(municipio.toString() + "\n");
		}
		return "Municipio [descrip=" + nombre + "] \n"+sb.toString();
	}
	
	
	

	
}
