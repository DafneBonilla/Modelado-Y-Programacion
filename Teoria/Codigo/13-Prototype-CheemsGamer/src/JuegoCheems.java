import java.util.Random;

public class JuegoCheems{

	private Elem[] nivel;
	private BDEnemigos enemigos = new BDEnemigos();
	private BDTesoros tesoros = new BDTesoros();

	public BDEnemigos getEnemigos(){
		return enemigos;
	}

	public BDTesoros getTesoros(){
		return tesoros;
	}

	private void generarNivel(int tam){
		Generador generador = new Generador();

		Random r = new Random();

		nivel = new Elem[tam];
		for(int i = 0; i < nivel.length; i++){
			int azar = r.nextInt(5);
			if(azar <= 2){
				Enemigo nEnemigo = generador.getEnemigoCueva(enemigos, r.nextInt(2)+1);
				nivel[i] = nEnemigo;
			} else{
				Tesoro nTesoro = generador.getTesoroCueva(tesoros, r.nextInt(2)+1);
				nivel[i] = nTesoro;
			}
		}

		System.out.println("\nLos elementos en este nivel son los siguientes:");
		for(int i = 0; i < nivel.length; i++){
			System.out.println(nivel[i].mostrarInfo());
		}

	}
	public static void main(String[] args){
		JuegoCheems proto = new JuegoCheems();

		System.out.println("*****LOS RECURSOS ORIGINALES*****");
		proto.getEnemigos().imprimirBD();
		proto.getTesoros().imprimirBD();
		proto.generarNivel(10);
	}
}