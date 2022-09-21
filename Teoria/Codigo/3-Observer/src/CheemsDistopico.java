import java.util.LinkedList;

public class CheemsDistopico implements Sujeto{

	LinkedList<CasaCiudadano> casasCiudadanos = new LinkedList<CasaCiudadano>();
	String noticia;

	public LinkedList<CasaCiudadano> getCasasCiudadanos(){
		return casasCiudadanos;
	}

	public String getNoticia(){
		return noticia;
	}

	public void setNoticia(String nuevaNoticia){
		noticia = nuevaNoticia;
	}

	public void registrar(CasaCiudadano c){
		casasCiudadanos.add(c);
		System.out.println("****************************************************************"
			+ "\nLIDER, la casa " + c.getId_Casa() 
			+ " ha sido ocupada por la familia " + c.getFamilia() + "\n"
			+ "****************************************************************");
	}

	public void remover(CasaCiudadano c){
		System.out.println("\n****************************************************************************"
			+ "\nLIDER, la familia " + c.getFamilia() 
			+ " de la casa " + c.getId_Casa() 
			+ " ha sido capturada por traicion.\n"
			+ "****************************************************************************");
		casasCiudadanos.remove(c);
	}
	
	public void notificar(){
		if(casasCiudadanos.size() > 0){
			System.out.println("****************************************"
				+ "\n********Pantallas de ciudadanos.********\n"
				+ "****************************************");
			for(CasaCiudadano c : casasCiudadanos){
				c.actualizar();
			}
		}
	}
}