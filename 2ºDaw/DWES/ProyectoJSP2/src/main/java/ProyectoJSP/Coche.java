package ProyectoJSP;

import java.time.LocalDate;

public class Coche {
	private String marca;
	private String modelo;
	private int kilometros;
	private int precio;
	private String color;
	private LocalDate fechaSubida;
	
	public Coche() {
		
		this.marca = null;
		this.modelo = null;
		this.kilometros = 0;
		this.precio = 0;
		this.color = null;
		this.fechaSubida=null;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(LocalDate fechaSubida) {
		this.fechaSubida = fechaSubida;
	}
	
	
	
	
	

}
