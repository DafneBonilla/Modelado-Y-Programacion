import java.io.Serializable;

public class EmpleadoProxy implements Serializable, InterfazEmpleado{
	private Empleado empleadoReal;
	private String recurso;

	public EmpleadoProxy(Empleado empleadoReal){
		this.empleadoReal = empleadoReal;
	}

	public void reportar(){
		empleadoReal.reportar();
	}

	public void actualizarDatos(String nRecurso){
		recurso = nRecurso;
	}

	public void actualizarEnReales(){
		empleadoReal.actualizarDatos(recurso);
	}
}