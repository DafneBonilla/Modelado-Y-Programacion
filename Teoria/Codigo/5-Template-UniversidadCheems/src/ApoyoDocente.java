public class ApoyoDocente extends Titulacion{
	
	@Override
	public void mostrarFormaTitulacion(){
		System.out.println("\n**********************************"
						+ "\n*****DESCRIPCION DE TITULACION****"
						+ "\n**********************************");
		System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", la forma de titulacion que has elegido es " 
				+ "APOYO A LA DOCENCIA. Para esto tendras que integrarte "
				+ "a un equipo de trabajo con un docente y realizar un "
				+ "reporte. La fecha asignada es inamovible, por lo que "
				+ "debes organizar bien tu trabajo. Al acabar presentras "
				+ "tu reporte frente a un consejo elegido por nosotros el "
				+ "dia indicado Buena suerte.");
	}

	@Override
	public void realizarTramite(){
		System.out.println("\n**********************************"
						+ "\n*********TRAMITE INICIADO*********"
						+ "\n**********************************");
		System.out.println("\nTu tramite de APOYO A LA DOCENCIA ha iniciado. "
			+ "El consejo ha sido elegido y te esperaran en el salon de "
			+ "examenes profesionales el dia asignado.");
	}

	@Override
	public void premioExcelencia(){
		if(alumnoProcesado.getPromedio() > 9.5){
			System.out.println("\n**********************************"
							+ "\n*******PREMIO POR EXCELENCIA******"
							+ "\n**********************************");
			System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", dado que tu promedio final es sobresaliente, "
				+ "has sido acredor a un TROFEO por "
				+ "aprovechamiento academico.");
		}
	}
}