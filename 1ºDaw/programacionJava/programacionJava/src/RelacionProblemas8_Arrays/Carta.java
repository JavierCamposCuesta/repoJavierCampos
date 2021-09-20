package RelacionProblemas8_Arrays;

public class Carta {

	public final static String[] PALOS= {"Oro", "Bastos", "Espadas", "Copas"};
	
	private String palo;
	private int numero;
	
	public Carta (String palo, int numero) {
		this.palo=palo;
		this.numero=numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
