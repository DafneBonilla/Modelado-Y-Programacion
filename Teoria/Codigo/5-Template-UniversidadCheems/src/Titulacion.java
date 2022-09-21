import java.util.LinkedList;
import java.util.Scanner;

public abstract class Titulacion{
	protected Alumno alumnoProcesado;

	//MetodoTemplate
	public void titulacion(LinkedList<Alumno> alumnos){
		identificarse(alumnos);
		mostrarFormaTitulacion();
		recibirFecha();
		realizarTramite();
		premioExcelencia();
		mostrarTitulo();
	}

	public void identificarse(LinkedList<Alumno> alumnos){
		Scanner sc = new Scanner(System.in);
		int noCuentaProcesada;

		while (alumnoProcesado == null){
			System.out.println("\n**********************************"
							+ "\n**********IDENTIFICACION**********"
							+ "\n**********************************");

			System.out.println("\nPor favor ingresa tu numero de cuenta sin letras o espacios.");

			while (true){
				try {
					String opcionUsuario = sc.nextLine();
					noCuentaProcesada = Integer.parseInt(opcionUsuario);
					break;
				}catch (NumberFormatException ex){
					System.out.println("\nPor favor ingresa tu numero de cuenta sin letras o espacios.");
				}
			}

			for(Alumno a : alumnos){
				if(a.getNoCuenta() == noCuentaProcesada)
					alumnoProcesado = a;
			}
		}
    }

	public abstract void mostrarFormaTitulacion();

	public void recibirFecha(){
		System.out.println("\n**********************************"
						+ "\n**************FECHA***************"
						+ "\n**********************************");
		System.out.println("\nSe ha procesado tu solicitud de titulacion."
			+ "\nLa fecha de tu proceso es XX/XX/XX.");
	}

	public abstract void realizarTramite();
	public abstract void premioExcelencia();

	public void mostrarTitulo(){
		System.out.println("\n**********************************"
						+ "\n*******TITULO UNIVERSITARIO*******"
						+ "\n**********************************");
		System.out.println(alumnoProcesado.toString());
	}
}