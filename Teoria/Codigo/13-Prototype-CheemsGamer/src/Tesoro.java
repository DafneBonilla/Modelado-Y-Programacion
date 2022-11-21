public class Tesoro implements Cloneable, Elem{
	
	private String nombre;
	private int cantidad;
	private int valor;

	public Tesoro(String nombre, int cantidad, int valor){
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valor = valor;
	}

	public String getNombre(){
		return nombre;
	}

	public int getCantidad(){
		return cantidad;
	}

	public int getValor(){
		return valor;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}

	public void setValor(int valor){
		this.valor = valor;
	}

	@Override
	public String mostrarInfo(){
		return getNombre() +
				" x" + getCantidad() +
				" $" + getValor();
	}

	@Override
	public Object clone(){
		Tesoro clon = new Tesoro(nombre, cantidad, valor);
		return clon;
	}

}