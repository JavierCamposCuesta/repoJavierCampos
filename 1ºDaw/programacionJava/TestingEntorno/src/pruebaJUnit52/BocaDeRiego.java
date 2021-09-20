package pruebaJUnit52;

public class BocaDeRiego {
	
	private boolean llaveDePaso;
	private int aguaDisponible;
    
    public BocaDeRiego (int aguaDisponible){
	    llaveDePaso = false;
	    this.aguaDisponible = aguaDisponible;
	    
    }
    
    public void riega () throws NoQuedaAguaException{
    	if (aguaDisponible > 0) {
    		llaveDePaso = true;
    		aguaDisponible--;
    	}
    	else {
    		throw new NoQuedaAguaException("Ya no queda agua");
    	}
    	
    }

    public void cierra (){
    	llaveDePaso = false;
    }
    
    public boolean estado() {
    	boolean estado;
    	if (llaveDePaso == true) {
    		estado = true;
    	} else {
    		estado = false;
    	}
    	return (estado);
    }
    
    public int getAguaDisponible() {
    	return aguaDisponible;
    }

    public String muestraEstado() {
    	String estado;
    	
    	if (estado() == true) {
    		estado = "Abierta";
    	} else {
    		estado = "Cerrada";
    	}
    	return (estado);
    }

}
