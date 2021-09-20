package prueba;

public class EstudioPrueba {
	private String nombre;
	private int edad;
	private double altura;
	
	public EstudioPrueba() {}
	
	public EstudioPrueba(String nombre, int edad, double altura) {
		this.nombre=nombre;
		this.edad=edad;
		this.altura=altura;
	}
	
	public void calcularSiEsJoven() throws Exception{
		if (this.edad<=0) {
			throw new ExceptionPruebaNoValido();
		}
		else if (this.edad>=50){
			throw new ExceptionPrueba();
		}
		else {
			System.out.println("Es una persona joven ");
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	

}
