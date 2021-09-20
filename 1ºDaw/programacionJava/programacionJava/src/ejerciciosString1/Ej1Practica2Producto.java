package ejerciciosString1;

public class Ej1Practica2Producto {
	private String codigo;
	private String categoria;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
// este constructor realmente es innecesario
	public Ej1Practica2Producto(String codigo, String categoria) {
		this.codigo=codigo;
		this.categoria=categoria;
	}
	public Ej1Practica2Producto() {
	}
	/**
	 * Comprueba si el codigo es valido
	 * @return devuelve el mensaje diciendo si el codigo es o no correcto
	 */
	public String compruebaCodigo() {
		int cuentaNumeros=0;
		String resultado;
		if (codigo.length()>=5 && codigo.length()<=12) {
			for (int i=0; i<codigo.length();i++) {
				if (Character.isDigit(codigo.charAt(i))) {
					cuentaNumeros++;
				}
			}
			if (cuentaNumeros>=3) {
				resultado="El codigo de producto si es correcto";
			}
			else {
				resultado="El codigo de producto no es correcto debido a que debe contener 3 numeros";
			}
		}
		else {
			resultado="El código de producto no es correcto debido a su tamaño que tiene que estar entre 5 y 12";
		}
		return resultado;
		
		
	}
	
	public String compruebaCategoria() {
		String resultadoCategoria="La categoria no es correcta";
		if (categoria.charAt(0)=='C'&& categoria.length() >=2 && categoria.length()<=5) {
			categoria=categoria.toLowerCase();
			int fin=0;
			int i=1;
			while (i<categoria.length()&& fin !=1) {
				if ((categoria.charAt(i)=='a') || (categoria.charAt(i)=='e')|| (categoria.charAt(i)=='i') || 
						(categoria.charAt(i)=='o')|| (categoria.charAt(i)=='u')) {
					i++;
				}
				else {
					fin =1;
				}
			}
			if (fin==0) {
				resultadoCategoria="La categoría es correcta";
			}
			
		}
		return resultadoCategoria;
		
	}

}
