public class Cheems implements Personaje{
	
	private String descripcion;
	private int fuerza;
	private int destreza;
	private int salud;
	private int inteligencia;
	private int carisma;

	public Cheems(){
		fuerza = 1;
		destreza = 1;
		salud = 1;
		inteligencia = 1;
		carisma = 1;
		descripcion = "Soym Cheems";
	}

	public String getDescripcion(){
		return descripcion;
	}

	public int getFuerza(){
		return fuerza;
	}

	public int getDestreza(){
		return destreza;
	}

	public int getSalud(){
		return salud;
	}

	public int getInteligencia(){
		return inteligencia;
	}

	public int getCarisma(){
		return carisma;
	}
}