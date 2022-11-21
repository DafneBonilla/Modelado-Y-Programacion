public class Avion extends Transporte{
	private long id;
	private String manejador;
	private String listaEscalas = "";

	public Avion(long id, String manejador){
		this.id = id;
		this.manejador = manejador;
	}

	@Override
	public long getID(){
		return id;
	}

	@Override
	public String getManejador(){
		return manejador;
	}

	@Override
	public void setRuta(String destino){
		if("EUA".equalsIgnoreCase(destino)){
			setEscalas("Aeropuerto Los Angeles,...");
		} else if ("RUSIA".equalsIgnoreCase(destino)){
			setEscalas("Aeropuerto Moscu,...");			
		} else if ("CANADA".equalsIgnoreCase(destino)){
			setEscalas("Aeropuerto Vancouver,...");
		} else{
			setEscalas("No hay ruta disponible.");
		}
	}

	@Override
	public String getRuta(){
		return getEscalas();
	}

	public String getEscalas(){
		return listaEscalas;
	}

	public void setEscalas(String ruta){
		this.listaEscalas = ruta;
	}
}