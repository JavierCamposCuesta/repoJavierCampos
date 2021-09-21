package aplicacionPlanificadorTareas;

public class TareaDeOtroTipo extends TareaAbstract{
	
	private String descripcionDetallada;
	private String ubicacion;

	public TareaDeOtroTipo(String descripcion, String prioridad, String descripcionDetallada, String ubicacion) {
		super(descripcion, prioridad);
		this.descripcionDetallada = descripcionDetallada;
		this.ubicacion=ubicacion;
	}

	@Override
	public String toString() {
		return "Tarea De Otro Tipo [descripcion Detallada= " + descripcionDetallada + ", ubicacion= " + ubicacion + super.toString();
	}

	
	//Se podrá modificar la descripcion detallada y la ubicacion
	public String getDescripcionDetallada() {
		return descripcionDetallada;
	}

	public void setDescripcionDetallada(String descripcionDetallada) {
		this.descripcionDetallada = descripcionDetallada;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
