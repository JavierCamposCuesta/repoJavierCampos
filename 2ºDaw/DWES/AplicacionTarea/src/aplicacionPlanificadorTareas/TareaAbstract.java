package aplicacionPlanificadorTareas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public abstract class TareaAbstract implements Temporizable, Comparable<TareaAbstract>{
	protected String descripcion;
	protected LocalDate fechaInicio;
	protected LocalDate fechaFin;
	protected int codigo;
	protected Prioridad prioridad;
	
	protected static int CONTADOR=0;
	
	public TareaAbstract (String descripcion, String prioridad) {
		
		this.descripcion = descripcion;
		prioridad = prioridad.toUpperCase();
		this.prioridad = Prioridad.valueOf(prioridad);
		
		this.fechaInicio=LocalDate.now();
		this.codigo= CONTADOR++;
		
	}
	
	//Metodo para contar el tiempo transcurrido entre que se creó y la fecha de consulta
	//Para esto sobreescribimos el metodo de la interfaz, este metodo siempre devolverá un valor positivo
	@Override
	public long numDias(LocalDate fecha) {
		
		long aux = ChronoUnit.DAYS.between(fecha, this.fechaInicio);
		if(aux<0) {
			aux=-aux;
		}
		return aux;
	}

	
	
	//Implementamos el metodo compareTo, para porder ordenar lista con todas las tareas ordenadas de forma ascendente por fecha
	@Override
	public int compareTo(TareaAbstract x) {
		
		return x.fechaInicio.compareTo(fechaInicio);
	}
	

	//Método toString, que utilizaremos para mostrar la información de las tareas
	@Override
	public String toString() {
		return ", descripcion= " + descripcion + ", fechaInicio= " + fechaInicio + ", fechaFin= " + fechaFin
				+ ", codigo=" + codigo + ", prioridad= " + prioridad +" ]";
	}

	
	
	
	//Lo único que vamos a poder modificar es la fecha de solucion de las tareas
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

	//Las tareas serán iguales cuando tengan la misma descripción y la misma fecha de inicio
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
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
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
