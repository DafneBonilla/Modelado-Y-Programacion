public class MotorDeportivo implements Motor{
	
	String tipo = "";

	@Override
	public void crearMotor(){
		tipo = "Motor deportivo";
	}

	@Override
	public void getTipo(){
		System.out.println(tipo);
	}
}