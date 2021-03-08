package Examen5Marzo;

public class PersonalDireccion extends Profesor{
private String ubicacion;
private String competencias;

public PersonalDireccion() {
	
}

public String getUbicacion() {
	return ubicacion;
}

public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
}

public String getCompetencias() {
	return competencias;
}

public void setCompetencias(String competencias) {
	this.competencias = competencias;
}

@Override
public String toString() {
	return "PersonalDireccion [ubicacion=" + ubicacion + ", competencias=" + competencias + ", getDepartamento()="
			+ getDepartamento() + ", getModulo()=" + getModulo() + ", getCurso()=" + getCurso() + ", getNombre()="
			+ getNombre() + ", getEdad()=" + getEdad() + ", getGenero()=" + getGenero() + ", getHorario()="
			+ getHorario() + ", getCodigoIdentificacion()=" + getCodigoIdentificacion() + ", getPass()=" + getPass()
			+ "]";
}


}
