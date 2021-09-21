package gestionTareas;

public class ExceptionFechaSolucionInvalidad extends Exception{
	
	public ExceptionFechaSolucionInvalidad() {
		super("La fecha de solución no puede ser anterior a la fecha de creación");
	}

}
