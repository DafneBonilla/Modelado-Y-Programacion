public class Tesis extends Titulacion{
	
	@Override
	public void mostrarFormaTitulacion(){
		System.out.println("\n**********************************"
						+ "\n*****DESCRIPCION DE TITULACION****"
						+ "\n**********************************");
		System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", la forma de titulacion "
				+ "que has elegido es TESIS. Para esto tendras que "
				+ "elegir un asesor quien te apoyara para elegir un tema "
				+ "a desarrollar. La fecha asignada es inamovible, por lo que "
				+ "debes apresurarte para terminar tu trabajo. Al acabar "
				+ "presentaras un examen profesional el dia indicado. Buena suerte.");
	}

	@Override
	public void realizarTramite(){
		System.out.println("\n**********************************"
						+ "\n*********TRAMITE INICIADO*********"
						+ "\n**********************************");
		System.out.println("\nTu tramite de TESIS ha iniciado. El grupo de sinodales "
			+ "ha sido elegido y te esperaran en el salon de examenes profesionales "
			+ "el dia asignado.");
	}

	@Override
	public void premioExcelencia(){
		if(alumnoProcesado.getPromedio() > 9.5){
			System.out.println("\n**********************************"
							+ "\n*******PREMIO POR EXCELENCIA******"
							+ "\n**********************************");
			System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", dado que tu promedio final es sobresaliente, "
				+ "has sido acredor a una MEDALLA por "
				+ "aprovechamiento academico.");
		}
	}
}