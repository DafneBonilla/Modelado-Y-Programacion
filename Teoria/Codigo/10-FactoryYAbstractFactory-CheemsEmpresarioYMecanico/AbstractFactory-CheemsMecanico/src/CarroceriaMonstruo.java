public class CarroceriaMonstruo implements Carroceria{
	
	String tipo = "";

	@Override
	public void crearCarroceria(){
		tipo = "Carroceria monstruo";
	}

	@Override
	public void getTipo(){
		System.out.println(tipo);
	}
}