public class MiThread extends Thread{

	int id;

	public MiThread(int id){
		this.id = id;
	}

	@Override
	public void run(){
		int contador = 0;
		do{
			System.out.println("Soy el proceso " + (id+1) 
								+ " y mi contador es: " + (contador+1));
			contador++;
			try{
				Thread.sleep(2000);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}while(contador < 5);
		System.out.println("El proceso " + (id+1) + " ya termino!!!!");
	}

	public static void main(String[] args){
		MiThread[] hilos = new MiThread[5];

		for(int i = 0; i < hilos.length; i++){
			hilos[i] = new MiThread(i);
		}

		for(MiThread h : hilos){
			h.start();
		}

		for(MiThread h : hilos){
			try{
				h.join();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}	
	
}