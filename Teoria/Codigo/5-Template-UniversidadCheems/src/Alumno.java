public class Alumno{
	private int noCuenta;
	private String nombre;
	private String curp;
	private String carrera;
	private double promedio;

	public Alumno (int noCuenta, String nombre, String curp, String carrera, double promedio){
		this.noCuenta = noCuenta;
		this.nombre = nombre;
		this.curp = curp;
		this.carrera = carrera;
		this.promedio = promedio;
	}

	public int getNoCuenta(){
		return noCuenta;
	}

	public String getNombre(){
		return nombre;
	}

	public String getCurp(){
		return curp;
	}

	public String getCarrera(){
		return carrera;
	}

	public double getPromedio(){
		return promedio;
	}

	public String toString(){
		return "\nNo. de cuenta: " + getNoCuenta()
			+ "\nNombre: " + getNombre()
			+ "\nCURP: " + getCurp()
			+ "\nCarrera: " + getCarrera()
			+ "\nPromedio: " + getPromedio() + "\n";
	}
}