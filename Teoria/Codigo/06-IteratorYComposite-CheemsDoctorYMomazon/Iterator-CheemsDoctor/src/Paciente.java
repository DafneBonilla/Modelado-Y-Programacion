public class Paciente{
	private String nombre;
	private long telefono;

	public Paciente(String nombre, long telefono){
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String toString(){
		return ("Nombre: " + nombre + " telefono: " + telefono);
	}
}