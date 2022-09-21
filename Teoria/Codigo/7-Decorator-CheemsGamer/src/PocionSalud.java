public class PocionSalud extends PowerUp{

	public PocionSalud(Personaje centro){
		super(centro);
	}

	public String getDescripcion(){
		return centro.getDescripcion() + " + Pocion de Salud";
	}

	public int getFuerza(){
		return centro.getFuerza();
	}

	public int getDestreza(){
		return centro.getDestreza();
	}

	public int getSalud(){
		return centro.getSalud() + 10;
	}

	public int getInteligencia(){
		return centro.getInteligencia();
	}

	public int getCarisma(){
		return centro.getCarisma();
	}
}