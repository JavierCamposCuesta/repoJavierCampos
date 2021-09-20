package ClasesAbstractas;

public class MainFiguras {

	public static void main(String[] args) {
		System.out.println(new Cubo(30, 50).calcularDensidad());
		System.out.println(new Cubo(30, 50).calcularVolumen());
		System.out.println(new Cubo(30, 50).flotaEnElAgua());

	}

}
