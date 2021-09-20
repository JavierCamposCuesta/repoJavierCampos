package feria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;





public class Calle {
	private ArrayList<Caseta>listaCasetas;
	private String nombreCalle;
	//private int numero;
	private int idCalle;
	
	public Calle(String nombreCalle, int idCalle) {
		listaCasetas = new ArrayList<Caseta>();
		this.nombreCalle=nombreCalle;
		//this.numero=numero;
		this.idCalle=idCalle;
	}
	
	
	
	public void addCaseta(String titulo, String clase, String entidad, int modulo, int idCaseta, int numero) {
		Caseta caseta = new Caseta(titulo, clase, entidad, modulo, idCaseta, numero);
		int posCaseta = this.listaCasetas.indexOf(caseta);
		if(posCaseta == -1) {
			this.listaCasetas.add(caseta);
			//posCaseta = this.listaCasetas.indexOf(caseta);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCalle;
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
		Calle other = (Calle) obj;
		if (idCalle != other.idCalle)
			return false;
		return true;
	}





	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	

	public int getIdCalle() {
		return idCalle;
	}

	public void setIdCalle(int idCalle) {
		this.idCalle = idCalle;
	}



	public String mostrarCasetas() {
		StringBuilder sb = new StringBuilder();
		sb.append("Calle " + this.getNombreCalle()+"\n");
		for(Caseta caseta : this.listaCasetas) {
			sb.append(caseta.toString()+"\n");
		}
		
		return sb.toString();
	}
	
//	2. Mostrar para cada una de las calles del recinto ferial el número de casetas que hay en lacalle
	public String numeroCasetas() {
		
		return "La calle : " + this.getNombreCalle() + " tiene " + (this.listaCasetas.size()) + " casetas";
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder("Calle=" + this.getNombreCalle()  + "\tId= " + this.getIdCalle()+"\n");
		Collections.sort(this.listaCasetas, new OrdenarPorNumero());
		for (Caseta caseta: this.listaCasetas) {
			resul.append(caseta.toString() + "\n");
		}
		return resul.toString();
	}



	public String borrarCaseta(int numero) {
		boolean fin = false;
		String resultado="Error: Ese numero no pertenece a ninguna calle";
		int modulo=0;
		boolean existe=false;
		Iterator <Caseta> iterator = this.listaCasetas.iterator();
		
		while(iterator.hasNext() && fin==false) {
			Caseta e = iterator.next();
			
			if(e.getNumero()==(numero)) {
				this.listaCasetas.remove(e);
				modulo = e.getModulo();
				resultado="Caseta borrada correctamente";
				int pos = this.listaCasetas.indexOf(e);
				fin=true;
			}
		}
		
		
		//Este for se podría hacer mas optimo, pero no tengo tiempo
		for(Caseta caseta: this.listaCasetas) {
			
			if(caseta.getNumero()>numero && fin==true) {
				caseta.setNumero(caseta.getNumero()-modulo);
				
			}
		}
		
		return resultado;
	}
	
	
	
	
	

}
