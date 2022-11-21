import java.util.Scanner;

public class Momazon {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion = 1;
		FactoryEnvios fabrica = new FactoryEnvios();

		do{
			System.out.println("Ingrese la opcion de la simulacion.\n" + 
				"1.- Prueba Transporte Nacional\n" +
				"2.- Prueba Transporte Internacional\n" +
				"3.- Prueba Transporte Express\n" +
				"0.- Salir\n");
				
				String opcionUsuario = sc.nextLine();
				try{
					opcion = Integer.parseInt(opcionUsuario);
					switch(opcion){
						case 1:
							Producto prod1 = new Producto("Bocinas", "NACIONAL", "JALISCO");
							Transporte nacional = fabrica.getTransporte(prod1);
							if(nacional.getRuta().equals("No hay ruta disponible.")){
								System.out.println("No hay rutas disponibles para ese destino.");
								break;
							}
							System.out.println("Datos entrega: " + nacional.toString());
							System.out.println("Datos del producto: " + prod1.toString());
							break;

						case 2:
							Producto prod2 = new Producto("Servidor", "INTERNACIONAL", "BRASIL");
							Transporte internacional = fabrica.getTransporte(prod2);
							if(internacional.getRuta().equals("No hay ruta disponible.")){
								System.out.println("No hay rutas disponibles para ese destino.");
								break;
							}
							System.out.println("Datos entrega: " + internacional.toString());
							System.out.println("Datos del producto: " + prod2.toString());
							break;

						case 3:
							Producto prod3 = new Producto("Monitor", "EXPRESS", "EUA");
							Transporte express = fabrica.getTransporte(prod3);
							if(express.getRuta().equals("No hay ruta disponible.")){
								System.out.println("No hay rutas disponibles para ese destino.");
								break;
							}
							System.out.println("Datos entrega: " + express.toString());
							System.out.println("Datos del producto: " + prod3.toString());
							break;

						case 0:
							break;

						default:
							System.out.println("Elige una opcion valida.\n");
							break;

					}
				} catch (NumberFormatException e){
					System.out.println("Elige una opcion valida.\n");
				}
		}while(opcion != 0);
	}
}