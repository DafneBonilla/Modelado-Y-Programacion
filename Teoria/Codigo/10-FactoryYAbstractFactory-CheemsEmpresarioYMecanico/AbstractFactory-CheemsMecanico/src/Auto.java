public class Auto{
	private LLanta llanta;
	private Carroceria carroceria;
	private Motor motor;

	public Auto(LLanta llanta, Carroceria carroceria, Motor motor){
		this.llanta = llanta;
		this.carroceria = carroceria;
		this.motor = motor;
	}

	public void muestraAuto(){
		System.out.println("El auto construido es el siguiente: ");
		llanta.getTipo();
		carroceria.getTipo();
		motor.getTipo();
	}
}