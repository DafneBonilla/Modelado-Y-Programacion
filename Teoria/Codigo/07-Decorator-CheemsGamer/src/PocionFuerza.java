public class PocionFuerza extends PowerUp{

	public PocionFuerza(Personaje centro){
		super(centro);
	}

	public String getDescripcion(){
		return centro.getDescripcion() + " + Pocion de Fuerza";
	}

	public int getFuerza(){
		return centro.getFuerza() + 10;
	}

	public int getDestreza(){
		return centro.getDestreza();
	}

	public int getSalud(){
		return centro.getSalud();
	}

	public int getInteligencia(){
		return centro.getInteligencia();
	}

	public int getCarisma(){
		return centro.getCarisma();
	}
}