
import java.util.Scanner;
import java.io.IOException;
import org.jdom2.JDOMException;
import java.util.LinkedList;

/**
 * Clase que modela el comportamiento de esta 
 * base de datos.
 * Si se esta probando este ejemplo en terminal
 * javac -cp "path/al/archivo/jar/jdom-2.0.6.jar" *.java
 * java -cp .:"path/al/archivo/jar/jdom-2.0.6.jar" Main para Linux
 * java -cp .;"path/al/archivo/jar/jdom-2.0.6.jar" Main para Windows
 * y si no funciona esto, pueden googlear como compialr y ejecutar 
 * archivos jar con sus scripts.
 * Tambien pueden usar ant (guardando el jar en una carpeta lib) o 
 * el IDE de su preferencia y ahorrarse esto.
 * @author Arturo Lemus Pablo
 * @version 1.0, octubre 2017
 */
public class Main {

	public static LinkedList<Alumno> ciencias;

	public static int contador;

	private static void imprimeObjetos(LinkedList<Alumno> alumnos){
		for(Alumno a : alumnos){
			System.out.println(a.toString());
		}
	}

	private static LinkedList crearObjetos(){
		Alumno a1 = new Alumno(100000001, "GERTRUDE GILBERT ZOLA", "MATEMATICAS", 9.8);
		Alumno a2 = new Alumno(100000002, "BRANDEE CARMEL GABRIELLE", "MATEMATICAS", 7.6);
		Alumno a3 = new Alumno(100000003, "CLARK TAMELA RALPH", "MATEMATICAS", 9.1);
		Alumno a4 = new Alumno(100000004, "VANESSA ZOE KYLA", "MATEMATICAS", 8.7);
		Alumno a5 = new Alumno(100000005, "MEREDITH KERRY ROLLO", "ACTUARIA", 6.0);
		Alumno a6 = new Alumno(100000006, "LAURA ANSELMO XOCHITL", "ACTUARIA", 6.3);
		Alumno a7 = new Alumno(100000007, "LOIDA EMPERATRIZ ROSALIA", "ACTUARIA", 6.1);
		Alumno a8 = new Alumno(100000008, "SEVERIANO CLAUDIA ERIC", "ACTUARIA", 7.0);
		Alumno a9 = new Alumno(100000009, "ENRIQUE FERDINAND ANGELA", "FISICA", 7.8);
		Alumno a10 = new Alumno(100000010, "ELWOOD BERNARDA COLE", "FISICA", 8.2);
		Alumno a11 = new Alumno(100000011, "ONEIDA EDNA LUKE", "FISICA", 6.1);
		Alumno a12 = new Alumno(100000012, "CECILY SALUD ELLEN", "FISICA", 9.7);
		Alumno a13 = new Alumno(100000013, "LUCY NORBERTO RENITA", "CIENCIAS DE LA COMPUTACION", 9.2);
		Alumno a14 = new Alumno(100000014, "LEONCIO ROSENDO ROSALINA", "CIENCIAS DE LA COMPUTACION", 6.0);
		Alumno a15 = new Alumno(100000015, "GODOFREDO EUNICE GERALD", "CIENCIAS DE LA COMPUTACION", 7.7);
		Alumno a16 = new Alumno(100000016, "STEPHANIA DRAKE ELDRED", "CIENCIAS DE LA COMPUTACION", 8.2);

		LinkedList<Alumno> ciencias = new LinkedList<Alumno>();
		ciencias.add(a1);
		ciencias.add(a2);
		ciencias.add(a3);
		ciencias.add(a4);
		ciencias.add(a5);
		ciencias.add(a6);
		ciencias.add(a7);
		ciencias.add(a8);
		ciencias.add(a9);
		ciencias.add(a10);
		ciencias.add(a11);
		ciencias.add(a12);
		ciencias.add(a13);
		ciencias.add(a14);
		ciencias.add(a15);
		ciencias.add(a16);

		return ciencias;
	}

	public static void main(String[] args)throws JDOMException, IOException,
		IllegalStateException{
		Parser parser = new Parser();

		/*Esto es para escribir el archivo.*/
		/*LinkedList objetos = crearObjetos();
		parser.crearXML(objetos, "Ciencias.xml");
		System.out.println("Se ha creado un archivo xml");*/

		/*Esto es para leer el archivo.*/
		
		try{
            //leer el archivo es obligatorio.
            ciencias = parser.parse("Ciencias.xml");
            } catch(IOException ex){
                System.out.println(ex);
            }
		imprimeObjetos(ciencias);
		
	}

}