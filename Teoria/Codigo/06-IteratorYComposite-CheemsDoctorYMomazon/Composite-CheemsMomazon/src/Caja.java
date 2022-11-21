import java.util.LinkedList;

public class Caja implements Articulo{

	private String id;
	private LinkedList<Articulo> articulos = new LinkedList<Articulo>();

	public Caja(String id){
		this.id = id;
	}

	public String mostrarInformacion(){
		String informacion = "***CAJA " + id + "***\n";
		for(Articulo a : articulos){
			informacion += a.mostrarInformacion() + "\n";
		}
		informacion += ("El precio total de " + id + " es de: " + mostrarPrecio());
		return informacion;
	}

	public double mostrarPrecio(){
		double precio = 0;
		for(Articulo a : articulos){
			precio += a.mostrarPrecio();
		}
		return precio;
	}

	public void empacar(Articulo a){
		articulos.add(a);
	}

	public void desempacar(Articulo a){
		articulos.remove(a);
	}
}