package EjemploEnum;

public class Titular {
	protected String nombre;
	protected int edad;

	public Titular() {
		
	}

public Titular(String nombre, int edad) {
	this.nombre=nombre;
	this.edad=edad;
}



public int getEdad() {
	return edad;
}



public void setEdad(int edad) {
	this.edad = edad;
}


}
