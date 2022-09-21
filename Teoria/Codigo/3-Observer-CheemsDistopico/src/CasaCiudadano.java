public class CasaCiudadano implements Observador{
	private String id_Casa;
	private String familia;
	private CheemsDistopico lider;
	private String noticia;

	public CasaCiudadano(String id_Casa, String familia, CheemsDistopico lider){
		this.id_Casa = id_Casa;
		this.familia = familia;
		this.lider = lider;
		lider.registrar(this);
		noticia = lider.getNoticia();
	}
	
	@Override
	public void actualizar(){
		noticia = lider.getNoticia();
		verNoticia();
	}

	public String getId_Casa(){
		return id_Casa;
	}

	public String getFamilia(){
		return familia;
	}

	public void mostrarDesinteres(){
		lider.remover(this);
	}

	public void verNoticia(){
		System.out.println("FAMILIA: " + familia 
			+ "\nCASA: " + id_Casa
			+ "\nEl lider ha publicado las noticias del dia: \n" 
			+ noticia);
	}
}