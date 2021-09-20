package RelacionProblemas8_Arrays;

public class RepartoDeCartas {
	private String oro="oro";
	private String espada="espada";
	private String bastos="bastos";
	private String copas="copas";
String arrayCartas[] = new String[48];
public void llenarListaCartas() {
	for(int i=0;i<arrayCartas.length;i++) {
		int contador=1;
		if(contador>=12) {
			contador=1;
		}
		else if(i<13) {
			arrayCartas[i]=contador+" de "+oro;
			contador++;
			
		}
		else if(i<25) {
			arrayCartas[i]=contador+" de "+espada;
			contador++;
		}
		else if(i<37) {
			arrayCartas[i]=contador+" de "+bastos;
			contador++;
		}
		else if(i<=48) {
			arrayCartas[i]=contador+" de "+copas;
			contador++;
		}
		
	}
}


	
	
}
