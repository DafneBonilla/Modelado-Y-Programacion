public class Enemigo implements Cloneable, Elem{

	private String nombre;
	private int hp;
	private int ataque;

	public Enemigo(String nombre, int hp, int ataque){
		this.nombre = nombre;
		this.hp = hp;
		this.ataque = ataque;
	}

	public String getNombre(){
		return nombre;
	}

	public int getHp(){
		return hp;
	}

	public int getAtaque(){
		return ataque;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setHp(int hp){
		this.hp = hp;
	}

	public void setAtaque(int ataque){
		this.ataque = ataque;
	}

	@Override
	public String mostrarInfo(){
		return getNombre() +
				" HP: " + getHp() +
				" Atq: " + getAtaque();
	}

	@Override
	public Object clone(){
		Enemigo clon = new Enemigo(nombre(), hp, ataque);
		return clon;
	}

}