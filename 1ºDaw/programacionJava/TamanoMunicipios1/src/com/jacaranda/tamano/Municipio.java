package com.jacaranda.tamano;

import java.util.ArrayList;

public class Municipio {
	
	private ArrayList<Datos> datos;

	private String  descrip;
	
	public Municipio(String descrip) {
		this.descrip=descrip;
		datos=new ArrayList<Datos>();
	}
	
	

	public ArrayList<Datos> getDatos() {
		return datos;
	}
	
	public String getDatosPorYear(int year) {
		Datos nuevoDato = new Datos(year,0);
		int aux = datos.indexOf(nuevoDato);
		return "Año: " + datos.get(aux).getAno() +" Cantidad: "+ datos.get(aux).getDato();
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



	public String getDescrip() {
		return descrip;
	}

	


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Datos datos : datos) {
			sb.append(datos.toString() + "\n");
		}
		return "Municipio [descrip=" + descrip + "] \n"+sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
