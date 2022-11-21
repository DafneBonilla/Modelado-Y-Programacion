public class LLantaDeportiva implements LLanta{
	
	String tipo = "";

	@Override
	public void crearLLanta(){
		tipo = "LLanta deportiva";
	}

	@Override
	public void getTipo(){
		System.out.println(tipo);
	}
}