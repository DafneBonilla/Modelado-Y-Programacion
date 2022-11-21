import java.util.Iterator;

public class Consultorio{
	private GrupoPaciente pacientes;
	private GrupoDoctor doctores;

	public Consultorio(){
		pacientes = new GrupoPaciente();
		doctores = new GrupoDoctor();
	}

	public Iterator getIteradorPacientes(){
		return pacientes.getIterator();
	}

	public Iterador getIteradorDoctores(){
		return doctores.getIterador();
	}

}