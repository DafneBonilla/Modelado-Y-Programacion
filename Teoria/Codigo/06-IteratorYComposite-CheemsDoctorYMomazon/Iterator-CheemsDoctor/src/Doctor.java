public class Doctor{
	private String nombre;
	private String rfc;

	public Doctor(String nombre, String rfc){
		this.nombre = nombre;
		this.rfc = rfc;
	}

	public String toString(){
		return ("Doctor: " + nombre + " rfc: " + rfc);
	}
}