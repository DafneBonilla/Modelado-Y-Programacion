public class Objetivo{
	private int distanciaAlObjetivo;
	private int hpObjetivo;
	private int toneladasDeEscombros;

	public Objetivo(int distanciaAlObjetivo, int hpObjetivo, int toneladasDeEscombros){
		this.distanciaAlObjetivo = distanciaAlObjetivo;
		this.hpObjetivo = hpObjetivo;
		this.toneladasDeEscombros = toneladasDeEscombros;
	}

	public int getDistancia(){
		return distanciaAlObjetivo;
	}

	public int getHP(){
		return hpObjetivo;
	}

	public int getEscombros(){
		return toneladasDeEscombros;
	}

	public void setDistancia(int distanciaAlObjetivo){
		this.distanciaAlObjetivo = distanciaAlObjetivo;
	}

	public void setHP(int hpObjetivo){
		this.hpObjetivo = hpObjetivo;
	}

	public void setEscombros(int toneladasDeEscombros){
		this.toneladasDeEscombros = toneladasDeEscombros;
	}
}