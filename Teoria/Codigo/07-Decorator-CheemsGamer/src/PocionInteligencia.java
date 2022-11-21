public class PocionInteligencia extends PowerUp{

	public PocionInteligencia(Personaje centro){
		super(centro);
	}

	public String getDescripcion(){
		return centro.getDescripcion() + " + Pocion de Inteligencia";
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
		return centro.getInteligencia() + 10;
	}

	public int getCarisma(){
		return centro.getCarisma();
	}
}