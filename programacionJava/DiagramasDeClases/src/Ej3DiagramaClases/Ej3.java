package Ej3DiagramaClases;

public class Ej3 {
	/**
	 4//
	public class Cuenta{
		private int ccc;
		private  Date fechaApertura;
		private double saldo;
	}

	public class Apunte{
		private int numero;
		private  String descripcion;
		private double importe;
		public Cuenta cuenta;
	}
	
	5//
	public class Libro{
		private String isbn;
		private  String titulo;
		private String autor;
		private String editorial;
		private int year;
		public java.util.Collection acercaDe = new java.util.TreeSet();

	}
	
	public class Tema{
	private int id;
	private String descripcion;
	
	}
	
	
	6//
	public class Asignatura{
		private String id;
		private String nombre;
		private int creditos;
		private String caracter;
		private String curso;
		
		private ArrayList<Grupo> grupos= new ArrayList();
		
		public Asignatura(String id, String nombre, int creditos, String caracter, String curso, Grupo grupo){
		this.id=id;
		this.nombre=nombre;
		this.creditos=creditos;
		this.caracter=caracter;
		this.curso=curso;
		this.grupos.add(grupo);
		}
		
		public void addGrupo(Grupo grupo){
		this.grupos.add(grupo);
		}
	}
	
	public class Grupo{
		private String id;
		private String tipo;
		private Asignatura asignatura;
		
		public Grupo(String id, Strig tipo, Asignatura asignatura){
		this.id=id;
		this.tipo=tipo;
		this.asignatura=asignatura;
		}
		
		private ArrayList <Asignada> asignadas = new ArrayList();
		
		public void  asignar(Asignada asignada){
			this.asignadas.add(asignada);
			}
	}
	
	public class Asignada{
		private String dia;
		private String hora;
		
		public Grupo grupo;
		public Aula aula;
		
		public Asignada(String dia, String hora, Grupo grupo, Aula aula){
			this.dia=dia;
			this.hora=hora;
			this.grupo=grupo;
			this.aula=aula;
		}
	}
	
	public class Aula{
		private String id;
		private int capacidad;
		
		public Aula(String id, int capacidad){
			this.id=id;
			this.capacidad=capacidad;
			}
		
		private ArrayList<Asignada> asignadas = new ArrayList();
		
		public void asignar(asignada){
			this.asignadas.add(asignada);
			}
		
	
	}
	
	public class Profesor{
	private String nrp;
	private String nombre;
	private String categoria;
	private String area;
	
	public Departamento pertenece;
	public Departamento dirige;
	
	public Profesor(String nrp, String nombre, String categoria, String area){
		this.nrp=nrp;
		this.nombre=nombre;
		this.categoria=categoria;
		this.area=area;
	}
	
	public void dirige(Departamento dpto){
		this.dirige=dpto;
	}
	
	
	
	}
	
	public class Departamento{
		private String id;
		private String nombre;
		private Profesor jefe;
		
		private ArrayList<Profesor> miembros = new ArrayList();
		
		public Departamento(String id, String nombre, Profesor jefe){
			this.id=id;
			this.nombre=nombre;
			this.jefe=jefe;
		}
		
		public void addMiembro(Profesor profesor){
			this.miembros.add(Profesor);
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	**/
}
