public class Xwing implements Nave{
	
	@Override
	public void impulsar(){
		System.out.println("\n***IMPULSO***" + 
			"\nSistema de propulsion intergalactico activado." +
			"\nMotores de fusion en linea." +
			"\nAceleracion de X-Wing activada.");
	}

	@Override
	public void frenar(){
		System.out.println("\n***FRENADO***" + 
			"\nEl X-Wing detiene su sistema de propulsion. " +
			"\nPreparandose para la suspension.");
	}

	@Override
	public void navegar(){
		System.out.println("\n***NAVEGACION***" +
			"\nActivando sistemas de navegacion." +
			"\nActivando localizador." + 
			"\nActivando giroscopio." + 
			"\nX-Wing listo para navegacion intergalactica.");
	}

	@Override
	public void hiperimpulsor(){
		System.out.println("\n***HIPERIMPULSOR***" + 
			"\nActivando hiperimpulsor." +
			"\nObjetivo listo." +
			"\nActivar velocidad luz de X-Wing.");
	}

	@Override
	public void atacar(){
		System.out.println("\n***ATAQUE***" + 
			"\nSistema de ataque de X-Wing activado." +
			"\nObjetivo localizado." +
			"\nDisparando desintegrador.");
	}

	@Override
	public void pruebaDeSistemas(){
		System.out.println("***INICIANDO SECUENCIA DE PRUEBAS DEL SISTEMA***");
		impulsar();
		navegar();
		atacar();
		frenar();
		hiperimpulsor();
	}

}