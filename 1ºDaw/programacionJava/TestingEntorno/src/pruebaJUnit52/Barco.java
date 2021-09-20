package pruebaJUnit52;

public class Barco {
	String marca;
	String modelo;
	float eslora;
	
	public Barco ( String marca, String modelo, float eslora) {
		this.marca = marca;
		this.eslora = eslora;
		this.modelo = modelo;
	}
	
	public String ObtenerMarca() {
		return marca;
	}
	
	public float ObtenerEslora() {
		return eslora;
	}
	
	public String ObtenerModelo() {
		return modelo;
	}
	
	public String toString() {
		return "Marca: " + this.marca + " Modelo: "+ this.modelo + " Eslora: " + this.eslora;
	}
	
	public int compareTo(Object o) {
		Barco barco = (Barco) o;
		int compare;
		if (this.eslora > barco.eslora) {
			compare = 1;
		}
		else if(this.eslora == barco.eslora) {
			compare = 0;
		}
		else {
			compare = -1;
		}
		return compare;
	}

}
