import java.util.Iterator;

public class CheemsRecepcionista{
	public static void main(String[] args){
		Consultorio consultorio = new Consultorio();

		Iterator pacientes = consultorio.getIteradorPacientes();
		Iterador doctores = consultorio.getIteradorDoctores();

		/*
		*El Recepcionista no sabe el tipo de estructura de datos utilizado
		*pero puede acceder a los elementos.
		*
		*/

		while(pacientes.hasNext()){
			if(doctores.hasNext()){
				System.out.println("El paciente: " + 
					((Paciente)pacientes.next()).toString() + 
					" puede pasar con el doctor: " +
					((Doctor)doctores.next()).toString());
			} else {
				System.out.println("No hay doctores disponibles de momento.");
				break;
			}
		}

	}
}