package Examen5Marzo;

public class Administracion extends Empleado{
	private String ubicacion;
	private int telefono;
	private String areaResponsabilidad;
	
	public Administracion() {
		
	}
	
	

	@Override
	public String toString() {
		return "Administracion [ubicacion=" + ubicacion + ", telefono=" + telefono + ", areaResponsabilidad="
				+ areaResponsabilidad + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + ", getGenero()="
				+ getGenero() + ", getHorario()=" + getHorario() + ", getCodigoIdentificacion()="
				+ getCodigoIdentificacion() + ", getPass()=" + getPass() + "]";
	}



	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getAreaResponsabilidad() {
		return areaResponsabilidad;
	}

	public void setAreaResponsabilidad(String areaResponsabilidad) {
		this.areaResponsabilidad = areaResponsabilidad;
	}

	
}
