public class Producto implements Articulo{
	
	private String nombre;
	private double precio;

	public Producto(String nombre, double precio){
		this.nombre = nombre;
		this.precio = precio;
	}

	public String mostrarInformacion(){
		return ("***ARTICULO*** Nombre: " + nombre +
			" Precio: " + precio);
	}

	public double mostrarPrecio(){
		return precio;
	}
}