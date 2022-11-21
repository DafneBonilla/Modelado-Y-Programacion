public class Elefante implements Animal{
	private String nombre = "Dumbo (Elefante Africano).";
	private String reino = "Animalia.";
	private String clase = "Mammalia.";
	private String orden = "Proboscidea.";
	private String familia = "Elephantidae.";
	private String genero = "Loxodonta.";
	private String sonido = "Barrito.";
	private String apariencia = "                          _" + "\n" +
                           		"                        .' `'.__" + "\n" +
                           		"                       /      \\ `'\"-," + "\n" +
        				   		"      .-''''--...__..-/ .     |      \\" + "\n" +
      					   		"    .'               ; :'     '.  a   |" + "\n" +
     							"   /                 | :.       \\     =\\" + "\n" +
    							"  ;                   \':.      /  ,-.__;.-;`" + "\n" +
   								" /|     .              '--._   /-.7`._..-;`" + "\n" +
  								"; |       '                |`-'      \\  =|" + "\n" +
  								"|/\\        .   -' /     /  ;         |  =/" + "\n" +
  								"(( ;.       ,_  .:|     | /     /\\   | =|" + "\n" +
   								" ) / `\\     | `\"\"`;     / |    | /   / =/" + "\n" +
     							"   | ::|    |      \\    \\ \\    \\ `--' =/" + "\n" +
    							"  /  '/\\    /       )    |/     `-...-`" + "\n" +
   								" /    | |  `\\    /-'    /;" + "\n" +
   								" \\  ,,/ |    \\   D    .'  \\" + "\n" +
								"  `\"\"`   \\  nnh  D_.-'L__nnh" + "\n" +
            					"          `\"\"\"`";

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
		Elefante dumbo = new Elefante();
		System.out.println(dumbo.mostrarInformacion());
	}
}