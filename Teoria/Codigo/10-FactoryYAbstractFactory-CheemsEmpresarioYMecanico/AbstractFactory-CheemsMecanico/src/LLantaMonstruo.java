public class LLantaMonstruo implements LLanta{
	
	String tipo = "";

	@Override
	public void crearLLanta(){
		tipo = "LLanta monstruo";
	}

	@Override
	public void getTipo(){
		System.out.println(tipo);
	}
}