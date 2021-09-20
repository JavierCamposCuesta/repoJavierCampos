package gestionTareas;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;



public abstract class TareaAbstract implements Temporizable, Comparable<TareaAbstract>{
	protected String descripcion;
	protected LocalDate fechaAlta;
	protected LocalDate fechaSolucion;
	protected PrioridadTarea prioridad;
	protected int codigo;
	
	protected static int CONTADOR=0;
	
	public TareaAbstract(String descripcion, String prioridad){
		this.descripcion=descripcion;
		this.fechaAlta=LocalDate.now();
		prioridad=prioridad.toUpperCase();
		this.codigo=CONTADOR++;
		this.prioridad=PrioridadTarea.valueOf(prioridad);
		
	}
	
	
	//eberá tener un método llamado numDias, que reciba como parámetrouna fecha y devuelva 
	//el número de días transcurridos entre la fecha de creación de la tarea y elparámetro
	@Override
	public long numDias(LocalDate fecha) {
		
		long aux = ChronoUnit.DAYS.between(fecha, this.fechaAlta);
		if(aux<0) {
			aux=-aux;
		}
		return aux;
	}
	
	//Devolverá la lista ordenada por fecha de forma ascendente
	@Override
	public int compareTo(TareaAbstract o) {
		return o.fechaAlta.compareTo(this.fechaAlta);
	}
	
	
	
	
	
@Override
	public String toString() {
		return " descripcion=" + descripcion + ", fechaAlta=" + fechaAlta + ", prioridad=" + prioridad
				 + ", codigo=" + codigo + "]";
	}



// No se podrá modificar ninguno de los datosde las empresas creadas excepto la fecha de solución.
	public void setFechaSolucion(LocalDate fechaSolucion) {
	this.fechaSolucion = fechaSolucion;
}

	public LocalDate getFechaSolucion() {
		return fechaSolucion;
	}

	


	


	//Las tareas serán iguales si tienen la misma descripción y la misma fecha
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
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
		TareaAbstract other = (TareaAbstract) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		return true;
	}
	

}
