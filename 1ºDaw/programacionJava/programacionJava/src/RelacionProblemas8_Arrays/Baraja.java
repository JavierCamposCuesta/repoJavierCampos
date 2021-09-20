package RelacionProblemas8_Arrays;

import java.util.ArrayList;
import java.util.List;

public class Baraja {

		public final static int NUMERO_CARTAS=48;
		private final static int CARTAS_POR_PALO=12;
		private List<Carta> cartas;
		
//		public Baraja() {
//			super();
//			inicalizarBaraja();		}
		
		public List<Carta> getCartas() {
			return cartas;
		}

		public void setCartas(List<Carta> cartas) {
			this.cartas = cartas;
		}

//		private void inicalizarBaraja(){
//			cartas=new ArrayList<Carta>();
//				for(Palos palo: Palos.values()) {
//					for(int i=1; i<13; i++) {
//						cartas.add(new Carta(palo, i));
//					}
//				}
		}
		
		
		
		
		

