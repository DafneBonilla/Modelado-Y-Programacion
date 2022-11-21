
import java.util.LinkedList;

/**
* Si se esta probando este ejemplo en terminal
* javac -cp "path/al/archivo/jar/gson-2.6.2.jar" *.java
* java -cp .:"path/al/archivo/jar/gson-2.6.2.jar" Main para Linux
* java -cp .;"path/al/archivo/jar/gson-2.6.2.jar" Main para Windows
* y si no funciona esto, pueden googlear como compilar y ejecutar 
* archivos jar con sus scripts.
* Tambien pueden usar ant (guardando el jar en una carpeta lib) o 
* el IDE de su preferencia y ahorrarse esto.
*/
public class Main{

	/*
	* Metodo que genera 'estados' de prueba.
	* @return Una lista con los 'estados'.
	*/
	private static LinkedList crearObjetos(){
		
		Estado edoMex = new Estado();
		edoMex.setId(1);
		edoMex.setNombre("Estado de Mexico");
		edoMex.setCapital("Toluca de Lerdo");
		edoMex.setSuperficie(22351);
		edoMex.setPoblacion(16187608);
		LinkedList ciudadesEdoMex = new LinkedList();
		ciudadesEdoMex.add("Toluca de Lerdo");
		ciudadesEdoMex.add("Ecatepec de Morelos");
		ciudadesEdoMex.add("Naucalpan de Juarez");
		edoMex.setCiudades(ciudadesEdoMex);

		Estado jal = new Estado();
		jal.setId(2);
		jal.setNombre("Jalisco");
		jal.setCapital("Guadalajara");
		jal.setSuperficie(78588);
		jal.setPoblacion(7844830);
		LinkedList ciudadesJal = new LinkedList();
		ciudadesJal.add("Guadalajara");
		ciudadesJal.add("Ocotlan");
		ciudadesJal.add("Puerto Vallarta");
		jal.setCiudades(ciudadesJal);

		Estado gto = new Estado();
		gto.setId(3);
		gto.setNombre("Guanajuato");
		gto.setCapital("Guanajuato");
		gto.setSuperficie(30608);
		gto.setPoblacion(5853677);
		LinkedList ciudadesGto = new LinkedList();
		ciudadesGto.add("Guanajuato");
		ciudadesGto.add("Celaya");
		ciudadesGto.add("Leon");
		gto.setCiudades(ciudadesGto);

		LinkedList<Estado> estados = new LinkedList<Estado>();
		estados.add(edoMex);
		estados.add(jal);
		estados.add(gto);
		
		return estados;
	}

	public static void main(String[] args){
		
		Parser parser = new Parser();

		// Esto es para generar un archivo json 
		/*LinkedList objetos = crearObjetos();
		parser.crearJSON(objetos);
		System.out.println("Se ha generado el archivo Json.");*/
		

		//Esto es para convertir un archivo json a objetos.
		parser.parse();
	}
}