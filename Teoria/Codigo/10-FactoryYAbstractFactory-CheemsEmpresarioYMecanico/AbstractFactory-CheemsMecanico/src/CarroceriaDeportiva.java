public class CarroceriaDeportiva implements Carroceria{
	
	String tipo = "";

	@Override
	public void crearCarroceria(){
		tipo = "Carroceria deportiva";
	}

	@Override
	public void getTipo(){
		System.out.println(tipo);
	}
}