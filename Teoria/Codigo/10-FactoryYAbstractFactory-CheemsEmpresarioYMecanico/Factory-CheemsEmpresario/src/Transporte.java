public abstract class Transporte{
	public abstract long getID();
	public abstract String getManejador();
	public abstract String getRuta();
	public abstract void setRuta(String destino);

	@Override
	public String toString(){
		return "ID= " + this.getID() 
		+ ", \nMANEJADOR= " + this.getManejador() 
		+ ", \nRUTA= " + this.getRuta() + "\n";
	}
}