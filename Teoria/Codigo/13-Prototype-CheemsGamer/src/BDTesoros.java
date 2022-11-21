public class BDTesoros{
	
	protected Tesoro[] elementos;

	public BDTesoros(){
		elementos = new Tesoro[]{new Tesoro("Roca", 2, 1), 
									new Tesoro("Carbon", 3, 2), 
									new Tesoro("Plata", 2, 5), 
									new Tesoro("Oro", 2, 10),
									new Tesoro("Diamante", 1, 50)};
	}

	public Tesoro getTesoro(int posicion){
		int i = posicion%elementos.length;
		return (Tesoro)elementos[i].clone();
	}

	public void imprimirBD(){
		System.out.println("***TESOROS DISPONIBLES***");
		for(int i = 0; i < elementos.length; i++){
			System.out.println(elementos[i].mostrarInfo());
		}
	}
}