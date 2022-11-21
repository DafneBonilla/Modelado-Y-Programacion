public class MotorMonstruo implements Motor{
	
	String tipo = "";

	@Override
	public void crearMotor(){
		tipo = "Motor monstruo";
	}

	@Override
	public void getTipo(){
		System.out.println(tipo);
	}
}