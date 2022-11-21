public class AutomotrizCheems{
	public static void main(String[] args){

		//Fabrica productora.
		CheemsMecanico cheems = new CheemsMecanico();

		//Fabricas para cada parte del auto.
		AbstractFactory fabricaLLantas = 
							cheems.getFactory("LLANTA");
		AbstractFactory fabricaCarrocerias = 
							cheems.getFactory("CARROCERIA");
		AbstractFactory fabricaMotores = 
							cheems.getFactory("MOTOR");

		System.out.println("***EL AUTO 1 PARA EL CLIENTE 1 ES EL SIGUIENTE:***");
		//Se crean las llantas.
		LLanta llantasNuevas1 = 
					(LLanta)fabricaLLantas.getComponente("monstruo");
		llantasNuevas1.crearLLanta();

		//Se crea la carroceria.
		Carroceria carroceriaNueva1 = 
					(Carroceria)fabricaCarrocerias.getComponente("deportiva");
		carroceriaNueva1.crearCarroceria();

		//Se crea el motor.
		Motor motorNuevo1 = 
					(Motor)fabricaMotores.getComponente("monstruo");
		motorNuevo1.crearMotor();

		//Se crea el auto nuevo con esas partes.
		Auto autoNuevo1 = 
					new Auto(llantasNuevas1, carroceriaNueva1, motorNuevo1);
		autoNuevo1.muestraAuto();

		System.out.println("\n***EL AUTO 2 PARA EL CLIENTE 2 ES EL SIGUIENTE:***");
		//Se crean las llantas.
		LLanta llantasNuevas2 = 
					(LLanta)fabricaLLantas.getComponente("deportiva");
		llantasNuevas2.crearLLanta();

		//Se crea la carroceria.
		Carroceria carroceriaNueva2 = 
					(Carroceria)fabricaCarrocerias.getComponente("deportiva");
		carroceriaNueva2.crearCarroceria();

		//Se crea el motor.
		Motor motorNuevo2 = 
					(Motor)fabricaMotores.getComponente("deportivo");
		motorNuevo2.crearMotor();

		//Se crea el auto nuevo con esas partes.
		Auto autoNuevo2 = 
					new Auto(llantasNuevas2, carroceriaNueva2, motorNuevo2);
		autoNuevo2.muestraAuto();

	}
}