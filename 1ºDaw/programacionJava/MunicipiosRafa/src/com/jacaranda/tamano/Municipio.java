package com.jacaranda.tamano;

import java.util.ArrayList;

public class Municipio {

	private String  descrip;
	private ArrayList<Datos> datos;
	
	public Municipio(String descrip) {
		this.datos=new ArrayList<Datos>();
		this.descrip = descrip;
	}

	public Municipio(String descrip, ArrayList<Datos> datos) {
		super();
		this.descrip = descrip;
		this.datos = datos;
	}
	
	public void addDatos(Datos aux) {
		if (datos.contains(aux)) {
			int aux2 =datos.indexOf(aux);
			datos.get(aux2).setDato(aux.getDato());
			//datos.get(datos.indexOf(aux)).setDato(aux.getDato());
		}else {
			datos.add(aux);
		}
		System.out.println( "El nuevo dato es :" + datos.get(datos.indexOf(aux)).getDato());
	}
	
	public ArrayList<Datos> getDatos(){
		return datos;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(descrip+":\n");
		for (Datos d : datos) {
			result.append("\n"+d.toString()+"\n");
		}
		
		return result.toString();
	}

	public String getDescrip() {
		return descrip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
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
		Municipio other = (Municipio) obj;
		if (descrip == null) {
			if (other.descrip != null)
				return false;
		} else if (!descrip.equals(other.descrip))
			return false;
		return true;
	}
	
	
	
	
}
