package RelacionProblemas8_Arrays;

public class MainFecha {

	public static void main(String[] args) {
Fecha fecha= new Fecha();
try {
	System.out.println(fecha.comprobarFechaCorrecta(32, 12, 212));
} catch (Exception e) {
	
	System.out.println(e.getMessage());
}
	}

}
