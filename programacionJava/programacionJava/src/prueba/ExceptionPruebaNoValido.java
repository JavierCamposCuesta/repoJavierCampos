package prueba;

public class ExceptionPruebaNoValido extends Exception{
	public ExceptionPruebaNoValido() {
		super("La edad no puede ser menor o igual que 0");
	}
}
