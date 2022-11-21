public class BDEnemigos{
	
	protected Enemigo[] elementos;

	public BDEnemigos(){
		elementos = new Enemigo[]{new Enemigo("Esqueleto", 10, 5), 
									new Enemigo("Slime", 5, 2), 
									new Enemigo("Murcielago", 2, 1), 
									new Enemigo("Fantasma", 8, 4),
									new Enemigo("Golem", 15, 8)};
	}

	public Enemigo getEnemigo(int posicion){
		int i = posicion%elementos.length;
		return (Enemigo)elementos[i].clone();
	}

	public void imprimirBD(){
		System.out.println("***ENEMIGOS DISPONIBLES***");
		for(int i = 0; i < elementos.length; i++){
			System.out.println(elementos[i].mostrarInfo());
		}
	}
}