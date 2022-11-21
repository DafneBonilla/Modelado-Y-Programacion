
/**
 * Clase que simula el comportamiento de un tenedor.
 * Esto representa los recursos de un sistema.
 * @author arturo
 */
public class Tenedor {
    private int id;
    private boolean ocupado = false;
    
    public Tenedor(int id){
        this.id = id;
    }
    
    public boolean getOcupado(){
        return ocupado;
    }
    
    public synchronized void tomarT(int filos) throws InterruptedException{
        while(ocupado){
            wait();
        }
        System.out.println("El filosofo " + filos + " tomo el tenedor " + id);
        ocupado = true;
    }
    
    public synchronized void soltarT(int filos) throws InterruptedException{
        ocupado = false;
        System.out.println("El filosofo " + filos + " solto el tenedor " + id);
        notify();
    }
}
