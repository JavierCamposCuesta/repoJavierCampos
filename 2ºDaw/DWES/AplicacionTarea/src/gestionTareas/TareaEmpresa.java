package gestionTareas;



public class TareaEmpresa extends TareaAbstract{

	private String departamento;

	public TareaEmpresa(String descripcion, String prioridad, String departamento){
		super(descripcion, prioridad);
		this.departamento=departamento;
	}

	@Override
	public String toString() {
		return "TareaEmpresa [departamento=" + departamento + super.toString();
	}

	
	//Los datos del departamento se podrán consultar y modificar
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
	

	
}
