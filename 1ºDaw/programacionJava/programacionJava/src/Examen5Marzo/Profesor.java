package Examen5Marzo;

public class Profesor extends Empleado{
private String departamento;
private String modulo;
private String curso;


public Profesor() {
	super();
}










public String informacionProfesor() {
	return ("Nombre: "+this.getNombre() + " Edad: "+this.getEdad()+ "Genero: "+this.getGenero()+" Horario: "+this.getHorario() + 
			" Codigo Identificacion: "+this.getCodigoIdentificacion() + " Pass: "+this.getPass()) + this.toString();
}

@Override
public String toString() {
	return "Profesor [departamento=" + departamento + ", modulo=" + modulo + ", curso=" + curso + "]";
}













public String getDepartamento() {
	return departamento;
}
public void setDepartamento(String departamento) {
	this.departamento = departamento;
}
public String getModulo() {
	return modulo;
}
public void setModulo(String modulo) {
	this.modulo = modulo;
}
public String getCurso() {
	return curso;
}
public void setCurso(String curso) {
	this.curso = curso;
}



}
