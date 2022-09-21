import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class GrupoPaciente{
	private Queue<Paciente> pacientes = new LinkedList<>();

	public GrupoPaciente(){
		Paciente p1 = new Paciente("Alice", 1111111);
		Paciente p2 = new Paciente("Bob", 2222222);
		Paciente p3 = new Paciente("Cesar", 3333333);
		Paciente p4 = new Paciente("Diego", 4444444);
		Paciente p5 = new Paciente("Emma", 5555555);

		pacientes.add(p1);
		pacientes.add(p2);
		pacientes.add(p3);
		pacientes.add(p4);
		pacientes.add(p5);
	}

	public Iterator getIterator(){
		return pacientes.iterator();
	}
}