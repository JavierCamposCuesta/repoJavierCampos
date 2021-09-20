package EjemploEnum;

public class PersonaPrueba {

	public PersonaPrueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		PersonaPrueba2 persona = new PersonaPrueba2("pao", Transporte.AVION);
		
	System.out.println(persona.getTransporte().getVelocidad());

	}

}
