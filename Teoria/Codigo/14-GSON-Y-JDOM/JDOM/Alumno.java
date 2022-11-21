
/**
 * Clase que modela el comportamiento de un alumno.
 * @author Arturo Lemus Pablo
 * @version 1.0, octubre 2017
 */
public class Alumno {
    private int noCuenta;
    private String nombreAlumno;
    private String carrera;
    private double promedio;
    
    /**
    * Metodo constructor de Alumno.
    */
    public Alumno(){}

    /**
    * Metodo constructor de Alumno.
    * @param noCuenta El numero de cuenta.
    * @param nombreAlumno El nombre del alumno.
    * @param carrera La carrera del alumno.
    * @param promedio El promedio del alumno.
    */
    public Alumno(int noCuenta, String nombreAlumno, String carrera, double promedio){
        this.noCuenta = noCuenta;
        this.nombreAlumno = nombreAlumno;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    /**
    * Metodo que regresa el numero de cuenta del alumno.
    * @return El numero de cuenta.
    */
    public int getNoCuenta() {
        return noCuenta;
    }

    /**
    * Metodo que asigna el numero de cuenta del alumno.
    * @param noCuenta El numero a asignar.
    */
    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
    * Metodo que regresa el nombre del alumno.
    * @return El nombre del alumno.
    */
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
    * Metodo que asigna el nombre del alumno.
    * @param nombreAlumno El nombre a asignar.
    */
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    /**
    * Metodo que regresa la carrera del alumno.
    * @return La carrera del alumno.
    */
    public String getCarrera() {
        return carrera;
    }

    /**
    * Metodo que asigna la carrera del alumno.
    * @param carrera La carrera a asignar.
    */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
    * Metodo que regresa el promedio del alumno.
    * @return El promedio del alumno.
    */
    public double getPromedio() {
        return promedio;
    }

    /**
    * Metodo que asigna el promedio del alumno.
    * @param promedio El promedio a asignar.
    */
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    /**
    * Metodo que regresa un alumno como cadena.
    * @return La cadena que representa a un alumno.
    */
    public String toString(){
        return "No. de cuenta: " + noCuenta + " Nombre: " + nombreAlumno + " Carrera: " 
            + carrera + " Promedio: " + promedio;
    }
}
