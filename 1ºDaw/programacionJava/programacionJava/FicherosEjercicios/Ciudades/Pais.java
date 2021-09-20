package Ciudades;

import java.util.ArrayList;
import java.util.Collections;




public class Pais{
	int idPais;
	String nombrePais;
	public ArrayList<Ciudad> listaCiudades;
	
	public Pais(int idPais, String nombrePais) {
		this.idPais=  idPais;
		this.nombrePais=nombrePais;
		this.listaCiudades=new ArrayList<Ciudad>();
	}
	
	public void addCiudad(Ciudad c){
		if(!listaCiudades.contains(c)) {
			listaCiudades.add(c);
		}
		
	}
	
	public boolean addDireccion(int idCiudad, Direccion a) {
		boolean resul = false;
		Ciudad c = new Ciudad(idCiudad, null);
		
		if(this.listaCiudades.contains(c)) {
			this.listaCiudades.get(this.listaCiudades.indexOf(c)).addDireccion(a);
			//c.addDireccion(a);
			resul = true;
		}
		return resul;
	}
	
	
	
	
	
	

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPais;
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
		Pais other = (Pais) obj;
		if (idPais != other.idPais)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		Collections.sort(listaCiudades);
		StringBuilder resul= new StringBuilder();
		resul.append("Pais [id=" + this.idPais + ", nombre= "+ this.nombrePais + "\n");
		for(Ciudad ciudad : listaCiudades) {
			resul.append("\t" + ciudad.toString() + "\n");
		}
		
		
		return resul.toString();
	}

	

}
