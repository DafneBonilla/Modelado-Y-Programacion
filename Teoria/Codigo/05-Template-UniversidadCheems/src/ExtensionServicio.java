public class ExtensionServicio extends Titulacion{
	
	@Override
	public void mostrarFormaTitulacion(){
		System.out.println("\n**********************************"
						+ "\n*****DESCRIPCION DE TITULACION****"
						+ "\n**********************************");
		System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", la forma de titulacion que has elegido es EXTENSION "
				+ "DE SERVICIO SOCIAL. Para esto tendras que realizar "
				+ "un tramite en las oficinas donde realizaste tu servicio "
				+ "social y realizar un reporte de actividades por un "
				+ "periodo extendido de tu servicio social. "
				+ "La fecha asignada es inamovible, por lo que debes organizar "
				+ "bien tu trabajo. Al acabar presentras tu reporte frente a un "
				+ "grupo de tecnicos academicos elegido por nosotros el dia "
				+ "indicado. Buena suerte.");
	}

	@Override
	public void realizarTramite(){
		System.out.println("\n**********************************"
						+ "\n*********TRAMITE INICIADO*********"
						+ "\n**********************************");
		System.out.println("\nTu tramite de EXTENSION DE SERVICIO SOCIAL ha iniciado. "
			+ "El grupo de tecnicos academicos ha sido elegido y te esperaran en "
			+ "el salon de examenes profesionales el dia asignado.");
	}

	@Override
	public void premioExcelencia(){
		if(alumnoProcesado.getPromedio() > 9.5){
			System.out.println("\n**********************************"
							+ "\n*******PREMIO POR EXCELENCIA******"
							+ "\n**********************************");
			System.out.println("\n" + alumnoProcesado.getNombre() 
				+ ", dado que tu promedio final es sobresaliente, "
				+ "has sido acredor a una PLACA por "
				+ "aprovechamiento academico.");
		}
	}
}