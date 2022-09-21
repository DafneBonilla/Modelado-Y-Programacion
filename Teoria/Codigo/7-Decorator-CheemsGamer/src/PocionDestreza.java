public class PocionDestreza extends PowerUp{

	public PocionDestreza(Personaje centro){
		super(centro);
	}

	public String getDescripcion(){
		return centro.getDescripcion() + " + Pocion de Destreza";
	}

	public int getFuerza(){
		return centro.getFuerza();
	}

	public int getDestreza(){
		return centro.getDestreza() + 10;
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