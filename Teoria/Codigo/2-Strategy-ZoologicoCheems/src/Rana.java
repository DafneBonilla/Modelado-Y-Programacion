public class Rana implements Animal{
	private String nombre = "Rene (Rana comun).";
	private String reino = "Animalia.";
	private String clase = "Amphibia.";
	private String orden = "Anura.";
	private String familia = "Ranidae.";
	private String genero = "Pelophylax.";
	private String sonido = "Croar.";
	private String apariencia = "           .--._.--." + "\n" +
          						"          ( O     O )"  + "\n" +
          						"          /   . .   \\"  + "\n" +
         						"         .`._______.'."  + "\n" +
        						"        /(          ) \\" + "\n" +
      							"      _/  \\  \\   /  /  \\_"  + "\n" +
   								"   .~    ` \\  \\ /  /  '   ~." + "\n" +
  								"  {    -.   \\  V  /   .-    }" + "\n" +
								"_ _`.    \\  |  |  |  /    .'_ _" + "\n" +
								">_       _} |  |  | {_       _<" + "\n" +
 								" /. - ~ ,_-'  .^.  `-_, ~ - .\\" + "\n" +
         						"         '-'|/   \\|`-`";

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
		Rana rene = new Rana();
		System.out.println(rene.mostrarInformacion());
	}
}