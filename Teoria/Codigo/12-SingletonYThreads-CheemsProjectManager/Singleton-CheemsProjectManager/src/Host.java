public class Host{

	/*La variable volatil se escribe en memoria principal.
	Esto lo hace una variable compartida entre todos los threads,
	por lo que un cambio en esta variable podrá ser visto por 
	todos los procesos con acceso a la memoria principal.*/
	private volatile static Host host;

	private Empleado empleadoBono;

	private Host(Empleado e){
		empleadoBono = e;
	}

	/**
	* Metodo que provee el punto de acceso al singleton.
	* Este metodo debe ser sincronizado en cado de que 
	* dos o mas hilos accedan al metodo a la vez.
	* Bloque comprobado doble.
	*/
	public static Host obtenerHost(Empleado e){
		if(host == null){
			synchronized(Host.class){
				if(host == null){
					host = new Host(e);
				}
			}
			
		}
		return host;
	}

	/**
	 * En el caso en que el rendimiento de obtenerHost
	 * no es crtico para la aplicacion.
	 *
	public synchronized static Host obtenerHost(Empleado e){
		if(host == null)
			host = new Host(e);
		return host;
	}
	*/

	public void infoSesion(){
		if (host == null)
			System.out.println("Aun no ha iniciado sesion ningun empleado.");
		System.out.println("El empleado ganador del bono es: " + 
							empleadoBono.getUsuario()
							+ " con numero de identificacion: " + 
							empleadoBono.getIdEmpleado());
	}
}