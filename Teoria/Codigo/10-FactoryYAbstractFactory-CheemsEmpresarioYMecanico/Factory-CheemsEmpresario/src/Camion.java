public class Camion extends Transporte{
	private long id;
	private String manejador;
	private String listaAutopistas = "";

	public Camion(long id, String manejador){
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
		if("NUEVO LEON".equalsIgnoreCase(destino)){
			setListaAutopistas("Autopista Queretaro,...");
		} else if ("JALISCO".equalsIgnoreCase(destino)){
			setListaAutopistas("Autopista Mexico-Toluca,...");			
		} else if ("YUCATAN".equalsIgnoreCase(destino)){
			setListaAutopistas("Autopista Mexico-Puebla,...");
		} else{
			setListaAutopistas("No hay ruta disponible.");
		}
	}

	@Override
	public String getRuta(){
		return getListaAutopistas();
	}

	public String getListaAutopistas(){
		return listaAutopistas;
	}

	public void setListaAutopistas(String mapa){
		this.listaAutopistas = mapa;
	}
}