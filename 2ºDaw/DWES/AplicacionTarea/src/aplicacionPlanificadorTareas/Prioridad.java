package aplicacionPlanificadorTareas;

public enum Prioridad {
ALTA(24), MEDIA(72), BAJA(168);
	
	private int numeroHoras;

	

	Prioridad(int numeroHoras) {
		this.numeroHoras=numeroHoras;
	}
	
	public int getNumeroHoras() {
		return this.numeroHoras;
	}
}
