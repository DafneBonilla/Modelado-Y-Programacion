public class PocionCarisma extends PowerUp{

	public PocionCarisma(Personaje centro){
		super(centro);
	}

	public String getDescripcion(){
		return centro.getDescripcion() + " + Pocion de Carisma";
	}

	public int getFuerza(){
		return centro.getFuerza();
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
		return centro.getCarisma() + 10;
	}
}