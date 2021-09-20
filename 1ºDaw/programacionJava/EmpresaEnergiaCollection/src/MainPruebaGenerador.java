import java.time.LocalDate;

public class MainPruebaGenerador {

	public static void main(String[] args) {
		GeneradorEolico gen1 = new GeneradorEolico(LocalDate.of(2020, 4, 29), "Burguillos", 76, 4);
		GeneradorEolico gen2 = new GeneradorEolico(LocalDate.of(2020, 5, 29), "Sevilla", 120, 6);
		GeneradorSolar gen3 = new GeneradorSolar(LocalDate.of(2020, 6, 29), "Arahal", 120, 10, 2500, TipoPanel.FOTOVOLTAICO);
		GeneradorSolar gen4 = new GeneradorSolar(LocalDate.of(2020, 7, 29), "Arahal", 120, 10, 2500, TipoPanel.FOTOVOLTAICO);

		Empresa empresa1 = new Empresa("TheBest");
		empresa1.addGeneradorEolico(gen1);
		empresa1.addGeneradorEolico(gen2);
		empresa1.addGeneradorSolar(gen3);
		empresa1.addGeneradorSolar(gen4);
		
		System.out.println(empresa1.generadoresPorFecha());
		System.out.println(" ");
		System.out.println(empresa1.generadoresPorLocalidad());
		
	
		
		

	}

}
