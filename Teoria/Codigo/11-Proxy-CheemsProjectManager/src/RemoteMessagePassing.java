import java.net.*;
import java.io.*;

import java.io.Serializable;

/*
* Clase que modela el comportamiento de paso de mensajes remotos.
*/
public class RemoteMessagePassing<T extends Serializable> {
    
	public Socket socket; //El socket usado para la comunicacion.
	public ObjectOutputStream out; //El objeto de salida
	public ObjectInputStream in; //El objeto de entrada
	//public Object sending = new Object(); // Objecto para la sincronizacion durante el envio.
	//public Object receiving = new Object(); // Objeto para la sincronizacion durante la recepcion.

	/*
	* Metodo constructor.
	* @param socket Un socket para enviar los objetos.
	*/
    public RemoteMessagePassing(Socket socket) {
    	if(socket == null){
    		System.out.println("El socket esta vacio.");
    		return;
    	}
    	this.socket = socket;
    	try{
    		out = new ObjectOutputStream(socket.getOutputStream());
    		in = new ObjectInputStream(socket.getInputStream());
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }
    
    /*
    * Metodo para enviar un objeto. Se sincroniza con la variable sending.
    * Se envia el objeto a traves del ObjectOutputStream out.
    * @param obj Un objeto que se pretende enviar.
    */
    public void send(T obj) {
    	//synchronized(sending){
	    	try{
	    		out.writeObject(obj);
	    	} catch (IOException e){
	    		e.printStackTrace();
	    	}
	    //}
    }
    
    /*
    * Metodo para recibir un objeto. Se sincroniza con la variable receiving.
    * Se recibe el objeto a traves del ObjectInputStream in.
    * @return El objeto leido de in.
    */
    public T receive() {
    	T value = null;
    	//synchronized(receiving){
	    	try{
	    		//Se interpreta el objeto que se leera en el ObjectInputStream in.
	    		value = (T) in.readObject();
	    	} catch (ClassNotFoundException e){
	    		e.printStackTrace();
	    	
	    	} catch (IOException e){
	    		e.printStackTrace();
	    	}
	    //}
    	return value;
    }

    /*
    * Metodo que cierra la comunicacion. Se cierra el socket 
    * y los ObjectOutputStream y ObjectInputStream.
    */
    public void close() throws IOException {
    	try{
    		if(socket != null) 
    			socket.close();
    		if(out != null) 
    			out.close();
    		if(in != null) 
    			in.close();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }
}