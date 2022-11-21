
/**
 * Clase que simula el comportamiento de los filosofos comensales.
 * Se crean tantos procesos como recursos de manera que se debe 
 * coordinar el uso de recursos.
 * Al ejecutar el programa escriban como parametro el numero de
 * filosofos a emular.
 * Ejemplo para 5 filosofos: java FilosofosComensales 5
 * @author arturo
 */
public class FilosofosComensales {

    public static void main(String[] args) {

        Tenedor[] tenedores = new Tenedor[Integer.parseInt(args[0])];
        Filosofo[] filosofos = new Filosofo[Integer.parseInt(args[0])];
        
        for(int i = 0; i < tenedores.length; i++){
            tenedores[i] = new Tenedor(i);
        }
        
        for(int i = 0; i< filosofos.length; i++){
            filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i+1)%5]);
            System.out.println("El filosofo " + i + " se sento en la mesa");
        }
        for(int i = 0; i< filosofos.length; i++){
            filosofos[i].start();
        }
    }
    
}
