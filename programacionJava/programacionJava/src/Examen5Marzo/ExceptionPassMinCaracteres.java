package Examen5Marzo;

public class ExceptionPassMinCaracteres extends Exception{
	public ExceptionPassMinCaracteres() {
		super("La contraseña no es correcta, tiene que tener mínimo 10 caracteres");
	}

}
