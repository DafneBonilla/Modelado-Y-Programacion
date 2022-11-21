
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;
import org.jdom2.JDOMException;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.jdom2.input.SAXBuilder;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.DocType;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Clase que realiza el cambio de un archivo XML
 * a un objeto en java y viceversa.
 * @author Arturo Lemus Pablo
 * @version 1.0, agosto 2017
 */

public class Parser{

	/**
	* Metodo que convierte una lista en un archivo XML.
	* @param cienciasLa lista.
	* @param nombre El nombre del archivo de salida.
	*/
	public static void crearXML(LinkedList<Alumno> ciencias, String nombre){
		try{
			/*Este es el elemento raiz del que sera el archivo xml.
			Aqui se pueden describir atributos generales de la bd
			que sirven para detallar su composicion*/
			Element facultad = new Element("facultad"); //un nombre
			facultad.setAttribute(new Attribute("id", nombre)); //un id
			facultad.setAttribute(new Attribute("alumnos", Integer.toString(ciencias.size()))); //el numero de alumnos

			/*Aqui se crea el documento con el elemento raiz*/
			Document doc = new Document(facultad);
			/*Aqui se especifica el tipo de archivo que debemos crear.
			Existen formas mas explicitas de hacerlo, pero para este 
			ejemplo nos basta especificar que es un archivo de una
			facultad.*/
			doc.setDocType(new DocType("facultad"));

			/*Para cada alumno en la estructura de datos 'ciencias'
			se crea un nuevo elemento al cual se agregan los atributos
			que deseamos especificar en el xml. Cada atributo del objeto
			corresponde a un atributo de xml*/
			for(Alumno a : ciencias){
				Element entrada = new Element("alumno");
				entrada.setAttribute(new Attribute("noCuenta", Integer.toString(a.getNoCuenta())));
				entrada.setAttribute(new Attribute("nombre", a.getNombreAlumno()));
				entrada.setAttribute(new Attribute("carrera", a.getCarrera()));
				entrada.setAttribute(new Attribute("promedio", Double.toString(a.getPromedio())));
				facultad.addContent(entrada);
			}

			/*Este objeto es el que permitira la conversion*/
			XMLOutputter xmlOutput = new XMLOutputter();

			/*Esta linea permite guardar el archivo en un formato 
			mas legible*/
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			/*Esta linea sirve para imprimir el documento en terminal
			para ver como quedo guardado.*/
			//xmlOutput.output(doc, System.out); 
			
			/*Esta linea sirve para escribir el documento en un
			archivo titulado 'nombre'.
			Deseamos que se sobreescriba en el mismo archivo
			por lo que usamos el mismo parametro de entrada.*/
			xmlOutput.output(doc, new FileOutputStream(nombre));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	/**
	* Metodo que convierte un archivo XML en una lista.
	* @param nombre el nombre del archivo a convertir.
	*/
	public static LinkedList<Alumno> parse(String nombre) throws JDOMException, IOException,
		IllegalStateException{

		SAXBuilder lectorSAX = new SAXBuilder();
		Document doc = lectorSAX.build(new FileInputStream(nombre));
		Element raiz = doc.getRootElement();
		List<Element> entradas = raiz.getChildren();
		LinkedList<Alumno> facultad = new LinkedList<Alumno>();

		for(Element entrada : entradas){
			Alumno alumno = new Alumno();
			alumno.setNoCuenta(Integer.parseInt(entrada.getAttributeValue("noCuenta")));
			alumno.setNombreAlumno(entrada.getAttributeValue("nombre"));
			alumno.setCarrera(entrada.getAttributeValue("carrera"));
			alumno.setPromedio(Double.parseDouble(entrada.getAttributeValue("promedio")));
			facultad.add(alumno);
		}

		return facultad;
	} 
}
