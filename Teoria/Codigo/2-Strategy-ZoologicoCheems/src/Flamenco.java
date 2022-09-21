public class Flamenco implements Animal{
	private String nombre = "Pasguato (Flamenco Mayor).";
	private String reino = "Animalia.";
	private String clase = "Aves.";
	private String orden = "Phoenicopteriformes.";
	private String familia = "Phoenicopteridae.";
	private String genero = "Phoenicopterus.";
	private String sonido = "Graznido.";
	private String apariencia = "         __" + "\n" +
           						"        /(`o" + "\n" +
     							"  ,-,  //  \\\\" + "\n" +
    							" (,,,) ||   V" + "\n" +
   								"(,,,,)\\//" + "\n" +
   								"(,,,/w)-'" + "\n" +
   								"\\,,/w)" + "\n" +
   								"`V/uu" + "\n" +
     							"  / |" + "\n" +
     							"  | |" + "\n" +
     							"  o o" + "\n" +
     							"  \\ |" + "\n" +
								"  ,\\|,.";

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
		Flamenco fla = new Flamenco();
		System.out.println(fla.mostrarInformacion());
	}
}