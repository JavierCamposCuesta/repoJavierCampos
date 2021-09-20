package com.jacaranda.tamano;

import java.util.ArrayList;

public class Comunidad {
	
	private String nombre;
	private ArrayList<Municipio>listMunicipio;
	

	
	public Comunidad(String nombre) {
		this.listMunicipio= new ArrayList<Municipio>();
		this.nombre = nombre;
		
	}



	public Comunidad(String nombre, ArrayList<Municipio> listMunicipio) {
		super();
		this.nombre = nombre;
		this.listMunicipio = listMunicipio;
	}
	
	public ArrayList<Municipio> getListMunicipio(){
		return listMunicipio;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.nombre+":\n");
		for (Municipio m : listMunicipio) {
			result.append("\n"+m.toString()+"\n");
		}
		
		return result.toString();
	}



	public String getNombre() {
		return nombre;
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



	
	
	
}
