package RelacionProblemas8_Arrays;

import java.util.ArrayList;
import java.util.List;

public class JugadorCarta {
	private List<Carta>mano;
	
	public JugadorCarta() {
		super();
		mano=new ArrayList<Carta>();
	}
	
	
	public void addCarta(Carta carta) {
		this.mano.add(carta);
	}

	public List<Carta> getMano() {
		return mano;
	}

	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}

}
