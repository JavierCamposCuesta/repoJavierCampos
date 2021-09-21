package gestionTareas;

public enum PrioridadTarea {
ALTA(24), MEDIA(72), BAJA(168);
	
	private int numeroHoras;

	
	PrioridadTarea(int numeroHoras) {
		this.numeroHoras=numeroHoras;
	}
	
	public int getNumeroHoras() {
		return this.numeroHoras;
	}
}
