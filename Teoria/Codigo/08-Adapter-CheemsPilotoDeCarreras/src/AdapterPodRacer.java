public class AdapterPodRacer implements Nave{

	private PodRacer pod;

	public AdapterPodRacer(PodRacer pod){
		this.pod = pod;
	}

	@Override
	public void impulsar(){
		String instruccion = pod.acelerar() + 
			"\nEl PodRacer activa su sistema de propulsion intergalactico.";
		System.out.println(instruccion);
	}

	@Override
	public void frenar(){
		String instruccion = pod.frenar() + 
			"\nPreparandose para la suspension.";
		System.out.println(instruccion);
	}

	@Override
	public void navegar(){
		String instruccion = pod.manejar() + 
			"\nActivando sistemas de navegacion." +
			"\nActivando localizador." + 
			"\nActivando giroscopio." + 
			"\nPod-Racer listo para navegacion intergalactica.";
		System.out.println(instruccion);
	}

	@Override
	public void hiperimpulsor(){
		System.out.println("\n***HIPERIMPULSOR***" + 
			"\nActivando hiperimpulsor." +
			"\nObjetivo listo." +
			"\nActivar velocidad luz.");
	}

	@Override
	public void atacar(){
		System.out.println("\n***ATAQUE***" + 
			"\nSistema de ataque activado." +
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