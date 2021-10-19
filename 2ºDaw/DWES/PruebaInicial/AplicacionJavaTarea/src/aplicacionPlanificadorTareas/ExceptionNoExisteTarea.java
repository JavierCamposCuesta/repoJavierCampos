package aplicacionPlanificadorTareas;

@SuppressWarnings("serial")
public class ExceptionNoExisteTarea extends Exception{
	public ExceptionNoExisteTarea() {
		super("No existe ninguna tarea con esos parametros");
	}

}
