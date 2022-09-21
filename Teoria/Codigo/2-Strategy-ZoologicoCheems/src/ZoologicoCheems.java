import java.util.Scanner;

public class ZoologicoCheems{

	/* Objeto de contexto. */
	private Animal ditto;

	private void transformarcion(Animal nuevoAnimal){
		ditto = nuevoAnimal;
	}

	public String mostrarAnimal(){
		return ditto.mostrarInformacion();
	}

	public static void main(String[] args){
		ZoologicoCheems zoo = new ZoologicoCheems();
		Scanner sc = new Scanner(System.in);
		int opcion;

		System.out.println("***BIENVENIDO AL ZOOLOGICO CHEEMS.***");

		do{
			System.out.println("Ingrese una de las siguientes " + 
				"opciones para mostrar al animal:\n" + 
				"1.- Oso.\n" +
				"2.- Flamenco.\n" + 
				"3.- Cocodrilo.\n" + 
				"4.- Rana.\n" +
				"5.- Elefante.\n" +
				"0.- Salir\n");
				
				

				while (true){
					try {
						String opcionUsuario = sc.nextLine();
						opcion = Integer.parseInt(opcionUsuario);
						break;
					}catch (NumberFormatException ex){
						System.out.println("Ingresa un numero valido.\n" + 
							"1.- Oso.\n" +
							"2.- Flamenco.\n" + 
							"3.- Cocodrilo.\n" + 
							"4.- Rana.\n" +
							"5.- Elefante.\n" +
							"0.- Salir\n");
					}
				}

				switch(opcion){
					case 1:
						zoo.transformarcion(new Oso());
						System.out.println(zoo.mostrarAnimal());
						break;

					case 2:
						zoo.transformarcion(new Flamenco());
						System.out.println(zoo.mostrarAnimal());
						break;

					case 3:
						zoo.transformarcion(new Cocodrilo());
						System.out.println(zoo.mostrarAnimal());
						break;

					case 4:
						zoo.transformarcion(new Rana());
						System.out.println(zoo.mostrarAnimal());
						break;

					case 5:
						zoo.transformarcion(new Elefante());
						System.out.println(zoo.mostrarAnimal());
						break;

					case 0:
						break;

					default:
						System.out.println("Ingresa un numero valido.\n" + 
							"1.- Oso.\n" +
							"2.- Flamenco.\n" + 
							"3.- Cocodrilo.\n" + 
							"4.- Rana.\n" +
							"5.- Elefante.\n" +
							"0.- Salir\n");
						break;

				}

		}while(opcion != 0);
	}
}