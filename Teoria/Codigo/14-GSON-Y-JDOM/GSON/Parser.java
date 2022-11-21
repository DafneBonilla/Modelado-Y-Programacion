
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Parser{

	/**
	* Metodo que crea un archivo Json a partir de
	* una lista de datos.
	* @param datos La lista de datos a guardar.
	*/
	public void crearJSON(LinkedList datos){

		/*Este constructor permite la interpretacion de una estructura
		de datos a una cadena. Ademas, se le da un formato mas
		legible.*/
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		/*Aqui se traduce una estructura de datos a un formato de
		cadena como un archivo json.*/
		String json = gson.toJson(datos);

		try {
			/*Aqui se escribe el archivo json a partir de la
			cadena anterior.*/
			FileWriter writer = new FileWriter("Estados.json");
			writer.write(json);
			writer.close();
		  
		}catch (IOException e) {
			e.printStackTrace();
		}
  		
  		/*Para revisar que se haya guardado el archivo en 
  		el formato adecuado lo imprimimos.*/
		//System.out.println(json);
	}

	/**
	* Metodo que convierte un archivo Json a una estrucura
	* de datos de java para su manipulacion.
	*/
	public void parse(){

		/*Este objeto sirve para leer el archivo Json
		en una estructura de datos.*/
		Gson gson = new Gson();

		try{
			/*Aqui se lee el archivo y se guarda 
			en una variable.*/
			BufferedReader br = new BufferedReader(
				new FileReader("Estados.json"));

			/*Este paso se realiza para forzar el tipo de objeto que 
			deseamos interpretar. Si desearamos recuperar la clase de un
			objeto Estado, se podría hacer Estado.class, sin embargo 
			no podemos realizar LinkedList<Estado>.class.
			Para eso sirve este metodo.*/
			Type listType = new TypeToken<LinkedList<Estado>>(){}.getType();
			
			/*Aqui se interpretar el archivo guardado 'br' con el
			tipo de objeto 'listType'*/
			LinkedList<Estado> estados = gson.fromJson(br, listType);

			/*En este caso solamente imprimiremos toda 
			la informacion guardada en la lista.*/
			for(Estado e: estados){
				System.out.println("id: " + e.getId());
				System.out.println("nombre: " + e.getNombre());
				System.out.println("capital: " + e.getCapital());
				System.out.println("superficie: " + e.getSuperficie());
				System.out.println("poblacion: " + e.getPoblacion());
				System.out.println("ciudades: ");

				LinkedList ciudades = e.getCiudades();
   				for (int i = 0; i < ciudades.size(); i++) {
    				System.out.println("\t" + ciudades.get(i));
   				}

   				System.out.println("\n");
			}
		} catch (IOException e) {
   			e.printStackTrace();
  		}
	}

}