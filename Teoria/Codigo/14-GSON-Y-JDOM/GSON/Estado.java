
import java.util.LinkedList;

public class Estado{
	int id;
	String nombre;
	String capital;
	int superficie;
	int poblacion;
	LinkedList ciudades;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getCapital(){
		return capital;
	}

	public void setCapital(String capital){
		this.capital = capital;
	}

	public int getSuperficie(){
		return superficie;
	}

	public void setSuperficie(int superficie){
		this.superficie = superficie;
	}

	public int getPoblacion(){
		return poblacion;
	}

	public void setPoblacion(int poblacion){
		this.poblacion = poblacion;
	}

	public LinkedList getCiudades(){
		return ciudades;
	}

	public void setCiudades(LinkedList ciudades){
		this.ciudades = ciudades;
	}

}