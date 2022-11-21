
/**
 * Clase que simula el comportamiento de los filosofos.
 * Esto representa los procesos que trabajan con el recurso.
 * @author arturo
 */
public class Filosofo extends Thread{
    private int id;
    private Tenedor der,izq;
    private long duerme = (long)2000;
    private long come = (long)1500;
    
    public Filosofo(int id, Tenedor izq, Tenedor der){
        this.id = id;
        this.der = der;
        this.izq = izq;
    }

    @Override
    public void run(){
        while(true){
            try{
                System.out.println("El filosofo " + id + " tiene HAMBRE");
                izq.tomarT(id);
                if(der.getOcupado()){
                    izq.soltarT(id);
                    System.out.println("El filosofo " + id + " no puede comer. "
                            + "Aun tiene HAMBRE.");
                    Thread.sleep(duerme);
                    continue;
                }
                der.tomarT(id);
                System.out.println("El filosofo " + id + " esta COMIENDO");
                Thread.sleep(come);
                izq.soltarT(id);
                der.soltarT(id);
                System.out.println("El filosofo " + id + " esta DURMIENDO");
                Thread.sleep(duerme);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
