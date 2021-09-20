package Ej3DiagramaClases;

public class CodigoJava_JavierCampos {
	
	/**
	 public class Factura{
	 private int coFatura;
	 private  Double igv=18.00;
	 private double descuento=0;
	 
	 public Cliente cliente;
	 
	 public Factura(int coFactura, Double igv, double descuento, Cliente cliente){
	 	this.coFactura=coFactura;
	 	this.igv=igv;
	 	this.descuento=descuento;
	 	this.cliente=cliente;
	 }
	 
	 private ArrayList<DetalleFactura> detalles = new ArrayList();
	 
	 public void addDetalleFactura(DetalleFactura detalle){
		this.grupos.add(detalle);
		}
	 }
	 
	 --------------------------------
	 
	 public class DetalleFactura{
	 private int noltem;
	 private int cantidad=0;
	 private Double descuento;
	 
	 public Factura factura;
	 public Producto producto;
	 
	 public DetalleFactura(int noltem, int cantidad, Double descuento,
	 Factura factura, Producto producto){
	 this.noltem=noltem;
	 this.cantidad=cantidad;
	 this.descuento=descuento;
	 this.factura=factura;
	 this.producto=producto;
	 }
	 
	 }
	 
	 --------------------------------
	 
	 public class Cliente{
	 private int codCliente;
	 private String direccion;
	 private Long telefono;
	 
	 public Pais pais;
	 
	 public Cliente(int codCliente, String direccion, Long telefono, Pais pais){
	 this.codCliente=codCliente;
	 this.direccion=direccion;
	 this.telefono=telefono;
	 this.pais=pais;
	 }
	 
	  private ArrayList<Factura> factura = new ArrayList();
	 
	 public void addFactura(Factura factura){
		this.grupos.add(factura);
		}
	 
	 
	 }
	 
	 ------------------------------
	 
	 public class Pais{
	 private int codPais;
	 private String descripcion;
	 
	 public Pais(int codPais, String descripcion){
	 this.codPais=codPais;
	 this.descripcion=descripcion;
	 }
	 
	  private ArrayList<Pais> pais = new ArrayList();
	 
	 public void addPais(Pais pais){
		this.grupos.add(pais);
		}
	 
	 }
	 
	 -----------------------------------
	 
	 public class PersonaNatural extends Cliente{
	 private String nombre;
	 private String dni;
	 
	 public PersonaNatural(){
	 super();
	 }
	 
	 public PersonaNatural(String nombre, String dni){
	 this.nombre=nombre;
	 this.dni=dni;
	 }
	 
	 
	 }
	 
	 -------------------------------
	 
	 public class PersonaJuridica extends Cliente{
	 private String razonSocial;
	 private String ruc;
	 
	 public PersonaJuridica(){
	 super();
	 }
	 
	 public PersonaJuridica(String razonSocial, String ruc){
	 this.razonSocial=razonSocial;
	 this.ruc=ruc;
	 }
	 
	 }
	 
	 -------------------------------------
	 
	 public class Producto{
	 private int codProducto;
	 private String descripcion;
	 private String um;
	 private double pu=0.00;
	 private String presentacion;
	 
	 public Producto(int codProducto, String descripcion, String um, double pu, String presentacion){
	 this.codProducto=codProducto;
	 this.descripcion=descripcion;
	 this.um=um;
	 this.pu=pu;
	 this.presentacion=presentacion;
	 }
	 
	 private ArrayList<DetalleFactura> detalles = new ArrayList();
	 
	 public void addDetalleFactura(DetalleFactura detalle){
		this.grupos.add(detalle);
		}
	 
	 }
	 **/

}
