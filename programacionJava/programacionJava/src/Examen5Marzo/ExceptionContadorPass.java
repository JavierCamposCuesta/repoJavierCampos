package Examen5Marzo;

public class ExceptionContadorPass extends Exception{
	public ExceptionContadorPass() {
		super("La contraseña debe tener minimo 2 mayusculas y 3 numeros");
	}
}
