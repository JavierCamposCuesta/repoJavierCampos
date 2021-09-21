package aplicacionPlanificadorTareas;

public class TareaDeClase extends TareaAbstract{
	
	private String asignatura;

	public TareaDeClase(String descripcion, String prioridad, String asignatura) {
		super(descripcion, prioridad);
		this.asignatura=asignatura;
	}

	@Override
	public String toString() {
		return "Tarea De Clase [ Asignatura= " + asignatura + super.toString();
	}
	

	//Podremos modificar la asignatura a la que corresponde la tarea
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
	

}
