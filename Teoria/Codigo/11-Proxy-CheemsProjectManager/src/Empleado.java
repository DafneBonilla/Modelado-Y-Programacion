import java.io.Serializable;

public class Empleado implements Serializable, InterfazEmpleado{

	private String rfc;
	private String nombre;

	private String recurso = "No hay recursos aun :(";

	public Empleado(String rfc, String nombre){
		this.rfc = rfc;
		this.nombre = nombre;
	}

	public void reportar() {
		System.out.println("Empleado{" + "rfc=" + rfc + ", nombre=" + nombre
							+ ", recursos= " + recurso + " }");
    }

    public void actualizarDatos(String nRecurso){
    	//simulando un sistema seguro.
    	System.out.println("***VERIFICANDO DATOS...***" + 
    						"\n***ACTUALIZANDO DATOS...***");
    	recurso = nRecurso;
    }
}