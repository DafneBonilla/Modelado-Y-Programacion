import java.lang.Math;
import java.util.Scanner;

public class JuegoCheems{
	
	public static void main(String[] args){

		Personaje cheems = new Cheems();

		System.out.println("*****BIENVENIDO AL JUEGO CHEEMS SOULS*****" + 
			"\nEs momento de crear tu personaje.");

		System.out.println("\n*****PERSONAJE INICIAL*****" + 
			"\n" + cheems.getDescripcion() + 
			"\nfuerza: " + cheems.getFuerza() +
			"\ndestreza: " + cheems.getDestreza() + 
			"\nsalud: " + cheems.getSalud() + 
			"\ninteligencia: " + cheems.getInteligencia() + 
			"\ncarisma: " + cheems.getCarisma());

		int numPociones = (int)(Math.random()*10)%3;
		
		String oraculo = "\nEl oraculo te ha dado " + (numPociones+1) + ((numPociones == 0) ? " pocion." : " pociones.");
		System.out.println(oraculo);

		for(int i = 0; i <= numPociones; i++){
			int pocion = (int)(Math.random()*10)%5;

			switch(pocion){
				case 0:
					cheems = new PocionFuerza(cheems);
					break;

				case 1:
					cheems = new PocionDestreza(cheems);
					break;

				case 2:
					cheems = new PocionSalud(cheems);
					break;

				case 3:
					cheems = new PocionInteligencia(cheems);
					break;

				case 4:
					cheems = new PocionCarisma(cheems);
					break;

				default:
					break;
			}

			System.out.println("\n*****POCION " + (i+1) + "*****" + 
	    	"\n" + cheems.getDescripcion() + 
			"\nfuerza: " + cheems.getFuerza() +
			"\ndestreza: " + cheems.getDestreza() + 
			"\nsalud: " + cheems.getSalud() + 
			"\ninteligencia: " + cheems.getInteligencia() + 
			"\ncarisma: " + cheems.getCarisma());
		}

		System.out.println("\n*****PERSONAJE FINAL*****" + 
			"\n" + cheems.getDescripcion() + 
			"\nfuerza: " + cheems.getFuerza() +
			"\ndestreza: " + cheems.getDestreza() + 
			"\nsalud: " + cheems.getSalud() + 
			"\ninteligencia: " + cheems.getInteligencia() + 
			"\ncarisma: " + cheems.getCarisma());

	}
}