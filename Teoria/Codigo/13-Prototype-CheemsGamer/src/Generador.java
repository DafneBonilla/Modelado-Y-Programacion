import java.util.Random;

public class Generador{
	public Enemigo getEnemigoCueva(BDEnemigos bd, int dificultad){
		Random r = new Random();
		int posicion = r.nextInt(10);
		Enemigo enemigo = bd.getEnemigo(posicion);
		enemigo.setHp(enemigo.getHp() * dificultad);
		enemigo.setAtaque(enemigo.getAtaque() * dificultad);
		return enemigo;
	}

	public Tesoro getTesoroCueva(BDTesoros bd, int recompensa){
		Random r = new Random();
		int posicion = r.nextInt(10);
		Tesoro recurso = bd.getTesoro(posicion);
		recurso.setCantidad(recurso.getCantidad() * recompensa);
		recurso.setValor(recurso.getValor() * recompensa);
		return recurso;
	}
}