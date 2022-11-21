public class FactoryEnvios{

	private static long contador = 100000;

	public static Transporte getTransporte(Producto prod){
		if("NACIONAL".equalsIgnoreCase(prod.getTipoDeEnvio())){
			Transporte c = new Camion(++contador, "Fulano");
			c.setRuta(prod.getDestino());
			return c;
		} else if ("INTERNACIONAL".equalsIgnoreCase(prod.getTipoDeEnvio())){
			Transporte b = new Barco(++contador, "Mengana");
			b.setRuta(prod.getDestino());
			return b;
		} else if ("EXPRESS".equalsIgnoreCase(prod.getTipoDeEnvio())){
			Transporte a = new Avion(++contador, "Zutana");
			a.setRuta(prod.getDestino());
			return a;
		}
		return null;
	}
}