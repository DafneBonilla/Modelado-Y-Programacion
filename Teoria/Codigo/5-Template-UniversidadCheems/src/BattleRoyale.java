public class BattleRoyale extends Titulacion{
	
	@Override
	public void mostrarFormaTitulacion(){
		System.out.println("\n**********************************"
						+ "\n*****DESCRIPCION DE TITULACION****"
						+ "\n**********************************");
		System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", la forma de titulacion que has elegido es "
				+ "por BATTLE ROYALE. El dia asignado deberas "
				+ "presentarte en el estadio universitario. No esta permitido "
				+ "el uso de armas. Las reglas indican que la ultima persona de pie "
				+ "sera acredor a su titulo universitario sin mas procesos "
				+ "burocraticos. Buena suerte.");
	}

	@Override
	public void realizarTramite(){
		System.out.println("\n**********************************"
						+ "\n*********TRAMITE INICIADO*********"
						+ "\n**********************************");
		System.out.println("\nTu tramite de BATTLE ROYALE ha iniciado. "
			+ "Tu grupo de contrincantes ha sido elegido y te esperaran en "
			+ "el estadio universitario el dia asignado.");
	}

	@Override
	public void premioExcelencia(){
		if(alumnoProcesado.getPromedio() > 9.5){
			System.out.println("\n**********************************"
							+ "\n*******PREMIO POR EXCELENCIA******"
							+ "\n**********************************");
			System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", dado que tu promedio final es sobresaliente, "
				+ "has sido acredor a un CINTURON por "
				+ "aprovechamiento academico.");
		}
	}
}