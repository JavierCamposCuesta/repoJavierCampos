package relacionDeProblemas7;

public class Producto {
private int codigo;
private String descripcion;
private double precio;
public static double iva=20;


//Constructor 
public Producto () {
}

public Producto(String descripcion, double precio) {
	this.descripcion=descripcion;
	this.precio=precio;
}





public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public double getIva() {
	return iva;
}

public void setIva(double iva) {
	this.iva = iva;
}



@Override
public int hashCode() {
	return this.descripcion.hashCode() + (String.valueOf(this.precio).hashCode());
	

}

@Override
public boolean equals(Object obj) {
	boolean sonIguales=false;
	if (this==obj) {
		sonIguales=true;
	}
	else if(obj!=null && obj instanceof Producto && ((Producto)obj).hashCode()==this.hashCode()){
		sonIguales=true;
	}
	return super.equals(obj);
}

@Override
public String toString() {
	
	// TODO Auto-generated method stub
	return "Codigo: "+ this.hashCode() 
			+ "\nDescripción: "+ this.descripcion 
			+ "\nPrecio sin Iva: "+ this.precio
			+ "\nIva: "+this.iva;
}

public void modificarAtributos() {
	
}

public String precioVenta() {
	double precioFinal = (this.precio+(this.precio*iva)/100);
	return "El precio con iva es de: " + precioFinal;
}


}
