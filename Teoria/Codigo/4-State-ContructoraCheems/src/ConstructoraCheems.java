import java.util.Scanner;

public class ConstructoraCheems{
	public static void main(String[] args){
		Robot mechaCheems = new Robot();

		Scanner sc = new Scanner(System.in);
		int opcion;

		System.out.println("***BIENVENIDO A LA CONSOLA DE MECHA CHEEMS.***"
						+ "\nPor favor elige la opcion que deseas ejecutar.");

		do{
			System.out.println(
				"1.- Activar.\n" +
				"2.- Caminar.\n" + 
				"3.- Demoler.\n" + 
				"4.- Recolectar escombros.\n" +
				"5.- Apagar.\n" +
				"0.- Terminar simulacion.\n");

				while (true){
					try {
						String opcionUsuario = sc.nextLine();
						opcion = Integer.parseInt(opcionUsuario);
						break;
					}catch (NumberFormatException ex){
						System.out.println("Por favor elige la opcion VALIDA "
							+ "que deseas ejecutar.\n" + 
							"1.- Activar.\n" +
							"2.- Caminar.\n" + 
							"3.- Demoler.\n" + 
							"4.- Recolectar escombros.\n" +
							"5.- Apagar.\n" +
							"0.- Terminar simulacion.\n");
					}
				}

				switch(opcion){
					case 1:
						mechaCheems.activar();
						break;

					case 2:
						mechaCheems.caminar();
						break;

					case 3:
						mechaCheems.demoler();
						break;

					case 4:
						mechaCheems.recolectar();
						break;

					case 5:
						mechaCheems.apagarse();
						break;

					case 0:
						break;

					default:
						System.out.println("\nPor favor elige la opcion que deseas ejecutar.");
						break;

				}

		}while(opcion != 0);

	}
}