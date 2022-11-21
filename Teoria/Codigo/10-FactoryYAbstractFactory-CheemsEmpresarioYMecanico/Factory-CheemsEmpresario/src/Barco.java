public class Barco extends Transporte{
	private long id;
	private String manejador;
	private String rutasMaritimas = "";

	public Barco(long id, String manejador){
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
		if("CHINA".equalsIgnoreCase(destino)){
			setRutasMaritimas("Puerto de Hong Kong,...");
		} else if ("BRASIL".equalsIgnoreCase(destino)){
			setRutasMaritimas("Puerto De Santos,...");			
		} else if ("INDIA".equalsIgnoreCase(destino)){
			setRutasMaritimas("Puerto de Calcuta,...");
		} else{
			setRutasMaritimas("No hay ruta disponible.");
		}
	}

	@Override
	public String getRuta(){
		return getRutasMaritimas();
	}

	public String getRutasMaritimas(){
		return rutasMaritimas;
	}

	public void setRutasMaritimas(String ruta){
		this.rutasMaritimas = ruta;
	}
}