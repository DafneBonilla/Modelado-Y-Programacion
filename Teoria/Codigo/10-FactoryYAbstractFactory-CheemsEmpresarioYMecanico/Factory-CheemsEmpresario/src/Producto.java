public class Producto{
	private String nombre;
	private String tipoDeEnvio;
	private String destino;

	public Producto(String nombre, String tipoDeEnvio, String destino){
		this.nombre = nombre;
		this.tipoDeEnvio = tipoDeEnvio;
		this.destino = destino;
	}

	public String getNombre(){
		return nombre;
	}

	public String getTipoDeEnvio(){
		return tipoDeEnvio;
	}

	public String getDestino(){
		return destino;
	}

	@Override
	public String toString(){
		return "NOMBRE= " + this.getNombre() 
		+ ", \nTIPO DE ENVIO= " + this.getTipoDeEnvio() 
		+ ", \nDESTINO= " + this.getDestino() + "\n";
	}
}