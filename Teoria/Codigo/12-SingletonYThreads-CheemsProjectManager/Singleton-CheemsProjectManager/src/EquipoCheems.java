import java.util.Scanner;

public class EquipoCheems{
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int opcion;

		do{
			System.out.println("Ingrese la opcion deseada.\n" + 
				"1.- Iniciar sesion.\n" +
				"0.- Salir\n");

			String opcionUsuario = sc.nextLine();

			opcion = Integer.parseInt(opcionUsuario);

			switch(opcion){
				case 1:
				Empleado[] empleados = {new Empleado("Hugo", 1), new Empleado("Maria", 2),
								new Empleado("Clara", 3), new Empleado("Jose", 4),
								new Empleado("Juan", 5), new Empleado("Manuel", 6),
								new Empleado("Gabriela", 7), new Empleado("Esther", 8)};

					//Comienza la ejecucion de los hilos
					for(Empleado e : empleados){
						e.start();
					}

					//Termina la ejecucion de los hilos
					for(Empleado e : empleados){
						try{
							e.join();
						} catch(InterruptedException ex){
							ex.printStackTrace();
						}
					}

					break;

				case 0:
					break;

				default:
					System.out.println("Elige una opcion valida.\n");
					break;
			}

		} while(opcion != 0);


	}
}