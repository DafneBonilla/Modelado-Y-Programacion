public class Oso implements Animal{
	private String nombre = "Yogi (Oso Grizzly).";
	private String reino = "Animalia.";
	private String clase = "Mammalia.";
	private String orden = "Carnivora.";
	private String familia = "Ursidae.";
	private String genero = "Ursus.";
	private String sonido = "Rugido.";
	private String apariencia = ".--.              .--." + "\n" +
						   		": (\\ \". _......_ .\" /) :" + "\n" +
						   		" '.    `        `    .'" + "\n" +
						   		"  /'   _        _   `\\ " + "\n" +
						   		" /     0}      {0     \\" + "\n" +
						   		"|       /      \\       |" + "\n" +
						   		"|      /'      `\\      |" + "\n" +
						   		" \\    |.  .==.  .|    /" + "\n" +
						   		"   '._ \\.'\\__/'./ _.'"+ "\n" +
						   		"  /  ``'._-''-_.'``  \\";

	private String getNombre(){
		return nombre;
	}

	private String getReino(){
		return reino;
	}

	private String getClase(){
		return clase;
	}

	private String getOrden(){
		return orden;
	}

	private String getFamilia(){
		return familia;
	}

	private String getGenero(){
		return genero;
	}

	private String getSonido(){
		return sonido;
	}

	private String getApariencia(){
		return apariencia;
	}

	@Override
	public String mostrarInformacion(){
		return (getApariencia()) + "\n" +
				"Nombre: " + getNombre() + "\n" +
				"Reino: " + getReino() + "\n" +
				"Clase: " + getClase() + "\n" +
				"Orden: " + getOrden() + "\n" +
				"Familia: " + getFamilia() + "\n" +
				"Genero: " + getGenero() + "\n" +
				"Sonido: " + getSonido() + "\n";
				
	}

	public static void main(String[] args){
		Oso oso = new Oso();
		System.out.println(oso.mostrarInformacion());
	}
}