public abstract class PowerUp implements Personaje{
	protected Personaje centro;

	public PowerUp(Personaje centro){
		this.centro = centro;
	}

	public String getDescripcion(){
		return centro.getDescripcion();
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
		return centro.getCarisma();
	}
}