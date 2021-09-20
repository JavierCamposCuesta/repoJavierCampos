package relacionDeProblemas7;

public class Jarra {
	private double capacidad;
	//Esta variable debería ser estática y así no necesitariamos método para calcular el total de agua de todas las jarras
	private double totalAgua;
	private double cantidad;
	
	
	//Constructores
	public Jarra() {
		
	}
	public Jarra(double capacidad) {
		this.capacidad=capacidad;
	}
	
	//Sets and gets
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
		this.totalAgua=0;
	}
	
	
	public double getTotalAgua() {
		return totalAgua;
	}
	public void setTotalAgua(double totalAgua) {
		this.totalAgua = totalAgua;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	//Este metodo llena la jarra
	//Cambiar por excepciones
	public void llenarJarra () throws Exception{
		if (this.cantidad<this.capacidad) {
			this.totalAgua+=this.capacidad-this.cantidad;
			this.cantidad=this.capacidad;
			System.out.println("Jarra llenada correctamente");
		}
		else {
			throw new ExceptionJarraLlena();
		}
		
	}
	
	//Este metodo vacia la jarra
	public void vaciarJarra() {
		if (this.cantidad>0) {
			this.cantidad=0;
			System.out.println("Jarra vaciada correctamente");
		}else {
			System.out.println("No se puede vaciar la jarra porque ya está vacía");
		}
		
		
	}
	
	//Este metodo es el encargado de comprobar si se puede volvar la jarra A en B, y si es así realizar las operaciones
	public void volcarAenB(Jarra j2) {
		if (j2.cantidad==j2.capacidad) {
			System.out.println("No podemos realizar la operacion porque la jarra que quieres llenar está llena");
		}
		else if (this.cantidad==0) {
			System.out.println("No podemos realizar la operacion porque la jarra con la que quieres llenar está vacía");
		}
		else {
			double posibilidadAgua=j2.capacidad-j2.cantidad;
			
			if (posibilidadAgua<=this.cantidad){
				j2.cantidad+=posibilidadAgua;
				this.cantidad-=posibilidadAgua;
				this.totalAgua+=posibilidadAgua;
				System.out.println("Jarra llenada correctamente");
			}
			else if (posibilidadAgua>this.cantidad) {
				j2.cantidad+=this.cantidad;
				this.totalAgua+=this.cantidad;
				this.cantidad=0;
				
				System.out.println("Jarra llenada correctamente");
			}
			
		}
	}
	
	//Este metodo imprime el estado de la jarra
	public String estadoJarra(Jarra j2) {
		return "Jarra A:\n"
				+ "Capacidad: "+ this.capacidad +"\n"
				+ "Cantidad: "+ this.cantidad +"\n"+
				"-------------------------------------- \n"+
				"Jarra B:\n"
				+ "Capacidad: "+ j2.capacidad +"\n"
						+ "Cantidad: "+ j2.cantidad +"\n"
				;
	}
	
	//Este metodo calcula el total de agua que se ha movido
	public String calcularAguaMovidad(Jarra j2) {
		return "El total de agua que se ha usado para llenar jarras es de: "+(this.totalAgua+j2.totalAgua)+" litros";
	}
	

}
