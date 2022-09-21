import java.util.LinkedList;
import java.util.Scanner;

public class UniversidadCheems{

	private LinkedList<Alumno> llenarBDAlumnos(){
		LinkedList<Alumno> alumnos = new LinkedList<Alumno>();
		Alumno a1 = new Alumno(1111, "Fulano", "GKHT654312HBLPRA55", "Ciencias de la computacion", 9.1);
		Alumno a2 = new Alumno(2222, "Mengana", "LAHF759275SMFJEE21", "Medicina", 9.8);
		Alumno a3 = new Alumno(3333, "Zutano", "UUJH998745PEURHJ90", "Filosofia", 7.5);
		Alumno a4 = new Alumno(4444, "Perengana", "PLOI907856TRFGHY86", "Relaciones internacionales", 9.6);
		Alumno a5 = new Alumno(5555, "Policarpo", "QWER214365NMKJUH45", "Arquitectura", 8.2);
		Alumno a6 = new Alumno (6666, "Cinzano", "RTGVCD758697UKMNHY06", "Ingenieria Mecatronica", 7.9);

		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);
		alumnos.add(a5);
		alumnos.add(a6);

		return alumnos;
	}

	public static void main(String[] args){
		UniversidadCheems uni = new UniversidadCheems();
		LinkedList<Alumno> alumnos = uni.llenarBDAlumnos();
		Titulacion tramiteTitulacion;

		Scanner sc = new Scanner(System.in);
		int opcion;

		System.out.println("***BIENVENIDO AL SISTEMA DE TITULACION.***"
						+ "\nPor favor elige la opcion de titulacion de tu preferncia.");

		do{
			System.out.println(
				"1.- Tesis.\n" +
				"2.- Apoyo a la docencia.\n" + 
				"3.- Servicio social extendido.\n" + 
				"4.- Battle Royale.\n" +
				"0.- Salir\n");

				while (true){
					try {
						String opcionUsuario = sc.nextLine();
						opcion = Integer.parseInt(opcionUsuario);
						break;
					}catch (NumberFormatException ex){
						System.out.println("Ingresa un NUMERO valido.\n" + 
							"1.- Tesis.\n" +
							"2.- Apoyo a la docencia.\n" + 
							"3.- Servicio social extendido.\n" + 
							"4.- Battle Royale.\n" +
							"0.- Salir\n");
					}
				}

				switch(opcion){
					case 1:
						tramiteTitulacion = new Tesis();
						tramiteTitulacion.titulacion(alumnos);
						break;

					case 2:
						tramiteTitulacion = new ApoyoDocente();
						tramiteTitulacion.titulacion(alumnos);
						break;

					case 3:
						tramiteTitulacion = new ExtensionServicio();
						tramiteTitulacion.titulacion(alumnos);
						break;

					case 4:
						tramiteTitulacion = new BattleRoyale();
						tramiteTitulacion.titulacion(alumnos);
						break;

					case 0:
						break;

					default:
						System.out.println("Ingresa un numero valido.");
						break;

				}

		}while(opcion != 0);

	}
}