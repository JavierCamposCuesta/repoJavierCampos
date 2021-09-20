package relacionDeProblemas7;

public class PrincipalPartido {

	public static void main(String[] args) {
		Equipo betis=new Equipo("Betis", "Benito Villamarin", "Sevilla");
		Equipo sevilla=new Equipo("Sevilla", "Ramon Sanchez Pizjuan", "Sevilla");
		Equipo cadiz=new Equipo("Cadiz", "Antonio Molina", "Cadiz");

		Partido p1=new Partido(betis, sevilla);
		Partido p2=new Partido(cadiz, betis);

		
		try {
			System.out.println(p1.ponerResultado(betis, sevilla));

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		/*try {
			System.out.println(p1.ponerResultado(cadiz, betis));

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		System.out.println(p1);
		
		
		System.out.println(betis);

	}

}
