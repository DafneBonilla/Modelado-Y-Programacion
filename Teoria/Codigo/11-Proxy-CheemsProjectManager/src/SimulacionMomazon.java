import java.net.*;
import java.io.*;

public class SimulacionMomazon{
	
	public static void main(String[] args) {
        /*Al correr el programa escribe "server" o "client".
          java SimulacionMomazon server en una terminal
          java SimulacionMomazon client en otra,*/
        
        if ("server".equals(args[0])) {
            startServer();
        } else if("client".equals(args[0])){
            startClient();
        }
    }

    public static void startServer() {
        System.out.println("***COMPUTADORA CHEEMS PM***");
        String recurso = "Este es el nuevo recurso :v";
        try{
            ServerSocket server = new ServerSocket(8080);
            while(true){
                Socket s = server.accept();
                RemoteMessagePassing rmp = new RemoteMessagePassing(s);
                EmpleadoProxy proxy = (EmpleadoProxy)rmp.receive();
                System.out.println("***REPORTE DEL EMPLEADO PARA EL SERVIDOR***");
                proxy.reportar();
                System.out.println("***ENVIANDO RECURSOS AL EMPLEADO...***");
                rmp.send(recurso);
                System.out.println("***ENVIO EXITOSO***");
                rmp.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void startClient() {
        System.out.println("***COMPUTADORA EMPLEADO DOGE***");
        try{
            Socket s = new Socket("localhost", 8080);
            RemoteMessagePassing rmp = new RemoteMessagePassing(s);
            Empleado empleadoAEnviar = new Empleado("HEFF8812131Q7", "Doge");
            System.out.println("***INFORMACION DE EMPLEADO DOGE***");
            empleadoAEnviar.reportar();
            EmpleadoProxy proxy = new EmpleadoProxy(empleadoAEnviar);
            System.out.println("***ENVIANDO DATOS...***");
            rmp.send(proxy);
            System.out.println("***ENVIO EXITOSO***");
            System.out.println("***RECIBIENDO RECURSOS...***");
            String recurso = (String)rmp.receive();
            proxy.actualizarDatos(recurso);
            proxy.actualizarEnReales();
            empleadoAEnviar.reportar();
            rmp.close();
        }catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}