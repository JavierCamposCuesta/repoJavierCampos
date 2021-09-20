package pruebaJUnit52;

public class Tren {
    String locomotora;
    Vagon vagones[];
    String responsable;
    private int numVagones; //número de vagones que forman el tren
    
    public Tren(String locomotora, String responsable) {
        this.locomotora = locomotora;
        this.responsable = responsable;
        
        //creamos la tabla de tamaño 5, pero no se crea ningún objeto de tipo vagón
        vagones = new Vagon[5]; 
        numVagones = 0; //por ahora no hay vagones enganchados al tren
    }
    
    /* Al ser la clase Vagon no visible por clases externas, será la clase Tren la que 
     * se encargue de construir el objeto a partir de los datos que nos pasen. 			*/
    public boolean enganchaVagon(int capacidadMax, int capacidadActual, String mercancia) {
    	boolean enganchado;
        if (numVagones >= 5) {
            enganchado=false;
        } else {
            Vagon v = new Vagon (capacidadMax, capacidadActual, mercancia);
            vagones[numVagones] = v; //el vagón pasado ocupa el último lugar
            numVagones ++; //ahora tenemos un vagón más enganchado al tren
            enganchado=true;
        }
        return enganchado;
    }   
    public void desenganchaVagon() throws NotVagonException {
    	if (numVagones >0) {
    		vagones[numVagones-1] = null;
    		numVagones --;
    	}
    	else {
    		throw new NotVagonException("No hay vagones que desenganchar");
    	}
    }
    
    public int getNumVagones() {
    	return numVagones;
    }
}